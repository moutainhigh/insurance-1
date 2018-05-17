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
 * 显示
 */
class LoanInfoShowModal extends Component{

  //取消
  handleShowCancel =()=> {
    LoanListAction.cancelShowModal();
  };
  render(){
    return (
      <div>
        <Modal width={1000} visible={this.props.showModalVisible} title="查看保险分期" onCancel={this.handleShowCancel}
               footer={[
                 <Button key="back" type="ghost" size="large" onClick={this.handleShowCancel}>返回</Button>,
               ]}>
          <LoanInfo showLoanInfo={this.props.showLoanInfo}></LoanInfo>
        </Modal>
      </div>

    );
  }
}
export default LoanInfoShowModal;



