import React, {Component} from "react";
import {Card, Upload,Radio,Form,Icon, Checkbox,InputNumber,Input, Modal, Select, Row, Col, Button,DatePicker} from "antd";
import CustomerAction from "actions/CustomerAction";
import { propsToFields,isEmptyObject } from 'services/functions';
import Moment from 'moment'
const RadioGroup = Radio.Group;
const CheckboxGroup = Checkbox.Group;
const FormItem = Form.Item;
const Option = Select.Option;
const show = (info) => {
  console.log("jsx loanListAddModal: " + JSON.stringify(info));
}
const planFinancingTypeOptions = [
  { label: '商业险', value: 'A' },
  { label: '交强险', value: 'B' },
  { label: '车船使用税', value: 'C' },
];
class CustomerListAddModal extends Component {


  handleAddCancel =(e)=> {
    CustomerAction.openAddModal();
    this.props.form.resetFields();
  };
  handleOnSave = (e) => {
    this.props.form.validateFieldsAndScroll((err, values) => {
      console.log("handleOnSave:"+JSON.stringify(values))
      if (!err) {
        if(!isEmptyObject(this.props.customerInfo)){
          //修改
          CustomerAction.updateLoan(values);
        }else {
          CustomerAction.addLoan(values);
        }
        this.props.form.resetFields();
      }
    });
  }






