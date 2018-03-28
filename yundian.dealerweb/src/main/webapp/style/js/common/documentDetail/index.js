var args, base64, cureent_dir, freeObj, getDocumentList, getSelectImage, loadTree, targetDir, treeTarget, zTreeOnClick;

jQuery.browser = {};

(function() {
  jQuery.browser.msie = false;
  jQuery.browser.version = 0;
  if (navigator.userAgent.match(/MSIE ([0-9]+)\./)) {
    jQuery.browser.msie = true;
    return jQuery.browser.version = RegExp.$1;
  }
})();

freeObj = null;

treeTarget = null;

cureent_dir = null;

getDocumentList = null;

targetDir = null;

imgType = null;

args = args || comn.getArgs();

var m = {};
m.loanApplyId = args['id'] || args['loanApplyId'];

base64 = function(file, index, callback) {
  return lrz(file).then(function(rst) {
    var imgRst;
    imgRst = rst.base64;
    return typeof callback === "function" ? callback(file, imgRst, index) : void 0;
  });
};

zTreeOnClick = function(event, treeId, treeNod) {
  console.log(cureent_dir);
  var page;
  $("#fileList tbody").html("");
  //if (!treeNod.isParent) {
  if (true) {
    if (treeNod.docType === "1") {
      $("#upMovie").addClass("hide");
      $("#upImage").removeClass("hide");
    } else if (treeNod.docType === "2") {
      $("#upMovie").removeClass("hide");
      $("#upImage").addClass("hide");
    }
    $("#upImage").removeClass("disabled");
    $("#removed").removeClass("disabled").html("<span>查看已删除影像</span>");
    $("#moveImage, #delImage").addClass("disabled");
    cureent_dir = treeNod;
    page = 0;
    imgType = null;
    $("#documentList").html("");
    getDocumentList = function(o) {
      page = (o && o.curPage) || ++page;
      if (page === 1) {
        $("#documentList").html("");
      }
      return comn.ajax({
        url: (o && o.url) || interUrl.gr.documentList,
        data: {
          loanApplyId: m.loanApplyId,
          dirId: cureent_dir['id'],
          fileNamespace: args['space'] || "",
          releventFlow: args['releventFlow'] || "",
          releventFlowNode: args['releventFlowNode'] || "",
          type: imgType,
          page: page || 1,
          pageSize: 20
        },
        success: function(res) {
          var item;
          if (cureent_dir.canUpload === 2) {
            $("#upImage, #upload, #upMovie").hide();
          } else {
            $("#upImage, #upload, #upMovie").show();
          }
          if (cureent_dir.canDelete === 2) {
            $("#delImage").hide();
          } else {
            $("#delImage").show();
          }
          if (cureent_dir.canMove === 2) {
            $("#moveImage").hide();
          } else {
            $("#moveImage").show();
          }
          if (page === 1) {
            $("#moveImage, #delImage, #btnPrint").addClass("disabled");
          }
          $("#documentList").append(((function() {
            var j, len, ref, results;
            ref = res.data;
            results = [];
            for (j = 0, len = ref.length; j < len; j++) {
              item = ref[j];
              results.push([
                "<div class='col-xs-6 col-sm-6 col-md-6 col-lg-6'>",
                "<div class='file' data-file='" + (JSON.stringify(item)) + "' data-id='"+ item.id +"'>",
                "<div class='image text-center' data-id='" + item.id + "' style='position: relative;'>",
                "<img src='" + item.filePath + "@100h' height='100' />",
                imgType == "deleted" ?
                    ["<div style='position: absolute; top:0; left:0; right: 0; bottom: 0; background-color: rgba(0,0,0,0.3); color: red;'> ",
                      "<h5 class='text-center'>【" + item.modifyRealname + "】</h5>",
                      "<h5 class='text-center'>" + item.modifyTime + "</h5>",
                      "<h5 class='text-center'>已删除</h5>",
                      "</div>"].join("") : "",
                "</div>",
                "<div class='file-name' style='text-overflow: ellipsis; overflow: hidden;'>",
                "<p style='text-overflow: ellipsis; overflow: hidden; white-space: nowrap;' title='"+ item.fileName +"'>" + item.fileName + "</p>",
                "<div>",
                "<i class='glyphicon glyphicon-eye-open' style='color: " + (item.hasRead === 1 ? "#CCD5D3" : "#1ab394") + ";'></i>",
                cureent_dir.canDelete === 1 || cureent_dir.canMove === 1 ? "<input type='checkbox' name='pic' class='pull-right' value='" + item.id + "' style='margin: 0;' />" : "<input type='checkbox' name='pic' class='pull-right' value='" + item.id + "' style='margin: 0;' />",
                "</div>",
                "</div>",
                "</div>",
                "</div>"
              ].join(""));
            }
            return results;
          })()).join(""));
          if (res.data.length < 20) {
            return $("#imgLoadMore").addClass("disabled");
          } else {
            return $("#imgLoadMore").removeClass("disabled");
          }
        }
      });
    };
    return getDocumentList();
  } else {
    return $("#upImage").addClass("disabled");
  }
};

