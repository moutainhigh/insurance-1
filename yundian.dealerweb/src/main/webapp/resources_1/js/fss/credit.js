$(function () {
	$("#creditList_menu").addClass("active");
	$("#creditList_menu").parents('li').addClass("active open");
	
	var table = $('#sample_3');
    /* Formatting function for row details */
    function fnFormatDetails(oTable, nTr) {
        var aData = oTable.fnGetData(nTr);
        var sOut = '<table>';
        sOut += '<tr><td>Platform(s):</td><td>' + aData[2] + '</td></tr>';
        sOut += '<tr><td>Engine version:</td><td>' + aData[3] + '</td></tr>';
        sOut += '<tr><td>CSS grade:</td><td>' + aData[4] + '</td></tr>';
        sOut += '<tr><td>Others:</td><td>Could provide a link here</td></tr>';
        sOut += '</table>';

        return sOut;
    }
  
   var datatable= table.dataTable({
		  "scrollY":        "600px",
		  "scrollX": true,
		  "scroller":true,
		  "bAutoWidth":false,
	  	   "scrollCollapse": true,
	  		"columns": [
				{ "data": "name"},
				{ "data": "idcard"},
				{ "data": "bankName"},
				{ "data": "guaranteeName"},
				{ "data": "guaranteeUserName"},
				{ "data": "creditStatus"},
				{ "data": "creditApplyTime"},
				{ "data": "creditAuditTime"},
		      ],  
		     "columnDefs": [
				{
					"targets" : [ 5 ], // 目标列位置，下标从0开始
					"data" : "creditStatus", 
					"render" : function(data, type, full) {
						return handle_creditStatus(data, full, 1);
					}
				},
				
				{
				"targets" : [ 6,7], // 目标列位置，下标从0开始
					"render" : function(data, type, full) {
												if(typeof(data)=="undefined" || data==""){return "";} return $.format.date(data,'yyyy-MM-dd HH:mm:ss');
					}
				},
				{
					"targets" : [ 8 ], // 目标列位置，下标从0开始
					"data" : "id", 
					"render" : function(data, type, full) {
						return handle_1(data, full, 0)
					}
				}
		      ],
			"ajax": {
		        "dataType" : 'json',
		        "type" : "POST",
		        "url" :creditListAjaxUrl,
		        "data": function ( d ) {
		        	var formValues=jQuery("#query_form").values();
		        	d.queryJson=JSON.stringify(formValues) 
		         }
		    },
			"processing": false,
			"bServerSide": true,
			"bPaginate": true, //翻页功能             
			"iDisplayLength": 10,  
			"bSort":false,  
			"bFilter":false,
			//"dom": "<'row'<'col-md-6 col-sm-12'l><'col-md-6 col-sm-12'f>r>t<'row'<'col-md-5 col-sm-12'i><'col-md-7 col-sm-12'p>>", // datatable layout without  horizobtal scroll
			"dom" : '<"top">r<"table-scrollable"t><"bottom"flpi<"col-md-12 center-block" >>',
			"scrollY": "300",
			"useColumnParam":false,
			"oLanguage": {
				"sLengthMenu": "每页显示 _MENU_ 条记录",
				"sInfo": "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
				"sInfoEmpty": "没有数据",
				"sInfoFiltered": "(从 _MAX_ 条数据中检索)",
				"oPaginate": {
					"sFirst": "首页",
					"sPrevious": "前一页",
					"sNext": "后一页",
					"sLast": "尾页"
					},
				"sZeroRecords": "没有检索到数据",
				"aLengthMenu": [[10, 25, 50,100], [10, 25, 50,100]],
			 	"bLengthChange":true
		 	},
		 	"fnInitComplete": function() {
		        jQuery("#sample_3").css("width","100%");
			   	$('.dataTables_scrollBody').css('height', ($(window).height() - 400));
		    },
		    "fnPreDrawCallback":function(oSettings){
		    	if(typeof(oSettings.json)!="undefined"){
		    		if(oSettings.json.timeout=="-1"){
			    		window.location.href=oSettings.json.timeoutHref;
			    	}
		    	}
		    },
		    "fnDrawCallback":function(oSettings){
		    	jQuery("#sample_3").css("width","100%");
			   	$('.dataTables_scrollBody').css('height', ($(window).height() - 400));
		    }
   	});
   
	   $("#signTimeStart").datetimepicker({
	       format: "yyyy-mm-dd",
	       autoclose: true,
	       minView: "month",
	       maxView: "decade",
	       todayBtn: true,
	       language:'zh-CN',
	       pickerPosition: "bottom-left",
	   }).on("click",function(ev){
	       $("#signTimeStart").datetimepicker("setEndDate", $("#signTimeEnd").val());
	   });
	   $("#signTimeEnd").datetimepicker({
	       format: "yyyy-mm-dd",
	       autoclose: true,
	       minView: "month",
	       maxView: "decade",
	       todayBtn: true,
	       language:'zh-CN',
	       pickerPosition: "bottom-left",
	   }).on("click", function (ev) {
	       $("#signTimeEnd").datetimepicker("setStartDate", $("#signTimeStart").val());
	   });
   
   
	 //窗口大小变化时，表格大小调整
	 $(window).resize(function() {
	 	datatable.fnAdjustTableSize();
	   	jQuery("#sample_3").css("width","100%");
	   	$('.dataTables_scrollBody').css('height', ($(window).height() - 400));
	 });
   
	//load bank list
    $('.btn-search').on('click', function () {
    	  datatable.fnDraw();
    });

    //add new bank
    $('#add_new_guarntee_user').on('click', function () {
        //init data
        window.mode = 'add';
        resetDialog();
    });
    
    //select common event
    $('select').on('change', function () {
        //set hidden input
        $(this).siblings('input[type="hidden"]').val($(this).find("option:selected").text());
    });

    //add bank
    $('#Dialog_new_guarntee_user').on('click', '.saveUserInfo', function () {
    	var dialogForm =$('#Dialog_new_guarntee_user .userinfo-form')
        if(!dialogForm.valid()){
        	return false;
        }
        
        var data = dialogForm.values();
        //****************去掉文本框空格
        
        var url=addGuaranteeUserUrl;
        if(window.mode == 'modify'){
            url=updateGuaranteeUserUrl;
        }
        
        comn.ajax({
            url: url,
            data: {
            	"userinfo": JSON.stringify(data)
            },
            success: function (res) {
                if (res && res.code == 10000) {
                    alert(res.message);
                    $('#Dialog_new_guarntee_user').modal('hide');
                }
                if (res && res.code == 20000) {
                    alert(res.message);
                }
                $('.btn-search').trigger('click');  
            },
            error:function(res){
            	alert("网络异常");
            }
        }); 
    });
//    
//    jQuery('body').on('click','.modify',function(){
// 	   var tr = $(this).closest('tr');
// 	   var row = datatable.api().row( tr );
// 	   //init data
//         window.mode = 'modify';
//         resetDialog();
//         $('#Dialog_new_guarntee_user').modal('show');
//         $('#Dialog_new_guarntee_user .userinfo-form').values(row.data());
// 	});
    
    jQuery('body').on('click','.detail',function(){
 	   var tr = $(this).closest('tr');
 	   var row = datatable.api().row( tr );
 	   jQuery("#creditDetailIframe").attr("src",creditDetailUrl+"?creditId="+row.data().creditId)
 	   //init data
         $('#Dialog_creditDetail').modal('show');
 	});
    
    
  //common
//    $("#province_1").getProvince().change(function () {
//        if (this.value) {
//            $("#area_1").val("");
//            return $("#city_1").getCity(this.value).unbind("change").change(function () {
//                if (this.value) {
//                    return $("#area_1").getArea(this.value);
//                }
//            });
//        }
//    });
    $('#Dialog_new_guarntee_user .userinfo-form').validate();

});


