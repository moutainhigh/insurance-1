import React, {Component} from "react";
import {Row,Col, Form, Input, Button, Select, DatePicker} from "antd";
import CustomerAction from "actions/CustomerAction";
import {Link} from "react-router";
const FormItem = Form.Item;
const Option = Select.Option;
const show = (info) => {
  console.log("CustomerListSearchBox jsx " + JSON.stringify(info));
}
const {MonthPicker, RangePicker} = DatePicker;
class CustomerListSearchBox extends Component {
  handleSubmit = (e) => {
    e.preventDefault();
    let fieldValues = this.props.form.getFieldsValue();
    CustomerAction.querySubmit({data: fieldValues, pager: {page: 1, pageSize: 20}});
  };
  handOpenAddModal =(e) =>{
    show("点击添加按钮");
    CustomerAction.openAddModal();
  };

  render() {
    const {getFieldDecorator} = this.props.form;

    return (
      <div>
        <Form inline>
<Row>
          <FormItem label="客户姓名">
            {getFieldDecorator('insuresName')(
              <Input size="large" placeholder="客户姓名" style={{width: 120}} onPressEnter={this.handleSubmit}/>
            )}
          </FormItem>

          <FormItem label="身份证">
            {getFieldDecorator('insuresIdcard')(
              <Input size="large" placeholder="身份证" style={{width: 120}} onPressEnter={this.handleSubmit}/>
            )}
          </FormItem>

          <FormItem label="手机号码">
            {getFieldDecorator('insuresPhone')(
              <Input size="large" placeholder="手机号码" style={{width: 120}} onPressEnter={this.handleSubmit}/>
            )}
          </FormItem>
</Row>
          <Row>
          <FormItem label="客户类型">
            {getFieldDecorator('insuresType')(
              <Select initialValue="personal" style={{width:"80px"}}>
                <Option value="personal">个人</Option>
                <Option value="enterprise">企业</Option>
              </Select>
              )}
          </FormItem>

            <FormItem label="保险购买方式">
              {getFieldDecorator('policyBuyType')(
                <Select initialValue="1" style={{width:"80px"}}>
                  <Option value="1">分期</Option>
                  <Option value="2">全款</Option>
                </Select>
              )}
            </FormItem>
            <FormItem label="保险到期日">
              {getFieldDecorator('policyExpireDate')(
                <RangePicker
                  style={{width: "200px"}}
                />
              )}
            </FormItem>
            <FormItem >
              <Button type="primary" onClick={this.handleSubmit}>查询</Button>
            </FormItem>
            <FormItem >
              <Button type="primary" onClick={this.handOpenAddModal}>添加</Button>
            </FormItem>
          </Row>

        </Form>

      </div>
    )
  }
}
//
CustomerListSearchBox = Form.create()(CustomerListSearchBox);
export default CustomerListSearchBox;
