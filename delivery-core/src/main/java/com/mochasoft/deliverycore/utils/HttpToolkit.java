package com.mochasoft.deliverycore.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 基于 httpclient 4.3.3版本的 http工具类.
 */
public class HttpToolkit {

    /**
     * httpclient.
     */
    private static final CloseableHttpClient httpClient;
    /**
     * 编码集.
     */
    public static final String DEFAULTCHARSET = "UTF-8";
    /**
     * 返回成功状态码.
     */
    private static final int HTTP_STATUS_CODE_SUCCESS = 200;
    /**
     * 调用传参格式——json.
     */
    public static final String POST_TYPE_BY_JSON = "json";
    /**
     * 调用传参格式——param.
     */
    public static final String POST_TYPE_BY_PARAM = "param";
    /**
     * url空提示.
     */
    private static final String URL_NULL_MESSAGE = "The argument 'url' does not null.";
    /**
     * 配置文件.
     */
    public static final RequestConfig config;
    /**
     * 日志.
     */
    private static final Logger httpToolkitLog = LoggerFactory.getLogger(HttpToolkit.class);

    private HttpToolkit() { }

    static {
        config = RequestConfig.custom().setConnectTimeout(60000)
                .setSocketTimeout(15000).build();
        httpClient = HttpClientBuilder.create().setDefaultRequestConfig(config)
                .build();
    }

    public static String doGet(String url, Map<String, String> params) {
        if (StringUtils.isBlank(url)) {
            throw new IllegalArgumentException();
        }
        return doGet(url, params, DEFAULTCHARSET);
    }

    /**
     * HTTP Get 获取内容.
     * @param url
     *            请求的url地址 ?之前的地址
     * @param params
     *            请求的参数
     * @param charset
     *            编码格式
     * @return 页面内容
     */
    public static String doGet(String url, Map<String, String> params, String charset) {
        try {
            List<NameValuePair> pairs = getNameValuePairList(params);
            String urlParam = url + "?" + EntityUtils.toString(new UrlEncodedFormEntity(pairs, charset));
            HttpGet httpGet = new HttpGet(urlParam);
            CloseableHttpResponse response = httpClient.execute(httpGet);
            return getHttpResult(httpGet, response, charset);
        } catch (JsonProcessingException e1) {
            httpToolkitLog.error(" 基于 httpclient 4.3.3版本的 http工具类 HTTP Post 参数转换json错误：", e1);
        } catch (UnsupportedEncodingException e2) {
            httpToolkitLog.error(" 基于 httpclient 4.3.3版本的 http工具类 HTTP Post 获取内容错误：", e2);
        } catch (IOException e) {
            httpToolkitLog.error(" 基于 httpclient 4.3.3版本的 http工具类 HTTP Post 获取内容错误：", e);
        }
        return null;
    }

    public static String doPost(String url, Map<String, String> params) {
        if (StringUtils.isBlank(url)) {
            throw new IllegalArgumentException(URL_NULL_MESSAGE);
        }
        return doPost(url, params, "", DEFAULTCHARSET, POST_TYPE_BY_PARAM);
    }

    public static String doPost(String url, Map<String, String> params, String postType) {
        if (StringUtils.isBlank(url)) {
            throw new IllegalArgumentException(URL_NULL_MESSAGE);
        }
        return doPost(url, params, "", DEFAULTCHARSET, postType);
    }

    public static String doPost(String url, String params, String postType) {
        if (StringUtils.isBlank(url)) {
            throw new IllegalArgumentException(URL_NULL_MESSAGE);
        }
        return doPost(url, null, params, DEFAULTCHARSET, postType);
    }

