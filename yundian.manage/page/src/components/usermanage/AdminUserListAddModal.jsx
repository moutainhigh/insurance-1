import React, {Component} from "react";
import {Radio, Form, Checkbox, Input, Modal, Select, Button} from "antd";
import AdminUserAction from "actions/AdminUserAction";
import {propsToFields, isEmptyObject} from "services/functions";
const RadioGroup = Radio.Group;
const CheckboxGroup = Checkbox.Group;
const FormItem = Form.Item;
const Option = Select.Option;
const show = (info) => {
  console.log("jsx AdminUserListAddModal: " + JSON.stringify(info));
}

class AdminUserListAddModal extends Component {


  handleAddCancel =(e)=> {
    AdminUserAction.openAddModal();
    this.props.form.resetFields();
  };
  handleOnSave = (e) => {
    this.props.form.validateFieldsAndScroll((err, values) => {
      console.log("handleOnSave:"+JSON.stringify(values))
      if (!err) {
        if(!isEmptyObject(this.props.adminUserInfo)){
          //修改
          AdminUserAction.updateAdminUser(values);
        }else {
          AdminUserAction.addAdminUser(values);
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
        <Modal visible={this.props.addModalVisible} title="员工管理" onCancel={this.handleAddCancel}
               footer={[
                 <Button key="back" type="ghost" size="large" onClick={this.handleAddCancel}>取消</Button>,
                 <Button key="submit" type="primary" size="large" onClick={this.handleOnSave}>保存</Button>
               ]}>
              <Form layout="horizontal">

                <FormItem label="登录账号" {...formItemLayout}>
                  {getFieldDecorator('userName', { rules: [ {required: true, message: '请输入被保险人姓名'}]} )(
                    <Input/>
                  )}
                </FormItem>

                <FormItem label="姓名" {...formItemLayout}>
                  {getFieldDecorator('name', { rules: [ {required: true, message: '请输入被保险人姓名'}]} )(
                    <Input/>
                  )}
                </FormItem>

                <FormItem label="所属角色" {...formItemLayout}>
                  {getFieldDecorator('roleId', { rules: [ {required: true, message: '请输入被保险人姓名'}]} )(
                    <Select initialValue="NORMAL">
                      <Option value="NORMAL">普通员工</Option>
                      <Option value="ADMIN">管理员</Option>
                    </Select>
                  )}
                </FormItem>



              </Form>
        </Modal>
      </div>)
  }

}
AdminUserListAddModal = Form.create({
  mapPropsToFields(props){
    show(props)
    show(isEmptyObject(props.adminUserInfo))
    if(!isEmptyObject(props.adminUserInfo))
    {
      return  propsToFields(props.adminUserInfo);

    }else {

      return {};
    }

  }

})(AdminUserListAddModal);
export default AdminUserListAddModal;

