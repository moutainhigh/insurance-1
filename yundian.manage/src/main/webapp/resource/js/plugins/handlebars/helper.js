/**
 * Created by Chen on 15/5/24.
 */

//S-公用

//S-时间格式化
Handlebars.registerHelper("dateFormatStyle",function(value,style){
    function formatDate(now) {
        var year=now.getFullYear();
        var month=now.getMonth()+1;
        var date=now.getDate();
        var hour=now.getHours();
        var minute=now.getMinutes();
        var second=now.getSeconds();
        if(second < 10)
        {
            second = '0' + second;
        }
        if(minute < 10)
        {
            minute = '0' + minute;
        }
        if(style ==1 ){//格式:2014-08-15 00:00:00
            return year+"-"+month+"-"+date+" "+hour+":"+minute+":"+second;
        }else if(style == 2){//格式:2014-08-15 00:00
            return year+"-"+month+"-"+date+" "+hour+":"+minute;
        }

    }
    if(value==null ||value==''){
        return '';
    }
    var d = new Date(value);
    return formatDate(d);
});

//E-时间格式化

//S-文本截取
Handlebars.registerHelper("hideText",function(value,num){
    if(value.length > num)
    {
        return new Handlebars.SafeString(value.substr(0,num)+'…');
    }
    else
    {
        return value;
    }

});
//E-文本截取

//E-公用

//S-申请记录状态
Handlebars.registerHelper("applicationState",function(state, loanid, secondhandorderid,isonline){
    if(state == 0){
    	secondhandorderid = typeof(secondhandorderid) =='undefined'?-1:secondhandorderid;
        return new Handlebars.SafeString('<a herf="javascript:;" class="mem-btn" onclick="cancelorder('+loanid +',' + secondhandorderid + ')">取消申请</a>&nbsp;<i class="state-icon accept">已受理</i>');
    }else if(state == 1){
        return new Handlebars.SafeString('<i class="state-icon approval">审核中</i>');
    }else if(state == 2){
    	var showBtn = "";
    	if(isonline == 0){
    		showBtn = '&nbsp;<a herf=\"javascript:;\" class=\"mem-btn\" onclick=\"showorder('+loanid+')\">查看意向申请</a>';
    	}
        return new Handlebars.SafeString('<i class="state-icon lending">审核通过</i>' + showBtn);
    }else if(state == 3){
        return new Handlebars.SafeString('<i class="state-icon fail">审核失败</i>');
    }
})
//E-申请记录状态

//S-我要贷款成功率
Handlebars.registerHelper("successRateFun",function(successRate){
    if(successRate > 0 && successRate < 40){
        return new Handlebars.SafeString('<img src="/statics/images/ic1.jpg" alt="'+successRate+'">');
    }else if(successRate >= 40 && successRate < 60){
        return new Handlebars.SafeString('<img src="/statics/images/ic2.jpg" alt="'+successRate+'">');
    }else if(successRate >= 60 && successRate < 80){
        return new Handlebars.SafeString('<img src="/statics/images/ic3.jpg" alt="'+successRate+'">');
    }else if(successRate >= 80 && successRate < 100){
        return new Handlebars.SafeString('<img src="/statics/images/ic4.jpg" alt="'+successRate+'">');
    }else if(successRate == 100){
        return new Handlebars.SafeString('<img src="/statics/images/ic5.jpg" alt="'+successRate+'">');
    }
})
//E-我要贷款成功率




//日期格式化
Handlebars.registerHelper("prettifyDate", function(timestr) {
	var date= new Date(Date.parse(timestr.replace(/-/g,   "/"))); //转换成Data();
	return  date.toLocaleDateString();

});

//金额转换为万
Handlebars.registerHelper("prettifyMoney", function(money) {
    if(money<10000)
    	return money;
    else 
    	return money/10000 +"万";
});


//计算差价
Handlebars.registerHelper("salemoney", function(a,b) {
   return (parseFloat(a)-parseFloat(b)).toFixed(2);
});


//封装判断函数
Handlebars.registerHelper("Judge", function(a,b,c,d) {
		if (a == 1){
		 return new Handlebars.SafeString(b);
		}else if(a == 2){
			return new Handlebars.SafeString(c);
			}else if(a == 3){
				return new Handlebars.SafeString(d);
				}
});



