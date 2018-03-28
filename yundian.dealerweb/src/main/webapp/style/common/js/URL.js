var system = ['report/'],
interUrl = {
    mockList: "",
    basic: "/api/",
    common: {
        login: "login",
        getProvince: "area/getProvince",
        getCity: "area/getCityByProvince",
        getArea: "area/getCountyByCity",
        getCompany: "carDealer/branchComp/list",
        getGroup: "group/list",
        orgInfo: "org/info",
        orgList: "org/list",
        ruleList: "role/list",
        brandList: "brandinfo/getbrandinfobychar",
        carList: "brandinfo/getbrandinfobycode",
        carModels: "brandinfo/getcarname",
        opinion: "opinion/save",
        opinionOnly: "opinion/only",
        getOpinion: "opinion/get", 
        approveOpinion: "opinion/approveOpinion",
        loanCarList: "cooperation/carDealer/list",
        insuranceList: "cooperation/insurance/list",
        bankInfo: "cooperation/bank/info",
        flowGet: "flow/get",
        getLoanFlowStatusList:"infoQuery/getLoanFlowStatusList",
		getAreaFullNameByAreaName: "loanCarPlateArea/getAreaFullNameByAreaName"
    },
    user: {
        login: "login",
        getUser: "user/session/get",
        menu: "za/menu/list",
        logOut: "logout"
    },
    purchase:{
    	purchaselist:"purchase/apply/list",
    	purchaseadd:"purchase/apply/add",	
    	purchasedelete:"purchase/apply/delete",
    	purchaseupdate:"purchase/apply/update",
    	purchaseget:"purchase/apply/get",
    	purchaseaddGet:"purchase/apply/addGet",
    	contractlist:"purchase/contract/list",
    	contractadd:"purchase/contract/add",
    	contractdelete:"purchase/contract/delete",
    	contractget:"purchase/contract/get",
    	contractupdate:"purchase/contract/update",
    	contractaddGet:"purchase/contract/addGet",
    	contractgetDetail:"purchase/contract/getDetail",
    	notStocklist:"purchase/stock/purchaseStockList",
    	stockList:"purchase/stock/stockList",
		stockaddGet:"purchase/stock/addGet",
		useNotList:"purchase/stock/useNotList",
		useList:"purchase/stock/useList",
		userStockList:"purchase/stock/userStockList",
		stockadd:"purchase/stock/addStock",
		getDetail:"purchase/stock/getDetail",
		saveStock:"purchase/stock/saveStock",
		stockDel:"purchase/stock/delStock"
    },
    customer: {
        list: "customer/import/list",
        get: "customer/import/get",
        close: "customer/import/close",
        reject: "customer/import/reject",
        groupList: "customer/import/list1",
        branchList: "customer/import/list",
        allot: "customer/import/allot",
        groupBranch: "customer/import/setBranch",
		getVisitAddressGPSInfo: "infoQuery/getVisitAddressGPSInfo"
    },
    gr:{
        getPhoto: "photoPreview/getAllDocInfo",
        list: "customer/list",
        add: "customer/add",
        update: "customer/update",
        get: "customer/get",
        delete: "customer/del",
        history: "customer/history",
        teamList: "customer/manager/list",
        customerAssetList: "customer/asset/list",
        relationShipList: "customer/relationship/list",
        customerManagerDel: "customer/manager/del",
        customerStatus: "customer/manager/setStatus",
        customerSetAut: "customer/manager/setAuth",
        customerRelationDel: "customer/relationship/del",
        customerRelationAdd: "customer/relationship/add",
        customerRelationEdit: "customer/relationship/edit",
        documentDir: "loanApprovalInfo/getApprovalDocumentDir",
        //documentAllDir: "loanApprovalInfo/getAllApprovalDocumentDir",
		recordDocQueryHistory: "photoPreview/recordDocQueryHistory",
        documentAllDir: "loanApprovalInfo/getApprovalDocumentDir",
        documentList: "loanApprovalInfo/getApprovalDocument",
		recoveryFile: "loanDocument/recoveryFile",
        moveDocument: "loanDocument/moveFile",
        delDocument: "loanDocument/deleteFile",
        loanList: "customer/loan/list",
        loanInfo: "loanApprovalInfo/getApprovalBudgetInfo",
        userList: "user/list",
        managerAdd: "customer/manager/add",
        loanApprovalInfo: "loanApprovalInfo/getApprovalAsserts",
        getApprovalList: "loanApprovalInfo/getApprovalGuarantor",
		getLoanGuarantorInfo: "loanInside/getLoanGuarantorInfo",
		lauchLoanGuarantorInfo: "loanInside/lauchLoanGuarantorInfo",
        uploadImage: "loanDocument/uploadFileString",
        upFile: "loanDocument/uploadFileByStream",
        downLoad: "loanDocument/downloadAllFile",
        flow: "flow",
        record: "customer/history/detail",
		loanQuery: "infoQuery/loanInfo",
        creditList: "loanApply/creditList",
        carDealerList: "cooperation/carDealer/list",
        bankList: "cooperation/bank/list",
        flowUser: "flowUser",
        loanInfoList: "infoQuery/loanInfo",
        getLoanModifyList: "loanModify/getLoanModifyList",
        launchLoanModifyApply: "loanModify/launchLoanModifyApply",
        expressCompanyCode: "cooperation/codeLibrary/list",
		reditEdit: "customer/credit/editRelavants",
		back2pre: "credit/back2pre",
		getLoanInfoOverview: "infoQuery/getLoanInfoOverview",
        getFlowPath: "infoQuery/getFlowPath",
		patchSearch: "patch/search",
        getBankAll: "cooperation/bank/all",
        getTemplateList: "loanOverdueLoadHis/getTemplateList",
        loanOverdueLoadHisList: "loanOverdueLoadHis/list",
        uploadExcel: "loanOverdueLoadHis/uploadExcel",
        loanOverdueLoadHisFinish: "loanOverdueLoadHis/finish",
        loanOverdueLoadHisRematch: "loanOverdueLoadHis/rematch",
        loanOverdueLoadHisDelete: "loanOverdueLoadHis/delete",
        getMatchFieldList: "loanOverdueLoadHis/getMatchFieldList",
        getPostloanInfo: "infoQuery/postLoanstatus",
        deletes: "loanOverdueLoadHis/deletes",
        listExport: "loanOverdueLoadHis/listExport"
    },
    credit: {
        creditList: "customer/credit/list",
        creditInfo: "customer/credit/get",
        creditAdd: "customer/credit/add",
        creditPreAdd: "customer/credit/preAdd",
        creditUser: "loanApply/list",
        creditRisk: "customer/credit/risk/list",
        creditSubmit: "credit/preSubmit",
        creditImport: "customer/import/get",
        creditSubmit2: "credit/submit2next",
        creditEdit: "customer/credit/editRelavants",
        back2pre: "credit/back2pre",
        cancel: "credit/cancel",
        CustomerCreditList: "infoQuery/getCustomerCreditList",
        getCustomerCreditListByProjectId: "infoQuery/getCustomerCreditListByProjectId",//参数都是loanApplyId,creditId,projectId(自动转换)
        determined: "customer/credit/determined",
        download: "customer/credit/file/download"
    },
    myTask: {
        TaskList: "mytasks",
        searchTaskList: "mytasks/search",
        getAssign: "loanAssign/getAssign",
        editAssign: "loanAssign/saveAssign",
        listsAssignMain: "loanAssign/listsAssign/main",
        listsAssignVice: "loanAssign/listsAssign/vice",
        getSurvery: "loanAssign/getSurvery",
        editLoanerInfo: "loanInside/editLoanerInfo",
        saveBudgetInfo: "loanInside/saveBudgetInfo",
        roleLists: "role/list",
        approvalInfo: "loanApprovalInfo/getApprovalInfo",
        approvalBaseInfo: "loanApprovalInfo/getApprovalBaseInfo",
        customerContacter: "loanApprovalInfo/getLoanCustomerContacter",
        approvalBudgetInfo: "loanApprovalInfo/getApprovalBudgetInfo",
        approvalAsserts: "loanApprovalInfo/getApprovalAsserts",
        approvalGuarantor: "loanApprovalInfo/getApprovalGuarantor",
        paymentGet: "loan/payment/get",
        guaranteeList: "cooperation/guarantee/list",
        back2pre: "loanReview/back2pre",
        preSubmit: "loanReview/preSubmit",
        submit2next: "loanReview/submit2next",
        back2BudgetOfficeStaff: "loanReview/back2BudgetOfficeStaff",
        closeLoanApply: "loanReview/closeLoanApply",
        preLongTop: "loanReview/preLongTop",
        submit2LongTop: "loanReview/submit2LongTop",
        deleteLoanCustomerContacter: "loanInside/deleteLoanCustomerContacter",
        modifyLoanCustomerContacter: "loanInside/modifyLoanCustomerContacter",
        saveLoanCustomerContacter: "loanInside/saveLoanCustomerContacter",
        paymentSave: "loan/payment/saveToCarDealer",
        relateLoanGuarantor: "loanInside/relateLoanGuarantor",
		saveLoanGuarantorInfo: "loanInside/saveLoanGuarantorInfo",
        deleteLoanGuarantorInfo: "loanInside/deleteLoanGuarantorInfo",
        addLoanGuarantorInfo: "loanInside/addLoanGuarantorInfo",
        saveToGuarantee: "loan/payment/saveToGuarantee",
        paymentGetGuarantee: "loan/payment/getGuaranteePayment",
        getCarDealerPayment: "loan/payment/getCarDealerPayment",
        getAccountList: "cooperation/carDealer/account/list",
        printBudgetInfo: "loanInside/printBudgetInfo",
        getApprovalOtherInfo: "loanApprovalInfo/getApprovalOtherInfo",
        getLoanCollection: "loan/payment/getLoanCollection",
        saveLoanCollection: "loan/payment/saveLoanCollection",
        myTasksRead: "mytasks/read",
		reverseSpouseInfo: "loanInside/reverseSpouseInfo",
		updateCustomerCredit: "loanApply/updateCustomerCredit"
    },
    loanDetail: {
        launch: "loanApply/launch",
        loanGet: "loanApply/get",
        loanUpdate: "loanApply/update",
        loansave: "loanApply/save",
        loansubmit: "loanReview/preSubmit",
        loanCarList: "cooperation/carDealer/list",
        loanList: "loanApply/creditList",
		loanInfo: "loanInfo/getLoanCarInfoAndLicensePlateInfo",
		getLoanContractInfo: "loanInfo/getLoanContractInfo",
        loanReview: "loanReview/cancel",
        getLoanProjectNo: "loanApply/getLoanProjectNo",
        getLoanFeeInfo: "loanApply/getLoanFeeInfo",
        getFinancialProduct: "loanApply/getFinancialProduct",
        getSecondHandCarList: "loanApply/getSecondHandCarList",
        getLoanCarInfoAndLicensePlateInfo:"infoQuery/getLoanCarInfoAndLicensePlateInfo",
        getPledgeInfoInfo: "infoQuery/getPledgeInfoInfo",
        getBankRemittanceInfo: "infoQuery/getBankRemittanceInfo",
        getRepaymentCardInfo:"infoQuery/getRepaymentCardInfo",
        getLoanDocumentTransmitList:"infoQuery/getLoanDocumentTransmitList",
        infoQueryGetLoanContractInfo:"infoQuery/getLoanContractInfo",
        getLoanContractRepayPlanList:"infoQuery/getLoanContractRepayPlanList",
        getLoanInsuranceInfoList:"infoQuery/getLoanInsuranceInfoList",
        getLoanCustomerInfo:"infoQuery/getLoanCustomerInfo",
        getLoanFeeInfoInfoQuery:"infoQuery/getLoanFeeInfo",
        getLoanAssetsInfo:"infoQuery/getLoanAssetsInfo",
        getLoanGuarantorInfo:"infoQuery/getLoanGuarantorInfo",
        getLoanApplyFlowList:"infoQuery/getLoanApplyFlowList",
		getGpsTrajectoryParam: "infoQuery/getGpsTrajectoryParam"
    },
    carDealer: {
        get: "carDealer/get",
        add: "carDealer/add",
        update: "carDealer/update",
        setStatus: "carDealer/setStatus",
        list: "carDealer/list",
        manager: "carDealer/manager/list",
        userList: "carDealer/manager/user/list",
        managerAdd: "carDealer/manager/add",
        managerSet: "carDealer/manager/setManager",
        accountList: "carDealer/account/list",
        accountAdd: "carDealer/account/add",
        accountDel: "carDealer/account/del",
        accountStop: "carDealer/account/setStatus",
        delete: "carDealer/del",
        fee: "carDealer/fee/list",
        feeGet: "carDealer/fee/get",
        feeAdd: "carDealer/fee/add",
        feeUpdate: "carDealer/fee/update",
        feeStop: "carDealer/fee/stop",
        isManager: "carDealer/isManager",
        managerDel: "carDealer/manager/del",
        managerSetStatus: "carDealer/manager/setStatus",
        preSubmit: "carDealer/process/preSubmit",
        submit2next: "carDealer/process/submit2next",
        back2pre: "carDealer/process/back2pre",
        cancel: "carDealer/process/cancel",
        carDealerInit: "carDealer/init",
        carDealerPyGet:"carDealer/py/get"
    },
    insurance: {
        loanInsuranceList: "loanInsuranceInfo/loanInsuranceList",
        loanInsuranceInfoAdd: "loanInsuranceInfo/add",
        loanInsuranceTypeList: "loanInsuranceInfo/typeList",
        loanInsuranceInfoList: "loanInsuranceInfo/loanInsuranceInfoList",
        loanInsuranceInfoDel: "loanInsuranceInfo/delete",
        loanInsuranceInfoToUpdate: "loanInsuranceInfo/toUpdate",
        loanInsuranceInfoUpdate: "loanInsuranceInfo/update",
        getLoanInsuranceInfo:"infoQuery/getLoanInsuranceInfo",
        getLoanInsuranceInfoTypeList:"infoQuery/getLoanInsuranceInfoTypeList",

        //续保列表接口
        getRenewInsuranceList: "loanInsuranceRenewal/renewalProjectList",
        getRenewInsuranceListInfo: "loanInsuranceRenewal/list",
        getRenewInsuranceListPhone: "loanInsuranceRenewal/listPhone",
        getInsuranceRenewPhone: "loanInsuranceRenewal/toUpdatePhone",
        //获取联系信息
        getCOntact:"loanInsuranceRenewal/getSpouseInfo",
        modifyInsuranceRenewPhone: "loanInsuranceRenewal/updatePhone",
        addInsuranceRenewPhone:"loanInsuranceRenewal/addPhone",
        addInsuranceRenew: "loanInsuranceRenewal/add",
        getInsuranceRenew: "loanInsuranceRenewal/toUpdate",
        //删除记录
        delInsuranceRenew: "loanInsuranceRenewal/delete",
        delInsuranceRenewPhone: "loanInsuranceRenewal/deletePhone",
        //获取图片列表
        getInsuranceRenewImags: "loanApprovalInfo/getApprovalDocument"
    },
    asset: {
        loanAssetPackageList: "loanAssetPackage/list",
        loanAssetPackageSave: "loanAssetPackage/save",
        loanAssetPackageDel: "loanAssetPackage/del",
        loanAssetPackageGet: "loanAssetPackage/get",
        loanAssetList: "loanAssetPackageManage/addAssets/list",
        loanAssetAdd: "loanAssetPackageManage/addAssets/add",
        loanAssetDel: "loanAssetPackageManage/delAssets",
        getInAssetsPackage: "loanAssetPackageManage/getListInAssetsPackage",
        getLoanApproveProject: "loanAssetPackageManage/getLoanApproveProject",
        getLoanApproveCustomer: "loanAssetPackageManage/getLoanApproveCustomer",
        getAssetPackageNo: "loanAssetPackage/getAssetPackageNo"
    },
    second: {
        estimateSearch: "estimate/search",
        serial: "estimate/serial",
        add: "estimate/add",
        preSubmit: "estimate/process/preSubmit",
        submit2next: "estimate/process/submit2next",
        cancel: "estimate/process/cancel",
        get: "estimate/get",
        save: "opinion/save",
        save1th: "estimate/save1th",
        save2th: "estimate/save2th",
        back2pre: "estimate/process/back2pre",
        transferBack2pre: "transfer/process/back2pre",
        not_yet: "transfer/search/not_yet",
        already: "transfer/search/already",
        saves: "transfer/save",
        transferPreSubmit: "transfer/process/preSubmit",
        transferSubmit2next: "transfer/process/submit2next",
        update: "estimate/update",
        opinionLast: "estimate/opinion/last",
        userList: "user/list"
    },
    messageBoardManage: {
        myQuestionList: "clsFeedbackManage/myQuestionList",
        clsFeedbackManageAdd: "clsFeedbackManage/add",
        feedbackDetail: "clsFeedbackManage/feedbackDetail",
        myFeedbackReply: "clsFeedbackManage/myFeedbackReply"
    },
    documentManagement: {
        deliverList: "deliver/list",
        sendCompanyList: "deliver/company/list",
        hasSendCompanyList: "deliver/company/sendList",
        sendBankList: "deliver/bank/list",
        hasSendBankList: "deliver/bank/sendList",
        expressList: "deliver/bill/detail",
        addExpress: "deliver/bill/add",
        saveExpress: "deliver/bill/save",
        delExpress: "deliver/bill/del",
        recipientBankList: "deliver/bank/recipientList",
        recipientCompanyList: "deliver/company/recipientList",
        getExpress: "deliver/bill/get",
        recipient: "deliver/recipient/do",
        recipientTemp: "deliver/recipient/temp",
        recipientCancel: "deliver/recipient/cancel",
		submit2next: "deliver/process/submit2next",
		deliverGet: "deliver/get",
		deliverStart: "deliver/start",
		deliverSave: "deliver/save",
		preSubmit: "deliver/process/preSubmit",
		cancel: "deliver/process/cancel",
		getApprovalProjectInfo: "infoQuery/getApprovalProjectInfo",
		getLoanContractInfo: "infoQuery/getLoanContractInfo",
		back2pre: "deliver/process/back2pre",
		saveCar: "licensePlateInfoVo/saveCar",
		documentOpinionLast: "opinion/last"
    },
    creditManagement: {
        licensePlateInfoVo: "licensePlateInfoVo/list",
        licenseAdd: "licensePlateInfoVo/save",
        licenseGet: "licensePlateInfoVo/get",
        mortageList: "pledgeInfo/list",
        mortageSave: "pledgeInfo/save",
        mortageGgt: "pledgeInfo/get",
        loanContractList: "loanContractInfo/list",
        loanContractSave: "loanContractInfo/save",
        loanContractGet: "loanContractInfo/get",
        loanContracPlanList: "loanContractInfo/plan/preList",
        bankList: "bankRemittanceInfo/list",
        bankInfoGet: "bankRemittanceInfo/get",
        bankInfoSave: "bankRemittanceInfo/save",
        bankCancel: "bankRemittanceInfo/cancel",
        repayCardList: "repaymentCardInfo/list",
        repayCardGet: "repaymentCardInfo/get",
        repayCardSave: "repaymentCardInfo/save"
    },
    loanCancel: {
        cancel: "loan/cancel/process/cancel",
        preSubmit: "loan/cancel/process/preSubmit",
        submit2next: "loan/cancel/process/submit2next",
        close: "loan/cancel/process/close",
        back2pre: "loan/cancel/process/back2pre"
    },
    loanModify: {
        cancel: "loan/modify/process/cancel",
        preSubmit: "loan/modify/process/preSubmit",
        submit2next: "loan/modify/process/submit2next",
        close: "loan/modify/process/close",
        back2pre: "loan/modify/process/back2pre",
        back2BudgetOfficeStaff: "loan/modify/process/back2BudgetOfficeStaff",
        getLoamModifyHistory: "loanModify/getLoamModifyHistory",
        getLoanRefundPayeeMethod: "loan/payment/getLoanRefundPayeeMethod"
    },
    loanChange: {
        getLoanRefundFull: "loan/payment/getLoanRefundFull",
        getLoanRefundBalance: "loan/payment/getLoanRefundBalance",
        saveLoanRefundFull: "loan/payment/saveLoanRefundFull", //全额保存
        saveLoanRefundBalance: "loan/payment/saveLoanRefundBalance" //差额保存
    },
	report: {
		businessQuery: system[0] + "query/business",
		feeQuery: system[0] + "query/fee",
		statisticByMonth: system[0] + "query/statisticByMonth",
		unPledgeStatistic: system[0] + "query/unPledgeStatistic",
		flowStatusStatistic: system[0] + "query/flowStatusStatistic",
		dealerCompanystatistic: system[0] + "query/dealerCompanystatistic",
        loanSignStatistic: system[0] + "query/loanSignStatistic",
        bankPayStatistic: system[0] + "query/bankPayStatistic",
        loanAmmountRotaryStatistic: system[0] + "query/loanAmmountRotaryStatistic",
        statisticRankWithSign: system[0] + "query/statisticRankWithSign",
        unPledgeRank: system[0] + "query/unPledgeRank",
        loanSignRank: system[0] + "query/loanSignRank",
        bankPayRank: system[0] + "query/bankPayRank",
        loanAmmountRotaryRank: system[0] + "query/loanAmmountRotaryRank",
        loanSignStatisticByArea: system[0] + "query/loanSignStatisticByArea",
        loanSignStatisticWithRecentPeriodByArea: system[0] + "query/loanSignStatisticWithRecentPeriodByArea"
	},
	postLoan: {
		lawsuitList: "lawsuit/list",
		courtApplyList: "loanOverdueInfo/loanOverdueAndProjectInfoList",
		defendantList: "lawsuit/defendant/list",
		defendantSelect: "lawsuit/defendant/selectList",
		saveDefendantList: "lawsuit/save",
		caseProcessGet: "lawsuit/get",
		caseProcessInfo: "lawsuit/process/list",
		saveCaseProcessLIst: "lawsuit/process/save",
		historyCaseProcessList: "lawsuit/history/list",
		savesNolPros: "lawsuit/nolPros/save",
		nolPros: "lawsuit/nolPros/list",
		saveImg: "lawsuit/process/upload",
		//saveOpinion: "opinion/save",
		delImg: "lawsuit/process/file/del",
		updateCaseProcessLIst: "lawsuit/process/update",
		preSubmit: "lawsuit/apply/process/preSubmit",
		submit2next: "lawsuit/apply/process/submit2next",
		back2pre: "lawsuit/apply/process/back2pre",
		cancel: "lawsuit/apply/process/cancel",
		preSubmitNolPros: "lawsuit/cancel/process/preSubmit",
		submit2nextNolPros: "lawsuit/cancel/process/submit2next",
		back2preNolPros: "lawsuit/cancel/process/back2pre",
		cancelNolPros: "lawsuit/cancel/process/cancel"
		
	},
    export: {
        getOrg: "org/list",
        getBank: "cooperation/bank/all",
        searchList: "loan/payment/loanApprovePaymentExportlist",
        getTotal: "loan/payment/countLoanApprovePaymentExport",
        exportExcel: "loan/payment/exportLoanApprovePaymentExport",
        getGuarantee:"cooperation/guarantee/all"
    },
	personal: {
		modifyPWD: "updPassWord" 
	},
    flowControl: {
        getFlow: "flow/get",
        getNode: "flow/nodes",
        searchFlow: "rule/search",
        flowEnable: "rule/enable",
        flowDisable: "rule/disable",
        flowModify: "rule/update",
        flowDel: "rule/delete",
        flowSee: "rule/get",
        flowAdd: "rule/add",
        flowUpdate: "rule/updte",
        operator: "biz/user/list"
    },
    //结清
    SettlementRegistration:{
        SettlementUrl:"settlement/getLoanSettlementList",
        basicInformation:"settlement/get",//结清处理基本信息
        settlementQuery:"settlement/query",
        imgUpload:"settlement/file/upload",//图片上传
        save:"settlement/save",//保存结清信息
        imgDelete:"settlement/file/del",//图片删除接口
        yuChu:"loan/clear/process/preSubmit",
        submit2next:"loan/clear/process/submit2next",
        cancel:"loan/clear/process/cancel",
        back2pre:"loan/clear/process/back2pre",
        saveYiJian:"opinion/save",//提交流程保存意见接口
        saveYiJian2:"opinion/only",//单单点击保存意见接口
        complete:"loan/clear/process/complete",
        // 保单列表
        baoDan:"loanInsuranceRenewal/list",
        listPhone:"loanInsuranceRenewal/listPhone"
    },
    //财务管理接口
    feeManage: {
        list: "feeManage/list",
        save: "feeManage/save",
        get: "feeManage/get",
        feeCategoryList: 'feeManage/feeCategoryList',
        feeList: 'feeManage/feeList',
        feeBalanceList: 'feeManage/feeBalanceList',
        //collectionList: 'loanOverdueInfo/collectionList',
        collectionList: 'loanOverdueInfo/loanOverdueAndProjectInfoList',
        uploadFile: 'feeManage/uploadFile',
        getFileList: 'feeManage/getFileList',
        delFile: 'feeManage/delFile',
        applyPreSubmit: 'fee/apply/process/preSubmit',
        applySubmit2next: 'fee/apply/process/submit2next',
        applyBack2pre: 'fee/apply/process/back2pre',
        applyCancel: 'fee/apply/process/cancel',
        applyClose: 'fee/apply/process/close',
        recyclePreSubmit: 'fee/recycle/process/preSubmit',
        recycleSubmit2next: 'fee/recycle/process/submit2next',
        recycleBack2pre: 'fee/recycle/process/back2pre',
        recycleCancel: 'fee/recycle/process/cancel',
        recycleClose: 'fee/recycle/process/close',
		guaranteeAccountList: 'cooperation/guaranteeAccount/list' 
    },
    //抵押物占管
    collateral: {
        getList: "carcheckout/list",
        shippingApply: "carcheckout/add",
        shippingApplySave: "carcheckout/save",
        collateralRecord: "carcheckout/getpipe",
        preSubmit: "carcheckout/process/preSubmit",
        submit2next: "carcheckout/process/submit2next",
        back2pre: "carcheckout/process/back2pre",
        cancel: "carcheckout/process/cancel"
    },
    //拖车管理
    trailer: {
        getList: "dragCar/list",
        trailerApply: "dragCar/add",
        getTrailerRecord: "dragCar/queryDragCar",
        trailerRecord: "dragCar/update",
        picLoad: "dragCar/upload",
        picDel: "dragCar/deleUploadFile",
        getPic: "dragCar/queryUploadFile",
        getDragCarPeople: "dragCar/dragCarPeople",
        getFlowInfo: "dragCar/getDragCarById",
        preSubmit: "tow/car/process/preSubmit",
        submit2next: "tow/car/process/submit2next",
        back2pre: "tow/car/process/back2pre",
        cancel: "tow/car/process/cancel"
    },
    collectionManage:{
        collectionList:"loanOverdueInfo/collectionList",
        loanCollectionInfoGet:"loanCollectionInfo/get",
        getCollectionObjList:"loanCollectionInfo/getCollectionObjList",
        loanCollectionInfoSave:"loanCollectionInfo/save",
        loanCollectionInfoList:"loanCollectionInfo/viewList",
        overdueList:"loanCollectionInfo/overdueList",
        collectionUserList:"loanCollectionInfo/collectionUserList",
        collectionStat: "loanOverdueInfo/collectionStat"
    },
    // 履约保证金
    ThePerformance:{
        lyIndexUrl:"deposit/getLoanDepositReturnList",
        seveXX:"deposit/save",
        imgSave:"deposit/upload",//图片上传
        imgGet:"deposit/queryUploadFile",//图片获取
        deleteImg:"deposit/deleUploadFile",
        lvYuepreSubmit:"perform/bond/process/preSubmit",
        lvYuesubmit2next:"perform/bond/process/submit2next",
        getImfor:"deposit/get",
        // 风险经理审批预提交接口
        preRisk:"perform/bond/process/preRisk",
        // 风险经理审批提交接口
        submit2Risk:"perform/bond/process/submit2Risk",
        // 业务经理审批预提交
        preBusiness: "perform/bond/process/preBusiness",
        //业务经理审批提交
        submit2Business: "perform/bond/process/submit2Business",
        // 取消
        lvYueCancel:"perform/bond/process/cancel",
        // 后退
        lvYueback2pre:"perform/bond/process/back2pre",
        close: "perform/bond/process/close"
    },

    RepaymentHistory:{
        RepaymentHistoryList:"loanOverdueContractRepayPlan/list"
    },
     // 费用收支情况
    sz:{
        list:"feeManage/feeBalanceList"
    }
};

