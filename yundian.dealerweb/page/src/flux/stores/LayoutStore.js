import alt from 'bases/Alt.js';
import LayoutAction from '../actions/LayoutAction.js';
import jsonp from "jsonp";
import {Notify} from "components/common/Common";
import {xFetch} from "../../services/xFetch";
class LayoutStore {

  constructor() {

    this.bindListeners({
      handleGetMenus: LayoutAction.getMenus,
      handleSetCurrent: LayoutAction.setCurrent,
      handleGetLoginInfo:LayoutAction.getLoginInfo,
      handleLoginOut:LayoutAction.loginOut,
    });

    this.state = {
      menus: {},
      current: "11",
      dealerUser:{name:'',dealerName:''}
    }
  }

  handleGetMenus=(data)=>{

  }
  handleSetCurrent = (data) => {
    this.setState({ current: data});
  }

  handleGetLoginInfo = () => {
    console.log('handleGetLoginInfo:/getLoginInfo')
      xFetch(SERVER_URL + '/getLoginInfo').then(result => {
      if (result && result.success) {
        console.log(JSON.stringify(result));
        this.setState({dealerUser: result.data});
      } else{
        Notify('请求明细数据发生异常', result.msg, 'error');
      }})
  }

  handleLoginOut=()=>{
    xFetch(SERVER_URL + '/loginOut').then(result => {
      if (result && result.success) {
        location.href="/login.html";
      } else{
        Notify('退出登录失败', result.msg, 'error');
      }})
  }


}

export default alt.createStore(LayoutStore, 'LayoutStore');
