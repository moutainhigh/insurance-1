import alt from 'bases/Alt.js';
import querystring from "querystring";
import jsonp from "jsonp";
import LoanListAction from '../actions/LoanListAction';
import {Notify} from "components/common/Common";
import {xFetch,xPostFetch} from "../../services/xFetch";
import {isEmptyObject} from "../../services/functions"

//************************ 用于打印log的 **************************
const show = (info) => {
  console.log("store LoanListStore: " + info);
}
const momentTansfer = (data)=>{
  let format="YYYY-MM-DD";
  if(data.carBuyDate!=null&&data.carBuyDate!='') {
    data.carBuyDate = data.carBuyDate.format(format);
  }
  if(data.policyEffectDate!=null&&data.policyEffectDate!='') {
    data.policyEffectDate = data.policyEffectDate.format(format);
  }
  if(data.policyExpireDate!=null&&data.policyExpireDate!='') {
    data.policyExpireDate = data.policyExpireDate.format(format);
  }
  return data;
}
//****************************************************************
class LoanListStore {
  constructor() {
    this.bindListeners({
      handleInitDataList: LoanListAction.initDataListInfo,
      handleQuerySubmit: LoanListAction.querySubmit,
      handlePagination: LoanListAction.setPagination,
      handleOpenAddModal: LoanListAction.openAddModal,
      handleOpenUpdateModal: LoanListAction.openUpdateModal,
      handleOpenShowModal: LoanListAction.openShowModal,
      handleCancelShowModal: LoanListAction.cancelShowModal,
      handleAddLoan: LoanListAction.addLoan,
      handleUpdateLoan: LoanListAction.updateLoan,
      handleSubmitLoan: LoanListAction.submitLoan,
      handleOpenLoanApplyModal: LoanListAction.openLoanApplyModal,
      handleCancelLoanApplyModal: LoanListAction.cancelLoanApplyModal,

      handleApplyLoan: LoanListAction.applyLoan,
      handleCarCascaderLoadData:LoanListAction.carCascaderLoadData,
      handleIntiData:LoanListAction.intiData

    });
    this.state = {
      dataList: [],
      loading: true,
      typeList : [],
      addModalVisible : false,
      applyLoanModalVisible : false,
      showModalVisible:false,
      loanInfo:{},
      loanId:null,
      fssLoanModel:{},
      fssLoanDocs:{},
      pagination: {
        pageSize: 20,
        showSizeChanger: true,
        showQuickJumper: true,
      },
      params: {},
    };
  }


  handleInitDataList = (pager) => {
    this.handleQuerySubmit({pager: pager,data:{status:'ON'}});
  };

  handlePagination = (pager) => {
    this.handleQuerySubmit({data: this.state.params, pager: pager});
  };