//枚举
statuss = function (value, row, index) {
	if (typeof value === "string") {
			value = parseInt(value);
		}
	return (value === 1 && "未生效") || (value === 2 && "已生效") || (value === -1 && "已删除") || "";
};

cardType = function (value, row, index) {
    return [null, "身份证", "军官证", "侨胞证", "外籍人士", ""][value] || null;
};

resultStatus = function (value, row, index) {
    return [null, "未处理", "关闭", "退回", "发起征信"][value] || null;
};

managementType = function (value, row, index) {
    return [null, "管理权", "业务权"][value] || null;
};
guaranteeType = function (value, row, index) {
    return [null, "抵押"][value] || null;
};

currencyType = function (value, row, index) {
    return [null, "抵押"][value] || null;
};

relationship = function (value, row, index) {
    // return [null, "本人", "夫妻", "父亲", "母亲", "姐妹", "兄弟", "子女"][value] || null;
    return [null, "本人", "夫妻", "父亲", "母亲", "兄弟", "姐妹", "合伙人", "朋友", "同事", "亲戚", "女儿", "儿子", "姐夫", "嫂子", "儿媳"][value] || null;
};

isNo = function (value, row, index) {
    return [null, "是", "否"][value] || null;
};

qi = function (value, row, index) {
    return value ? (value + "期") : null;
};

