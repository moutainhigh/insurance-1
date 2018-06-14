!
    function(e) {
        if ("function" == typeof define && define.amd) define(e);
        else if ("object" == typeof exports) module.exports = e();
        else {
            var t = window.Cookies,
                a = window.Cookies = e();
            a.noConflict = function() {
                return window.Cookies = t,
                    a
            }
        }
    } (function() {
        function e() {
            for (var e = 0,
                     t = {}; e < arguments.length; e++) {
                var a = arguments[e];
                for (var n in a) t[n] = a[n]
            }
            return t
        }
        function t(a) {
            function n(t, o, i) {
                var r;
                if ("undefined" != typeof document) {
                    if (arguments.length > 1) {
                        if (i = e({
                                    path: "/"
                                },
                                n.defaults, i), "number" == typeof i.expires) {
                            var s = new Date;
                            s.setMilliseconds(s.getMilliseconds() + 864e5 * i.expires),
                                i.expires = s
                        }
                        try {
                            r = JSON.stringify(o),
                            /^[\{\[]/.test(r) && (o = r)
                        } catch(l) {}
                        return o = a.write ? a.write(o, t) : encodeURIComponent(String(o)).replace(/%(23|24|26|2B|3A|3C|3E|3D|2F|3F|40|5B|5D|5E|60|7B|7D|7C)/g, decodeURIComponent),
                            t = encodeURIComponent(String(t)),
                            t = t.replace(/%(23|24|26|2B|5E|60|7C)/g, decodeURIComponent),
                            t = t.replace(/[\(\)]/g, escape),
                            document.cookie = [t, "=", o, i.expires ? "; expires=" + i.expires.toUTCString() : "", i.path ? "; path=" + i.path: "", i.domain ? "; domain=" + i.domain: "", i.secure ? "; secure": ""].join("")
                    }
                    t || (r = {});
                    for (var d = document.cookie ? document.cookie.split("; ") : [], c = /(%[0-9A-Z]{2})+/g, u = 0; u < d.length; u++) {
                        var p = d[u].split("="),
                            f = p.slice(1).join("=");
                        '"' === f.charAt(0) && (f = f.slice(1, -1));
                        try {
                            var m = p[0].replace(c, decodeURIComponent);
                            if (f = a.read ? a.read(f, m) : a(f, m) || f.replace(c, decodeURIComponent), this.json) try {
                                f = JSON.parse(f)
                            } catch(l) {}
                            if (t === m) {
                                r = f;
                                break
                            }
                            t || (r[m] = f)
                        } catch(l) {}
                    }
                    return r
                }
            }
            return n.set = n,
                n.get = function(e) {
                    return n(e)
                },
                n.getJSON = function() {
                    return n.apply({
                            json: !0
                        },
                        [].slice.call(arguments))
                },
                n.defaults = {},
                n.remove = function(t, a) {
                    n(t, "", e(a, {
                        expires: -1
                    }))
                },
                n.withConverter = t,
                n
        }
        return t(function() {})
    });
var lang = Cookies.getJSON("maycurData") && Cookies.getJSON("maycurData").lang || window.navigator.userLanguage || window.navigator.language || "zh";
lang = "-1" == lang.indexOf("en") ? "zh": "en";
var validate_trans = {
    zh: {
        maycurAccount: "请输入正确的手机号或邮箱账号"
    },
    en: {
        maycurAccount: "Please enter the correct phone number or email account"
    }
};
$.extend($.validator.messages, validate_trans[lang]),
    jQuery.extend(jQuery.expr[":"], {
        reallyvisible: function(e) {
            return ! (jQuery(e).is(":hidden") || jQuery(e).parents(":hidden").length || "none" === jQuery(e).css("display"))
        }
    }),
    jQuery.validator.setDefaults({
        debug: !0,
        errorPlacement: function(e, t) {
            var a = t.closest(".form-group"),
                n = a.find(">label");
            0 != n.length && n.hide(),
                e.appendTo(a)
        }
    }),
    jQuery.validator.addMethod("maycurAccount",
        function(e, t, a) {
            var n = !1;
            return e = jQuery.trim(e) || "",
                this.optional(t) ? n = !0 : e.indexOf("@") !== -1 ? n = jQuery.validator.methods.email.call(this, e, t) : (n = jQuery.validator.methods.number.call(this, e, t), n && (n = jQuery.validator.methods.rangelength.call(this, e, t, a))),
                n
        }),
    jQuery.fn.select2.defaults.set("minimumResultsForSearch", 1),
    jQuery.fn.select2.defaults.set("language", "zh-CN"),
    jQuery(function() {
        $("body").on("focus", "input",
            function() {
                $(this).parents(".control").addClass("focus")
            }).on("blur", "input",
            function() {
                $(this).parents(".control").removeClass("focus")
            })
    }),
PNotify && (PNotify.prototype.options.styling = "fontawesome", PNotify.prototype.options.stack = {
    dir1: "down",
    dir2: "right"
},
    PNotify.prototype.options.addclass = "stack-center", PNotify.prototype.options.delay = 1e3, PNotify.prototype.options.width = "300px"),
"undefined" != typeof WOW && new WOW({
    offset: 100
}).init(),
    $(document).ready(function() {
        function e() {
            navigator.appName.toString().indexOf("Internet") != -1 ? window.attachEvent("onscroll",
                    function(e) {
                        s || (s = !0, setTimeout(t, 250))
                    }) : window.addEventListener("scroll",
                    function(e) {
                        s || (s = !0, setTimeout(t, 250))
                    },
                    !1),
                $(".dobber .up").click(function() {
                    return $("body,html").animate({
                            scrollTop: 0
                        },
                        300),
                        !1
                }),
                $(".dobber .qrcode").mouseenter(function() {
                    $(".dobber .qr-box").addClass("in")
                }).mouseleave(function() {
                    $(".dobber .qr-box").removeClass("in")
                })
        }
        function t() {
            var e = a();
            r.hasClass("page-index") && (e >= l ? o.addClass("navbar-scroll") : o.removeClass("navbar-scroll")),
                e >= d ? (i.removeClass("hide"), $(".kf5-support-btn").addClass("in")) : (i.addClass("hide"), $(".kf5-support-btn").removeClass("in")),
                s = !1
        }
        function a() {
            return window.pageYOffset || n.scrollTop
        }
        var n = document.documentElement,
            o = $(".navbar-default"),
            i = $(".dobber"),
            r = $("body"),
            s = !1,
            l = 160,
            d = 500;
        e()
    }),
    function(e) {
        var t = function() {};
        t.prototype = {
            init: function() {
                var e = this;
                return function(t) {
                    return e.popup.apply(e, [t])
                }
            },
            popup: function(e) {
                return (new a).init(e).create()
            }
        };
        var a = function() {
            this.msg = "",
                this.level = "",
                this.title = "",
                this.detail = "",
                this.buttons = {}
        };
        a.prototype = {
            constructor: a,
            init: function(e) {
                return e = $.extend({},
                    a.prototype.defaults, "object" == typeof e ? e: {}),
                    this.id = (new Date).getTime(),
                    this.level = e.level,
                    this.title = e.title,
                    this.msg = e.msg,
                    this.detail = e.detail,
                    this.buttons = e.buttons,
                    this.panel = e.panel,
                    this.style = e.style,
                    this.$element = null,
                    this
            },
            create: function() {
                var e = this,
                    t = '<div id="' + this.id + '" class="modal error-modal fade" tabindex="-1" aria-hidden="true" role="dialog"><div class="modal-dialog ' + this.style + '"><div class="modal-content"><div class="modal-header"><h4 class="modal-title">' + this.title + '</h4></div><div class="modal-body">' + (this.panel ? '<div class="panel last-block panel-' + this.level + '"><div class="panel-heading"><h4 class="panel-title"><a data-toggle="collapse" data-parent="#' + this.id + ' .modal-body" href="#' + this.id + '-error-detail">' + this.msg + '</a></h4></div><div id="' + this.id + '-error-detail" class="panel-collapse collapse no-"><div class="panel-body">' + this.detail + "</div></div></div>": '<div class="panel last-block panel-' + this.level + '"><div class="panel-heading"><h4 class="panel-title"><a href="javascript:void(0);">' + this.msg + "</a></h4></div></div>") + '</div><div class="modal-footer"><span class="loading-small hide pull-left"></span>';
                for (var a in this.buttons) {
                    var n = this.buttons[a];
                    t += "object" == typeof n ? '<button class="btn btn-sm ' + (n.primary ? "btn-primary": "btn-default") + '">' + a + "</button>": '<button class="btn btn-sm btn-clear">' + a + "</button>"
                }
                t += "</div></div></div></div>",
                    this.$element = $(t).appendTo("body").on("click", ".btn", $.proxy(e.click, e)).on("hidden.bs.modal", $.proxy(e.destroy, e)).modal({
                        keyboard: !1,
                        backdrop: "static"
                    })
            },
            destroy: function(e) {
                this.$element.off("click", ".btn", this.click),
                    this.$element.off("hidden.bs.modal", this.destroy),
                    $("#" + this.id).remove()
            },
            click: function(e) {
                var t = $(e.target);
                t.is("button") || (t = t.parents("button"));
                var a = t.text(),
                    n = this.buttons[a],
                    o = null;
                o = "object" == typeof n ? n.callback: n,
                    o.apply(this, [e])
            }
        },
            a.prototype.defaults = {
                msg: "Server internal error",
                level: "danger",
                title: "提示",
                detail: "无详细信息（No detail stack trace）",
                panel: !0,
                style: "modal-lg",
                buttons: {
                    "确定": {
                        primary: !0,
                        callback: function(e) {
                            this.$element.modal("hide")
                        }
                    }
                }
            },
            e.popup = (new t).init()
    } (window);
var maycurData = Cookies.getJSON("maycurData"),
    lang = maycurData && maycurData.lang || window.navigator.userLanguage || window.navigator.language || "zh",
    local = null;
lang = "-1" == lang.indexOf("en") ? "zh": "en",
    $.getJSON("../scripts/i18n/" + lang + ".json",
        function(e) {
            local = e
        }),
    $(document).ajaxSend(function(e, t, a) {
        maycurData && (t.setRequestHeader("tokenId", maycurData.maycurTokenId), t.setRequestHeader("lang", maycurData.lang), t.setRequestHeader("entCode", maycurData.entCode))
    }),
    $(document).ajaxError(function(e, t, a, n) {
        try {
            var o = $.parseJSON(t.responseText);
            "SESSION_TIME_OUT" === o.code ? popup({
                    msg: o.message,
                    title: local && local.SYS_ERROR.ERROR1 || "登录会话过期",
                    buttons: {
                        OK: {
                            primary: !0,
                            callback: function(e) {
                                this.$element.modal("hide"),
                                    window.location.replace("/signin")
                            }
                        }
                    }
                }) : new PNotify({
                    text: o.message || local && local.SYS_ERROR.ERROR2 || "服务器有一些小问题，请稍后再试。",
                    type: "error"
                })
        } catch(i) {
            new PNotify({
                text: local && local.SYS_ERROR.ERROR3 || "页面有一些小问题，请稍后再试。",
                type: "error"
            })
        }
    }),
    $(document).ajaxSuccess(function(e, t, a) {
        try {
            if (206 != t.status) {
                if ((a.url || "").indexOf(".hbs") != -1) return;
                var n = $.parseJSON(t.responseText);
                n && n.hasOwnProperty("code") && n.hasOwnProperty("message") && n.hasOwnProperty("data") && ("ACK" === n.code && n.message && !n.linkDetail ? new PNotify({
                        text: n.message,
                        type: "success"
                    }) : "NACK" === n.code && n.message && !n.linkDetail ? new PNotify({
                            text: n.message,
                            type: "warning"
                        }) : "VALIDATION_ERROR" === n.code ? $.each(n.data,
                                function(e, t) {
                                    if (t && t.formId) {
                                        var a = {};
                                        $("#" + t.formId).data("validator") || $("#" + t.formId).validate({}),
                                            $("#" + t.formId).validate().resetForm(),
                                        0 != (t.generalError || []).length && $("#" + t.formId).find(".general-error").show().text((t.generalError || []).join(",")),
                                        t.fieldErrors && ($("#" + t.formId).find("input,textarea").each(function() {
                                            var e = $(this).attr("data-prop") || $(this).attr("name");
                                            e && t.fieldErrors.hasOwnProperty(e) && (a[e] = t.fieldErrors[e])
                                        }), $("#" + t.formId).validate().showErrors(a))
                                    }
                                }) : "REDIRECT" === n.code || "BUSINESS_ERROR" !== n.code || n.linkDetail || new PNotify({
                                text: n.message,
                                type: "warning"
                            }))
            }
        } catch(o) {
            new PNotify({
                text: local && local.SYS_ERROR.ERROR4 || "服务器返回的数据有一些小问题，请稍后再试。",
                type: "error"
            })
        }
    }),
    $(function() {
        var e = navigator.appName,
            t = $(".ie-placeholder"),
            a = !1;
        e.toString().indexOf("Internet") == -1 ? t.css("display", "none") : (t.css("display", "inline-block"), a = !0),
            $(".form-control").on("keypress",
                function() {
                    $(this).prev().css("display", "none")
                }),
            $(".form-control").on("blur",
                function() {
                    "" != $(this).val() && $(this).val() || !a ? $(this).prev().css("display", "none") : $(this).prev().css("display", "inline-block")
                })
    }),
    function(e) {
        var t = e.navigator.userAgent;
        e.mobilePlatform = /IEMobile|Windows Phone|Lumia/i.test(t) ? "w": /iPhone|iP[oa]d/.test(t) ? "i": /Android/.test(t) ? "a": /BlackBerry|PlayBook|BB10/.test(t) ? "b": /Mobile Safari/.test(t) ? "s": /webOS|Mobile|Opera Mini|\bCrMo\/|Opera Mobi/i.test(t) ? 1 : 0
    } (window),
    function() {
        function e(e, t) {
            t || (t = window.location.href),
                e = e.replace(/[\[\]]/g, "\\$&");
            var a = new RegExp("[?&]" + e + "(=([^&#]*)|&|#|$)"),
                n = a.exec(t);
            return n ? n[2] ? decodeURIComponent(n[2].replace(/\+/g, " ")) : "": null
        }
        function t() {}
        function a() {
            $.extend($.validator.messages, {
                required: "这是必填项",
                remote: "请修正此项",
                email: "请输入有效的电子邮件地址",
                url: "请输入有效的网址",
                date: "请输入有效的日期",
                dateISO: "请输入有效的日期 (YYYY-MM-DD)",
                number: "请输入有效的数字",
                digits: "只能输入数字",
                alphanumeric: "只能输入数字和字母",
                creditcard: "请输入有效的信用卡号码",
                equalTo: "你的输入不相同",
                extension: "请输入有效的后缀",
                maxlength: $.validator.format("最多可以输入 {0} 个字符"),
                minlength: $.validator.format("最少要输入 {0} 个字符"),
                rangelength: $.validator.format("请输入长度在 {0} 到 {1} 之间的字符串"),
                range: $.validator.format("请输入范围在 {0} 到 {1} 之间的数值"),
                max: $.validator.format("请输入不大于 {0} 的数值"),
                min: $.validator.format("请输入不小于 {0} 的数值")
            })
        }
        var n = {};
        n.en = t,
            n.zh = a;
        var o = e("language");
        o = o || Cookies.getJSON("maycurData") && Cookies.getJSON("maycurData").lang || window.navigator.userLanguage || window.navigator.language || "zh",
            o = "-1" == o.indexOf("en") ? "zh": "en",
            n[o]()
    } ();