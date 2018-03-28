var comn, queryParams, ref, tableData, tip;

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
	closeTab: function(){
		window.parent.closeTab();
	},
    addTab: function(o) {
      if (o.href) {
        return window.parent.menuItemClick.call(o);
      }
    },
    accAdd: function(arg1, arg2){ //js精度问题(加法)
      var r1,r2,m;
      try{
        r1=arg1.toString().split(".")[1].length
      }catch(e){r1=0}
      try{
        r2=arg2.toString().split(".")[1].length
      }catch(e){r2=0}
      m=Math.pow(10,Math.max(r1,r2))
      return (arg1*m+arg2*m)/m
    },
    accSub: function(arg1, arg2){ //js精度问题(减法)
      var r1,r2,m,n;
      try{
        r1=arg1.toString().split(".")[1].length
      }catch(e){r1=0}
      try{
        r2=arg2.toString().split(".")[1].length
      }catch(e){r2=0}
      m=Math.pow(10,Math.max(r1,r2));
      //last modify by deeka
      //动态控制精度长度
      n=(r1>=r2)?r1:r2;
      return ((arg1*m-arg2*m)/m).toFixed(n);
    },
    accMul: function(arg1, arg2){  //js精度问题(乘法)
      var m=0,s1=arg1.toString(),s2=arg2.toString();
      try{m+=s1.split(".")[1].length}catch(e){}
      try{m+=s2.split(".")[1].length}catch(e){}
      return Number(s1.replace(".",""))*Number(s2.replace(".",""))/Math.pow(10,m);
    },
    accDiv: function(arg1, arg2){  //js精度问题(除法)
      var t1=0,t2=0,r1,r2;
      try{t1=arg1.toString().split(".")[1].length}catch(e){}
      try{t2=arg2.toString().split(".")[1].length}catch(e){}
      with(Math){
        r1=Number(arg1.toString().replace(".",""))
        r2=Number(arg2.toString().replace(".",""))
        return (r1/r2)*pow(10,t2-t1);
      }
    },
    ajax: function(o) {
      var _this, mask;
      //console.log((o.url + " -->") + JSON.stringify(o.data));
      mask = layer.load();
      _this = this;
      if (o.url) {
        return $.ajax({
          url: interUrl.basic + o.url,
          type: o.type || "POST",
          dataType: "json",
          async: o.async || true,
          data: o.data || {},
          complete: function(jqXHR, textStatus) {
            return layer.close(mask);
          },
          success: function(data) {
            if (data.code === 20000) {
              return tip({
                content: data.message || "<code>" + o.url + "</code><br /> 接口异常！！！"
              });
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
    },
	/*
	 *省市区三级联动,传递参数
	 *{type: "car", level: [{
	 *    el: $("#carBrandID")  渲染对象
	 *    key: code  选中值
	 *    target: $("#id") 中文赋值对象
	 *},{
	 *    el: $("#carMakeID")
	 *    key: code
	 *    target: $("#id")
	 *},{
	 *    el: $("#carModelID")
	 *    key: code
	 *}]}
	 */
    linkage: function(o) {
      var o0, o1, o2;
      if (o.type === "car") {
        o0 = o.level[0];
        o1 = o.level[1];
        o2 = o.level[2];
        if (o1.key) {
          o1.el.getCarList(o0.key, o1.key).unbind("change").change(function() {
            if (o1.target) {
              o1.target.val($(this).find("option:selected").text());
            }
            o2.el.val("");
            if (this.value) {
              return o2.el.getCarModel(this.value);
            }
          });
        }
        if (o2.key) {
          o2.el.getCarModel(o1.key, o2.key).unbind("change").change(function() {
            if (o1.target) {
              return o2.target.val($(this).find("option:selected").text());
            }
          });
        }
        return o0.el.getBrand(o0.key || "").unbind("change").change(function() {
          if (o0.target) {
            o0.target.val($(this).find("option:selected").text());
          }
          if (this.value) {
            o2.el.val("");
            return o1.el.getCarList(this.value).unbind("change").change(function() {
              if (o1.target) {
                o1.target.val($(this).find("option:selected").text());
              }
              if (this.value) {
                return o2.el.getCarModel(this.value).unbind("change").change(function() {
                  if (o2.target) {
                    return o2.target.val($(this).find("option:selected").text());
                  }
                });
              }
            });
          }
        });
      }
    }
  };
})();

$.fn.extend({
  //获取费用类别
  getFeeCategoryCode: function(value) {
    comn.ajax({
      url: interUrl.feeManage.feeCategoryList,
      success: (function(_this) {
        return function(res) {
          var o;
          return $(_this).html("<option value=''>--请选择--</option>" + ((function() {
            var j, len, ref, results;
            ref = res.data;
            results = [];
            for (j = 0, len = ref.length; j < len; j++) {
              o = ref[j];
              results.push("<option data-id='" + o.id + "' value='" + o.codeId + "'>" + o.codeName + "</option>");
            }
            return results;
          })()).join("")).val(value || "");
        };
      })(this)
    });
    return this;
  },
  //获取费用名称
  getFeeCode: function(codeLibraryFeedTypeId, value) {
    if (codeLibraryFeedTypeId) {
      comn.ajax({
        url: interUrl.feeManage.feeList,
        data: {
          codeLibraryFeedTypeId: codeLibraryFeedTypeId
        },
        success: (function(_this) {
          return function(res) {
            var o;
            return $(_this).html("<option value=''>--请选择--</option>" + ((function() {
              var j, len, ref, results;
              ref = res.data;
              results = [];
              for (j = 0, len = ref.length; j < len; j++) {
                o = ref[j];
                results.push("<option value='" + o.codeId + "'>" + o.codeName + "</option>");
              }
              return results;
            })()).join("")).val(value || "");
          };
        })(this)
      });
    }
    return this;
  },
  //获取拖车人列表
  getDragUser: function(launchUserId, value) {
      comn.ajax({
        url: interUrl.trailer.getDragCarPeople,
        data: {
          launchUserId: launchUserId
        },
        success: (function(_this) {
          return function(res) {
            var o;
            return $(_this).html("<option value=''>--请选择--</option>" + "<option value='-1'>委外</option>" + ((function() {
              var j, len, ref, results;
              ref = res.data;
              results = [];
              for (j = 0, len = ref.length; j < len; j++) {
                o = ref[j];
                results.push("<option value='" + o.uid + "'>" + o.realname + "</option>");
              }
              return results;
            })()).join("")).val(value || "");
          };
        })(this)
      });
    return this;
  },
  nameValues: function() {
    var arg;
    arg = arguments[0];
    return $(this).find("[data-name]").each(function(index, item) {
      var key, keySwitch, value;
      key = $(this).data("name");
      keySwitch = $(this).data("formatter");
      if (keySwitch) {
        value = window[keySwitch](arg[key]) || "--";
      }
      if (key) {
        return $(item).html(value || arg[key] || "--");
      }
    });
  },
  getProvince: function(value) {
    comn.ajax({
      url: interUrl.common.getProvince,
      success: (function(_this) {
        return function(res) {
          var o;
          return $(_this).html("<option value=''>--请选择--</option>" + ((function() {
            var j, len, ref, results;
            ref = res.data;
            results = [];
            for (j = 0, len = ref.length; j < len; j++) {
              o = ref[j];
              results.push("<option value='" + o.areacode + "'>" + o.province + "</option>");
            }
            return results;
          })()).join("")).val(value || "");
        };
      })(this)
    });
    return this;
  },
  getCity: function(provinceCode, value) {
    if (provinceCode) {
      comn.ajax({
        url: interUrl.common.getCity,
        data: {
          areacode: provinceCode
        },
        success: (function(_this) {
          return function(res) {
            var o;
            return $(_this).html("<option value=''>--请选择--</option>" + ((function() {
              var j, len, ref, results;
              ref = res.data;
              results = [];
              for (j = 0, len = ref.length; j < len; j++) {
                o = ref[j];
                results.push("<option value='" + o.areacode + "'>" + o.city + "</option>");
              }
              return results;
            })()).join("")).val(value || "");
          };
        })(this)
      });
    }
    return this;
  },
  getArea: function(cityCode, value) {
    if (cityCode) {
      comn.ajax({
        url: interUrl.common.getArea,
        data: {
          areacode: cityCode
        },
        success: (function(_this) {
          return function(res) {
            var o;
            return $(_this).html("<option value=''>--请选择--</option>" + ((function() {
              var j, len, ref, results;
              ref = res.data;
              results = [];
              for (j = 0, len = ref.length; j < len; j++) {
                o = ref[j];
                results.push("<option value='" + o.areacode + "'>" + o.county + "</option>");
              }
              return results;
            })()).join("")).val(value || "");
          };
        })(this)
      });
    }
    return this;
  },
  getOrg: function(value) {
    comn.ajax({
      url: interUrl.common.orgList,
      success: (function(_this) {
        return function(res) {
          var o;
          return $(_this).html("<option value=''>--请选择--</option>" + ((function() {
            var j, len, ref, results;
            ref = res.data.module;
            results = [];
            for (j = 0, len = ref.length; j < len; j++) {
              o = ref[j];
              results.push("<option value='" + o.id + "'>" + o.name + "</option>");
            }
            return results;
          })()).join("")).val(value || "");
        };
      })(this)
    });
    return this;
  },
  getRuleList: function(value) {
    comn.ajax({
      url: interUrl.common.ruleList,
      success: (function(_this) {
        return function(res) {
          var o;
          return $(_this).html("<option value=''>--请选择--</option>" + ((function() {
            var j, len, ref, results;
            ref = res.data;
            results = [];
            for (j = 0, len = ref.length; j < len; j++) {
              o = ref[j];
              results.push("<option value='" + o.id + "'>" + o.name + "</option>");
            }
            return results;
          })()).join("")).val(value || "");
        };
      })(this)
    });
    return this;
  },
	getBrand: function(value) {
		comn.ajax({
			url: interUrl.common.brandList,
			success: (function(_this) {
				return function(res) {
					var carList;
					return $(_this).html("<option value=''>--请选择--</option>" + ((function() {
						var j, len, ref, results;
						ref = res.data;
						results = [];
						for (j = 0, len = ref.length; j < len; j++) {
							carList = ref[j].cars;
							for(var o in carList){
								results.push("<option value='" + carList[o].brandcode + "'>" + carList[o].brandname + "</option>");
							}
						}
						return results;
					})()).join("")).val(value || "");
				};
			})(this)
		});
		return this;
	},
	getCarList: function(code, value) {
    if (code) {
      comn.ajax({
        url: interUrl.common.carList,
        data: {
          brandcode: code
        },
        success: (function(_this) {
          return function(res) {
            var o;
            return $(_this).html("<option value=''>--请选择--</option>" + ((function() {
              var j, len, ref, results;
              results = [];
              ref = res.data.manuInfo;
              for(var i=0; i<ref.length;i++){
            	  var carList = ref[i].child;
            	  for (j = 0, len = carList.length; j < len; j++) {
                      o = carList[j];
                      results.push("<option value='" + o.brandcode + "'>" + o.brandname + "</option>");
                    }
              }
              return results;
            })()).join("")).val(value || "");
          };
        })(this)
      });
    }
    return this;
  },
  getCarModel: function(code, value) {
	if (code) {
      comn.ajax({
        url: interUrl.common.carModels,
        data: {
          brandcode: code
        },
        success: (function(_this) {
          return function(res) {
            var o;
            return $(_this).html("<option value=''>--请选择--</option>" + ((function() {
              var j, len, ref, results;
              ref = res.data;
              results = [];
              for (j = 0, len = ref.length; j < len; j++) {
                o = ref[j];
                for(var o in ref[j].cars)
                results.push("<option value='" + ref[j].cars[o].carid + "'>" + ref[j].cars[o].carname + "</option>");
              }
              return results;
            })()).join("")).val(value || "");
          };
        })(this)
      });
    }
    return this;
  },
  getInsurance: function(value) {
    comn.ajax({
      url: interUrl.common.insuranceList,
      success: (function(_this) {
        return function(res) {
          var o;
          return $(_this).html("<option value=''>--请选择--</option>" + ((function() {
            var j, len, ref, results;
            ref = res.data;
            results = [];
            for (j = 0, len = ref.length; j < len; j++) {
              o = ref[j];
              results.push("<option value='" + o.id + "'>" + o.insuranceCompanyName + "</option>");
            }
            return results;
          })()).join("")).val(value || "");
        };
      })(this)
    });
    return this;
  },
  getLoad: function(callback) {
    if (!$(this).hasClass("loaded")) {
      $(this).load($(this).data("url") + ("?t=" + (new Date().getTime())), (function(_this) {
        return function() {
          if (typeof callback === "function") {
            callback();
          }
          return $(_this).addClass("loaded");
        };
      })(this));
    }
    return this;
  },
  getCarDealer: function(value) {
    comn.ajax({
      url: interUrl.common.loanCarList,
      success: (function(_this) {
        return function(res) {
          var o;
          return $(_this).html("<option value=''>--请选择--</option>" + ((function() {
            var j, len, ref, results;
            ref = res.data;
            results = [];
            for (j = 0, len = ref.length; j < len; j++) {
              o = ref[j];
              results.push("<option value='" + o.id + "'>" + o.dealerName + "</option>");
            }
            return results;
          })()).join("")).val(value || "");
        };
      })(this)
    });
    return this;
  },
  getCompany: function(value) {
    comn.ajax({
      url: interUrl.common.getCompany,
      success: (function(_this) {
        return function(res) {
          var o;
          return $(_this).html("<option value=''>--请选择--</option>" + ((function() {
            var j, len, ref, results;
            ref = res.data;
            results = [];
            for (j = 0, len = ref.length; j < len; j++) {
              o = ref[j];
              results.push("<option value='" + o.id + "'>" + o.name + "</option>");
            }
            return results;
          })()).join("")).val(value || "");
        };
      })(this)
    });
    return this;
  },
  getGroup: function(companyId, value) {
    if (companyId) {
      comn.ajax({
        url: interUrl.common.getGroup,
        data: {
          companyId: companyId
        },
        success: (function(_this) {
          return function(res) {
            var o;
            return $(_this).html("<option value=''>--请选择--</option>" + ((function() {
              var j, len, ref, results;
              ref = res.data;
              results = [];
              for (j = 0, len = ref.length; j < len; j++) {
                o = ref[j];
                results.push("<option value='" + o.id + "'>" + o.name + "</option>");
              }
              return results;
            })()).join("")).val(value || "");
          };
        })(this)
      });
    }
    return this;
  }
});

$(function() {
  $(window).resize(function() {
    var base;
    return typeof (base = $("table")).bootstrapTable === "function" ? base.bootstrapTable('resetView') : void 0;
  });
  $("body").on("click", "a", function(e) {
    var ref;
    if (((ref = $(this).href) != null ? ref.index(".html") : void 0) > -1) {
      e.preventDefault();
      return comn.toUrl({
        "url": $(this).href
      });
    }
  }).on("focus", ".date", function() {
    var base;
    return typeof (base = $(this)).datetimepicker === "function" ? base.datetimepicker({
      format: "yyyy-mm-dd",
      pickerPosition: "bottom-right",
      language: "zh-CN",
      minView: 2,
      todayHighlight: true,
      autoclose: true,
      todayBtn: true,
      show: true
    }) : void 0;
  }).on("show.bs.tab", "[data-toggle='tab']", function(e) {
    return $($(this).attr("href")).find("[data-url]").getLoad();
  }).on("click", ".btn[modal='reset']", function() {
    var ref;
    return (ref = $(this).parents("form")[0]) != null ? ref.reset() : void 0;
  });
  $(".modal").on("show.bs.modal", function() {
    if ($(this).find("form").length) {
      return $(this).find("form")[0].reset();
    }
  });
  return $("#btn-search").click(function() {
    return $("#table").bootstrapTable('refresh', {url: "..."});
  });
});

if (typeof Mock !== "undefined" && Mock !== null) {
  Mock.mock(/list.json/, {
    'totalItem': 500,
    'data|40': [
      {
        'id': '@INT(1000, 60000)',
        'customerId': '@INT(1000, 60000)',
        'cardNo': '@INT(1000000000000000, 6000000000000000)',
        'loanAmount': '@INT(1000, 60000)',
        'loanTerm|1': [1, 2, 3],
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
}

if ((ref = $.validator) != null) {
  ref.setDefaults({
    highlight: function(e) {
      return $(e).closest(".input-tip").removeClass("has-success").addClass("has-error");
    },
    success: function(e, r) {
      return $(r).closest(".input-tip").removeClass("has-error").addClass("has-success");
    },
    errorPlacement: function(e, r) {
      if (e.text()) {
        return e.appendTo((r.is(":radio") || r.is(":checkbox") ? r.parent().parent().parent() : r.parent()));
      }
    }
  });
}

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

queryParams = function(params) {
  return {
    search: params.search,
    page: (params.limit + params.offset) / params.limit,
    pageSize: params.limit
  };
};


