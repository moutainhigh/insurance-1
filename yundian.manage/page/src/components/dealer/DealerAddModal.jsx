import React, {Component} from "react";
import {Card, Upload,Radio,Form,Icon, Checkbox,InputNumber,Input, Modal, Select, Row, Col, Button,DatePicker} from "antd";
import DealerAction from "actions/DealerAction";
import { propsToFields,isEmptyObject } from 'services/functions';
import Moment from 'moment'
const RadioGroup = Radio.Group;
const CheckboxGroup = Checkbox.Group;
const FormItem = Form.Item;
const Option = Select.Option;
const show = (info) => {
  console.log("DealerAddModal: " + JSON.stringify(info));
}

class DealerAddModal extends Component {


  handleAddCancel =(e)=> {
    DealerAction.openAddModal();
    this.props.form.resetFields();
  };
  handleOnSave = (e) => {
    this.props.form.validateFieldsAndScroll((err, values) => {
      console.log("handleOnSave:"+JSON.stringify(values))
      if (!err) {
        if(!isEmptyObject(this.props.delaerInfo)){
          //修改
          DealerAction.updateDealer(values);
        }else {
          DealerAction.updateDealer(values);
        }
        this.props.form.resetFields();
      }
    });
  }






  render() {


    const {getFieldDecorator} = this.props.form;
    const formItemLayout = {
      labelCol:{span:6,offset: 0},
      wrapperCol: {span: 12}
    };
    return (
      <div>
        <Modal width={1000} visible={this.props.addModalVisible} title="客户管理" onCancel={this.handleAddCancel}
               footer={[
                 <Button key="back" type="ghost" size="large" onClick={this.handleAddCancel}>取消</Button>,
                 <Button key="submit" type="primary" size="large" onClick={this.handleOnSave}>保存</Button>
               ]}>
              <Form layout="horizontal">

                <FormItem label="经销商名称" {...formItemLayout}>
                  {getFieldDecorator('dealerName' , { rules: [ {required: true, message: '请输入经销商名称'}]})(
                    <Input/>
                  )}
                </FormItem>

                <FormItem label="所在地区" {...formItemLayout}>
                  {getFieldDecorator('province')(
                    <Input/>
                  )}
                </FormItem>
                <FormItem label="详细地址" {...formItemLayout}>
                  {getFieldDecorator('street')(
                    <Input/>
                  )}
                </FormItem>
                <FormItem label="联系人" {...formItemLayout}>
                  {getFieldDecorator('contactor', { rules: [ {required: true, message: '请输入联系人姓名'}]} )(
                    <Input/>
                  )}
                </FormItem>
                <FormItem label="联系人电话" {...formItemLayout}>
                  {getFieldDecorator('phone', { rules: [ {required: true, message: '请输入联系人电话手机号码'}]} )(
                    <Input/>
                  )}
                </FormItem>
              </Form>
        </Modal>
      </div>)
  }

}

DealerAddModal = Form.create({
  mapPropsToFields(props){
    show(props)
    show(isEmptyObject(props.delaerInfo))
    if(!isEmptyObject(props.delaerInfo))
    {
      return  propsToFields(props.delaerInfo);

    }
  }

})(DealerAddModal);
export default DealerAddModal;