//判断
Handlebars.registerHelper("ic", function(a) {
		if (a == 1){
		 return new Handlebars.SafeString('<i class=""></i>');
		}else if(a == 2){
			return new Handlebars.SafeString('<i class="on"></i>');
			}
	   
});
//检测结果
Handlebars.registerHelper("accident",function(a,b,c,d){
	if(a == '事故排查'){
		var f = '';
		if (d == 2){
		var f = 'on';
		}
	    return new Handlebars.SafeString('<span>'+c+'（共'+b+'项）<i class="'+f+'"></i></span>');
		}		
});

Handlebars.registerHelper("appearance",function(a,b,c,d){
	if(a == '外观内饰检测'){
		var f = '';
		if (d == 2){
		var f = 'on';
		}
	    return new Handlebars.SafeString('<span>'+c+'（共'+b+'项）<i class="'+f+'"></i></span>');
		}		
});

Handlebars.registerHelper("system",function(a,b,c,d){
	if(a == '系统设备检测'){
		var f = '';
		if (d == 2){
		var f = 'on';
		}
	    return new Handlebars.SafeString('<span>'+c+'（共'+b+'项）<i class="'+f+'"></i></span>');
		}		
});

Handlebars.registerHelper("dynamic",function(a,b,c,d){
	if(a == '动态检测'){
		var f = '';
		if (d == 2){
		var f = 'on';
		}
	    return new Handlebars.SafeString('<span>'+c+'（共'+b+'项）<i class="'+f+'"></i></span>');
		}		
});

Handlebars.registerHelper("time",function(a){
		var b = "";
		if(typeof a == "string"){
			b = a.substring(0,7)+"";
		}
		return new Handlebars.SafeString(b);
});

Handlebars.registerHelper("timeData",function(a){
		var b = "";
		if(typeof a == "string"){
			b = a.substring(0,10)+"";
		}
		return new Handlebars.SafeString(b);
});

Handlebars.registerHelper("xing",function(a){
	if(a == '正常'){
		return new Handlebars.SafeString('<i class="no"></i>');
	}else{
		return new Handlebars.SafeString('<i class="damage"></i>');
	}
});

Handlebars.registerHelper("substring",function(a,b,c){
	if(typeof a == "string"){
		a = a.substring(b,c)+"";
	}
	return new Handlebars.SafeString(a);
});

Handlebars.registerHelper("xingyz",function(a){
		if(a != undefined){
			return new Handlebars.SafeString("("+a+")");
		}else{
			return new Handlebars.SafeString('');
		}
	
});

Handlebars.registerHelper("btn",function(a,b){    //二手车处理
		if(a == 1){
			return new Handlebars.SafeString('<a href="javascript:;" data-val="{{baseinfoid}}" id="linkes" class="buttons fn-fl appointments">预约看车</a>');
		}else if(a == 2){
			return new Handlebars.SafeString('<a href="javascript:;" class="buttons fn-fl" style="background:#f5f5f5; color:#404040;">已售罄</a>');
		}
	
});

Handlebars.registerHelper("xingTime",function(a,b){    //车商二手车处理
		if(a == 2){   //行金融
			return new Handlebars.SafeString('<p class="fn-fl timeBox"><i class="fn-fl color40">限时购：</i><span class="timeSpanBox"></span></p><input type="hidden" class="mtime" value="'+ b +'">');
		}
	
});

Handlebars.registerHelper("xingIc",function(a){    //车商二手车处理
		if(a == 2){   //行金融
			return new Handlebars.SafeString('<i class="fn-fr"></i>');
		}
	
});

Handlebars.registerHelper("xingChange",function(a,b,c){    //车商二手车处理
		if(a == c){   //行金融
			return new Handlebars.SafeString(b);
		}
	
});

Handlebars.registerHelper("xingHref",function(a,b){    //车商二手车处理
		if(a == 1){
			return new Handlebars.SafeString('href="/secondhandcar/secondhandcar-detail-'+ b +'.html"');
		}else if(a == 2){//行金融
			return new Handlebars.SafeString('href="/xingfinance-'+ b +'.html"');
		}
	
});