ci = function (value, row, index) {
    return value ? (value + "次") : null;
};

financialType = function (value, row, index) {
    return [null, "征信中", "征信通过", "未通过", "失效"][value] || null;
};

businessBreed = function (value, row, index) {
    return [null, "信用卡贷款", "银行直销贷款", "个人消费贷款"][value] || null;
};

level = function (value, row, index) {
    return [null, "一般", "紧急"][value] || null;
};

loanTerm = function (value, row, index) {
    return [null, "12期", "18期","24期", "36期"][value] || null;
};

costType = function (value, row, index) {
    return [null, "公司", "车行", "客户"][value] || null;
};

number = function (value, row, index) {
    return ["元", "1", "2", "3"][value] || null;
};

feeType = function (value, row, index) {
    return [null, "无", "保险手续费", "补收印花税", "抵押押金（非现金）", "短期保费", "公证费（非现金)", "其他费用", "银行中介费（现金）", "银行手续费", "调查费"][value] || null;
};

deliveryMethod = function (value, row, index) {
    return [null, "现金", "非现金"][value] || null;
};

accountType = function (value, row, index) {
    return [null, "对公账户", "个人账户"][value] || null;
};

sex = function (value, row, index) {
    return ["女", "男"][value] || null;
};

maritalStatus = function (value, row, index) {
    return [null, "已婚", "未婚", "离异", "丧偶"][value] || null;
};

