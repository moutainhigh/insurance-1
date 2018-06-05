import React, {Component} from "react";
import {Card, Radio, Form, Checkbox, Modal, Select, Row, Col, Button} from "antd";
import LoanListAction from "actions/LoanListAction";
import {propsToFields, isEmptyObject} from "services/functions";
const RadioGroup = Radio.Group;
const CheckboxGroup = Checkbox.Group;
const FormItem = Form.Item;
const Option = Select.Option;
const show = (info) => {
  console.log("jsx loanGrantModal: " + JSON.stringify(info));
}
class ViewImg extends Component {

  render() {
    let data = this.props.data;
    let url = '';
    if (data) {
      url = data.url;
    }
    return (
      <img width="100px" height="100px" src={url} onClick={()=>{window.open(url)}} />
    )
  }
}
/*放款*/
class LoanGrantModal extends Component {
  handleGrantCancel =()=> {
    LoanListAction.cancelLoanGrantModal();
  };
  handleOnGrant = () => {
    LoanListAction.grantLoan({});
  }

  render() {
    let fssLoanModel = {};
    let docs = {};
    let imgViewCommercialInsurancePic ;
    let imgViewWithholdingAgreementPic ;
    if(!isEmptyObject(this.props.loanInfo)) {
      fssLoanModel = this.props.loanInfo.fssLoanModel;
      docs = this.props.loanInfo.fssLoanDocs;
      show(docs);
      if (docs != null) {

        if (docs.commercialInsurancePic != undefined) {
          imgViewCommercialInsurancePic = docs.commercialInsurancePic.map((item, index) => {
            let data = {title: '', desc: '', url: item.url};
            return <ViewImg data={data} key={index}/>;
          });
        }
        if (docs.withholdingAgreementPic != undefined) {
          imgViewWithholdingAgreementPic = docs.withholdingAgreementPic.map((item, index) => {
            let data = {title: '', desc: '', url: item.url};
            return <ViewImg data={data} key={index}/>;
          });
        }

      }
    }
    const rowLayout = {
      marginTop: 5,
      marginBottom: 5
    }
    return (
      <div>
        <Modal width={1000} visible={this.props.grantLoanModalVisible} title="放款审核" onCancel={this.handleGrantCancel}
               footer={[
                 <Button key="back" type="ghost" size="large" onClick={this.handleGrantCancel}>取消</Button>,
                 <Button key="submitTJ" type="primary" size="large" onClick={this.handleOnGrant}>放款</Button>
               ]}>
                <Card title="被保险人信息" style={{marginBottom: 24}} bordered={true}>
                  <Row style={rowLayout}>
                    <Col span="2"><span>被保人姓名:</span></Col>
                    <Col span="6"><span>{fssLoanModel.insuresName==undefined?"":fssLoanModel.insuresName}</span>
                    </Col>
                    <Col span="2"><span>联系电话:</span></Col>
                    <Col span="6"><span>{fssLoanModel.insuresPhone}</span>
                    </Col>
                    <Col span="2"><span>身份证号:</span></Col>
                    <Col span="6"><span>{fssLoanModel.insuresIdcard}</span>
                    </Col>
                  </Row>
                  </Card>

                <Card title="影象信息" style={{marginBottom: 24}} bordered={true}>
                  <Row style={rowLayout}>
                    <Col span="2"><FormItem label="贷款合同" ></FormItem></Col>
                    <Col span="6">
                      {imgViewWithholdingAgreementPic}
                    </Col>
                    <Col span="2"><FormItem label="委托代扣协议" /></Col>
                    <Col span="6">
                      {imgViewCommercialInsurancePic}
                    </Col>
                  </Row>
                </Card>
        </Modal>
      </div>)
  }

}
export default LoanGrantModal;
