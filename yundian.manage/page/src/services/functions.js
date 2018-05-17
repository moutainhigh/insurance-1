import React,{ Component } from 'react';
import Moment from 'moment'
function add0(m){
    return m<10?'0'+m:m;
}

export function formatDate(shijianchuo){
    var time = new Date(shijianchuo);
    var y = time.getFullYear();
    var m = time.getMonth()+1;
    var d = time.getDate();
    var h = time.getHours();
    var mm = time.getMinutes();
    var s = time.getSeconds();
    return y+'-'+add0(m)+'-'+add0(d)+' '+add0(h)+':'+add0(mm)+':'+add0(s);
}

export function getDay(shijianchuo){
    var time = new Date(shijianchuo);
    var d = time.getDate();
    return d;
}

export function getYMD(shijianchuo){
    var time = new Date(Date.parse(shijianchuo.replace(/-/g, "/")));
    var y = time.getFullYear();
    var m = time.getMonth()+1;
    var d = time.getDate();
    var h = time.getHours();
    var mm = time.getMinutes();
    var s = time.getSeconds();
    return y+'-'+add0(m)+'-'+add0(d);
}

export function formatDateZero(shijianchuo){
    var time = new Date(shijianchuo);
    var y = time.getFullYear();
    var m = time.getMonth()+1;
    var d = time.getDate();
    var h = time.getHours();
    var mm = time.getMinutes();
    var s = time.getSeconds();
    return y+'-'+add0(m)+'-'+add0(d)+' 00:00:00';
}

export function formatDateEnd(shijianchuo){
    var time = new Date(shijianchuo);
    var y = time.getFullYear();
    var m = time.getMonth()+1;
    var d = time.getDate();
    var h = time.getHours();
    var mm = time.getMinutes();
    var s = time.getSeconds();
    return y+'-'+add0(m)+'-'+add0(d)+' 23:59:59';
}

export function fenToYuan(fen){
    if(isNaN(fen)){
        return '-';
    }
    return fen / 100;
}

export function fenToWan(fen){
    if(isNaN(fen)){
        return '-';
    }
    return fen / 100 / 10000;
}

export function propsToFields(modelObj)
{
  var fields = {};
  if(modelObj ==null){
    return fields
  }

  for (let i in modelObj) {
    console.log(modelObj[i])
    if(modelObj[i]!=null) {
      // console.log(isDate(modelObj[i]))
      if (isDate(modelObj[i])) {
        fields[i] = {value: Moment(String(modelObj[i]))};
      }
      else if( modelObj[i] instanceof Array){
        fields[i] = {value: modelObj[i]};
      }
      else {
        fields[i] = {value: String(modelObj[i])};
      }
    }
  }
  return fields;

}
export function  isEmptyObject(obj){
  for(var n in obj){return false}
  return true;
}

export function isDate(str) {
let regex= /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/;
  return  regex.test(str);
}

export function checkIdCardLength(rule, value, callback){
  let regex = /(^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$)|(^[1-9]\d{5}\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{2}[0-9Xx]$)/;
  if (!regex.test(value)) {
    callback("请输入正确身份证号");
  }
  else {
    callback();
  }
};
export function checkMobileLength(rule, value, callback){
  let regex = /^((\+)?86|((\+)?86)?)0?1[34578]\d{9}$/;
  if (!regex.test(value)) {
    callback("请输入正确手机号");
  }
  else {
    callback();
  }
};