collectionType = function (value, row, index){
    return [null, "电话催收", "上门催收"][value] || null;
};

continuousOverdueTimes = function (value, row, index){
    if (value == undefined) {
        return "--";
    }
    var arr=[null];
    for(var i= 1;i<=36;i++){
        var n="";
        if(i<=4){
            n="N"+i+"<span class='N"+i+"'></span>";
        }else{
            n="N"+i+"<span class='N4'></span>";
        }
        arr[i]=n;
    }
    return arr[value] || null;
};
collectionResult = function (value, row, index){
    return [null, "愿意还款", "不愿还款"][value] || null;
};

settleMethod = function (value, row, index) {
    return [null, "车行结算", "个人结算", "无需结算"][value] || null;
};

loanStatus = function (value, row, index) {
    return [null, "贷款拒绝", "审批通过", "贷款审核", "贷款发起", "贷款作废"][value] || null;
};

loanStatusQuery = function (value, row, index) {
    return [null, "业务办理中", "分公司审批中", "总部审批中", "审批通过","审批否决","贷款作废","分公司请款中","已付款未放款","已付款已放款","贷款修改中","贷款作废中"][value] || null;
};

deliverType = function(value, row, index) { return [null, "快递", "客户自取", "客户经理代送", "其他"][value] || null; };

