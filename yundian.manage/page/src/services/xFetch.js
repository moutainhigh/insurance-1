// 自定义访问服务器api函数

import {notification} from 'antd';

const errorMessages = (res) => `${res.status} ${res.statusText}`;

function check401(res) {
  if (res.status === 401) {
    location.href = '/401';
  }
  return res;
}

function check404(res) {
  if (res.status === 404) {
    return Promise.reject(errorMessages(res));
  }
  return res;
}

function jsonParse(res) {
  return res.json();
}

function errorMessageParse(res) {
  const success = res.success;
  const code = res.code;
  if (!success || code != '200') {
    notification.warn({
      message: '获取服务器数据异常',
      description: res.msg
    });
    return Promise.reject(res.msg);
  }
  return res;
}

function catchError(error){
  if(error){
    console.error('ERROR:',error);
  }
}

export function xPostFetch(url,body) {
  const postOption=  { method: 'POST', headers: { 'Content-Type': 'application/x-www-form-urlencoded', }, body: body };
  return xFetch(url,postOption);
}
export function xFetch(url ,options) {
  let seperator = '';
  let token = '';

  console.log(options)
  if(options==undefined){
    options = {
      method: 'GET'
    };
  }
  options.credentials = 'include';
  options.headers={ 'Content-Type': 'application/x-www-form-urlencoded', 'X-Requested-With':'fetch'};

  //
  // if(url.endsWith('.json')){
  //   seperator = '?';
  // }else{
  //   seperator = '&';
  // }
  // url = url + seperator + token;


  return fetch(url, options)
    .then(check401)
    .then(check404)
    .then(jsonParse)
    .then(errorMessageParse)
    .catch(catchError);
}

export default xFetch;
