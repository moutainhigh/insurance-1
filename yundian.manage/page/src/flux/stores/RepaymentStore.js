import alt from "bases/Alt.js";
import querystring from "querystring";
import RepaymentAction from "../actions/RepaymentAction";
import {Notify} from "components/common/Common";
import {xFetch, xPostFetch} from "../../services/xFetch";
import {propsToFields, isEmptyObject} from "services/functions";
import {citys} from "services/data"
//************************ 用于打印log的 **************************
const show = (info) => {
  console.log("store RepaymentStore: " + JSON.stringify(info));
}

//****************************************************************
class RepaymentStore {
  constructor() {
    this.bindListeners({
      handleInitDataList: RepaymentAction.initDataListInfo,
      handlePagination: RepaymentAction.setPagination,
      handleOpenShowModal: RepaymentAction.openShowModal,
      handleCloseShowModal:RepaymentAction.closeShowModal



    });
    this.state = {
      dataList: [],
      loading: true,
      typeList : [],
      showModalVisible : false,
      showLoanInfo:{},
      loanId:null,
      pagination: {
        pageSize: 20,
        showSizeChanger: true,
        showQuickJumper: true,
      },
      repaymentPlans: [],
    };
  }


  handleInitDataList = (pager) => {
    this.handleQuerySubmit({pager: pager,data:{status:'ON'}});
  };

  handlePagination = (pager) => {
    this.handleQuerySubmit(pager);
  };


  handleCloseShowModal=()=>{
    let visible = !this.state.showModalVisible;
    console.log(visible);
    this.setState({showModalVisible : visible});
  }
  /**
   * 打开详情
   * @param data
   */
  handleOpenShowModal = (data)=>{

    console.log("loanId:"+data.loanId);
    let visible = !this.state.showModalVisible;
    console.log(visible);
    this.setState({showModalVisible : visible});
    xFetch(SERVER_URL + '/loan/getInfo?loanId='+data.loanId).then(result => {
      if (result && result.data) {
        show("get Info OK");
        this.setState({showLoanInfo: result.data,loanId:data.loanId});
      } else{
        Notify('请求贷款明细数据发生异常', result.msg, 'error');
      }})

    xFetch(SERVER_URL + '/repayment/getPlans?loanId='+data.loanId).then(result => {
      if (result && result.data) {
        show("get Info OK");
        this.setState({repaymentPlans: result.data,loanId:data.loanId});
      } else{
        Notify('请求还款明细数据发生异常', result.msg, 'error');
      }})


  }

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

export default alt.createStore(RepaymentStore, 'RepaymentStore');