  render() {


    const {getFieldDecorator} = this.props.form;
    const formItemLayout = {
      labelCol:{span:2,offset: 0},
      wrapperCol: {span: 23}
    };

    const rowLayout = {
      marginTop: 5,
      marginBottom: 5
    }
    const labelLayout = {
      span: 2
    }
    const contentLayout = {
      span: 5
    }
    return (
      <div>
        <Modal width={1000} visible={this.props.addModalVisible} title="客户管理" onCancel={this.handleAddCancel}
               footer={[
                 <Button key="back" type="ghost" size="large" onClick={this.handleAddCancel}>取消</Button>,
                 <Button key="submit" type="primary" size="large" onClick={this.handleOnSave}>保存</Button>
               ]}>
              <Form layout="horizontal">
                <Card title="被保险人信息" style={{marginBottom: 24}} bordered={true}>
                    <Row style={rowLayout}>
                      <Col span="2"><FormItem label="*被保人姓名"></FormItem></Col>
                      <Col span="6">
                        <FormItem {...formItemLayout}>
                          {getFieldDecorator('insuresName', { rules: [ {required: true, message: '请输入被保险人姓名'}]} )(
                            <Input/>
                          )}
                        </FormItem>
                      </Col>
                      <Col span="2"><FormItem label="联系电话" /></Col>
                      <Col span="6">
                        <FormItem {...formItemLayout}>
                          {getFieldDecorator('insuresPhone', { rules: [ {required: true, message: '请输入联系电话'}, {validator: this.checkMobileLength}]} )(
                            <Input/>
                          )}
                        </FormItem>
                      </Col>
                      <Col span="2"><FormItem label="身份证号" /></Col>
                      <Col span="6">
                        <FormItem {...formItemLayout}>
                          {getFieldDecorator('insuresIdcard', { rules: [ {required: true, message: '请输入身份证号'}, {validator: this.checkIdCardLength}]})(
                            <Input/>
                          )}
                        </FormItem>
                          </Col>
                    </Row>
                  <Row style={rowLayout}>
                    <Col span="2"><FormItem label="联系人姓名" /></Col>
                    <Col span="6">
                        <FormItem  {...formItemLayout}>
                          {getFieldDecorator('insuresLinkName', { rules: [ {required: true, message: '请输入联系人姓名'}]})(
                            <Input/>
                          )}
                        </FormItem>
                    </Col>
                    <Col span="2"><FormItem label="联系电话" /></Col>
                      <Col span="6">
                        <FormItem   {...formItemLayout}>
                          {getFieldDecorator('insuresLinkPhone', { rules: [ {required: true, message: '请输入联系电话'}, {validator: this.checkMobileLength}]})(
                            <Input/>
                          )}
                        </FormItem>
                      </Col>
                    <Col span="2"><FormItem label="客户类型" /></Col>
                        <Col span="6">
                        <FormItem   {...formItemLayout}>
                          {getFieldDecorator('insuresType')(
                            <Select initialValue="personal">
                              <Option value="personal">个人</Option>
                              <Option value="enterprise">企业</Option>
                            </Select>
                          )}
                        </FormItem>
                      </Col>
                  </Row>
                  <Row style={rowLayout}>
                    <Col span="2"> <FormItem label="被保人地址" /></Col>
                    <Col span="10">
                    <FormItem {...formItemLayout}>
                      {getFieldDecorator('insuresAddress')(
                        <Input/>
                      )}
                    </FormItem>
                    </Col>
                  </Row>
                  </Card>
                <Card title="车辆信息" style={{marginBottom: 24}} bordered={true}>
                  <Row style={rowLayout}>
                    <Col span="2"><FormItem label="品牌车型" /></Col>
                    <Col span="4">
                      <FormItem {...formItemLayout}>
                        {getFieldDecorator('carBrand', { rules: [ {required: true, message: '请输入品牌'}]} )(
                          <Input/>
                        )}
                      </FormItem>

                    </Col>
                    <Col span="5">
                      <FormItem {...formItemLayout}>
                        {getFieldDecorator('carVehicleName', { rules: [ {required: true, message: '请输入车系'}]} )(
                          <Input/>
                        )}
                      </FormItem>

                    </Col>
                    <Col span="5">
                      <FormItem {...formItemLayout}>
                        {getFieldDecorator('carModelName', { rules: [ {required: true, message: '请输入车型'}]} )(
                          <Input/>
                        )}
                      </FormItem>

                    </Col>
                    <Col span="2"><FormItem label="车牌号" /></Col>
                    <Col span="6">
                      <FormItem {...formItemLayout}>
                        {getFieldDecorator('carPlateNumber', { rules: [ {required: true, message: '请输入车牌号'}]} )(
                          <Input/>
                        )}
                      </FormItem>
                    </Col>

                  </Row>
                  <Row style={rowLayout}>
                    <Col span="2"><FormItem label="车架号" /></Col>
                    <Col span="6">
                      <FormItem  {...formItemLayout}>
                        {getFieldDecorator('carVin', { rules: [ {required: true, message: '请输入车架号'}]})(
                          <Input/>
                        )}
                      </FormItem>
                    </Col>
                    <Col span="2"><FormItem label="发动机号" /></Col>
                    <Col span="6">
                      <FormItem   {...formItemLayout}>
                        {getFieldDecorator('carEngineNo', { rules: [ {required: true, message: '请输入发动机号'}]})(
                          <Input/>
                        )}
                      </FormItem>
                    </Col>
                    <Col span="2"><FormItem label="车辆类型" /></Col>
                    <Col span="6">
                      <FormItem   {...formItemLayout}>
                        {getFieldDecorator('carType')(
                          <Select initialValue="1">
                            <Option value="1">新车</Option>
                            <Option value="2">二手车</Option>
                          </Select>
                        )}
                      </FormItem>
                    </Col>
                  </Row>
                  <Row style={rowLayout}>
                    <Col span="2"><FormItem label="购买方式" /></Col>
                    <Col span="6">
                      <FormItem  {...formItemLayout}>
                        {getFieldDecorator('carBuyType')(
                          <Select initialValue="1">
                            <Option value="1">分期</Option>
                            <Option value="2">全款</Option>
                          </Select>
                        )}
                      </FormItem>
                    </Col>
                    <Col span="2"><FormItem label="车辆颜色" /></Col>
                    <Col span="6">
                      <FormItem   {...formItemLayout}>
                        {getFieldDecorator('carColor')(
                        <Select>
                          <Option value="1">白色</Option>
                          <Option value="2">黑色</Option>
                        </Select>
                        )}
                      </FormItem>
                    </Col>
                    <Col span="2"><FormItem label="购车日期" /></Col>
                    <Col span="6">
                      <FormItem   {...formItemLayout}>
                        {getFieldDecorator('carBuyDate')(
                          <DatePicker/>
                        )}
                      </FormItem>
                    </Col>
                  </Row>
                  <Row style={rowLayout}>
                    <Col span="2"><FormItem label="座位数" /></Col>
                    <Col span="6">
                      <FormItem  {...formItemLayout}>
                        {getFieldDecorator('carSeatNumber')(
                          <Select>
                            <Option value="5">5座</Option>
                            <Option value="7">7座</Option>
                          </Select>
                        )}
                      </FormItem>
                    </Col>
                    <Col span="2"><FormItem label="排量" /></Col>
                    <Col span="6">
                      <FormItem   {...formItemLayout}>
                        {getFieldDecorator('carDisplacement')(
                          <Input/>
                        )}
                      </FormItem>
                    </Col>
                    <Col span="2"><FormItem label="车" /></Col>
                    <Col span="6">
                      <FormItem   {...formItemLayout}>
                        {getFieldDecorator('carImports')(
                          <RadioGroup initialValue="1">
                            <Radio value="1">国产</Radio>
                            <Radio value="2">进口</Radio>
                          </RadioGroup>
                        )}
                      </FormItem>
                    </Col>
                  </Row>
                </Card>
                <Card title="保单信息" style={{marginBottom: 24}} bordered={true}>
                  <Row style={rowLayout}>
                    <Col span="2"><FormItem label="投保类型" ></FormItem></Col>
                    <Col span="6">
                      <FormItem {...formItemLayout}>
                        {getFieldDecorator('policyType')(
                          <Select>
                            <Option value="first">首保</Option>
                            <Option value="other">非首保</Option>
                          </Select>
                        )}
                      </FormItem>
                    </Col>
                    <Col span="2"><FormItem label="保险公司" /></Col>
                    <Col span="6">
                      <FormItem {...formItemLayout}>
                        {getFieldDecorator('policyInsuranceCompany')(
                          <Input/>
                        )}
                      </FormItem>
                    </Col>
                    <Col span="2"><FormItem label="保险总额" /></Col>
                    <Col span="6">
                      <FormItem {...formItemLayout}>
                        {getFieldDecorator('policyTotalAmount')(
                          <Input/>
                        )}
                      </FormItem>
                    </Col>
                  </Row>
                  <Row style={rowLayout}>
                    <Col span="2"><FormItem label="生效日期" /></Col>
                    <Col span="6">
                      <FormItem  {...formItemLayout}>
                        {getFieldDecorator('policyEffectDate', { rules: [ {required: true, message: '请输入生效日期'}]})(
                          <DatePicker/>
                        )}
                      </FormItem>
                    </Col>
                    <Col span="2"><FormItem label="到期日期" /></Col>
                    <Col span="6">
                      <FormItem   {...formItemLayout}>
                        {getFieldDecorator('policyExpireDate', { rules: [ {required: true, message: '请输入到期日期'}]})(
                          <DatePicker/>
                        )}
                      </FormItem>
                    </Col>
                  </Row>
                  <Row style={rowLayout}>
                  <Col span="2"><FormItem label="交强险" /></Col>
                  <Col span="6">
                    <FormItem  {...formItemLayout}>
                      {getFieldDecorator('policyCompulsoryInsurance')(
                        <InputNumber />
                      )}
                    </FormItem>
                  </Col>
                  <Col span="2"><FormItem label="车船使用税" /></Col>
                  <Col span="6">
                    <FormItem   {...formItemLayout}>
                      {getFieldDecorator('policyVehicleTax')(
                        <InputNumber/>
                      )}
                    </FormItem>
                  </Col>
                </Row>
                  <Row style={rowLayout}>
                    <Col span="3"><Checkbox>第三者责任险</Checkbox></Col>
                    <Col span="2">
                      <FormItem  {...formItemLayout}>
                        {getFieldDecorator('policyThreePayLevel')(
                          <Select >
                            <Option value="">请选择赔付额度</Option>
                            <Option value="10">10万</Option>
                            <Option value="30">30万</Option>
                            <Option value="50">50万</Option>
                            <Option value="100">100万</Option>
                          </Select>
                        )}
                      </FormItem>
                    </Col>
                    <Col span="4">
                      <FormItem  {...formItemLayout}>
                        {getFieldDecorator('policyThreePay')(
                          <InputNumber />
                        )}
                      </FormItem>
                    </Col>
                    <Col span="3"><Checkbox>车辆损失险</Checkbox></Col>
                    <Col span="8">
                      <FormItem   {...formItemLayout}>
                        {getFieldDecorator('policyDamage')(
                          <InputNumber/>
                        )}
                      </FormItem>
                    </Col>
                  </Row>
                  <Row style={rowLayout}>
                    <Col span="3"><Checkbox>全车盗抢险</Checkbox></Col>
                    <Col span="6">
                      <FormItem  {...formItemLayout}>
                        {getFieldDecorator('policyLost')(
                          <InputNumber />
                        )}
                      </FormItem>
                    </Col>
                    <Col span="3"><Checkbox>玻璃单独破碎险</Checkbox></Col>
                    <Col span="8">
                      <FormItem   {...formItemLayout}>
                        {getFieldDecorator('policyGlassBreakage')(
                          <InputNumber/>
                        )}
                      </FormItem>
                    </Col>
                  </Row>
                  <Row style={rowLayout}>
                    <Col span="3"><Checkbox>自燃损失险</Checkbox></Col>
                    <Col span="6">
                      <FormItem  {...formItemLayout}>
                        {getFieldDecorator('policyAutoIgnition')(
                          <InputNumber />
                        )}
                      </FormItem>
                    </Col>
                    <Col span="3"><Checkbox>不计免赔特约险</Checkbox></Col>
                    <Col span="8">
                      <FormItem   {...formItemLayout}>
                        {getFieldDecorator('policyDisregardContributing') (
                          <InputNumber/>
                        )}
                      </FormItem>
                    </Col>
                  </Row>

                  <Row style={rowLayout}>
                    <Col span="3"><Checkbox>乘客座位责任险</Checkbox></Col>
                    <Col span="6">
                      <FormItem  {...formItemLayout}>
                        {getFieldDecorator('policySeatPassenger')(
                          <InputNumber />
                        )}
                      </FormItem>
                    </Col>
                    <Col span="3"><Checkbox>司机座位责任险</Checkbox></Col>
                    <Col span="8">
                      <FormItem   {...formItemLayout}>
                        {getFieldDecorator('policySeatDriver')(
                          <InputNumber/>
                        )}
                      </FormItem>
                    </Col>
                  </Row>
                  <Row style={rowLayout}>
                    <Col span="3"><Checkbox>车身划痕险</Checkbox></Col>
                    <Col span="6">
                      <FormItem  {...formItemLayout}>
                        {getFieldDecorator('policyScratch')(
                          <InputNumber />
                        )}
                      </FormItem>
                    </Col>
                    <Col span="3"><Checkbox>涉水险／发动机特别损失险</Checkbox></Col>
                    <Col span="8">
                      <FormItem   {...formItemLayout}>
                        {getFieldDecorator('policyWading')(
                          <InputNumber/>
                        )}
                      </FormItem>
                    </Col>
                  </Row>
                </Card>
              </Form>
        </Modal>
      </div>)
  }

}

CustomerListAddModal = Form.create({
  mapPropsToFields(props){
    show(props)
    show(isEmptyObject(props.customerInfo))
    if(!isEmptyObject(props.customerInfo))
    {
      return  propsToFields(props.customerInfo);

    }else {
      return {};
    }

  }

})(CustomerListAddModal);
export default CustomerListAddModal;