//tool functions
function resetDialog() {
    if (window.mode == 'add') {
    	$("#userPwdTip").show();
    	$("#userName").attr("readonly",false);
        $('#Dialog_new_guarntee_user .modal-header .modal-title').html('新建担保用户信息');
    }
    if (window.mode == 'modify') {
    	$("#userPwdTip").hide();
    	$("#userName").attr("readonly",true);
    	$('#Dialog_new_guarntee_user .modal-header .modal-title').html('修改担保用户信息');
    }

    //reset form values
    $('#Dialog_new_guarntee_user').find('input,select').val('');

}

function handle_1(value, row, index) {
	return ["<div class='btn-group btn-group-sm' style='top: 0px; float: left;'>",
        	"<button type='button' class='btn btn-blue-c dropdown-toggle' data-toggle='dropdown'>",
        	"<span class='hidden-xs'>操作</span><i class='fa fa-angle-down'></i>",
        	"</button>",
        	"<ul class='dropdown-menu' role='menu'>",
        		//"<li><a href='javascript:;' class='modify'><i class='icon-docs'></i>修改 </a></li>",
        		"<li><a href='javascript:;' class='detail'><i class='icon-docs'></i>详情 </a></li>",
        	"</ul>",
        "</div>"].join("");}

function handle_creditStatus(value, row, index) {
    if(value=='SUBMITED'){
    	return "已提交";
    }else if(value=='WAIT_ADUIT'){
    	return "待调查";
    }else if(value=='CREDIT_PASS'){
    	return "征信通过";
	}else if(value=='CREDIT_NOT_PASS'){
		return "征信不通过";
	}else if(value=='CREDIT_BACK'){
		return "退回";
	}
	else{
		return value;
    }
}

function handle_roleId(value, row, index) {
    if(value=="ADMIN"){
    	return "管理员";
    }else {// if(value=="GENERAL"){
    	return "普通";
    }
};
