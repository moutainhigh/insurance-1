var cardType, comn, initEvent, interUrl, managementType, queryParams, relationship, customerType,resultStatus, tip;

comn = {};

tip = null;

(function() {
  tip = function(o) {
    var base;
    return typeof (base = window.parent.comn).tip === "function" ? base.tip(o) : void 0;
  };
  return comn = {
		    user: window.parent.user,
		    cache: window.parent.cache,
		    table: {
		      "undefinedText": "--",
		      "classes": "table-striped table-hover table",
		      "pagination": true,
		      "sidePagination": "server",
		      "queryParams": "queryParams",
		      "paginationFirstText": "第一页",
		      "paginationPreText": "上一页",
		      "paginationNextText": "下一页",
		      "paginationLastText": "最后一页",
		      "clickToSelect": true,
		      "height": "500"
		    },
		    toUrl: function(o) {
		      var base;
		      if (o.url.indexOf(".html") > -1) {
		        return typeof (base = window.parent).toUrl === "function" ? base.toUrl(o.url) : void 0;
		      }
		    },
		    addTab: function(o) {
		      if (o.href) {
		        return window.parent.menuItemClick.call(o);
		      }
		    },
        closeTab: function(){
          window.parent.closeTab();
        },
		    ajax: function(o) {
		      var _this, mask;
		      //console.log((o.url + " -->") + JSON.stringify(o.data));
		      mask = layer.load();
		      _this = this;
		      if (o.url) {
		        return $.ajax({
		          url:  o.url,
		          type: o.type || "POST",
		          dataType: "json",
		          async: o.async || true,
		          data: o.data || {},
		          complete: function(jqXHR, textStatus) {
		            return layer.close(mask);
		          },
		          success: function(data) {
		            if (data.code === 20000) {
		             /* return tip({
		                content: data.message || "<code>" + o.url + "</code><br /> 接口异常！！！"
		              })*/;
		              alert(data.message);
		              return;
		            } else if (data.code === 30000) {
		              return window.parent.location.href = "../../../index.html";
		            } else {
		              if (typeof data === "string") {
		                data = JSON.parse(data);
		              }
		              return typeof o.success === "function" ? o.success(data) : void 0;
		            }
		          },
		          error: function(jqXHR, textStatus, errorThrown) {
		            return typeof o.error === "function" ? o.error(textStatus) : void 0;
		          }
		        });
		      }
		    },
		    getArgs: function() {
		      var args, i, item, items, name, qs, value;
		      qs = (location.search.length > 0 ? location.search.substring(1) : "");
		      items = (qs.length ? qs.split("&") : []);
		      args = {};
		      i = 0;
		      while (i < items.length) {
		        item = items[i].split("=");
		        name = decodeURIComponent(item[0]);
		        value = decodeURIComponent(item[1]);
		        if (name.length) {
		          args[name] = value;
		        }
		        i++;
		      }
		      return args;
		    }
		  };
  
})();

initEvent = function() {
  return $("body").on("click", ".btn[modal='reset']", function() {
    var ref;
    return (ref = $(this).parents("form")[0]) != null ? ref.reset() : void 0;
  });
};

$.fn.nameValues = function() {
  var arg;
  arg = arguments[0];
  return $(this).find("[data-name]").each(function(index, item) {
    var key, keySwitch, value;
    key = $(this).data("name");
    keySwitch = $(this).data("formatter");
    if (keySwitch) {
      value = window[keySwitch](arg[key]) || "";
    }
    if (key) {
      return $(item).html(value || arg[key] || "");
    }
  });
};
$.fn.dataValues1 = function() {
	  var arg;
	  arg = arguments[0];
	  return $(this).find("[data-name]").each(function(index, item) {
	    var key, keySwitch, value;
	    key = $(this).data("name");
	    keySwitch = $(this).data("formatter");
	    if (keySwitch) {
	      value = window[keySwitch](arg[key]) || "";
	    }
	    if (key) {
	      return $(item).val(value || arg[key] || "");
	    }
	  });
	};


$.fn.getProvince = function() {
  comn.ajax({
    url: interUrl.common.getProvince,
    success: (function(_this) {
      return function(res) {
        var j, len, o, ref, str;
        str = "";
        ref = res.data;
        var defaultValue = $(_this).attr('defaultValue');
        for (j = 0, len = ref.length; j < len; j++) {
          o = ref[j];
          str += "<option value='" + o.areacode + "' "+(defaultValue==o.areacode?"selected":"")+">" + o.province + "</option>";
        }
        return $(_this).append(str);
      };
    })(this)
  });
  return this;
};

