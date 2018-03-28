//加载车行,银行信息
loadMess = function(a, b, c) {
	comn.ajax({
		url: a,
		async: false,
		data: {
			randomTime: (new Date()).getTime()
		},
		success: function(res) {
			var j, len, o, ref, str;
			str = "<option value=''>--请选择--</option>";
			ref = res.data;
			for (j = 0, len = ref.length; j < len; j++) {
				o = ref[j];
				str += "<option value='" + o.id + "'>" + o.bankName + "</option>";
			}
			return b.html(str);
		}
	});
}

getValue = function(o, key) { //处理undefine
	return o[key] ? o[key] : "";
}

loanVal = function(a, b) {
	for (var i = 0; i < a.length; i++) {
		var htmlArr=[
      '<div class="panel panel-default partyList party_List">',
      '<div class="panel-heading">',
      '<h3 class="panel-title">借款人 - ' + a[i].fullName + '</h3>',
      '</div>',
      '<div class="panel-body panel-default" style="padding-bottom:0;">',
      '<div class="form-group form-group-sm panel-heading openBox" style="border-top:1px solid #ddd;">',
      '<div class="col-md-18">',
      '<label><h3 class="panel-title" style="line-height: 34px;">银行征信信息</h3></label>',
      '</div>',
      '<div class="col-md-6 text-right">',
      '<button type="button" class="btn btn-primary closeOp"><span>查看详细信息</span></button>',
      '</div>',
      '</div>',
      '<div class="openValBox">',
      '<fieldset class="disabled1Class">',
      '<div class="form-group form-group-sm">',
      '<div class="input-tip">',
      '<label class="col-md-3 col-xs-3 col-sm-3 control-label">调查方式：</label>',
      '<div class="col-md-5 cl-sm-5 col-xs-5">',
      '<select id="seHan" name="relavants['+i+'].checkType" value="' + a[i].checkType + '" class="form-control" required="" aria-required="true">',
      '<option value="">--请选择--</option>',
      '<option value="1">电话</option>',
      '<option value="2">网络</option>',
      '</select>',
      '</div>',
      '</div>',
      '<div class="input-tip">',
      '<label class="col-md-3 col-xs-3 col-sm-3 control-label">调查结果：</label>',
      '<div class="col-md-5 cl-sm-5 col-xs-5">',
      '<select name="relavants['+i+'].checkResult" value="' + a[i].checkResult + '" class="form-control checkResult" required="" aria-required="true">',
      '<option value="">--请选择--</option>',
      '<option value="1">通过</option>',
      ' <option value="2">不通过</option>',
      '</select>',
      '</div>',
      '</div>',
      '<div class="input-tip hide">',
      '<label class="radio-inline"><input type="radio" fors="radio0" value="1" name="relavants['+i+'].checkResultStatus" required="" aria-required="true" />关注</label>',
      '<label class="radio-inline"><input type="radio" fors="radio0" value="2" name="relavants['+i+'].checkResultStatus" required="" aria-required="true" />禁入</label>',
      '<label class="radio-inline"><input type="radio" fors="radio0" value="3" name="relavants['+i+'].checkResultStatus" required="" aria-required="true" />其他</label>',
      '</div>',
      '</div>',
      '<div class="form-group form-group-sm">',
      '<div class="input-tip">',
      '<label class="col-md-3 col-xs-3 col-sm-3 control-label">调查人：</label>',
      '<div class="col-md-5 cl-sm-5 col-xs-5">',
      '<input type="text" maxlength="5" name="relavants['+i+'].staffName" value="' + getValue(a[i], 'staffName') + '" for="staffName" placeholder="请输入调查人姓名" class="form-control" required="" aria-required="true" />',
      '<input type="hidden" name="relavants['+i+'].staffId" value="' + getValue(a[i], 'staffId') + '" />',
      '</div>',
      '</div>',
      '<div class="input-tip">',
      '<label class="col-md-3 col-xs-3 col-sm-3 control-label">调查日期：</label>',
      '<div class="col-md-5 cl-sm-5 col-xs-5">',
      '<input type="text" name="relavants['+i+'].checkDate" placeholder="请输入调查日期" value="' + getValue(a[i], 'checkDate') + '" class="form-control date required dateISO" required="" aria-required="true" />',
      '</div>',
      '</div>',
      '</div>',
      '<div class="form-group form-group-sm">',
      '<label class="col-md-3 control-label">备注：</label>',
      '<div class="col-md-21">',
      '<textarea required="" aria-required="true" class="form-control" rows="3" name="relavants['+i+'].creditRemark">' + getValue(a[i], 'creditRemark') + '</textarea>',
      '</div>',
      '</div>',
      '</fieldset>',
      '</div>',
      '<div class="form-group form-group-sm panel-heading openBox" style="border-top:1px solid #ddd;">',
      '<div class="col-md-18">',
      '<h3 class="panel-title" style="line-height: 34px;">网络征信信息</h3>',
      '</div>',
      '<div class="col-md-6 text-right">',
      '<button type="button" class="btn btn-primary closeOp"><span>查看详细信息</span></button>',
      '</div>',
      '</div>',
      '<div class="openValBox">',
      '<fieldset class="disabled1Class">',
      '<div class="form-group form-group-sm">',
      '<div class="input-tip">',
      '<label class="col-md-3 col-xs-3 col-sm-3 control-label">报告日期：</label>',
      '<div class="col-md-5 cl-sm-5 col-xs-5">',
      '<input type="hidden" name="relavants['+i+'].netResult" value="1" />',
      '<input type="text" name="relavants['+i+'].netReportDate" value="' + getValue(a[i], 'netReportDate') + '" placeholder="请输入报告日期" disabled="disabled" class="form-control date required dateISO" required="" aria-required="true" />',
      '</div>',
      '</div>',
      '<div class="input-tip">',
      '<label class="col-md-3 col-xs-3 col-sm-3 control-label">风险等级：</label>',
      '<div class="col-md-5 cl-sm-5 col-xs-5">',
      '<select name="relavants['+i+'].riskStatus" value="' + a[i].riskStatus + '" class="form-control riskStatus" disabled="disabled" required="" aria-required="true">',
      '<option value="1">正常</option>',
      '<option value="2">黑名单</option>',
      '<option value="3">灰名单</option>',
      '</select>',
      '</div>',
      '</div>',
      '</div>',
      '<div class="form-group form-group-sm">',
      '<label class="col-md-3 control-label">网络征信：</label>',
      '<div class="col-md-21">',
      '<textarea disabled="disabled" required="" aria-required="true" class="form-control netReportDetailVal netReportDetail' + i + '" rows="3" name="relavants['+i+'].creditRemark"></textarea>',
      '</div>',
      '</div>',
      '</fieldset>',
      '</div>',
      '</div>',
      '</div>'
    ];
		if(a[i].borrowerRelationship == 1){    //本人
	    var oneself = htmlArr.join('');
			$(".partyBox").append(oneself);
		}else if(a[i].borrowerRelationship == 2){    //妻子
			htmlArr[0]='<div class="panel panel-default partyList">';
			htmlArr[2]='<h3 class="panel-title">配偶 - ' + a[i].fullName + '</h3>';
	    var wife = htmlArr.join('');
	    $("#wife").append(wife);
		}else{
			htmlArr[0]='<div class="panel panel-default partyList party_mean">';
			htmlArr[2]='<h3 class="panel-title">借款关系人 - ' + a[i].fullName + '</h3>';
	    var Borrower = htmlArr.join('');
	    $("#partyBox").append(Borrower);
		};
		if(a[i].riskDetail){   
			$(".netReportDetail"+ i +"").html(a[i].riskDetail);    
		}else{
			$(".netReportDetail"+ i +"").html('无记录');    
		}
		$("select[name='relavants["+ i +"].checkResult']").attr("value",a[i].checkResult).change();    //调查结果
		$("input[name='relavants["+ i +"].checkResultStatus'][value='"+ a[i].checkResultStatus +"']").attr("checked",true);    //调查结果状态
	}
	selectCheck();
	$(".disabledClass,.disabled1Class").attr("disabled", true);
};

