
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
   * 打开添加模态框
   * @param data
   * @returns {*}
   */
  openAddModal =()=> {
    return null;
  };

  /**
   * 打开查看页面
   */
  openShowModal =(data)=>{
    return data;
  }

  关闭查到页面
  cancelShowModal=()=>{
    return null;
  }
  /**
   * 打开申请放款模态框
   */
  openLoanApplyModal=(data)=>{
    return data;
  }

  cancelLoanApplyModal=()=>{
    return null;
  }

  /**
   * 打开修改模态框
   * @param data
   * @returns {*}
   */
  openUpdateModal =(data)=> {
    return data;
  };
  /**
   * 申请放款
   * @param data
   * @returns {*}
   */
  applyLoan =(data)=>{
    return data;
  }
  addLoan =(data)=> {
    return data;
  };

 updateLoan =(data)=> {
    return data;
  };
  /**
   * 提交审核
   * @param data
   * @returns {*}
   */
  submitLoan =(data)=> {
    return data;
  };


  carCascaderLoadData = (data)=> {
    return data;
  };

  /**
   *汽车品牌
   */
  intiData =()=> {
    return null;
  };
}

export default alt.createActions(LoanListAction);