  handleAddLoan = (data) =>{
    data = momentTansfer(data);
    let arrayCarModel = data.arrayCarModel;

    if(arrayCarModel.length>2) {
      data.carBrand = arrayCarModel[0];
      data.carVehicle = arrayCarModel[1];
      data.carModel = arrayCarModel[2];
    }
    delete data.arrayCarModel;
    let idcardFrontPic = data.idcardFrontPic;
    delete data.idcardFrontPic;
    let idcardBackPic = data.idcardBackPic;
    delete data.idcardBackPic;
    let compulsoryInsurancePic = data.compulsoryInsurancePic;
    delete data.compulsoryInsurancePic;
    let commercialInsurancePic = data.commercialInsurancePic;
    delete data.commercialInsurancePic;
    let param = querystring.encode(data);
    if(!isEmptyObject(idcardFrontPic)) {
      param = param + "&idcardFrontPic=" + JSON.stringify(idcardFrontPic);
    }
    if(!isEmptyObject(idcardBackPic)) {
      param =  param+"&idcardBackPic="+JSON.stringify(idcardBackPic);
    }
    if(!isEmptyObject(compulsoryInsurancePic)) {
      param =  param+"&compulsoryInsurancePic="+JSON.stringify(compulsoryInsurancePic);

    }
    if(!isEmptyObject(commercialInsurancePic)) {
      param =  param+"&commercialInsurancePic="+JSON.stringify(commercialInsurancePic);

    }

    console.log("add:"+param)

    xPostFetch(SERVER_URL + '/loan/addLoan',param).then(result => {
      if (result && result.success) {
        Notify('添加成功', result.msg, 'success');
        this.handleOpenAddModal();
        this.handleQuerySubmit({data: this.state.params, pager: {page:this.state.page,pageSize:this.state.pageSize}});
      } else{
        Notify('添加发生异常', result.msg, 'error');
      }})
  };
  handleUpdateLoan = (data) =>{
    data.loanId=this.state.loanId;
    let arrayCarModel = data.arrayCarModel;

    if(arrayCarModel.length>2) {
      data.carBrand = arrayCarModel[0];
      data.carVehicle = arrayCarModel[1];
      data.carModel = arrayCarModel[2];
    }
    data = momentTansfer(data);
    let idcardFrontPic = data.idcardFrontPic;
    delete data.idcardFrontPic;
    let idcardBackPic = data.idcardBackPic;
    delete data.idcardBackPic;
    let compulsoryInsurancePic = data.compulsoryInsurancePic;
    delete data.compulsoryInsurancePic;
    let commercialInsurancePic = data.commercialInsurancePic;
    delete data.commercialInsurancePic;
    let param = querystring.encode(data);
    if(!isEmptyObject(idcardFrontPic)) {
      param = param + "&idcardFrontPic=" + JSON.stringify(idcardFrontPic);
    }
    if(!isEmptyObject(idcardBackPic)) {
      param =  param+"&idcardBackPic="+JSON.stringify(idcardBackPic);
    }
    if(!isEmptyObject(compulsoryInsurancePic)) {
      param =  param+"&compulsoryInsurancePic="+JSON.stringify(compulsoryInsurancePic);

    }
    if(!isEmptyObject(commercialInsurancePic)) {
      param =  param+"&commercialInsurancePic="+JSON.stringify(commercialInsurancePic);

    }
    console.log("update:"+param);
    xPostFetch(SERVER_URL + '/loan/updateLoan',param).then(result => {
      if (result && result.success) {
        Notify('修改成功', result.msg, 'success');
        this.handleOpenAddModal();
        this.handleQuerySubmit({data: this.state.params, pager: {page:this.state.page,pageSize:this.state.pageSize}});
      } else{
        Notify('添加发生异常', result.msg, 'error');
      }})
  };

  handleSubmitLoan = (data) =>{
    data = momentTansfer(data);
    data.loanId=this.state.loanId;
    let arrayCarModel = data.arrayCarModel;

    if(arrayCarModel.length>2) {
      data.carBrand = arrayCarModel[0];
      data.carVehicle = arrayCarModel[1];
      data.carModel = arrayCarModel[2];
    }
    let idcardFrontPic = data.idcardFrontPic;
    delete data.idcardFrontPic;
    let idcardBackPic = data.idcardBackPic;
    delete data.idcardBackPic;
    let compulsoryInsurancePic = data.compulsoryInsurancePic;
    delete data.compulsoryInsurancePic;
    let commercialInsurancePic = data.commercialInsurancePic;
    delete data.commercialInsurancePic;
    let param = querystring.encode(data);
    if(!isEmptyObject(idcardFrontPic)) {
      param = param + "&idcardFrontPic=" + JSON.stringify(idcardFrontPic);
    }
    if(!isEmptyObject(idcardBackPic)) {
      param =  param+"&idcardBackPic="+JSON.stringify(idcardBackPic);
    }
    if(!isEmptyObject(compulsoryInsurancePic)) {
      param =  param+"&compulsoryInsurancePic="+JSON.stringify(compulsoryInsurancePic);

    }
    if(!isEmptyObject(commercialInsurancePic)) {
      param =  param+"&commercialInsurancePic="+JSON.stringify(commercialInsurancePic);

    }

    console.log("submit:"+param);
    xPostFetch(SERVER_URL + '/loan/submitLoan',param).then(result => {
      if (result && result.success) {
        Notify('修改成功', result.msg, 'success');
        this.handleOpenAddModal();
        this.handleQuerySubmit({data: this.state.params, pager: {page:this.state.page,pageSize:this.state.pageSize}});
      } else{
        Notify('添加发生异常', result.msg, 'error');
      }})
  };