$.fn.getCity = function(provinceCode) {
  comn.ajax({
    url: interUrl.common.getCity,
    data: {
      areacode: provinceCode
    },
    success: (function(_this) {
      return function(res) {
        var j, len, o, ref, str;
        str = "<option value=''>--请选择--</option>";
        ref = res.data;
        var defaultValue = $(_this).attr('defaultValue');
        for (j = 0, len = ref.length; j < len; j++) {
          o = ref[j];
          str += "<option value='" + o.areacode + "' "+(defaultValue==o.areacode?"selected":"")+">" + o.city + "</option>";
        }
         $(_this).html(str);
         return;
      };
    })(this)
  });
  return this;
};

$.fn.getArea = function(cityCode) {
  comn.ajax({
    url: interUrl.common.getArea,
    data: {
      areacode: cityCode
    },
    success: (function(_this) {
      return function(res) {
        var j, len, o, ref, str;
        str = "<option value=''>--请选择--</option>";
        ref = res.data;
        var defaultValue = $(_this).attr('defaultValue');
        for (j = 0, len = ref.length; j < len; j++) {
          o = ref[j];
          str += "<option value='" + o.areacode + "' "+(defaultValue==o.areacode?"selected":"")+">" + o.county + "</option>";
        }
        $(_this).html(str);
        return
      };
    })(this)
  });
  return this;
};


interUrl = {
  basic: "/",
  common: {
    login: "login",
    getProvince: "area/getProvince",
    getCity: "area/getCityByProvince",
    getArea: "area/getCountyByCity",
    getCompany: "carDealer/branchComp/list",
    getGroup: "carDealer/group/list",
    getUserByCompanyId: "carDealer/compUser/list",
    orgList: "org/list",
    ruleList: "role/list",
    bankList: "organization/bankList",
    insuList: "insurance/list",
    orgsList: "organization/brachCompany"
  },

};

$(function() {
  $("body").on("click", "a", function(e) {
    var ref;
    if (((ref = $(this).href) != null ? ref.index(".html") : void 0) > -1) {
      e.preventDefault();
      return comn.toUrl({
        "url": $(this).href
      });
    }
  });
  
  try{
	  $(".date").datetimepicker({
	        format: "yyyy-mm-dd",
	        pickerPosition: "bottom-right",
	        language: "zh-CN",
	        minView: 2,
	        todayHighlight: true,
	        autoclose: true,
	        todayBtn: true,
	        show: true
	      });
  }catch(e){};
  initEvent();
  $(".modal").on("show.bs.modal", function() {
    if ($(this).find("form").length) {
      return $(this).find("form")[0].reset();
    }
  });
  return $("#btn-search").click(function() {
    return $("#table").bootstrapTable('refresh');
  });
});

Mock.mock(/list.json/, {
  'totalItem': 500,
  'data|40': [
    {
      'type|1': [1,2,3,4,5,6,7,8,9,10,11,12,13],
      'id': '@INT(1000, 60000)',
      'customerId': '@INT(1000, 60000)',
      'customerName': '@CHINESENAME',
      'cardId': '@INT(1,100)',
      'projcetName|1': ['车贷项目申请', '某某项目申请'],
      'mobile': '@INT(600000)',
      'proceing|1': ['调度岗', '集团估计师', '录入内勤', '审核内勤'],
      'handleP': '@NAME',
      'proced|1': ['银行征信', '公安征信', '签单分配', '签单调查'],
      'orgname|1': ['杭州分公司', '湖北分公司'],
      'faqiren': '@CHINESENAME',
      'dbe': '@FLOAT(1,2)',
      'modifyTime': Random.datetime('yyyy-MM-dd A HH:mm:ss')
    }
  ]
});

$.validator.setDefaults({
  highlight: function(e) {
    return $(e).closest(".input-tip").removeClass("has-success").addClass("has-error");
  },
  success: function(e, r) {
    return $(r).closest(".input-tip").removeClass("has-error").addClass("has-success");
  },
  errorPlacement: function(e, r) {
    if (e.text()) {
      return layer.tips(e.text(), r, {
        tips: [1, "#000"]
      });
    }
  }
});

queryParams = function(params) {
  return {
    search: params.search,
    page: (params.limit + params.offset) / params.limit,
    pageSize: params.limit
  };
};
jQuery.validator.addMethod("telephone", function(value,element){  
	  return this.optional(element) || /^[[\d]{3,4}-]?[\d]{7,8}$/.test(value);  
});
jQuery.validator.addMethod("mobile", function(value, element) {
	    return this.optional(element) || /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/.test(value);
});
jQuery.validator.addMethod("phoneMix", function(value, element) {
	    return this.optional(element) || /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/.test(value) || /^[[\d]{3,4}-]?[\d]{7,8}$/.test(value);
});
tableData = function(params, data, url, callback) {
  var p;
  p = params.data;
  if (url) {
    return comn.ajax({
      url: url,
      data: $.extend(data, p),
      success: function(res) {
        params.success({
          'total': res.totalItem,
          'rows': res.data
        });
        params.complete();
        return typeof callback === "function" ? callback(res) : void 0;
      }
    });
  }
};