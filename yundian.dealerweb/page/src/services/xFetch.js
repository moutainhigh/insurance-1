// 自定义访问服务器api函数

import {notification,Modal} from 'antd';

const errorMessages = (res) => `${res.status} ${res.statusText}`;

function check403(res) {
  console.log('check403:'+JSON.stringify(res));
  console.log('check403:'+res.code);
  if (!res.success&&res.code === '403') {
    Modal.error({
      title: '登录超时，请重新登录！',
      content: '',
    });
    location.href = '/login.html';
  }
  return res;
}

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

  console.log('errorMessageParse:'+JSON.stringify(res));
  const success = res.success;
  const code = res.code;
  if(!success&&code=='403'){
    console.log('errorMessageParse:'+res.code);
      Modal.error({
        title: '登录超时，请重新登录！',
        content: '',
      });
      location.href = '/login.html';
    return Promise.reject(res.msg);
  }
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
  const postOption=  { method: 'POST', headers: { 'Content-Type': 'application/x-www-form-urlencoded', 'X-Requested-With':'fetch',}, body: body };
  return xFetch(url,postOption);
}
export function xFetch(url ,options) {
  let seperator = '';
  let token = '';

  if(options==undefined){
    options = {
      method: 'GET'
    };
  }
  options.headers={ 'Content-Type': 'application/x-www-form-urlencoded', 'X-Requested-With':'fetch'};

  options.credentials = 'include';

  return fetch(url, options)
    .then(check401)
    .then(check404)
    .then(jsonParse)
    .then(errorMessageParse)
    .catch(catchError);
}

export default xFetch;