assetType = function(value, row, index) { return [null, "汽车", "房产", "地产", "银行存款", "其他", "机器设备类", "设施类在建工程", "有价证券", "保证金"][value] || null; };

loanInfoYears = function (value, row, index) {
    return [null, "12个月", "18个月", "24个月", "36个月"][value] || null;
};

failReason = function (value, row, index) {
    return [null, "要示本人到场", "资料不齐全", "拍牌", "其他"][value] || null;
};

guarantyRelationship = function (value, row, index) {
    return [null, "担保人", "反担保人"][value] || null;
};

loanCarType = function (value, row, index) {
    return [null, "新车", "二手车"][value] || null;
};
//节点分流操作状态枚举
flow_status = function (value, row, index) {
    return ["停用", "启用"][value] || null;
};
//导出状态判断
export_Status = function (value, row, index) {
    return [null, "未导出", "已导出"][value] || null;
}

//数据状态
matchStatus = function (value, row, index) {
    return [null, "匹配成功", "匹配失败", "匹配重复"][value] || null;
}
//贷后-诉讼管理 - 案件状态
lawsuitStatus = function (value, row, index) {
	return [null, "起诉申请中", "起诉审批中", "起诉申请通过", "撤诉申请中", "撤诉审批中", "撤诉申请通过", "已立案", "已开庭(传票)", "已判决", "执行中", "执行终结", "恢复执行中", "执行完毕", "已撤诉", "达成调解"][value] || null;
}
yuan = function (value, row, index) {
    return value ? (value + "元") : null;
};

