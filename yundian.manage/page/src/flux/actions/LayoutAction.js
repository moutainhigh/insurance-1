import alt from 'bases/Alt.js';

class LayoutAction {

  getMenus(_cb) {
    return {cb: _cb};
  }

  setCurrent(data){
    return data;
  }
}

export default alt.createActions(LayoutAction);
