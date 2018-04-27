import React, {Component} from "react";
import {Row,Col, Form, Input, Button, Select, DatePicker} from "antd";
import DealerAction from "actions/DealerAction";
import {Link} from "react-router";
const FormItem = Form.Item;
const Option = Select.Option;
const show = (info) => {
  console.log("DealerListSearchBox.jsx " + JSON.stringify(info));
}
const {MonthPicker, RangePicker} = DatePicker;
class DealerListSearchBox extends Component {
  handleSubmit = (e) => {
    e.preventDefault();
    let fieldValues = this.props.form.getFieldsValue();
    DealerAction.querySubmit({data: fieldValues, pager: {page: 1, pageSize: 20}});
  };
  handOpenAddModal =(e) =>{
    show("点击添加按钮");
    DealerAction.openAddModal();
  };

  render() {
    const {getFieldDecorator} = this.props.form;

    return (
      <div>
        <Form inline>
<Row>
          <FormItem label="dealerName">
            {getFieldDecorator('insuresName')(
              <Input size="large" placeholder="经销商名称" style={{width: 120}} onPressEnter={this.handleSubmit}/>
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
DealerListSearchBox = Form.create()(DealerListSearchBox);
export default DealerListSearchBox;
