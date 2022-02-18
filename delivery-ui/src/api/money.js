import { req, reqForm } from './axiosFun';

// const commonUrl = "http://localhost:8080"

// const commonUrl = "http://docker.for.mac.localhost:8085"

const commonUrl = "http://host.docker.internal:8085"


export const dicReq = (param, url) =>  {
    return req("get", commonUrl + url + param);
}

export const tranReq = (method, params, url) => {
    return reqForm(method, commonUrl + url, params)
}