  handleApplyLoan = (data) =>{
    data = momentTansfer(data);
    data.loanId=this.state.loanId;

    let withholdingAgreementPic = data.withholdingAgreementPic;
    delete data.withholdingAgreementPic;
    let commercialInsurancePic = data.commercialInsurancePic;
    delete data.commercialInsurancePic;

    let param = querystring.encode(data);
    if(!isEmptyObject(withholdingAgreementPic)) {
      param = param + "&withholdingAgreementPic=" + JSON.stringify(withholdingAgreementPic);
    }
    if(!isEmptyObject(commercialInsurancePic)) {
      param =  param+"&commercialInsurancePic="+JSON.stringify(commercialInsurancePic);
    }
    console.log("submit:"+param);
    xPostFetch(SERVER_URL + '/loan/applyLoan',param).then(result => {
      if (result && result.success) {
        Notify('提交放款申请成功', result.msg, 'success');
        this.handleCancelLoanApplyModal();
        this.handleQuerySubmit({data: this.state.params, pager: {page:this.state.page,pageSize:this.state.pageSize}});
      } else{
        Notify('提交放款申请发生异常', result.msg, 'error');
      }})
  };

  handleOpenLoanApplyModal =(data) =>{
    console.log("进入handleOpenLoanApplyModal");
    let visible = !this.state.applyLoanModalVisible;
    console.log(visible);
    this.setState({
      applyLoanModalVisible : visible,
    });
    xFetch(SERVER_URL + '/loan/getInfo?loanId='+data.loanId).then(result => {
      if (result && result.data) {
        show("get Info OK");
        this.setState({loanInfo: result.data,loanId:data.loanId});
      } else{
        Notify('请求贷款明细数据发生异常', result.msg, 'error');
      }})

  };
  handleCancelShowModal=()=>{
    console.log('handleCancelShowModal:visible:');
    this.setState({showModalVisible : false});
  }
  handleCancelLoanApplyModal=()=>{
    this.setState({applyLoanModalVisible : false});
  }


  //打开查看窗口
  handleOpenShowModal =(data) =>{

    console.log("loanId:"+data.loanId);
    let visible = !this.state.showModalVisible;
    console.log('handleOpenShowModal:visible:'+visible);
    this.setState({showModalVisible : visible});
    xFetch(SERVER_URL + '/loan/getInfo?loanId='+data.loanId).then(result => {
      if (result && result.data) {
        show("get Info OK");
        this.setState({showLoanInfo: result.data,loanId:data.loanId});
      } else{
        Notify('请求贷款明细数据发生异常', result.msg, 'error');
      }})

  };

