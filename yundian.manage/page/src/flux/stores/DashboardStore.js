import alt from "bases/Alt.js";
import {Notify} from "components/common/Common";

//************************ 用于打印log的 **************************
const show = (info) => {
  console.log("store WhiteListStore: " + info);
}
//****************************************************************
class DashboardStore {
  constructor() {
    this.bindListeners({

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



}

export default alt.createStore(DashboardStore, 'DashboardStore');
