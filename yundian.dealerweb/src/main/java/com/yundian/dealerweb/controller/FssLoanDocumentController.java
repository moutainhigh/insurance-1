package com.yundian.dealerweb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yundian.fssapi.domain.FssDictionaryModel;
import com.yundian.fssapi.domain.FssLoanDocumentModel;
import com.yundian.fssapi.service.FssDictionaryService;
import com.yundian.fssapi.service.FssLoanDocumentService;
import com.yundian.fssapi.service.FssLoanRelationService;
import com.yundian.fssapi.service.FssLoanService;
import com.yundian.result.Result;
import com.yundian.result.ResultCodeContants;

@Controller
@RequestMapping("/fss/loan/document")
public class FssLoanDocumentController {
	private static final Logger logger = Logger
			.getLogger(FssLoanDocumentController.class);

	@Autowired
	private FssLoanService fssLoanService;
	
	@Autowired
	private FssLoanRelationService fssLoanRelationService;
	
	@Autowired
	private FssDictionaryService fssDictionaryService;
	@Autowired
	private FssLoanDocumentService fssLoanDocumentService;

	
	@RequestMapping(value = "/loanDocument.html", method = RequestMethod.GET)
	public String loanDocument(@RequestParam( value = "loanId") Long loanId,ModelMap context,
			HttpServletRequest httpRequest) {
		context.put("loanId",loanId);
		return "/loan/loanDocument";
	}

	@RequestMapping(value = "/loanDocumentCategoryTree.html", method = RequestMethod.POST)
	public String loanDocumentCategoryTree(
			@RequestParam(value = "type",required=false) String type,
			@RequestParam(value = "loanId") Long loanId,ModelMap context){
		context.put("loanId",loanId);
		try {
			FssDictionaryModel fssDictionaryModel=new FssDictionaryModel();
			fssDictionaryModel.setDictTypeCode("FSS_FILE_CATEGORY");
			Result<List<FssDictionaryModel>>  result=
					fssDictionaryService.getFssDictionaryList(fssDictionaryModel);
			context.put("fssCategoryList", result.getData());
		} catch (Exception e) {
			logger.error(String.format("查询贷款分类出现错误：%d", loanId),e);
			context.put("errorMsg", "系统异常,请重试");
		}
		return "/loan/ajax/loanDocumentCategoryTree";
	}
	
	
	@RequestMapping(value = "/loanDocumentGallery.html", method = RequestMethod.POST)
	public String loanDocumentGallery(
			@RequestParam(value = "loanId") Long loanId,			
			@RequestParam(value = "fileCategory") String fileCategory,
			ModelMap context){
		try {
			context.put("loanId",loanId);
			Result<List<FssLoanDocumentModel>> documentListResult =
					fssLoanDocumentService.getFssLoanDocumentListByLoanIdAndDocumentType(loanId, fileCategory);
			if(documentListResult.getCode()!=ResultCodeContants.success){
				context.put("errorMsg", documentListResult.getMessage());
			}
			else{
				context.put("documentList", documentListResult.getData());
			}
		} catch (Exception e) {
			logger.error(String.format("查询贷款资料信息出现错误：%d", loanId),e);
			context.put("errorMsg", "系统异常,请重试");
		}
		return "/loan/ajax/loanDocumentGallery";
	}
	
}
