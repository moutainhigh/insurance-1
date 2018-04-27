import React, {Component} from "react";
import {Card, Upload,Radio,Form,Icon, Checkbox,InputNumber,Input, Modal, Select, Row, Col, Button,DatePicker} from "antd";
import LoanListAction from "actions/LoanListAction";
import { propsToFields,isEmptyObject } from 'services/functions';
const FormItem = Form.Item;
const show = (info) => {
  console.log("jsx LoanListShowModal: " + JSON.stringify(info));
}
class LoanListShowModal extends Component {

  //取消
  handleShowCancel =(e)=> {
    LoanListAction.openShowModal();
  };

  render() {

    const formItemLayout = {
      labelCol:{span:2,offset: 0},
      wrapperCol: {span: 23}
    };

    const rowLayout = {
      marginTop: 5,
      marginBottom: 5
    }
    let fssLoanModel = {};
    if(this.props.fssLoanModel!=null){
      fssLoanModel = this.props.fssLoanModel;
    }
    return (
      <div>
        <Modal width={1000} visible={this.props.showModalVisible} title="保险分期" onCancel={this.handleShowCancel}
               footer={[
                 <Button key="back" type="ghost" size="large" onClick={this.handleShowCancel}>返回</Button>,
               ]}>

                <Card title="被保险人信息" style={{marginBottom: 24}} bordered={true}>
                    <Row style={rowLayout}>
                      <Col span="2"><FormItem label="*被保人姓名"></FormItem></Col>
                      <Col span="6">{fssLoanModel.insuresName==undefined?"":fssLoanModel.insuresName}
                      </Col>
                      <Col span="2"><FormItem label="联系电话" /></Col>
                      <Col span="6">
                        {fssLoanModel.insuresPhone}
                      </Col>
                      <Col span="2"><FormItem label="身份证号" /></Col>
                      <Col span="6">
                        {fssLoanModel.insuresIdcard}
                          </Col>
                    </Row>
                  <Row style={rowLayout}>
                    <Col span="2"><FormItem label="联系人姓名" /></Col>
                    <Col span="6">
                      {fssLoanModel.insuresLinkName}
                    </Col>
                    <Col span="2"><FormItem label="联系电话" /></Col>
                      <Col span="6">
                        {fssLoanModel.insuresLinkPhone}
                      </Col>
                    <Col span="2"><FormItem label="客户类型" /></Col>
                        <Col span="6">
                          {fssLoanModel.insuresType=="personal"? "个人":"企业"}
                      </Col>
                  </Row>
                  <Row style={rowLayout}>
                    <Col span="2"> <FormItem label="被保人地址" /></Col>
                    <Col span="10">{fssLoanModel.insuresAddress}
                    </Col>
                  </Row>
                  </Card>
                <Card title="车辆信息" style={{marginBottom: 24}} bordered={true}>
                  <Row style={rowLayout}>
                    <Col span="2"><FormItem label="品牌车型" /></Col>
                    <Col span="4">{fssLoanModel.carBrand}
                    </Col>
                    <Col span="5">{fssLoanModel.carVehicleName}
                    </Col>
                    <Col span="5">{fssLoanModel.carModelName}
                    </Col>
                    <Col span="2"><FormItem label="车牌号" /></Col>
                    <Col span="6">{fssLoanModel.carPlateNumber}
                    </Col>

                  </Row>
                  <Row style={rowLayout}>
                    <Col span="2"><FormItem label="车架号" /></Col>
                    <Col span="6">{fssLoanModel.carVin}
                    </Col>
                    <Col span="2"><FormItem label="发动机号" /></Col>
                    <Col span="6">{fssLoanModel.carEngineNo}
                    </Col>
                    <Col span="2"><FormItem label="车辆类型" /></Col>
                    <Col span="6"> {fssLoanModel.carType==1? "新车":"二手车"}
                    </Col>
                  </Row>
                  <Row style={rowLayout}>
                    <Col span="2"><FormItem label="购买方式" /></Col>
                    <Col span="6">{fssLoanModel.carBuyType==1? "分期":"全款"}
                    </Col>
                    <Col span="2"><FormItem label="车辆颜色" /></Col>
                    <Col span="6">{fssLoanModel.carColor}
                    </Col>
                    <Col span="2"><FormItem label="购车日期" /></Col>
                    <Col span="6">{fssLoanModel.carBuyDate}
                    </Col>
                  </Row>
                  <Row style={rowLayout}>
                    <Col span="2"><FormItem label="座位数" /></Col>
                    <Col span="6">{fssLoanModel.carSeatNumber}
                    </Col>
                    <Col span="2"><FormItem label="排量" /></Col>
                    <Col span="6">{fssLoanModel.carDisplacement}
                    </Col>
                    <Col span="2"><FormItem label="车" /></Col>
                    <Col span="6">{fssLoanModel.carImports}
                    </Col>
                  </Row>
                </Card>
                <Card title="保单信息" style={{marginBottom: 24}} bordered={true}>
                  <Row style={rowLayout}>
                    <Col span="2"><FormItem label="投保类型" ></FormItem></Col>
                    <Col span="6">{fssLoanModel.policyType}
                    </Col>
                    <Col span="2"><FormItem label="保险公司" /></Col>
                    <Col span="6">{fssLoanModel.policyInsuranceCompany}
                    </Col>
                    <Col span="2"><FormItem label="保险总额" /></Col>
                    <Col span="6">{fssLoanModel.policyTotalAmount}
                    </Col>
                  </Row>
                  <Row style={rowLayout}>
                    <Col span="2"><FormItem label="生效日期" /></Col>
                    <Col span="6">{fssLoanModel.policyEffectDate}
                    </Col>
                    <Col span="2"><FormItem label="到期日期" /></Col>
                    <Col span="6">{fssLoanModel.policyExpireDate}
                    </Col>
                  </Row>
                  <Row style={rowLayout}>
                  <Col span="2"><FormItem label="交强险" /></Col>
                  <Col span="6">{fssLoanModel.policyCompulsoryInsurance}
                  </Col>
                  <Col span="2"><FormItem label="车船使用税" /></Col>
                  <Col span="6">{fssLoanModel.policyVehicleTax}
                  </Col>
                </Row>
                  <Row style={rowLayout}>
                    <Col span="3"><Checkbox>第三者责任险</Checkbox></Col>
                    <Col span="2">{fssLoanModel.policyThreePayLevel}
                    </Col>
                    <Col span="4">{fssLoanModel.policyThreePay}
                    </Col>
                    <Col span="3"><Checkbox>车辆损失险</Checkbox></Col>
                    <Col span="8">{fssLoanModel.policyDamage}
                    </Col>
                  </Row>
                  <Row style={rowLayout}>
                    <Col span="3"><Checkbox>全车盗抢险</Checkbox></Col>
                    <Col span="6">{fssLoanModel.policyLost}
                    </Col>
                    <Col span="3"><Checkbox>玻璃单独破碎险</Checkbox></Col>
                    <Col span="8">{fssLoanModel.policyGlassBreakage}
                    </Col>
                  </Row>
                  <Row style={rowLayout}>
                    <Col span="3"><Checkbox>自燃损失险</Checkbox></Col>
                    <Col span="6">{fssLoanModel.policyAutoIgnition}
                    </Col>
                    <Col span="3"><Checkbox>不计免赔特约险</Checkbox></Col>
                    <Col span="8">{fssLoanModel.policyDisregardContributing}
                    </Col>
                  </Row>

                  <Row style={rowLayout}>
                    <Col span="3"><Checkbox>乘客座位责任险</Checkbox></Col>
                    <Col span="6">{fssLoanModel.policySeatPassenger}
                    </Col>
                    <Col span="3"><Checkbox>司机座位责任险</Checkbox></Col>
                    <Col span="8">{fssLoanModel.policySeatDriver}
                    </Col>
                  </Row>
                  <Row style={rowLayout}>
                    <Col span="3"><Checkbox>车身划痕险</Checkbox></Col>
                    <Col span="6">{fssLoanModel.policyScratch}
                    </Col>
                    <Col span="3"><Checkbox>涉水险／发动机特别损失险</Checkbox></Col>
                    <Col span="8">{fssLoanModel.policyWading}
                    </Col>
                  </Row>
                </Card>
                <Card title="金融方案" style={{marginBottom: 24}} bordered={true}>
                  <Row style={rowLayout}>
                    <Col span="2"><FormItem label="产品名称" ></FormItem></Col>
                    <Col span="6">{fssLoanModel.planId}
                    </Col>
                    <Col span="2"><FormItem label="贷款期限" /></Col>
                    <Col span="6">{fssLoanModel.planPeriod}
                    </Col>
                  </Row>
                  <Row style={rowLayout}>
                    <Col span="2"><FormItem label="融资类目" /></Col>
                    <Col span="6">{fssLoanModel.planFinancingType}
                    </Col>
                    <Col span="2"><FormItem label="贷款总额" /></Col>
                    <Col span="6">{fssLoanModel.planLoanAmount}
                    </Col>
                  </Row>
                </Card>
                <Card title="还款卡信息" style={{marginBottom: 24}} bordered={true}>
                  <Row style={rowLayout}>
                    <Col span="2"><FormItem label="开户行" ></FormItem></Col>
                    <Col span="6">{fssLoanModel.repaymentBankCode}
                    </Col>
                    <Col span="2"><FormItem label="还款卡号" /></Col>
                    <Col span="6">{fssLoanModel.repaymentCard}
                    </Col>
                    <Col span="2">
                    </Col>
                  </Row>
                </Card>
                <Card title="影象信息" style={{marginBottom: 24}} bordered={true}>
                  <Row style={rowLayout}>
                    <Col span="2"><FormItem label="身份证正面" ></FormItem></Col>
                    <Col span="6">{fssLoanModel.idcardFrontPic}

                    </Col>
                    <Col span="2"><FormItem label="身份证反面" /></Col>
                    <Col span="6">{fssLoanModel.idcardBackPic}

                    </Col>
                  </Row>
                    <Row style={rowLayout}>
                    <Col span="2"><FormItem label="交强险保单" /></Col>
                    <Col span="6">{fssLoanModel.compulsoryInsurancePic}

                    </Col>
                      <Col span="2"><FormItem label="商业险保单" /></Col>
                      <Col span="6">{fssLoanModel.carSeatcommercialInsurancePicNumber}

                      </Col>
                  </Row>
                  <Row style={rowLayout}>
                    <Col span="2"><FormItem label="贷款合同" /></Col>
                    <Col span="6">{fssLoanModel.loanContractPic}
                    </Col>
                    <Col span="2"><FormItem label="委托代扣协议" /></Col>
                    <Col span="6">
                      <img alt="withholdingAgreementPic" style={{ width: '100%' }}
                           src={fssLoanModel.withholdingAgreementPic} />

                    </Col>
                  </Row>
                </Card>

        </Modal>
      </div>)
  }

}
export default LoanListShowModal;

