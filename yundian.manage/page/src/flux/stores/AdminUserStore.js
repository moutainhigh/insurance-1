import alt from 'bases/Alt.js';
import querystring from "querystring";
import jsonp from "jsonp";
import AdminUserAction from '../actions/AdminUserAction';
import {Notify} from "components/common/Common";
import {xFetch,xPostFetch} from "../../services/xFetch";

//************************ 用于打印log的 **************************
const show = (info) => {
  console.log("store DealerUserStore: " + info);
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
class AdminUserStore {
  constructor() {
    this.bindListeners({
      handleInitDataList: AdminUserAction.initDataListInfo,
      handleQuerySubmit: AdminUserAction.querySubmit,
      handlePagination: AdminUserAction.setPagination,
      handleOpenAddModal: AdminUserAction.openAddModal,
      handleOpenUpdateModal: AdminUserAction.openUpdateModal,
      handleAddAdminUser: AdminUserAction.addAdminUser,
      handleUpdateAdminUser: AdminUserAction.updateAdminUser,
      handleResetPwd: AdminUserAction.resetPwd


    });
    this.state = {
      dataList: [],
      loading: true,
      typeList : [],
      addModalVisible : false,
      adminUserInfo:{},
      userId:null,
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

  handleAddAdminUser = (data) =>{
    data = momentTansfer(data);
    let param = querystring.encode(data);
    console.log("add:"+param)
    xPostFetch(SERVER_URL + '/adminUser/addUser',param).then(result => {
      if (result && result.success) {
        Notify('添加成功', result.msg, 'success');
        this.handleOpenAddModal();
        this.handleQuerySubmit({data: this.state.params, pager: {page:this.state.page,pageSize:this.state.pageSize}});
      } else{
        Notify('添加发生异常', result.msg, 'error');
      }})
  };
  handleUpdateAdminUser = (data) =>{
    data.userId=this.state.userId;
    data = momentTansfer(data);
    let param = querystring.encode(data);
    console.log("update:"+param);
    xPostFetch(SERVER_URL + '/adminUser/updateUser',param).then(result => {
      if (result && result.success) {
        Notify('修改成功', result.msg, 'success');
        this.handleOpenAddModal();
        this.handleQuerySubmit({data: this.state.params, pager: {page:this.state.page,pageSize:this.state.pageSize}});
      } else{
        Notify('添加发生异常', result.msg, 'error');
      }})
  };
  handleResetPwd = (data) =>{
    data = momentTansfer(data);
    let param = querystring.encode(data);
    console.log("update:"+param);
    xPostFetch(SERVER_URL + '/adminUser/resetPwd',param).then(result => {
      if (result && result.success) {
        Notify('密码重置成功!', result.msg, 'success');
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
    this.setState({
      addModalVisible : visible,
      adminUserInfo:{},
      userId:null
    });
  };
  //打开修改窗口
  handleOpenUpdateModal =(data) =>{

    console.log("userId:"+data.userId);
    let visible = !this.state.addModalVisible;
    console.log(visible);
    this.setState({addModalVisible : visible});
    xFetch(SERVER_URL + '/adminUser/getInfo?userId='+data.userId).then(result => {
      if (result && result.data) {
        show("get Info OK");
        this.setState({adminUserInfo: result.data,userId:data.userId});
      } else{
        Notify('请求经销商用户明细数据发生异常', result.msg, 'error');
      }})

  };


  handleQuerySubmit = (data) => {
    this.setState({loading:true});
    let queryParam = querystring.encode(data.data) + "&" + querystring.encode(data.pager);
    show(SERVER_URL + '/adminUser/getList?'+queryParam)
    xFetch(SERVER_URL + '/adminUser/getList?'+queryParam).then(result => {
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

export default alt.createStore(AdminUserStore, 'AdminUserStore');