current_yuan = function (value, row, index) {
    if (row.LastOverdueTotalAmount && row.LastOverdueTotalAmount) {
        var current = comn.accSub(parseFloat(row.overdueTotalAmount), parseFloat(row.LastOverdueTotalAmount));
        return current + "元";
    } else {
        return "--"
    }
}

approveStatus = function (value, row, index) {
    if (typeof value === "string") {
        value = parseInt(value);
    }
    return (value === 0 && "未审批") || (value === 1 && "审批中") || (value === 2 && "审批通过") || (value === 3 && "审批拒绝") || null;
};

bankFormatter = function (value) {
    switch (value) {
        case "ICBC":
            return "工商银行";
            break;
        case "CCB":
            return "建设银行";
            break;
        case "BOC":
            return "中国银行";
            break;
        case "ABC":
            return "农业银行";
            break;
        case "CMB":
            return "招商银行";
        case "RCC":
            return "农村信用合作社";
        case "BCM":
            return "交通银行";
        case "CCBZX":
            return "中信银行";
            break;
    }
};
fileSended = function (value) {
    if (value != "") {
        var arrayValue = "";
        //从右到左：抵押合同、还款卡、抵押委托书、合同资料、抵押资料
        if ((value & 1) == 1)arrayValue = arrayValue + "抵押资料" + "、";
        if ((value & 2) == 2)arrayValue = arrayValue + "合同资料" + "、";
        if ((value & 4) == 4)arrayValue = arrayValue + "抵押委托书" + "、";
        if ((value & 8) == 8)arrayValue = arrayValue + "还款卡" + "、";
        if ((value & 16) == 16)arrayValue = arrayValue + "抵押合同" + "、";
        arrayValue = arrayValue.substring(0, arrayValue.length - 1);
        return arrayValue;
    } else {
        return "-";
    }
};
recipientStatus = function (value) {
    switch (value) {
        case 1:
            return "未收件";
            break;
        case 2:
            return "资料缺失";
            break;
        case 3:
            return "已收件";
    }
};
assetsPackageStatus = function (value, row, index) {
    if (typeof value === "string") {
        value = parseInt(value);
    }
    return (value === 1 && "生效中") || (value === 2 && "过期") || null;
};

dateFormTen = function (value, row, index) {
    if (value && value.length > 10) {
        return value.substr(0,10);
    } else {       
    	return value;
    }
};

//当前月，年
var date, year, month, nowMonth;
date=new Date();
year=date.getFullYear();
month=date.getMonth()<10?"0"+(date.getMonth()+1):date.getMonth()+1;
nowMonth = year+"-"+ month;

