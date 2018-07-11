import alt from 'bases/Alt.js';
import LayoutAction from '../actions/LayoutAction.js';
import jsonp from "jsonp";
import querystring from "querystring";
import {Notify} from "components/common/Common";
import {xFetch,xPostFetch} from "../../services/xFetch";
class LayoutStore {

  constructor() {

    this.bindListeners({
      handleGetMenus: LayoutAction.getMenus,
      handleSetCurrent: LayoutAction.setCurrent,
      handleGetLoginInfo:LayoutAction.getLoginInfo,
      handleLoginOut:LayoutAction.loginOut,
      handleOpenPwdModal: LayoutAction.openPwdModal,
      handleChangePwd: LayoutAction.changePwd,
    });

    this.state = {
      pwdModalVisible:false,
      menus: {},
      current: "11",
      dealerUser:{name:'',dealerName:''}
    }
  }

  handleOpenPwdModal =() =>{
    let visible = !this.state.pwdModalVisible;
    console.log(visible);
    this.setState({
      pwdModalVisible : visible,
    });
  };
  handleChangePwd = (data) =>{
    let param = querystring.encode(data);
    console.log("update:"+param);
    xPostFetch(SERVER_URL + '/dealerUser/modifyPwd?'+param).then(result => {
      if (result && result.success) {
        Notify('密码修改成功！', result.msg, 'success');
        this.handleOpenPwdModal();
      } else{
        Notify('密码修改失败', result.msg, 'error');
      }})
  };

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
