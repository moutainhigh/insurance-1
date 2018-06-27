
import alt from 'bases/Alt.js';

class RepaymentAction {
  /**
   * 初始化列表
   * @param data
   * @returns {*}
   */
  initDataListInfo = (data)=> {
    return data;
  };

  /**
   * 提交查询
   * @param data
   * @returns {*}
   */
  querySubmit = (data)=> {
    return data;
  };

  /**
   * 修改页面索引
   * @param pager
   * @returns {*}
   */
  setPagination = (pager)=> {
    return pager;
  };

  /**
   * 关闭
   * @param data
   * @returns {*}
   */
  closeShowModal =()=> {
    return null;
  };

  /**
   * 打开查看模态框
   * @param data
   * @returns {*}
   */
  openShowModal =(data)=> {
    return data;
  };

  /**
   * 提交代扣
   * @param data
   * @returns {*}
   */
  witholding =(data)=> {
    return data;
  };



}

export default alt.createActions(RepaymentAction);
