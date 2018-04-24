import alt from 'bases/Alt.js';
import querystring from "querystring";
import jsonp from "jsonp";
import LoanListAction from '../actions/LoanListAction';
import {Notify} from "components/common/Common";
import {xFetch,xPostFetch} from "../../services/xFetch";

//************************ 用于打印log的 **************************
const show = (info) => {
  console.log("store LoanListStore: " + info);
}
const momentTansfer = (data)=>{
  let format="YYYY-MM-DD";
  if(data.carBuyDate!=null) {
    data.carBuyDate = data.carBuyDate.format(format);
  }
  if(data.policyEffectDate!=null) {
    data.policyEffectDate = data.policyEffectDate.format(format);
  }
  if(data.policyExpireDate!=null) {
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

      handleAddLoan: LoanListAction.addLoan,
      handleUpdateLoan: LoanListAction.updateLoan,
      handleSubmitLoan: LoanListAction.submitLoan,
      handleOpenLoanApplyModal: LoanListAction.openLoanApplyModal,
      handleApplyLoan: LoanListAction.applyLoan,


    });
    this.state = {
      dataList: [],
      loading: true,
      typeList : [],
      addModalVisible : false,
      applyLoanModalVisible : false,
      loanInfo:{},
      loanId:null,
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
    let param = querystring.encode(data);
    console.log("add:"+param)
    xPostFetch(SERVER_URL + '/loan/addLoan?'+param).then(result => {
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
    data = momentTansfer(data);
    let param = querystring.encode(data);
    console.log("update:"+param);
    xPostFetch(SERVER_URL + '/loan/updateLoan?'+param).then(result => {
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
    let param = querystring.encode(data);
    console.log("submit:"+param);
    xPostFetch(SERVER_URL + '/loan/submitLoan?'+param).then(result => {
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
    let param = querystring.encode(data);
    console.log("submit:"+param);
    xPostFetch(SERVER_URL + '/loan/applyLoan?'+param).then(result => {
      if (result && result.success) {
        Notify('提交放款申请成功', result.msg, 'success');
        this.handleOpenLoanApplyModal();
        this.handleQuerySubmit({data: this.state.params, pager: {page:this.state.page,pageSize:this.state.pageSize}});
      } else{
        Notify('提交放款申请发生异常', result.msg, 'error');
      }})
  };

  handleOpenLoanApplyModal =() =>{
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
    console.log(visible);
    this.setState({addModalVisible : visible});
    xFetch(SERVER_URL + '/loan/getInfo?loanId='+data.loanId).then(result => {
      if (result && result.data) {
        show("get Info OK");
        this.setState({loanInfo: result.data,loanId:data.loanId});
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


}

export default alt.createStore(LoanListStore, 'LoanListStore');