    /**
     * HTTP Post 获取内容.
     *
     * @param url
     *            请求的url地址 ?之前的地址
     * @param params
     *            请求的参数
     * @param charset
     *            编码格式
     * @param parmamsJson
     *             请求参数
     * @param paramsType
     *              请求参数类型
     * @return 页面内容
     */
    public static String doPost(String url, Map<String, String> params, String parmamsJson, String charset, String paramsType) {
        try {
            HttpPost httpPost = prepareHttpPostParam(url, params, parmamsJson, charset, paramsType);
            CloseableHttpResponse response = httpClient.execute(httpPost);
            return getHttpResult(httpPost, response, charset);
        } catch (JsonProcessingException e1) {
            httpToolkitLog.error(" 基于 httpclient 4.3.3版本的 http工具类 HTTP Post 参数转换json错误：", e1);
        } catch (UnsupportedEncodingException e2) {
            httpToolkitLog.error(" 基于 httpclient 4.3.3版本的 http工具类 HTTP Post 获取内容错误：", e2);
        } catch (IOException e) {
            httpToolkitLog.error(" 基于 httpclient 4.3.3版本的 http工具类 HTTP Post 获取内容错误：", e);
        }
        return null;
    }

    /**
     * 准备http请求参数.
     * @param url 请求链接
     * @param params 请求参数map稽核
     * @param charset 编码格式
     * @param paramsType 调用参数方式（json/param）
     * @param paramsJson 请求参数
     * @return 返回post请求
     * @throws JsonProcessingException 转换异常
     * @throws UnsupportedEncodingException 编码异常
     */
    private static HttpPost prepareHttpPostParam(String url, Map<String, String> params, String paramsJson,
                                                 String charset, String paramsType)
        throws JsonProcessingException, UnsupportedEncodingException {
        HttpPost httpPost = new HttpPost(url);
        if (paramsType.equals(POST_TYPE_BY_JSON)) {
            ObjectMapper objectMapper = new ObjectMapper();
            String postParams = StringUtils.isNotEmpty(paramsJson) ? paramsJson : objectMapper.writeValueAsString(params);
            httpToolkitLog.info("请求参数：{}", postParams);
            httpPost.setEntity(new StringEntity(postParams, charset));
            httpPost.setConfig(config);
            httpPost.addHeader("Content-Type", "application/json");
        } else {
            List<NameValuePair> pairs = getNameValuePairList(params);
            if (!pairs.isEmpty()) {
                httpPost.setEntity(new UrlEncodedFormEntity(pairs, charset));
            }
        }
        return httpPost;
    }

    /**
     ** 转换参数map为ListNameValuePair.
     * @param params map参数
     * @return 返回list转化结果
     */
    private static List<NameValuePair> getNameValuePairList(Map<String, String> params) {
        if (MapUtils.isNotEmpty(params)) {
            return params.entrySet().stream()
                    .filter(mapSingle -> StringUtils.isNotEmpty(mapSingle.getValue()))
                    .map(pairSingle -> new BasicNameValuePair(pairSingle.getKey(), pairSingle.getValue()))
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    /**
     * 获取请求结果.
     * @param httpGet 请求体
     * @param response 返回体
     * @param charset 编码格式
     * @return 返回结果String
     * @throws IOException ioe异常
     */
    private static String getHttpResult(HttpGet httpGet, CloseableHttpResponse response, String charset) throws IOException {
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode != HTTP_STATUS_CODE_SUCCESS) {
            httpGet.abort();
            throw new RuntimeException("HttpClient,error status code :" + statusCode);
        }
        HttpEntity entity = response.getEntity();
        final String result = EntityUtils.toString(Optional.ofNullable(entity)
                                                    .orElseThrow(() -> new NullPointerException("返回HttpEntity为空")), charset);
        EntityUtils.consume(entity);
        response.close();
        return result;
    }

    /**
     * 获取请求结果.
     * @param httpPost 请求
     * @param response 返回体
     * @param charset 编码格式
     * @return 返回结果
     * @throws IOException 读取异常
     */
    private static String getHttpResult(HttpPost httpPost, CloseableHttpResponse response, String charset) throws IOException {
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode != HTTP_STATUS_CODE_SUCCESS) {
            httpPost.abort();
            throw new RuntimeException("HttpClient,error status code :"
                    + statusCode);
        }
        HttpEntity entity = response.getEntity();
        final String result = EntityUtils.toString(Optional.ofNullable(entity)
                                                    .orElseThrow(() -> new NullPointerException("返回HttpEntity为空")), charset);
        EntityUtils.consume(entity);
        response.close();
        return result;
    }


}
