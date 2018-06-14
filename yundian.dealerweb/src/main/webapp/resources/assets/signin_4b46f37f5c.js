$(function () {
  // var signInDto = {loginType: 0}, cookieData, redirectUrl;
  // var data = [{
  //   id: 'zh',
  //   text: '中文（简体）'
  // }, {
  //   id: 'en',
  //   text: 'English'
  // }];
  // var local = null;
  // var ldapMode;
  // var lang = (Cookies.getJSON('maycurData') && Cookies.getJSON('maycurData').lang) ||
  //   window.navigator.userLanguage ||
  //   window.navigator.language ||
  //   'zh';
  //
  // lang = lang.indexOf('en') == '-1' ? 'zh' : 'en';
  // if(!Cookies.getJSON('maycurData')){
  //   Cookies.set('maycurData', {lang: lang});
  //   location.reload();
  // }
  //
  // $('.language-switch').select2({
  //   data: data,
  //   minimumResultsForSearch: Infinity
  // });
  // $('.language-switch').val(lang).trigger('change');
  //
  // //设置记住的用户名和密码
  // var maycurAccount = Cookies.getJSON('maycurAccount');
  // if(maycurAccount) {
  //   $('input.phone-email').val(maycurAccount.account || '');
  //   $('input.password').val(maycurAccount.pwd || '');
  // }

  focusFirstInput();


  // $('.dobber-signin .qrcode').mouseenter(function () {
  //   $('.dobber-signin .qr-box').addClass('in');
  // }).mouseleave(function () {
  //   $('.dobber-signin .qr-box').removeClass('in');
  // });
  //
  //
  // $('#captcha-img').click(function () {
  //   var $img = $('#captcha-img');
  //   $img.attr('src', '/captcha.jpg?t=' + new Date().getTime());
  // });

  /**
   * do sign in
   */
  $('.signin-btn').click(function (e) {
      var $this = $(this);
      e.preventDefault();
      e.stopPropagation();
      var $form = $('.signin-form');
      var $formPane =  $('.normal-signin');
      if (!$form.validate({
              errorPlacement: function(error, element) {
                  // Append error within linked label
                  $( element )
                      .closest( "div" )
                      .after( error );
              }}).form()) {
          return false;
      }
      doTrim();
      var signInDto ={};
      // set value for the dto property
      $formPane.find('input').each(function () {
          var prop = $(this).attr('name');
          var value = $(this).val();
          signInDto[prop] = value;

      });
      $form.find('.error-box').addClass('hide');
      // do sign in
      var param = {
          from: getParameterByName('from'),
          return_to: getParameterByName('return_to')
      };
      if (param.from) {
          var qs = decodeURIComponent($.param(param));
      }
      $this.button('loading');

      //初始化Cookies
      // Cookies.set('maycurData', {lang: lang});


      $.ajax({
          type: 'POST',
          url: $form.attr('action') + (qs ? '?' + qs : ''),
          // contentType: 'application/json; charset=utf-8',
          dataType: 'json',
          // headers: {
          //     'x-form-id': $form.attr('id'),
          //     'accept': 'application/json; text/javascript',
          //     'tokenid': ''
          // },
          data: getQueryString(signInDto)
      }).then(function (data) {

          if (data && data.success) {
              // data = data.data || {};
              // writeCookie(data);
              location.href = '/index.html';
          }else if (data && !data.success) { //密码错误或者需要验证码
                  $form.find('.error-box').removeClass('hide');
                  $form.find('.error-box .alert').text(data.msg);
          }
          $this.button('reset');
      });

  });

  function writeCookie(data) {
    var ent = data.ents &&
      (data.ents.length === 1) &&
      data.ents[0] || null;
    // write session cookies
    window.maycurData = {
      maycurTokenId: data.tokenId,
      lang: data.lang,
      entCode: ent ? ent.entCode : data.entCode,
      userCode: data.userCode,
      userName: data.userName,
      account: data.account,
      symbol: data.symbol,
      vipUser: data.vipUser
    };

    var ifAuto = $(".checkbox-input");
    if (ifAuto.hasClass("selected")) {
    //  Cookies.set('maycurData', window.maycurData, {expires: 60});
    }
    else {
     // Cookies.set('maycurData', window.maycurData);
    }
  }




  /**
   * focus on the first visible input.
   */
  function focusFirstInput() {

    var status = $('#account-switcher').data('status') || 'maycur',
      maycurLabel = $(this).data('maycur-label'),
      ldapLabel = $(this).data('ldap-label');

    if (status === 'maycur') {
      $('.signin-form input[name="maycurAccount"]').focus();
    } else {
      $('.signin-form input[name="corpDomain"]').focus();
    }
  }

  /**
   * Get the query param from url
   * @param name
   * @param url
   * @returns {*}
   */
  function getParameterByName(name, url) {
    if (!url) url = window.location.href;
    name = name.replace(/[\[\]]/g, "\\$&");
    var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
      results = regex.exec(url);
    if (!results) return null;
    if (!results[2]) return '';
    return decodeURIComponent(results[2].replace(/\+/g, " "));
  }

  function doTrim() {
    $("input:not([type ='password'])").each(function () {
      $(this).val($.trim($(this).val()));
    })
  }
 function getQueryString(json) {
        if (!json) return ''
        return cleanArray(Object.keys(json).map(key => {
            if (json[key] === undefined) return ''
            return encodeURIComponent(key) + '=' +
                encodeURIComponent(json[key])
        })).join('&')
}
function cleanArray(actual) {
        const newArray = []
        for (let i = 0; i < actual.length; i++) {
            if (actual[i]) {
                newArray.push(actual[i])
            }
        }
        return newArray
}
  //change language
  $('.language-switch').on('select2:select', function () {
    lang = $('.language-switch').val();
   // Cookies.set('maycurData', {lang: lang});
    //存储用户名和密码，切换语言后不用重新输入
    // Cookies.set('maycurAccount', {
    //   account: $('input.phone-email').val(),
    //   pwd: $('input.password').val()
    // });
    // location.reload();
  });

  /*
   * Translated default messages for the jQuery validation plugin.
   * Locale: ZH (Chinese, 中文 (Zhōngwén), 汉语, 漢語)
   */
    $.extend($.validator.messages, {
        required: "这是必填字段",
        remote: "请修正此字段",
        email: "请输入有效的电子邮件地址",
        url: "请输入有效的网址",
        date: "请输入有效的日期",
        dateISO: "请输入有效的日期 (YYYY-MM-DD)",
        number: "请输入有效的数字",
        digits: "只能输入数字",
        creditcard: "请输入有效的信用卡号码",
        equalTo: "你的输入不相同",
        extension: "请输入有效的后缀",
        maxlength: $.validator.format("最多可以输入 {0} 个字符"),
        minlength: $.validator.format("最少要输入 {0} 个字符"),
        rangelength: $.validator.format("请输入长度在 {0} 到 {1} 之间的字符串"),
        range: $.validator.format("请输入范围在 {0} 到 {1} 之间的数值"),
        max: $.validator.format("请输入不大于 {0} 的数值"),
        min: $.validator.format("请输入不小于 {0} 的数值")
    });
});
