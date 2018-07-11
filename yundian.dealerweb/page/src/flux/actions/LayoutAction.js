import alt from 'bases/Alt.js';

class LayoutAction {

  getMenus(_cb) {
    return {cb: _cb};
  }

  setCurrent(data){
    return data;
  }

  getLoginInfo(){
    return null;
  }
  loginOut(){
    return null;
  }
  /**
   * 打开修改密码
   * @param data
   * @returns {*}
   */
  openPwdModal = ()=> {
    return null;
  };
  /**
   *修改密码
   */
  changePwd =(data)=> {
    return data;
  };
}

export default alt.createActions(LayoutAction);
