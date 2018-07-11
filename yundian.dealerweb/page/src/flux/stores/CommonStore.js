import alt from 'bases/Alt.js';
import CommonAction from '../actions/CommonAction';
import {Notify} from "components/common/Common";
import {xFetch} from "../../services/xFetch";
class CommonStore {

  constructor() {

    this.bindListeners({
      handleGetCodeList: CommonAction.getCodeList,
    });

    this.state = {
      codeList: {},
    }
  }

  handleGetCodeList = (codeType) => {
    let queryParam ="codeType="+codeType;
    xFetch(SERVER_URL + '/library/getTypeList?'+queryParam).then(result => {
      if (result && result.data) {
        this.setState({codeList:result.data});
      } else{
        show("请求列表发生异常");
        Notify('请求列表发生异常', result.msg, 'error');
      }})


  }

}

export default alt.createStore(CommonStore, 'CommonStore');
