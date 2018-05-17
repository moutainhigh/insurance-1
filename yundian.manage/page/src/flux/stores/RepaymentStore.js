import alt from "bases/Alt.js";
import querystring from "querystring";
import DealerAction from "../actions/DealerAction";
import {Notify} from "components/common/Common";
import {xFetch, xPostFetch} from "../../services/xFetch";
import {propsToFields, isEmptyObject} from "services/functions";
import {citys} from "services/data"
//************************ 用于打印log的 **************************
const show = (info) => {
  console.log("store DealerStore: " + JSON.stringify(info));
}

//****************************************************************
class RepaymentStore {
  constructor() {
    this.bindListeners({
      handleInitDataList: DealerAction.initDataListInfo,
      handlePagination: DealerAction.setPagination,
      handleOpenAddModal: DealerAction.openAddModal,
      handleOpenUpdateModal: DealerAction.openUpdateModal,
      handleAddDealer: DealerAction.addDealer,
      handleUpdateDealer: DealerAction.updateDealer


    });
    this.state = {
      dataList: [],
      loading: true,
      typeList : [],
      addModalVisible : false,
      dealerInfo:{},
      dealerId:null,
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
    this.handleQuerySubmit(pager);
  };

  handleAddDealer = (data) =>{

    show(citys);
    let array =  data.arrayProvince;
    if(array.length>1){
      data.province =array[0];
      data.city =array[1];
      let selectProvince = citys.filter(function (item) {
        return item.value==data.province;
      })
      if(!isEmptyObject(selectProvince)) {
        data.provinceName = selectProvince[0].label;
        //查找城市
        let selectCity = selectProvince[0].children.filter(function (item) {
          return item.value==data.city;
        })
        if(!isEmptyObject(selectCity)){
          data.cityName=selectCity[0].label;
        }
      }
    }
    let param = querystring.encode(data);
    console.log("add:"+param)
    xPostFetch(SERVER_URL + '/dealer/addDealer',param).then(result => {
      if (result && result.success) {
        Notify('添加成功', result.msg, 'success');
        this.handleOpenAddModal();
        this.handleQuerySubmit({data: this.state.params, pager: {page:this.state.page,pageSize:this.state.pageSize}});
      } else{
        Notify('添加发生异常', result.msg, 'error');
      }})
  };
  handleUpdateDealer = (data) =>{


        let array =  data.arrayProvince;
        if(array.length>1){
          data.province =array[0];
          data.city =array[1];
          let selectProvince = citys.filter(function (item) {
            return item.value==data.province;
          })
          if(!isEmptyObject(selectProvince)) {
            data.provinceName = selectProvince[0].label;
        //查找城市
         let selectCity = selectProvince[0].children.filter(function (item) {
          return item.value==data.city;
        })
            show(selectCity)
        if(!isEmptyObject(selectCity)){
          data.cityName=selectCity[0].label;
        }
      }
    }
    data.dealerId=this.state.dealerId;
    let param = querystring.encode(data);
    console.log("update:"+param);
    xPostFetch(SERVER_URL + '/dealer/updateDealer',param).then(result => {
      if (result && result.success) {
        Notify('修改成功', result.msg, 'success');
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
      dealerInfo:{},
      dealerId:null
    });
  };
  //打开修改窗口
  handleOpenUpdateModal =(data) =>{

    console.log("dealerId:"+data.dealerId);
    let visible = !this.state.addModalVisible;
    console.log(visible);
    this.setState({addModalVisible : visible});
    xFetch(SERVER_URL + '/dealer/getInfo?dealerId='+data.dealerId).then(result => {
      if (result && result.data) {
        show("get Info OK");
        this.setState({dealerInfo: result.data,dealerId:data.dealerId});
      } else{
        Notify('请求明细数据发生异常', result.msg, 'error');
      }})
  };


  handleQuerySubmit = (data) => {
    this.setState({loading:true});
    let queryParam = querystring.encode(data.data) + "&" + querystring.encode(data.pager);
    show(SERVER_URL + '/dealer/getList?'+queryParam)
    xFetch(SERVER_URL + '/dealer/getList?'+queryParam).then(result => {
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
