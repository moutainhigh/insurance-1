var myChart1 = echarts.init($("#pie")[0], "shine"), myChart2 = echarts.init(
		$("#line")[0], "shine"), myChart3 = echarts.init($("#lineBar")[0],
		"shine");
pieOption = {
	tooltip : {
		trigger : "item",
		formatter : "{b} <br/> {d}%",
		textStyle : {
			fontSize : 16
		}
	},
	legend : {
		x : "right",
		y : "top",
		show : false,
		data : [ "其它", "车辆抵押贷款", "二手车分期", "新车分期" ]
	},
	color : [ "#e96151", "#5fbb4c", "#f0c45b", "#1493fe" ],
	series : [ {
		type : "pie",
		name : "数据",
		center : [ "50%", "50%" ],
		radius : [ "50%", "75%" ],
		data : [ {
			name : "其它",
			value : 10
		}, {
			name : "车辆抵押贷款",
			value : 20
		}, {
			name : "二手车分期",
			value : 10
		}, {
			name : "新车分期",
			value : 10
		} ]
	} ]
};

function chart1Load() {
	$.ajax({
		url : '/statistics/loantype',
		dataType : 'json',
		data : $("#loanForm").serialize(),
		/*
		 * data: { startDate: '2016-07-01', endDate: '2016-10-30', bankId: 1 },
		 */
		success : function(res) {
			var arr = [];
			$.each(res.data, function(i, item) {
				arr.push(item.name);
			});
			pieOption.legend.data = arr;
			pieOption.series[0].data = res.data;
			myChart1.clear();
			myChart1.setOption(pieOption);
		}
	});
}


var formatDate = function (date) {  
    var y = date.getFullYear();  
    var m = date.getMonth() + 1;  
    m = m < 10 ? '0' + m : m;  
    var d = date.getDate();  
    d = d < 10 ? ('0' + d) : d;  
    return y + '-' + m + '-' + d;  
}; 


function getPreMonth(date) {
    var arr = date.split('-');
    var year = arr[0]; //获取当前日期的年份
    var month = arr[1]; //获取当前日期的月份
    var day = arr[2]; //获取当前日期的日
    var days = new Date(year, month, 0);
    days = days.getDate(); //获取当前日期中月的天数
    var year2 = year;
    var month2 = parseInt(month) - 1;
    if (month2 == 0) {
        year2 = parseInt(year2) - 1;
        month2 = 12;
    }
    var day2 = day;
    var days2 = new Date(year2, month2, 0);
    days2 = days2.getDate();
    if (day2 > days2) {
        day2 = days2;
    }
    if (month2 < 10) {
        month2 = '0' + month2;
    }
    var t2 = year2 + '-' + month2 + '-' + day2;
    return t2;
}

$("#startDate").val(getPreMonth(formatDate(new Date()))).datetimepicker({
	format : "yyyy-mm-dd", 
	autoclose : true,
	minView : "month",
	maxView : "decade",
	todayBtn : true,
	language : 'zh-CN',
	pickerPosition : "bottom-left",
}).on("click", function(ev) {
	$("#startDate").datetimepicker("setEndDate", $("#endDate").val());
});


 $("#endDate").val(formatDate(new Date())).datetimepicker({ 
	 format: "yyyy-mm-dd",
	 autoclose: true,
	 minView: "month",
	 maxView: "decade",
	 todayBtn: true,
	 language:'zh-CN',
	 pickerPosition: "bottom-left",
 }).on("click", function (ev) {
	 $("#endDate").datetimepicker("setStartDate", $("#startDate").val()); 
 });
 

$("#signTimeStart").val(getPreMonth(formatDate(new Date()))).datetimepicker({
	format : "yyyy-mm-dd",
	autoclose : true,
	minView : "month",
	maxView : "decade",
	todayBtn : true,
	language : 'zh-CN',
	pickerPosition : "bottom-left",
}).on("click", function(ev) {
	$("#signTimeStart").datetimepicker("setEndDate", $("#signTimeEnd").val());
});
$("#signTimeEnd").val(formatDate(new Date())).datetimepicker({
	format : "yyyy-mm-dd",
	autoclose : true,
	minView : "month",
	maxView : "decade",
	todayBtn : true,
	language : 'zh-CN',
	pickerPosition : "bottom-left",
}).on(
		"click",
		function(ev) {
			$("#signTimeEnd").datetimepicker("setStartDate",
					$("#signTimeStart").val());
		});

