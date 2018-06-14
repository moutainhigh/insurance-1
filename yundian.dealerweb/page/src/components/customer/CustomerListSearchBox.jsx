import React, {Component} from "react";
import {Row, Form, Input, Button, Select, DatePicker,Upload,Icon} from "antd";
import CustomerAction from "actions/CustomerAction";
import {Notify} from "components/common/Common";
const FormItem = Form.Item;
const Option = Select.Option;
const show = (info) => {
  console.log("CustomerListSearchBox jsx " + JSON.stringify(info));
}
const {MonthPicker, RangePicker} = DatePicker;



const props = {
  action: '/customer/importXls'
  };

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
  handleImport =({ file, fileList }) =>{
    show("导入按钮");
    if (file.status == 'done') {
      console.log(file, fileList);
      let successCount=file.response.data.successCount;
      Notify('客户导入成功', '总共导入:'+successCount+'条客户数据', 'success');
    }
    else if(file.status == 'error'){
      Notify('客户导入成功！请重试');
    }


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
          <Row style={rowLayout}>
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
            <FormItem >
              <Upload {...props} onChange={this.handleImport}>
                <Button>
                  <Icon type="upload" /> 导入客户
                </Button>
              </Upload>
            </FormItem>
            <FormItem><a href="/resources/assets/客户导入模板.xls" target="_blank">下载模型</a></FormItem>
          </Row>

        </Form>

      </div>
    )
  }
}
//
CustomerListSearchBox = Form.create()(CustomerListSearchBox);
export default CustomerListSearchBox;