  handleOpenAddModal =() =>{
    console.log("进入store");
    let visible = !this.state.addModalVisible;
    console.log(visible);
    this.setState({
      addModalVisible : visible,
      loanInfo:{},
      loanId:null
    });
  };
  //打开修改窗口
  handleOpenUpdateModal =(data) =>{

    console.log("loanId:"+data.loanId);
    let visible = !this.state.addModalVisible;
    let carOptions = this.state.carOptions;


    console.log(visible);
    this.setState({addModalVisible : visible});
    xFetch(SERVER_URL + '/loan/getInfo?loanId='+data.loanId).then(result => {
      if (result && result.data) {
        show("get Info OK");
        let fssLoanModel = result.data.fssLoanModel;
        if(fssLoanModel.carBrand!="") {
          let childrenOptions = [{
            value: fssLoanModel.carVehicle, label: fssLoanModel.carVehicleName
            , children: [{value: fssLoanModel.carModel, label: fssLoanModel.carModelName}]
          }]
          carOptions.forEach(function (obj) {
            if (obj.value == fssLoanModel.carBrand) {
              obj.children = childrenOptions;
              return;
            }
          })
        }
        show(carOptions);
        this.setState({carOptions:carOptions,loanInfo: result.data,loanId:data.loanId});
      } else{
        Notify('请求贷款明细数据发生异常', result.msg, 'error');
      }})

  };


  handleQuerySubmit = (data) => {
    this.setState({loading:true});
    let queryParam = querystring.encode(data.data) + "&" + querystring.encode(data.pager);
    show(SERVER_URL + '/loan/getList?'+queryParam)
    xFetch(SERVER_URL + '/loan/getList?'+queryParam).then(result => {
      if (result && result.data) {
        show("OK");
        this.state.pagination.total = result.data.totalNumber;
        let pagination = this.state.pagination;
        pagination.pageSize = data.pager.pageSize;
        pagination.current = data.pager.page;
        this.setState({pagination: pagination});
        this.setState({dataList: result.data.items});
        this.setState({totalNumber: result.data.totalNumber});
        this.setState({pageSize: data.pager.pageSize});
        this.setState({page: data.pager.page});
        this.setState({loading:false});
        this.setState({params:data.data});
      } else{
        show("请求列表发生异常");
        Notify('请求列表发生异常', result.msg, 'error');
      }})
  }


  handleIntiData = () => {
    xFetch(SERVER_URL + '/car/getCarBrands').then(result => {
      if (result && result.data) {

        let options = result.data.map(brand=>(
          {label:brand.brandName,value:brand.brandCode,isLeaf:false}
        ));

        this.setState({
          carOptions: options,
        });
      } else{
        show("请求列表发生异常");
        Notify('请求列表发生异常', result.msg, 'error');
      }})

    xFetch(SERVER_URL + '/loan/getPlans').then(result => {
      if (result && result.data) {
        this.setState({
          planOptions: result.data,
        });
      } else{
        show("请求列表发生异常");
        Notify('请求列表发生异常', result.msg, 'error');
      }})
  }


  //
  handleCarCascaderLoadData =(selectedOptions) =>{

    const targetOption = selectedOptions[selectedOptions.length - 1];
    targetOption.loading = true;
    if (selectedOptions.length == 1){
      //第一级，获取车系
      xFetch(SERVER_URL + '/car/getCarSeries?brandCode='+targetOption.value).then(result => {
        if (result && result.data) {
          show("get series OK");
            let children = result.data.map(series=>(
            {label:series.seriesName,value:series.seriesCode,isLeaf:false}
          ));
          show(children);
          targetOption.children =children;

          this.setState({
            carOptions: [...this.state.carOptions],
          });
          targetOption.loading = false;
        } else{
          Notify('请求数据发生异常', result.msg, 'error');
        }})
    }
    else if(selectedOptions.length == 2) {
      //选择第二级，获取车型
      //第一级，获取车系
      xFetch(SERVER_URL + '/car/getCarModels?seriesCode='+targetOption.value).then(result => {
        if (result && result.data) {
          show("get car models OK");
          let children = result.data.map(models=>(
            {label:models.modelsName,value:models.modelsCode,isLeaf:true}
          ));
          show(children);
          targetOption.children =children;

          this.setState({
            carOptions: [...this.state.carOptions],
          });
          targetOption.loading = false;
        } else{
          Notify('请求数据发生异常', result.msg, 'error');
        }})
    }
    targetOption.loading = false;
  };


}

export default alt.createStore(LoanListStore, 'LoanListStore');