var lineOption = {
	tooltip : {
		trigger : "item",
		formatter : function(params) {
			return "8月" + params.name + "号" + "<br>业务量：" + params.value;
		},
		textStyle : {
			fontSize : 16,
			color : "#333"
		},
		backgroundColor : "#fff"
	},
	color : [ '#1493fe', '#5fbb4c' ],
	legend : {
		x : "right",
		y : "top",
		data : [ "上个月", "本月" ]
	},
	xAxis : [ {
		name : "单位：日",
		splitLine : {
			show : false
		},
		nameTextStyle : {
			fontSize : 16
		},
		axisLabel : {
			interval : 1,
			textStyle : {
				fontSize : 16
			}
		},
		data : [ "1", "3", "6", "9", "12", "15", "18", "21", "24", "27", "30" ]
	} ],
	yAxis : [ {
		name : "单位：笔",
		nameTextStyle : {
			fontSize : 16
		},
		axisLabel : {
			textStyle : {
				fontSize : 16
			}
		}
	} ],
	series : [ {
		type : "line",
		name : "上个月",
		data : [ 12, 4, 5, 4, 6, 58, 4, 7, 2, 6, 7 ]
	}, {
		type : "line",
		name : "本月",
		data : [ 4, 58, 41, 7, 12, 18, 35, 47, 5, 24, 36 ]
	} ]
};
myChart2.setOption(lineOption, true);

// 业务量对比
$.ajax({
	url : '/statistics/businesscontrast',
	dataType : 'json',
	data : {
		bankId : 1
	},
	success : function(res) {
		lineOption.xAxis[0].data = res.data.dateStingList;
		lineOption.series[0].data = res.data.preMonthLoanDataList;
		lineOption.series[1].data = res.data.thisMonthLoanDataList;
		myChart2.clear();
		myChart2.setOption(lineOption);
	}
});

var lineBarOption = {
	tooltip : {
		trigger : "item",
		formatter : "{a} : {c}",
		textStyle : {
			fontSize : 16
		}
	},
	legend : {
		x : "right",
		y : "top",
		orient : "vertical",
		data : [ "新车分期", "二手车分期", "车辆抵押贷款" ]
	},
	color : [ "#1493fe", "#f0c45b", "#5fbb4c" ],
	xAxis : [ {
		name : "单位：日",
		nameTextStyle : {
			fontSize : 16
		},
		data : [ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 ]
	} ],
	yAxis : [ {
		name : "单位：笔",
		nameTextStyle : {
			fontSize : 16
		},
		axisLabel : {
			textStyle : {
				fontSize : 16
			}
		}
	} ],
	series : [ {
		name : "新车分期",
		type : "bar",
		data : [ 1, 4, 7, 5, 4, 5, 4, 14, 12, 14, 21, 17, 14, 15, 16, 18 ]
	}, {
		name : "二手车分期",
		type : "bar",
		data : [ 1, 4, 7, 5, 4, 5, 4, 14, 12, 14, 21, 17, 14, 15, 16, 18 ]
	}, {
		name : "车辆抵押贷款",
		type : "bar",
		data : [ 1, 4, 7, 5, 4, 5, 4, 14, 12, 14, 21, 17, 14, 15, 16, 18 ]
	}, {
		type : "line",
		data : [ 14, 2, 13, 5, 8, 7, 9, 11, 6, 4, 7, 5, 13, 14, 15, 3 ]
	} ]
};
myChart3.setOption(lineBarOption, true);

// 业务量走势
function chart3Load() {
	$.ajax({
		url : '/statistics/businesstrend',
		dataType : 'json',
		data : $("#loanForm2").serialize(),
		success : function(res) {
			lineBarOption.xAxis[0].data = res.data.intervalDateList;
			lineBarOption.series = res.data.series;
			myChart3.clear();
			myChart3.setOption(lineBarOption);
		}
	});
}
$(function(){
	chart3Load();
	chart1Load();
});
