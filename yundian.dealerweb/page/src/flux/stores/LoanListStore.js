import alt from 'bases/Alt.js';
import querystring from "querystring";
import LoanListAction from '../actions/LoanListAction';
import {Notify} from "components/common/Common";
import xFetch from "../../services/xFetch";

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
      handleDeleteRecord: LoanListAction.deleteRecord,
      handleChangeStatus: LoanListAction.changeStatus,
      handleOpenAddModal: LoanListAction.openAddModal,
      handleAddWhiteNameList: LoanListAction.addWhiteNameList,
    });
    this.state = {
      dataList: [],
      loading: true,
      typeList : [],
      addModalVisible : false,
      pagination: {
        pageSize: 20,
        showSizeChanger: true,
        showQuickJumper: true,
      },
      params: {},
    }
  }

  handleInitDataList = (pager) => {
    this.handleQuerySubmit({pager: pager,data:{status:'ON'}});
  };

  handlePagination = (pager) => {
    this.handleQuerySubmit({data: this.state.params, pager: pager});
  };
  handleChangeStatus = (data) =>{
    let param = querystring.encode(data);
    xFetch(SERVER_URL + '/admin/NameListApi/changeStatus.json?'+param).then(result => {
      if (result && result.data) {
        Notify('状态改变成功', result.msg, 'success');
        this.handleQuerySubmit({data: this.state.params, pager: {page:this.state.page,pageSize:this.state.pageSize}});
      } else{
        Notify('状态改变发生异常', result.msg, 'error');
      }})
  };

  handleDeleteRecord = (data) =>{
    let param = querystring.encode(data);
    xFetch(SERVER_URL + '/admin/NameListApi/deleteRecord.json?'+param).then(result => {
      if (result && result.data) {
        Notify('删除成功', result.msg, 'success');
        this.handleQuerySubmit({data: this.state.params, pager: {page:this.state.page,pageSize:this.state.pageSize}});
      } else{
        Notify('删除发生异常', result.msg, 'error');
      }})
  };

  handleAddWhiteNameList = (data) =>{
    let param = querystring.encode(data);
    xFetch(SERVER_URL + '/admin/NameListApi/addRecord.json?'+param).then(result => {
      if (result && result.data) {
        Notify('添加成功', result.msg, 'success');
        this.handleOpenAddModal();
        this.handleQuerySubmit({data: this.state.params, pager: {page:this.state.page,pageSize:this.state.pageSize}});
      } else{
        Notify('添加发生异常', result.msg, 'error');
      }})
  };

  handleOpenAddModal =() =>{
    console.log("进入store");
    let visible = !this.state.addModalVisible;
    console.log(visible);
    this.setState({addModalVisible : visible});
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
