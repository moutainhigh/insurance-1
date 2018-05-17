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
//****************************************************************
class LoanListStore {
  constructor() {
    this.bindListeners({
      handleInitDataList: LoanListAction.initDataListInfo,
      handleQuerySubmit: LoanListAction.querySubmit,
      handlePagination: LoanListAction.setPagination,
      //打开查看页面
      handleOpenShowModal: LoanListAction.openShowModal,
      handleCancelShowModal: LoanListAction.cancelShowModal,

      //打开放款页面
      handleOpenLoanGrantModal: LoanListAction.openLoanGrantModal,
      handleCancelLoanGrantModal: LoanListAction.cancelLoanGrantModal,
      //打开审核页面
      handleOpenAuditModal: LoanListAction.openAuditModal,
      handleCancelAuditModal: LoanListAction.cancelAuditModal,
      //放款
      handleGrantLoan: LoanListAction.grantLoan,
      //审核操作
      handleAudit: LoanListAction.audit,

    });
    this.state = {
      dataList: [],
      loading: true,
      typeList : [],
      auditModalVisible : false,
      grantLoanModalVisible : false,
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


  /**
   * 审核操作
   * @param data
   */
  handleAudit = (data) =>{
    data.loanId=this.state.loanId;
    console.log("audit:"+data);
    let param = querystring.encode(data);
    xPostFetch(SERVER_URL + '/loan/audit',param).then(result => {
      if (result && result.success) {
        Notify('审核成功', result.msg, 'success');
        this.handleCancelAuditModal();
        this.handleQuerySubmit({data: this.state.params, pager: {page:this.state.page,pageSize:this.state.pageSize}});
      } else{
        Notify('提交放款申请发生异常', result.msg, 'error');
      }})
  };

  /**
   * 放款
   * @param data
   */
  handleGrantLoan = (data) =>{
    data.loanId=this.state.loanId;
    let param = querystring.encode(data);
    xPostFetch(SERVER_URL + '/loan/grantLoan',param).then(result => {
      if (result && result.success) {
        Notify('提交放款成功', result.msg, 'success');
        this.handleCancelLoanGrantModal();
        this.handleQuerySubmit({data: this.state.params, pager: {page:this.state.page,pageSize:this.state.pageSize}});
      } else{
        Notify('提交放款申请发生异常', result.msg, 'error');
      }})
  };

  /**
   * 打开审核页面
   */
  handleOpenAuditModal =(data) =>{
    console.log("handleOpenAuditModal");
    let visible = !this.state.auditModalVisible;
    console.log(visible);
    this.setState({
      auditModalVisible : visible,
    });
    xFetch(SERVER_URL + '/loan/getInfo?loanId='+data.loanId).then(result => {
      if (result && result.data) {
        show("get Info OK");
        this.setState({auditLoanInfo: result.data,loanId:data.loanId});
      } else{
        Notify('请求贷款明细数据发生异常', result.msg, 'error');
      }})

  };

  handleCancelLoanGrantModal=()=>{
    this.setState({grantLoanModalVisible : false});
  }

  handleCancelShowModal=()=>{
    console.log('handleCancelShowModal:visible:');
    this.setState({showModalVisible : false});
  }
  handleCancelAuditModal=()=>{
    this.setState({auditModalVisible : false});
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
