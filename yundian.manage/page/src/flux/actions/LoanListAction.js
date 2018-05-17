
import alt from 'bases/Alt.js';

class LoanListAction {
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
   * 打开查看页面
   */
  openShowModal =(data)=>{
    return data;
  }

  /**
   * 关闭查看页面
   * @returns {null}
   */
  cancelShowModal=()=>{
    return null;
  }



  /**
   * 打开放款页面
   */
  openLoanGrantModal=(data)=>{
    return data;
  }
  /**
   * 关闭
   * @returns {null}
   */
  cancelLoanGrantModal=()=>{
    return null;
  }
  /**
   * 发放贷款
   * @param data
   * @returns {*}
   */
  grantLoan =(data)=>{
    return data;
  }
  /**
   * 打开审核页面
   * @returns data
   */
  openAuditModal=(data)=>{
    return data;
  }
  /**
   * 关闭审核页面
   * @returns{null}
   */
  cancelAuditModal=()=>{
    return null;
  }

  /**
   * 审核操作，集成通过,拒绝,退回
   * @param data
   */
  audit =(data)=> {
    return data;
  }


}

export default alt.createActions(LoanListAction);