getSelectImage = function() {
  var arr;
  arr = {
    id: [],
    item: []
  };
  $("#documentList .file-name").find("input[name='pic']:checked").each(function() {
    arr.id.push($(this).val());
    return arr.item.push($(this).parents(".col-md-6"));
  });
  return arr;
};

loadTree = function() {
  var url;
  $.fn.zTree.destroy();
  url = args['isFlow'] === "yes" ? interUrl.gr.documentDir : interUrl.gr.documentAllDir;
  return comn.ajax({
    url: url,
    data: {
      loanApplyId: m.loanApplyId,
      fileNamespace: args['space'] || "",
      releventFlow: args['releventFlow'] || "",
      releventFlowNode: args['releventFlowNode'] || ""
    },
    success: function(res) {
      var treeObj;
      treeObj = $.fn.zTree.init($("#tree"), {
        showLine: true,
        expand: true,
        callback: {
          onClick: zTreeOnClick
        }
      }, res.data);
      treeTarget = $.fn.zTree.init($("#targetTree"), {
        showLine: true,
        expand: true,
        callback: {
          onClick: function(event, treeId, treeNod) {
            if (!treeNod.isParent) {
              targetDir = treeNod;
              return $("#targetSure").removeClass("disabled");
            } else {
              return $("#targetSure").addClass("disabled");
            }
          }
        }
      }, res.data);
      treeTarget.expandAll(true);
      return treeObj.expandAll(true);
    }
  });
};

handle = function(o) {
  return comn.ajax({
    url: o.url || "",
    data: {
      loanApplyId: m.loanApplyId,
      dirId: o.dirId,
      documentIds: getSelectImage()['id'].join(","),
      fileNamespace: args['space'] || "",
      releventFlow: args['releventFlow'] || "",
      releventFlowNode: args['releventFlowNode'] || ""
    },
    success: function(res) {
      var i, j, len, ref;
      loadTree();
      ref = getSelectImage()['item'];
      for (j = 0, len = ref.length; j < len; j++) {
        i = ref[j];
        $(i).remove();
      }
      $("#moveImage, #delImage").addClass("disabled");
      return typeof o.callback === "function" ? o.callback(res) : void 0;
    }
  });
};

