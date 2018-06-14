import alt from 'bases/Alt.js';
import LayoutAction from '../actions/LayoutAction.js';
import jsonp from "jsonp";

class LayoutStore {

  constructor() {

    this.bindListeners({
      handleGetMenus: LayoutAction.getMenus,
      handleSetCurrent: LayoutAction.setCurrent,
    });

    this.state = {
      menus: {},
      current: "11",

    }
  }

  handleSetCurrent = (data) => {
    this.setState({ current: data});
  }


  handleGetMenus = (obj) => {
  //   var _cb = obj.cb;
  //   // console.log(SERVER_URL)
  //   // console.log("99999" + _cb)
  //   jsonp(SERVER_URL + '/UserMenuApi/getMenuList.jsonp', (err, result) => {
  //     // console.log('Get Server Order Data:', result);
  //     if (err) {
  //       Notify('获取菜单信息异常', result.msg, 'error');
  //     }
  //     if (result.code == '200' && result.success) {
  //       // console.log("后台返回数据：" + result.loader);
  //       this.setState({
  //         menus: result.loader
  //       });
  //       _cb(result.loader);
  //     } else {
  //       Notify('获取菜单信息异常', result.msg, 'error');
  //     }
  //   });
  }

}

export default alt.createStore(LayoutStore, 'LayoutStore');
