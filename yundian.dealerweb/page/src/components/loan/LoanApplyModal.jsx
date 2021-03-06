import React, {Component} from "react";
import {Card, Upload,Radio,Form,Icon, Checkbox,InputNumber,Input, Modal, Select, Row, Col, Button,DatePicker} from "antd";
import LoanListAction from "actions/LoanListAction";
import { propsToFields,isEmptyObject } from 'services/functions';
import PicturesWall from '../common/PicturesWall'
import Moment from 'moment'
const RadioGroup = Radio.Group;
const CheckboxGroup = Checkbox.Group;
const FormItem = Form.Item;
const Option = Select.Option;
const show = (info) => {
  console.log("jsx loanApplyModal: " + JSON.stringify(info));
}
/*申请放款*/
class LoanApplyModal extends Component {


  handleAddCancel =()=> {
    LoanListAction.cancelLoanApplyModal();
  };
  handleOnSubmit = (e) => {
    this.props.form.validateFieldsAndScroll((err, values) => {
      console.log("applyLoan:"+JSON.stringify(values))
          if (!err) {
            LoanListAction.applyLoan(values);
      }
    });
  }
  handleUploadChange = ({ fileList }) =>
  {
    show(fileList);
  }
  render() {
    const picturesWallprops={
      length:1,
      maxFileSize:2,
      onChange:this.handleUploadChange
    };

    const {getFieldDecorator} = this.props.form;
    const formItemLayout = {
      labelCol:{span:2,offset: 0},
      wrapperCol: {span: 23}
    };

    const rowLayout = {
      marginTop: 5,
      marginBottom: 5
    }
    return (
      <div>
        <Modal width={1000} visible={this.props.applyLoanModalVisible} title="申请放款" onCancel={this.handleAddCancel}
               footer={[
                 <Button key="back" type="ghost" size="large" onClick={this.handleAddCancel}>取消</Button>,
                 <Button key="submitTJ" type="primary" size="large" onClick={this.handleOnSubmit}>申请放款</Button>
               ]}>
              <Form layout="horizontal">
                <Card title="被保险人信息" style={{marginBottom: 24}} bordered={true}>
                    <Row style={rowLayout}>
                      <Col span="2"><FormItem label="被保人姓名"></FormItem></Col>
                      <Col span="6">
                        <FormItem {...formItemLayout}>
                          {getFieldDecorator('insuresName' )(
                            <Input/>
                          )}
                        </FormItem>
                      </Col>
                      <Col span="2"><FormItem label="联系电话" /></Col>
                      <Col span="6">
                        <FormItem {...formItemLayout}>
                          {getFieldDecorator('insuresPhone' )(
                            <Input/>
                          )}
                        </FormItem>
                      </Col>
                      <Col span="2"><FormItem label="身份证号" /></Col>
                      <Col span="6">
                        <FormItem {...formItemLayout}>
                          {getFieldDecorator('insuresIdcard')(
                            <Input/>
                          )}
                        </FormItem>
                          </Col>
                    </Row>
                  </Card>

                <Card title="影象信息" style={{marginBottom: 24}} bordered={true}>
                  <Row style={rowLayout}>
                    <Col span="2"><FormItem label="贷款合同" ></FormItem></Col>
                    <Col span="6">
                      {getFieldDecorator('loanContractPic' , { rules: [ {required: true, message: '请上传贷款合同照片'}]})(
                          <PicturesWall  {...picturesWallprops}/>
                      )}
                    </Col>
                    <Col span="2"><FormItem label="委托代扣协议" /></Col>
                    <Col span="6">
                      {getFieldDecorator('withholdingAgreementPic' , { rules: [ {required: true, message: '请上传委托代扣协议照片'}]})(
                        <PicturesWall  {...picturesWallprops}/>
                      )}
                    </Col>
                  </Row>
                </Card>
              </Form>
        </Modal>
      </div>)
  }

}

LoanApplyModal = Form.create({
  mapPropsToFields(props){
    if(!isEmptyObject(props.loanInfo))
    {
      let loan = props.loanInfo.fssLoanModel;
      if(props.loanInfo.fssLoanDocs!=null){
        let docs = props.loanInfo.fssLoanDocs;
        loan.withholdingAgreementPic = docs.withholdingAgreementPic;
        loan.loanContractPic = docs.loanContractPic;
      }
      let fields = propsToFields(loan);
      return fields;

    }else {

    }

  }

})(LoanApplyModal);
export default LoanApplyModal;
