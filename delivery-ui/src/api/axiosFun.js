import axios from 'axios';
import router from '../router';


// // 请求拦截
// axios.interceptors.request.use(config => {
//     // startLoading()
 
//     // 设置统一的请求头：如何配置访问有token的接口
//     if (localStorage.token) {
//         config.headers.Authorization = window.sessionStorage.getItem("token");
//     }
 
//     return config
// }, error => {
//     return Promise.reject(error)
// })

// axios.interceptors.response.use( response => {
//     // endLoading()
//     return response
// }, error => {
//     // endLoading()
//     // Message.error(error.message)
 
//     // 获取错误状态码，token失效
//     const { status } = error.code
//     if (status == 403) {
//         alert('token失效，请重新登录')
//         // 清除token
//         // localStorage.removeItem('token')
//         // 重新跳转到login页面
//         router.push('/login')
//     }
 
//     return Promise.reject(error)
// })

// 登录请求方法
const loginreq = (method, url, params) => {
    return axios({
        method: method,
        url: url,
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
        },
        data: params,
        traditional: true,
        transformRequest: [
            function(data) {
                let ret = ''
                for (let it in data) {
                    ret +=
                        encodeURIComponent(it) +
                        '=' +
                        encodeURIComponent(data[it]) +
                        '&'
                }
                return ret
            }
        ]
    }).then(res => res.data);
};
// 通用公用方法
const reqForm = (method, url, params) => {
    return axios({
        method: method,
        url: url,
        headers: {
            'Content-Type': 'application/json',
            'token' : window.sessionStorage.getItem("token")
        },
        data: params
    }).then(res => {
        if(res.data.code === 403){
            router.push({name:'login',params: {expire:'1'}})
        } else {
            return res.data
        }
    });
};

// 通用公用方法
const req = (method, url) => {
    return axios({
        method: method,
        url: url,
        headers: {
            'token' : window.sessionStorage.getItem("token")
        }
    }).then(res => {
        if(res.data.code === 403){
            router.push({name:'login',params: {expire:'1'}})
        } else {
            return res.data
        }
    });
};

export {
    loginreq,
    req,
    reqForm
}