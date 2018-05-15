import React, {Component} from "react";
import {Card, Upload,Radio,Form,Icon, Checkbox,InputNumber,Input, Modal, Select, Row, Col, Button,DatePicker} from "antd";
import LoanListAction from "actions/LoanListAction";
import { propsToFields,isEmptyObject } from 'services/functions';
const FormItem = Form.Item;
const show = (info) => {
  console.log("jsx LoanListShowModal: " + JSON.stringify(info));
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

class LoanListShowModal extends Component {

  //取消
  handleShowCancel =()=> {
    LoanListAction.cancelShowModal();
  };

  render() {

    const formItemLayout = {
      labelCol:{span:2,offset: 0},
      wrapperCol: {span: 23}
    };

    const rowLayout = {
      marginTop: 5,
      marginBottom: 10
    }

    show(this.props.showLoanInfo);
    let fssLoanModel = {};
    let docs = {};
    let imgViewIdcardFrontPic ;
    let imgViewIdcardBackPic ;
    let imgViewCompulsoryInsurancePic ;
    let imgViewCommercialInsurancePic ;
    let imgViewWithholdingAgreementPic ;
    let imgViewLoanContractPic ;
    if(!isEmptyObject(this.props.showLoanInfo)) {
      fssLoanModel = this.props.showLoanInfo.fssLoanModel;
       docs = this.props.showLoanInfo.fssLoanDocs;
      show(docs);
       if(docs!=null) {
         if (docs.idcardFrontPic != undefined) {
           imgViewIdcardFrontPic = docs.idcardFrontPic.map((item, index) => {
             let data = {title: '', desc: '', url: item.url};
             return <ViewImg data={data} key={index}/>;
           });
         }
         if (docs.idcardBackPic != undefined) {
           imgViewIdcardBackPic = docs.idcardBackPic.map((item, index) => {
             let data = {title: '', desc: '', url: item.url};
             return <ViewImg data={data} key={index}/>;
           });
         }
         if (docs.compulsoryInsurancePic != undefined) {
           imgViewCompulsoryInsurancePic = docs.compulsoryInsurancePic.map((item, index) => {
             let data = {title: '', desc: '', url: item.url};
             return <ViewImg data={data} key={index}/>;
           });
         }
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
         if (docs.loanContractPic != undefined) {
           imgViewLoanContractPic = docs.loanContractPic.map((item, index) => {
             let data = {title: '', desc: '', url: item.url};
             return <ViewImg data={data} key={index}/>;
           });
         }
       }
    }





    return (
      <div>
        <Modal width={1000} visible={this.props.showModalVisible} title="查看保险分期" onCancel={this.handleShowCancel}
               footer={[
                 <Button key="back" type="ghost" size="large" onClick={this.handleShowCancel}>返回</Button>,
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
                  <Row style={rowLayout}>
                    <Col span="2"><span>联系人姓名:</span></Col>
                    <Col span="6"><span>
                      {fssLoanModel.insuresLinkName}</span>
                    </Col>
                    <Col span="2"><span>联系电话:</span></Col>
                      <Col span="6"><span>
                        {fssLoanModel.insuresLinkPhone}</span>
                      </Col>
                    <Col span="2"><span>客户类型</span></Col>
                        <Col span="6"><span>{fssLoanModel.insuresType=="personal"? "个人":"企业"}</span>
                      </Col>
                  </Row>
                  <Row style={rowLayout}>
                    <Col span="2"> <span>被保人地址:</span></Col>
                    <Col span="10"><span>{fssLoanModel.insuresAddress}</span>
                    </Col>
                  </Row>
                  </Card>
                <Card title="车辆信息" style={{marginBottom: 24}} bordered={true}>
                  <Row style={rowLayout}>
                    <Col span="2"><span>品牌车型:</span></Col>
                    <Col span="14"><span>{fssLoanModel.carBrandName}-{fssLoanModel.carVehicleName}-{fssLoanModel.carModelName}</span>
                    </Col>
                    <Col span="2"><span>车牌号:</span></Col>
                    <Col span="6"><span>{fssLoanModel.carPlateNumber}</span>
                    </Col>
                  </Row>
                  <Row style={rowLayout}>
                    <Col span="2"><span>车架号:</span></Col>
                    <Col span="6">{fssLoanModel.carVin}
                    </Col>
                    <Col span="2"><span>发动机号:</span></Col>
                    <Col span="6"><span>{fssLoanModel.carEngineNo}</span>
                    </Col>
                    <Col span="2"><span>车辆类型:</span></Col>
                    <Col span="6"> <span>{fssLoanModel.carType==1? "新车":"二手车"}</span>
                    </Col>
                  </Row>
                  <Row style={rowLayout}>
                    <Col span="2"><span>购买方式:</span></Col>
                    <Col span="6"><span>{fssLoanModel.carBuyType==1? "分期":"全款"}</span>
                    </Col>
                    <Col span="2"><span>车辆颜色:</span></Col>
                    <Col span="6"><span>{fssLoanModel.carColor}</span>
                    </Col>
                    <Col span="2"><span>购车日期:</span></Col>
                    <Col span="6"><span>{fssLoanModel.carBuyDate}</span>
                    </Col>
                  </Row>
                  <Row style={rowLayout}>
                    <Col span="2"><span>座位数:</span></Col>
                    <Col span="6"><span>{fssLoanModel.carSeatNumber}</span>
                    </Col>
                    <Col span="2"><span>排量:</span></Col>
                    <Col span="6"><span>{fssLoanModel.carDisplacement}</span>
                    </Col>
                    <Col span="2"><span>车:</span></Col>
                    <Col span="6"><span>{fssLoanModel.carImports}</span>
                    </Col>
                  </Row>
                </Card>
                <Card title="保单信息" style={{marginBottom: 24}} bordered={true}>
                  <Row style={rowLayout}>
                    <Col span="2"><span>投保类型:</span></Col>
                    <Col span="6"><span>{fssLoanModel.policyType}</span>
                    </Col>
                    <Col span="2"><span>保险公司:</span></Col>
                    <Col span="6"><span>{fssLoanModel.policyInsuranceCompany}</span>
                    </Col>
                    <Col span="2"><span>保险总额:</span></Col>
                    <Col span="6"><span>{fssLoanModel.policyTotalAmount}</span>
                    </Col>
                  </Row>
                  <Row style={rowLayout}>
                    <Col span="2"><span>生效日期:</span></Col>
                    <Col span="6"><span>{fssLoanModel.policyEffectDate}</span>
                    </Col>
                    <Col span="2"><span>到期日期:</span></Col>
                    <Col span="6"><span>{fssLoanModel.policyExpireDate}</span>
                    </Col>
                  </Row>
                  <Row style={rowLayout}>
                  <Col span="2"><span>交强险:</span></Col>
                  <Col span="6"><span>{fssLoanModel.policyCompulsoryInsurance}</span>
                  </Col>
                  <Col span="2"><span>车船使用税:</span></Col>
                  <Col span="6"><span>{fssLoanModel.policyVehicleTax}</span>
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
                    <Col span="2"><span>金融产品:</span></Col>
                    <Col span="6"><span>{fssLoanModel.planName}</span>
                    </Col>
                    <Col span="2"><span>贷款期限:</span></Col>
                    <Col span="6"><span>{fssLoanModel.planPeriod}</span>
                    </Col>
                  </Row>
                  <Row style={rowLayout}>
                    <Col span="2"><span>融资类目:</span></Col>
                    <Col span="6"><span>{fssLoanModel.planFinancingType}</span>
                    </Col>
                    <Col span="2"><span>贷款总额:</span></Col>
                    <Col span="6"><span>{fssLoanModel.planLoanAmount}</span>
                    </Col>
                  </Row>
                </Card>
                <Card title="还款卡信息" style={{marginBottom: 24}} bordered={true}>
                  <Row style={rowLayout}>
                    <Col span="2"><span>开户行:</span></Col>
                    <Col span="6"><span>{fssLoanModel.repaymentBankCode}</span>
                    </Col>
                    <Col span="2"><span>还款卡号:</span></Col>
                    <Col span="6"><span>{fssLoanModel.repaymentCard}</span>
                    </Col>
                    <Col span="2">
                    </Col>
                  </Row>
                </Card>
                <Card title="影象信息" style={{marginBottom: 24}} bordered={true}>
                  <Row style={rowLayout}>
                    <Col span="2"><FormItem label="身份证正面" ></FormItem></Col>
                    <Col span="6">{imgViewIdcardFrontPic}

                    </Col>
                    <Col span="2"><FormItem label="身份证反面" /></Col>
                    <Col span="6">{imgViewIdcardBackPic}

                    </Col>
                  </Row>
                    <Row style={rowLayout}>
                    <Col span="2"><FormItem label="交强险保单" /></Col>
                    <Col span="6">{imgViewCommercialInsurancePic}

                    </Col>
                      <Col span="2"><FormItem label="商业险保单" /></Col>
                      <Col span="6">{imgViewCompulsoryInsurancePic}

                      </Col>
                  </Row>
                  <Row style={rowLayout}>
                    <Col span="2"><FormItem label="贷款合同" /></Col>
                    <Col span="6">{imgViewLoanContractPic}
                    </Col>
                    <Col span="2"><FormItem label="委托代扣协议" /></Col>
                    <Col span="6">{imgViewWithholdingAgreementPic}

                    </Col>
                  </Row>
                </Card>

        </Modal>
      </div>)
  }

}
export default LoanListShowModal;