// 日期格式化插件
Date.prototype.format = function(format) {
  var o = {
    "M+": this.getMonth() + 1, //month
    "d+": this.getDate(), //day
    "h+": this.getHours(), //hour
    "m+": this.getMinutes(), //minute
    "s+": this.getSeconds(), //second
    "q+": Math.floor((this.getMonth() + 3) / 3), //quarter
    "S": this.getMilliseconds() //millisecond
  }
  if (/(y+)/.test(format)) format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
  for (var k in o)
    if (new RegExp("(" + k + ")").test(format))
      format = format.replace(RegExp.$1,
        RegExp.$1.length == 1 ? o[k] :
        ("00" + o[k]).substr(("" + o[k]).length));
  return format;
}

//确认提交或退回模态框
var sureModal='<div class="modal fade" id="sureModal">'+
    '<div class="modal-dialog">'+
    '<div class="modal-content">'+
    '<div class="modal-header">'+
    '<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>'+
    '<h4 class="modal-title">提示信息</h4>'+
    '</div>'+
    '<div class="modal-body">'+
    '<p class="tipText"></p>'+
    '</div>'+
    '<div class="modal-footer">'+
    '<button type="button" class="btn btn-primary" id="sureOption">确定</button>'+
    '<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>'+
    '</div></div></div></div>';

function oppSureModal(text){
    if($("#sureModal").length>0){
        $("#sureModal").modal("show");
        $("#sureModal").find(".tipText").text(text);
    }else{
        $("body").append(sureModal);
        $("#sureModal").find(".tipText").text(text);
        $("#sureModal").modal("show");
    }
}

