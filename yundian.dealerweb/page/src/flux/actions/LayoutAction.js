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
}

export default alt.createActions(LayoutAction);
