import React, {Component} from "react";
import {Form, Input, Button, Select, DatePicker} from "antd";
import DealerUserAction from "actions/DealerUserAction";
const FormItem = Form.Item;
const Option = Select.Option;
const show = (info) => {
  console.log("CustomerListSearchBox jsx " + JSON.stringify(info));
}
const {MonthPicker, RangePicker} = DatePicker;
class DealerUserListSearchBox extends Component {
  handleSubmit = (e) => {
    e.preventDefault();
    let fieldValues = this.props.form.getFieldsValue();
    DealerUserAction.querySubmit({data: fieldValues, pager: {page: 1, pageSize: 20}});
  };
  handOpenAddModal =(e) =>{
    show("点击添加按钮");
    DealerUserAction.openAddModal();
  };

  render() {
    const {getFieldDecorator} = this.props.form;
    return (
      <div>
        <Form inline>
          <FormItem label="姓名">
            {getFieldDecorator('name')(
              <Input size="large" placeholder="姓名" style={{width: 120}} onPressEnter={this.handleSubmit}/>
            )}
          </FormItem>
          <FormItem label="手机号码">
            {getFieldDecorator('tel')(
              <Input size="large" placeholder="手机号码" style={{width: 120}} onPressEnter={this.handleSubmit}/>
            )}
          </FormItem>
          <FormItem >
            <Button type="primary" onClick={this.handleSubmit}>查询</Button>
          </FormItem>
          <FormItem >
            <Button type="primary" onClick={this.handOpenAddModal}>添加</Button>
          </FormItem>
        </Form>

      </div>
    )
  }
}
//
DealerUserListSearchBox = Form.create()(DealerUserListSearchBox);
export default DealerUserListSearchBox;