$.fn.extend({
    getBank: function () {
        comn.ajax({
            url: interUrl.gr.bankList,
            success: (function (_this) {
                return function (res) {
                    var o;
                    return $(_this).html("<option value=''>--请选择--</option>" + ((function () {
                            var j, len, ref, results;
                            ref = res.data;
                            results = [];
                            for (j = 0, len = ref.length; j < len; j++) {
                                o = ref[j];
                                results.push("<option value='" + o.id + "'>" + o.bankName + "</option>");
                            }
                            return results;
                        })()).join(""));
                };
            })(this)
        });
        return this;
    },
    getBankAll: function () {
        comn.ajax({
            url: interUrl.gr.getBankAll,
            success: (function (_this) {
                return function (res) {
                    var o;
                    return $(_this).html("<option value=''>--请选择--</option>" + ((function () {
                            var j, len, ref, results;
                            ref = res.data;
                            results = [];
                            for (j = 0, len = ref.length; j < len; j++) {
                                o = ref[j];
                                results.push("<option value='" + o.id + "'>" + o.bankName + "</option>");
                            }
                            return results;
                        })()).join(""));
                };
            })(this)
        });
        return this;
    },
    getUserByCompanyId: function (companyId) {
        if (companyId) {
            comn.ajax({
                url: interUrl.common.getUserByCompanyId,
                data: {
                    companyId: companyId
                },
                success: (function (_this) {
                    return function (res) {
                        var j, len, o, ref, str;
                        str = "<option value=''>--请选择--</option>";
                        var defaultValue = $(_this).attr('defaultValue');
                        ref = res.data;
                        for (j = 0, len = ref.length; j < len; j++) {
                            o = ref[j];
                            str += "<option value='" + o.uid + "' " + (defaultValue == o.uid ? "selected" : "") + ">" + o.realname + "</option>";
                        }
                        return $(_this).html(str);
                    };
                })(this)
            });
            return this;
        }
    },
    getGroup: function (companyId, value) {
        if (companyId) {
            comn.ajax({
                url: interUrl.common.getGroup,
                data: {
                    companyId: companyId
                },
                success: (function (_this) {
                    return function (res) {
                        var o;
                        return $(_this).html("<option value=''>--请选择--</option>" + ((function () {
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
    },
    flowGet: function (value) {
        comn.ajax({
            url: interUrl.common.flowGet,
            success: (function (_this) {
                return function (res) {
                    var o;
                    return $(_this).html("<option value=''>--请选择--</option>" + ((function () {
                            var j, len, ref, results;
                            ref = res.data;
                            results = [];
                            for (j = 0, len = ref.length; j < len; j++) {
                                o = ref[j];
                                results.push("<option value='" + o.flowType + "'>" + o.flowName + "</option>");
                            }
                            return results;
                        })()).join("")).val(value || "");
                };
            })(this)
        });
        return this;
    },
    getFlowNode: function (flowName, value) {
        if (flowName) {
            comn.ajax({
                url: interUrl.flowControl.getNode,
                data: {
                    businessTypeCode: flowName
                },
                success: (function (_this) {
                    return function (res) {
                        var o;
                        return $(_this).html("<option value=''>--请选择--</option>" + ((function () {
                                var j, len, ref, results;
                                ref = res.data;
                                results = [];
                                for (j = 0, len = ref.length; j < len; j++) {
                                    o = ref[j];
                                    results.push("<option value='" + o.nodeCode + "'>" + o.nodeName + "</option>");
                                }
                                return results;
                            })()).join("")).val(value || "");
                    };
                })(this)
            });
        }
        return this;
    },
    getFlowOperator: function (groupId, value) {
        if (flowName) {
            comn.ajax({
                url: interUrl.flowControl.operator,
                data: {
                    bizGroupId: groupId
                },
                success: (function (_this) {
                    return function (res) {
                        var o;
                        return $(_this).html("<option value=''>--请选择--</option>" + ((function () {
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
        }
        return this;
    },
    //获取资金部待打款列表合作银行下拉列表
    bank_Get: function (value) {
        comn.ajax({
            url: interUrl.export.getBank,
            success: (function (_this) {
                return function (res) {
                    var o;
                    return $(_this).html("<option value=''>--请选择--</option>" + ((function () {
                            var j, len, ref, results;
                            ref = res.data;
                            results = [];
                            for (j = 0, len = ref.length; j < len; j++) {
                                o = ref[j];
                                results.push("<option value='" + o.id + "'>" + o.bankName + "</option>");
                            }
                            return results;
                        })()).join("")).val(value || "");
                };
            })(this)
        });
        return this;
    },
    //获取资金部待打款列表收款人全称下拉列表
    getGuarantee_Get: function (value) {
        comn.ajax({
            url: interUrl.export.getGuarantee,
            success: (function (_this) {
                return function (res) {
                    var o;
                    return $(_this).html("<option value=''>--请选择--</option>" + ((function () {
                            var j, len, ref, results;
                            ref = res.data;
                            results = [];
                            for (j = 0, len = ref.length; j < len; j++) {
                                o = ref[j];
                                results.push("<option value='" + o.id + "'>" + o.organizationName + "</option>");
                            }
                            return results;
                        })()).join("")).val(value || "");
                };
            })(this)
        });
        return this;
    },
    getExpressCompanyCode: function (type) {
		//type : "ExpressCompany" 快递公司(默认)
		//type : "RelationShipType" 关系人
        comn.ajax({
            url: interUrl.gr.expressCompanyCode,
            data: {codeType: type || 'ExpressCompany'},
            success: (function (_this) {
                return function (res) {
                    var o;
                    return $(_this).html("<option value=''>--请选择--</option>" + ((function () {
                            var j, len, ref, results;
                            ref = res.data;
                            results = [];
                            for (j = 0, len = ref.length; j < len; j++) {
                                o = ref[j];
                                results.push("<option value='" + o.codeId + "'>" + o.codeName + "</option>");
                            }
                            return results;
                        })()).join(""));
                };
            })(this)
        });
        return this;
    },
    // 逾期数据导入银行插件
    getBankAll: function () {
        comn.ajax({
            url: interUrl.gr.getBankAll,
            success: (function (_this) {
                return function (res) {
                    var o;
                    return $(_this).html("<option value=''>--请选择--</option>" + ((function () {
                            var j, len, ref, results;
                            ref = res.data;
                            results = [];
                            for (j = 0, len = ref.length; j < len; j++) {
                                o = ref[j];
                                results.push("<option value='" + o.id + "'>" + o.bankName + "</option>");
                            }
                            return results;
                        })()).join(""));
                };
            })(this)
        });
        return this;
    },
    // 逾期数据导入银行模版插件
    getTemplateList: function (coBankId, value) {
        //if (coBankId) {
            comn.ajax({
                url: interUrl.gr.getTemplateList,
                data: {
                    coBankId: coBankId
                },
                success: (function (_this) {
                    return function (res) {
                        var o;
                        return $(_this).html("<option value=''>--请选择--</option>" + ((function () {
                                var j, len, ref, results, k, bankList;
                                ref = res.data;
                                results = [];
                                bankList = [];
                                for (j = 0, len = ref.length; j < len; j++) {
                                    o = ref[j];
                                    results.push("<option value='" + o.id + "' data-name='"+ o.bankName +"'>" + o.name + "</option>");
                                }
                                return results;
                            })()).join("")).val(value || "");
                    };
                })(this)
            });
        //}
        return this;
    },
    getToday:function(){
        var date, y, m, d,today;
        date=new Date();
        y=date.getFullYear();
        m=date.getMonth()<9 ? "0"+(date.getMonth()+1) : date.getMonth()+1;
        d=date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
        today=y+"-"+m+"-"+d;
        $(this).val(today);
    },
    getMonthDay1:function(){
        var date, y, m, d,today;
        date=new Date();
        y=date.getFullYear();
        m=date.getMonth()<9 ? "0" + (date.getMonth()+1) : date.getMonth()+1;
        today=y+"-"+m+"-"+ "01";
        $(this).val(today);
    },
    getLastMonthDay1:function(){
        var date, y, m, d,today;
        date=new Date();
        y=date.getFullYear();
        m=date.getMonth()<9 ? "0"+(date.getMonth()+1) : date.getMonth() + 1;
        today=y+"-"+m+"-"+ "01";
        $(this).val(today);
    },
    getYear1Day1:function(){
        var date, y, m, d,today;
        date=new Date();
        y=date.getFullYear();
        m=date.getMonth()<9 ? "0"+(date.getMonth()+1):date.getMonth()+1;
        d=date.getDate();
        today=(y+1)+"-"+m+"-"+(d-1);
        $(this).val(today);
    },
    //当年第一月
    getMonthFirst:function(){
        var date=new Date();
        var MonthFirst=date.getFullYear();
        $(this).val(MonthFirst+"-01");
    },
    //当月
    getMonthCur:function(){
        var date=new Date();
        var currentMonth=date.getMonth();
        var MonthFirstDay=new Date(date.getFullYear(),currentMonth,1).format('yyyy-MM');
        $(this).val(MonthFirstDay);
    },
    //当月第一天
    getMonthDayFirst:function(){
        var date=new Date();
        var currentMonth=date.getMonth();
        var MonthFirstDay=new Date(date.getFullYear(),currentMonth,1).format('yyyy-MM-dd');
        $(this).val(MonthFirstDay);
    },
    //当月最后一天
    getMonthDayLast:function(){
        var date=new Date();
        var currentMonth=date.getMonth();
        var nextMonth=++currentMonth;
        var nextMonthFirstDay=new Date(date.getFullYear(),nextMonth,1);
        var oneDay=1000*60*60*24;
        var today = new Date(nextMonthFirstDay-oneDay).format('yyyy-MM-dd');
        $(this).val(today);
    },
    getLoanFlowStatusList: function () {
        comn.ajax({
            url: interUrl.common.getLoanFlowStatusList,
            success: (function (_this) {
                return function (res) {
                    var o;
                    return $(_this).html("<option value=''>--请选择--</option>" + ((function () {
                            var j, len, ref, results;
                            ref = res.data.flowStatus;
                            results = [];
                            for (j = 0, len = ref.length; j < len; j++) {
                                o = ref[j];
                                results.push("<option value='" + o.code + "'>" + o.name + "</option>");
                            }
                            return results;
                        })()).join(""));
                };
            })(this)
        });
        return this;
    },
    //获取流程意见
    getOpinion_s: function (data) {
        comn.ajax({
            url: interUrl.common.getOpinion,
            data: data,
            success: (function (_this) {
                return function (res) {
                    $(_this).val(res.data);
                };
            })(this)
        });
    },
    setPostLoanTerm:function(){
        var arr=[];
        for(var i=1;i<=36;i++){
            arr.push("<option value="+i+">"+i+"期</option>");
        }
        return $(this).append(arr.join(""));
    }
    
});