CustomerLoad = function(a, b, c) {
	loadMess(interUrl.gr.bankList, $("#bankDeraler"), 2); //银行加载
	comn.ajax({
		url: b,
		async: false,
		data: {
			id:'',
			projectId: a.projectId,
                  loanApplyId: a.loanApplyId
		},
		success: function(res) {
			$("#creditInfoForm").values(res.data);
			if (res.data.source == 2) $(".Number").addClass('hide');
			args["creditApplyId"] = res.data.id;
                  args["customerId"] = res.data.customerId;
                  if($('#loadCreditInfo')){
                    $('#loadCreditInfo').getLoad();
                  }
			loanVal(res.data.relavants, c); //借款人、借款关系人信息处理
		}
	});
};

selectCheck = function() {
	var length = $("select").length;
	for (var i = 0; i < length; i++) {
		var val = $("select:eq(" + i + ")").attr('value');
		$("select:eq(" + i + ") option[value=" + val + "]").attr("selected", true);
	}
};

$(function(){

	CustomerLoad({projectId: args["projectId"],loanApplyId: args["loanApplyId"]}, interUrl.credit.creditInfo, '1');

  //展开关闭动画
	$(document).on("click", ".open", function() {
		$(this).removeClass("open").addClass("closeOp").parents(".openBox").next(".openValBox").stop().slideDown(1000);
	});
	$(document).on("click", ".closeOp", function() {
		$(this).removeClass("closeOp").addClass("open").parents(".openBox").next(".openValBox").stop().slideUp(1000);
	});
});