$(function() {
  loadTree();
  $("#removed").click(function() {
    if (imgType === "deleted") {
      if (!$(this).hasClass("disabled")) {
        return $("#replayFile").modal("show");
      }
    } else {
      imgType = "deleted";
      $(this).addClass("disabled").html("<span>恢复已删除影像</span>");
      return getDocumentList({
        curPage: 1
      });
    }
  });
  $("#documentList").on("click", ".image", function() {
    var _this = this;
    if (imgType !== "deleted") {
      return window.parent.swpImage({
        id: $(this).data("id"),
        loanApplyId: m.loanApplyId,
        dirId: cureent_dir['id'],
        fileNamespace: args['space'] || "",
        releventFlow: args['releventFlow'] || "",
        releventFlowNode: args['releventFlowNode'] || "",
        title: cureent_dir.title,
        callback: function(ids){
          var arr = ids.split(",");
          $.each(arr, function(index, item){
            $($("#documentList")).find(".file[data-id='"+ item +"']").find(".glyphicon").css("color", "#1ab394");
          });
        }
      });
    } else {
      return tip({
        content: "请恢复文件后再进行大图查看！"
      });
    }
  });
  $("#imgLoadMore").click(function() {
    if (!$(this).hasClass("disabled")) {
      return getDocumentList();
    }
  });
  $("#delImage").click(function() {
    if (!$(this).hasClass("disabled")) {
      return $("#delDocument").modal("show");
    }
  });
  $("#moveImage").click(function() {
    if (!$(this).hasClass("disabled")) {
      return $("#targetDir").modal("show");
    }
  });
  $("#upMovie").click(function() {
    return $("#upMovieInput").trigger("click");
  });
  $("#upImage").click(function() {
    if (!$(this).hasClass("disabled")) {
      return $("#upImageInput").trigger("click");
    }
  });
  $("#replay").click(function() {
    return handle({
      url: interUrl.gr.recoveryFile,
      dirId: cureent_dir['id'],
      callback: function(res) {
        return $("#replayFile").modal("hide");
      }
    });
  });
  $("#delSure").click(function() {
    if (!$(this).hasClass("disabled")) {
      return handle({
        url: interUrl.gr.delDocument,
        dirId: cureent_dir['id'],
        callback: function(res) {
          return $("#delDocument").modal("hide");
        }
      });
    }
  });
  $("#targetSure").click(function() {
    if (!$(this).hasClass("disabled")) {
      return handle({
        url: interUrl.gr.moveDocument,
        dirId: targetDir['id'],
        callback: function(res) {
          return $("#targetDir").modal("hide");
        }
      });
    }
  });
  $("#btnPrint").click(function() {
    var picArr;
    if (!$(this).hasClass("disabled")) {
      picArr = [];
      $.each(getSelectImage()['item'], function(index, item) {
        var url;
        url = item.find(".file").data("file")['filePath'];
        return picArr.push(url);
      });
      return window.open("../../../Modal/common/documentDetail/imagePrint.html?imgUrl=" + picArr.join(","));
    }
  });
  $("#documentList").on("click", ".file-name", function(e) {
    var $checkbox, $els;
    $els = $("#moveImage, #delImage, #btnPrint");
    if (!$(e.target).is(":input")) {
      $checkbox = $(this).find("input:checkbox")[0];
      $checkbox.checked = !$checkbox.checked;
    }
    if (getSelectImage()['item'].length > 0) {
      if (imgType === "deleted") {
        return $("#removed, #btnPrint").removeClass("disabled");
      } else {
        return $els.removeClass("disabled");
      }
    } else {
      if (imgType === "deleted") {
        return $("#moveImage, #delImage, #removed, #btnPrint").addClass("disabled");
      } else {
        return $els.addClass("disabled");
      }
    }
  });
  $("#upImageInput").change(function() {
    var fileArr, html, i, j, k, len, results;
    fileArr = this.files;
    results = [];
    for (k = j = 0, len = fileArr.length; j < len; k = ++j) {
      i = fileArr[k];
      html = "";
      results.push(base64(i, k, function(f, o, index) {
        html = ["<tr>",
          "<td>",
          "<img src='" + o + "' width='80' />",
          "<input name='LoanDocuments[0].fileName' class='hide' value='" + f.name + "' />",
          "</td>",
          "<td>" + f.name + "</td>",
          "<td>" + (((f.size * 0.5) / 1048576).toFixed(2)) + "M</td>",
          "<td data-name='imgHandle'>",
          "<button type='button' class='btn btn-danger btn-sm upCancle'><span>取消上传</span></button>",
          "</td>",
          "</tr>"].join("");
        return $("#fileList tbody").prepend(html);
      }));
    }
    return results;
  });
  $("#upMovieInput").change(function() {
    var file;
    file = this.files[0];
    return $.ajaxFileUpload({
      url: interUrl.basic + interUrl.gr.upFile,
      secureuri: false,
      fileElementId: 'upMovieInput',
      data: {
        loanApplyId: m.loanApplyId,
        dirId: cureent_dir['id'],
        fileName: file.name,
        fileNamespace: args['space'] || "",
        releventFlow: args['releventFlow'] || "",
        releventFlowNode: args['releventFlowNode'] || ""
      },
      dataType: "json",
      success: function(data, status) {
        return console.log(data);
      },
      complete: function() {
        return console.log("msg");
      },
      error: function(data, status, e) {
        return console.log(e);
      }
    });
  });
  $("#downLoad").click(function() {
    return window.open(interUrl.basic + interUrl.gr.downLoad + ("?loanApplyId=" + m.loanApplyId + "&fileNamespace=" + (args['space'] || '') + "&releventFlow=" + (args['releventFlow'] || '') + "&releventFlowNode=" + (args['releventFlowNode'] || '')));
  });
  $("#fileList tbody").on("click", ".upCancle", function() {
    return $(this).parents("tr").remove();
  });
  return $("#upload").click(function() {
    var $tr, $trAll, maxImg, num, upImg;
    $tr = $("#fileList tbody").find("tr:not('.loaded')");
    $trAll = $("#fileList tbody").find("tr");
    num = $tr.index();
    if (num === -1) {
      return;
    }
    maxImg = $tr.length;
    return upImg = setInterval((function(_this) {
      return function() {
        var cur_tr;
        cur_tr = $trAll.get(num);
        if (!$(cur_tr).hasClass("loaded")) {
          comn.ajax({
            url: interUrl.gr.uploadImage,
            data: $.extend($(cur_tr).values(), {
              loanApplyId: m.loanApplyId,
              dirId: cureent_dir['id'],
              fileNamespace: args['space'] || "",
              releventFlow: args['releventFlow'] || "",
              releventFlowNode: args['releventFlowNode'] || "",
              "LoanDocuments[0].filePath": $(cur_tr).find("img").eq(0).attr("src")
            }),
            success: function(res) {
              $(cur_tr).addClass("loaded").nameValues({
                imgHandle: "<span class='text-success'>上传成功！</span>"
              });
              if (maxImg === 0) {
                getDocumentList({
                  curPage: 1
                });
                return loadTree();
              }
            }
          });
        }
        num++;
        if (!(--maxImg)) {
          return clearInterval(upImg);
        }
      };
    })(this), 100);
  });
});
