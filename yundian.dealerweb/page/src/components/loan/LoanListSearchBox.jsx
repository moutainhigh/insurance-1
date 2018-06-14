import React, {Component} from "react";
import {Row,Col, Form, Input, Button, Select, DatePicker} from "antd";
import LoanListAction from "actions/LoanListAction";
import {Link} from "react-router";
const FormItem = Form.Item;
const Option = Select.Option;
const show = (info) => {
  console.log("LoanListSearchBox jsx " + JSON.stringify(info));
}
const {MonthPicker, RangePicker} = DatePicker;
class LoanListSearchBox extends Component {
  handleSubmit = (e) => {
    e.preventDefault();
    let fieldValues = this.props.form.getFieldsValue();
    LoanListAction.querySubmit({data: fieldValues, pager: {page: 1, pageSize: 20}});
  };
  handOpenAddModal =(e) =>{
    show("点击添加按钮");
    LoanListAction.openAddModal();
    this.props.form.resetFields();
  };

  render() {
    const {getFieldDecorator} = this.props.form;
    const rowLayout = {
      marginTop: 8
    }
    return (
      <div>
        <Form inline>
<Row style={rowLayout}>
          <FormItem label="车架号">
            {getFieldDecorator('carVin')(
              <Input size="large" placeholder="车架号" style={{width: 120}} onPressEnter={this.handleSubmit}/>
            )}
          </FormItem>

          <FormItem label="姓名">
            {getFieldDecorator('insuresName')(
              <Input size="large" placeholder="姓名" style={{width: 120}} onPressEnter={this.handleSubmit}/>
            )}
          </FormItem>

          <FormItem label="手机号码">
            {getFieldDecorator('insuresPhone')(
              <Input size="large" placeholder="手机号码" style={{width: 120}} onPressEnter={this.handleSubmit}/>
            )}
          </FormItem>

          <FormItem label="车牌号码">
            {getFieldDecorator('carPlateNumber')(
              <Input size="large" placeholder="车牌号码" style={{width: 100}} onPressEnter={this.handleSubmit}/>
            )}
          </FormItem>
</Row>
          <Row style={rowLayout}>
            <FormItem label="保险公司">
              {getFieldDecorator('policyInsuranceCompany')(
                <Input size="large" placeholder="保险公司" style={{width: 120}} onPressEnter={this.handleSubmit}/>
              )}
            </FormItem>
          <FormItem label="品牌">
            {getFieldDecorator('carBrandName')(
              <Input size="large" placeholder="车型" style={{width: 120}} onPressEnter={this.handleSubmit}/>
            )}
          </FormItem>
          <FormItem label="时间">
            {getFieldDecorator('startAndEndTime')(
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
LoanListSearchBox = Form.create()(LoanListSearchBox);
export default LoanListSearchBox;
