import React, {Component} from "react";
import {Form,Modal,Button,Input} from "antd";
import LayoutAction from "actions/LayoutAction";
const FormItem = Form.Item;
const show = (info) => {
  console.log("jsx MenuLayout:  " + JSON.stringify(info));
}
class ModifyPwd extends React.Component {
  handleAddCancel =(e)=> {
    LayoutAction.openPwdModal();
  };
  handleOnSave = (e) => {
    this.props.form.validateFieldsAndScroll((err, values) => {
      if (!err) {
        LayoutAction.changePwd(values);
      }
    });
  }
  compareToFirstPassword = (rule, value, callback) => {
    const form = this.props.form;
    if (value && value !== form.getFieldValue('newPwd')) {
      callback('两次密码输入不一致！');
    } else {
      callback();
    }
  }

  validateToNextPassword = (rule, value, callback) => {
    const form = this.props.form;
    if (value) {
      form.validateFields(['newPwd2'], { force: true });
    }
    callback();
  }

  render() {
    const {getFieldDecorator} = this.props.form;
    const formItemLayout = {
      labelCol:{span:6,offset: 0},
      wrapperCol: {span: 12}
    };
    return (
      <div>
        <Modal visible={this.props.pwdModalVisible} title="密码修改" onCancel={this.handleAddCancel}
               footer={[
                 <Button key="back" type="ghost" size="large" onClick={this.handleAddCancel}>取消</Button>,
                 <Button key="submit" type="primary" size="large" onClick={this.handleOnSave}>保存</Button>
               ]}>
          <Form layout="horizontal">
            <FormItem label="旧密码" {...formItemLayout}>
              {getFieldDecorator('oldPwd', { rules: [ {required: true, message: '请输入旧密码'}]} )(
                <Input type="password"/>
              )}
            </FormItem>

            <FormItem label="新密码" {...formItemLayout}>
              {getFieldDecorator('newPwd', { rules: [ {required: true, message: '请输入新密码'}, {
                validator: this.validateToNextPassword,
              }]} )(
                <Input type="password" />
              )}
            </FormItem>
            <FormItem label="重复密码" {...formItemLayout}>
              {getFieldDecorator('newPwd2', { rules: [ {required: true, message: '重复新密码'}, {
                validator: this.compareToFirstPassword,
              }]} )(
                <Input type="password"/>
              )}
            </FormItem>
          </Form>
        </Modal>
      </div>)
  }
}
ModifyPwd = Form.create()(ModifyPwd);
export default ModifyPwd;
