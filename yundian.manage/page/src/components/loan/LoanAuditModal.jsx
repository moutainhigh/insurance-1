import React, {Component} from "react";
import {Card, Form, Checkbox, Modal, Row, Col, Button} from "antd";
import LoanListAction from "actions/LoanListAction";
import {propsToFields, isEmptyObject} from "services/functions";
import LoanInfo from "./LoanInfo";
const FormItem = Form.Item;
const show = (info) => {
  console.log("jsx LoanListShowModal: " + JSON.stringify(info));
}
/**
 * 审核
 */
class LoanAuditModal extends Component{

  //通过
  handleOnAuditPass =()=> {
    LoanListAction.audit({type:'PASS'});
  };
  //拒绝
  handleOnReject =()=> {
    LoanListAction.audit({type:'REJECT'});
  };
  //退回
  handleOnReturn =()=> {
    LoanListAction.audit({type:'RETURN'});
  };
  //关闭
  handleCancelAuditModal =()=> {
    LoanListAction.cancelAuditModal();
  };
  render(){

    return (
      <div>
      <Modal width={1000} visible={this.props.auditModalVisible} title="订单审核" onCancel={this.handleCancelAuditModal}
             footer={[

               <Button key="submitPass" type="primary" size="large" onClick={this.handleOnAuditPass} >审核通过</Button>,
               <Button key="submitReturn" type="danger" size="large" onClick={this.handleOnReturn}>退回</Button>,
               <Button key="submitReject" type="primary" size="large" onClick={this.handleOnReject}>拒绝</Button>,
               <Button key="back" type="ghost" size="large" onClick={this.handleCancelAuditModal}>返回</Button>,
             ]}>
        <LoanInfo showLoanInfo={this.props.auditLoanInfo}></LoanInfo>
      </Modal>
    </div>
    );
  }
}

export default LoanAuditModal;
