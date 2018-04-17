$(function () {
	$("#loan_menu").addClass("active");
	$("#loan_menu").parents('li').addClass("active open");
	
	var table = $('#loanDatatable');
  
    var datatable= table.dataTable({
		  "scrollY":        "1000px",
		  "scrollX": true,
		  "scroller":true,
		  "bAutoWidth":false,
	  	  "scrollCollapse": true,
	  		"columns": [
				{
				    "class":          "details-control",
				    "orderable":      false,
				    "data":           null,
				    "defaultContent": "<a href='javascript:void(0);'><i class='fa fa-plus-square'></i></a>"
				},
    			{ "data": "loanCode"},
				{ "data": "insuresName"},
				{ "data": "carModelName"},
				{ "data": "carPlateNumber"},
				{ "data": "policyInsuranceCompany"},
				{ "data": "policyEffectDate"},
				{ "data": "policyExpireDate"},
				{ "data": "ctime"},
				{ "data": "submitPerson"},
				{ "data": "auditStatus"}
		        ],  
		     "columnDefs": [

				{
					"targets" : [ 10 ], // 目标列位置，下标从0开始
					"data" : "auditStatus",
					"render" : function(data, type, full) {
						return handle_auditStatus(data, full, 1);
					}
				},

				{
					"targets" : [ 11 ], // 目标列位置，下标从0开始
					"data" : "loanId",
					"render" : function(data, type, full) {
						return handle_1(data, full, 0)
					}
				}
		      ],
			"ajax": {
		        "dataType" : 'json',
		        "type" : "POST",
		        "url" :loanListAjaxUrl,
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
			//"dom" : '<"top">r<"table-scrollable"t><"bottom"flpi<"col-md-12 center-block" >>',
			"dom" : '<"top">rt<"bottom"flpi<"col-md-12 center-block" >>',
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
		 	"fnInitComplete": function(oSettings) {
		        jQuery("#loanDatatable").css("width","100%");
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
		    	jQuery("#loanDatatable").css("width","100%");
		        $('.dataTables_scrollBody').css('height', ($(window).height() - 400));
		    }
		    
   	});
   var tableWrapper = $('#loanDatatable_wrapper'); // datatable creates the table wrapper by adding with id {your_table_jd}_wrapper
   var tableColumnToggler = $('#loanDatatable_column_toggler');
   
   /* handle show/hide columns*/
   $('input[type="checkbox"]', tableColumnToggler).change(function () {
       /* Get the DataTables object again - this is not a recreation, just a get of the object */
       var iCol = parseInt($(this).attr("data-column"));
       var bVis = datatable.fnSettings().aoColumns[iCol].bVisible;
       datatable.fnSetColumnVis(iCol, (bVis ? false : true));
   });
   
	var detailRows = [];
	jQuery('#loanDatatable tbody').on( 'click', 'tr td.details-control', function () {
		var tr = jQuery(this).closest('tr');
		var row = datatable.api().row( tr );
	    var idx = jQuery.inArray( tr.attr('id'), detailRows );
	    if ( row.child.isShown() ) {
	    	  jQuery(this).html("<a href='javascript:void(0);'><i class='fa fa-plus-square'></i></a>");
	          tr.removeClass( 'details' );
	          row.child.hide();
	          // Remove from the 'open' array
	          detailRows.splice( idx, 1 );
	      }
      else {
          jQuery(this).html("<a href='javascript:void(0);'><i class='fa fa-minus-circle'></i></a>");
          tr.addClass( 'details' );
          jQuery.ajax({
  	        "type" : "GET",
  	        "url" : loanDetailUrl,
  	        "data":{
  	        	loanId:row.data().loanId
  	         },
  	         success:function(data){
  	       		row.child( data)
  	         },
  	         error:function(data){
  	        	 alert("网络错误");
  	         }
  		});
       	row.child( "<div id='productDetail_"+row.data().id+"' style='text-align:center'><img src='../../assets/global/img/ajax-loader-7.gif'></div>"  ).show();
        // Add to the 'open' array
        if ( idx === -1 ) {
            detailRows.push( tr.attr('id') );
        }
      }
  });

  // On each draw, loop over the `detailRows` array and show any child rows
  datatable.on( 'draw', function () {
  	 jQuery.each( detailRows, function ( i, id ) {
  		 jQuery('#'+id+' td.details-control').trigger( 'click' );
      } );
  });
   
   jQuery('body').on('click','.modify',function(){
	   var tr = $(this).closest('tr');
	   var row = datatable.api().row( tr );
	   //init data
        window.mode = 'modify';
        resetDialog();
        $("#area_1").getArea(row.data().area);  
        $('#Dialog_about_bank').modal('show');
        $('#Dialog_about_bank .basicinfo-form').values(row.data());
	});

   jQuery('body').on('click','.pictureVideo',function(){
	   var tr = $(this).closest('tr');
	   var row = datatable.api().row( tr );
	   jQuery("#pictureVideoIframe").attr("src",loanDocumentUrl+"?loanId="+row.data().loanId)
	   //init data
        $('#Dialog_pictureVideo').modal('show');
	});


   jQuery('body').on('click','.submitLoan',function(){
	   var tr = $(this).closest('tr');
	   var row = datatable.api().row( tr );
	   if(confirm("确定要提交审批吗？")){
		   comn.ajax({
	            url: submitLoanUrl,
	            data: {
	            	"loanId":row.data().loanId
	            },
	            success: function (res) {
	                if (res && res.code == 10000) {
	                    alert(res.message);
	                }
	                if (res && res.code == 20000) {
	                    alert(res.message);
	                }
	                $('.btn-search').trigger('click');  
	            }
	        });
	   }
	});
   jQuery('body').on('click','.approveLoan',function(){
	   var tr = $(this).closest('tr');
	   var row = datatable.api().row( tr );
	   jQuery("#pictureVideoIframe").attr("src",loanApproveUrl+"?loanId="+row.data().loanId)
	   //init data
        $('#Dialog_pictureVideo').modal('show');
	});
   
   
   //load bank list
    $('.btn-search').on('click', function () {
    	datatable.fnDraw();
    });

    //add new bank
    $('.add-new-bank').on('click', function () {
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
    $('#Dialog_about_bank').on('click', '.save', function () {
    	var dialogForm =$('#Dialog_about_bank .basicinfo-form')
        if(!dialogForm.valid()){
        	return false;
        }
        
        var data = dialogForm.values();
        //****************去掉文本框空格
        
        var url='fss/guarantee/addGuarantee';
        if(window.mode == 'modify'){
            url='fss/guarantee/updateGuarantee';
        }
        //$("#ddlregtype").find("option:selected").text();
        data.provinceName= dialogForm.find("#province_1").find("option:selected").text();
        data.cityName= dialogForm.find("#city_1").find("option:selected").text();
        data.areaName= dialogForm.find("#area_1").find("option:selected").text();
        
        comn.ajax({
            url: url,
            data: {
            	"guaranteeJson": JSON.stringify(data)
            },
            success: function (res) {
                if (res && res.code == 10000) {
                    alert(res.message);
                    $('#Dialog_about_bank').modal('hide');
                }
                if (res && res.code == 20000) {
                    alert(res.message);
                }
                $('.btn-search').trigger('click');  
            }
        });
    });

    //common
   /* $("#province_1").getProvince().change(function () {
        if (this.value) {
            $("#area_1").val("");
            return $("#city_1").getCity(this.value).unbind("change").change(function () {
                if (this.value) {
                    return $("#area_1").getArea(this.value);
                }
            });
        }
    });*/
    $('#Dialog_about_bank .basicinfo-form').validate();

    
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
	   	jQuery("#loanDatatable").css("width","100%");
        $('.dataTables_scrollBody').css('height', ($(window).height() - 400));
	 });
   
});



//tool functions
function resetDialog() {
    if (window.mode == 'add') {
    	//document.getElementById("departmentName").readOnly=false;
        $('#Dialog_about_bank .modal-header .modal-title').html('创建业务渠道');
    }
    if (window.mode == 'modify') {
    	//document.getElementById("departmentName").readOnly=true;
        $('#Dialog_about_bank .modal-header .modal-title').html('修改业务渠道');
    }

    //reset form values
    $('#Dialog_about_bank').find('input,select').val('');

}

function handle_1(value, row, index) {
	var string="";
	if(row.auditStatus=='UNSUBMIT' || row.auditStatus=='AUDIT_NOT_PASS'){
		string="<li><a href='javascript:;' class='approveLoan'><i class='icon-docs'></i>提交审核 </a></li>";
    }else{
    	string="<li><a href='javascript:;' class='approveLoan'><i class='icon-docs'></i>贷款详情 </a></li>";
    }
	 return ["<div class='btn-group btn-group-sm' style='top: 0px; float: left;'>",
	        	"<button type='button' class='btn btn-blue-c dropdown-toggle' data-toggle='dropdown'>",
	        	"<span class='hidden-xs'>操作</span><i class='fa fa-angle-down'></i>",
	        	"</button>",
	        	"<ul class='dropdown-menu' role='menu'>",
	        	string,
	        	"<li><a href='javascript:;' class='pictureVideo'><i class='icon-docs'></i>查看资料 </a></li>",
	        	"</ul>",
	        "</div>"].join("");
}

function handle_auditStatus(value, row, index){
	    if(value=='UNSUBMIT'){
	    	return "未提交";
	    }else if(value=='WAIT_ADUIT'){
	    	return "待审核";
	    }
	    else if(value=='ADUIT_PASS'){
	    	return "审核通过";
	    }
	    else if(value=='AUDIT_NOT_PASS'){
	    	return "审核未通过";
	    }
	    else if(value=='AUDIT_BACK'){
	    	return "退回";
	    }
	    else {
	    	return "未知["+value+"]";
	    }
}

function handle_dealwithStatus(value, row, index) {
    if(value=='HAVE_TODO'){
    	return "已办";
    }else {
    	return "未办";
    }
}


function handle_loanType(value, row, index) {
    if(value=='PURCHASE_CAR_TERM'){
    	return "购车分期";
    }else {
    	return "其他";
    }
}

function handle_sex(value, row, index) {
    if(value=='F'){
    	return "女";
    }else if(value=='M'){
    	return "男";
    }
}
