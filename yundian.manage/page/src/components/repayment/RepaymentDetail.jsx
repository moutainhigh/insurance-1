import React, {Component} from "react";
import Layout from "../common/MenuLayout";
import {FullWidthHR, MeBreadCrumb} from "../common/Common";
import LoanInfo from "../loan/LoanInfo";
import {Tabs} from "antd";

class RepaymentPlan extends Component{

  render(){
    return (
      <div>

      </div>
    )
  }
}

class LoanRepayment extends Component{

  render(){
    return (
      <div>

      </div>
    )
  }
}

class RepaymentDetail extends Component {

  handleTabCallback= ()=>{

    console.log('');
  }
  render() {
    return (
      <Layout>
        <MeBreadCrumb title="还款明细"/>
        <FullWidthHR/>
        <Tabs onChange={handleTabCallback} type="card">
          <TabPane tab="基本信息" key="1">
            <LoanInfo showLoanInfo={this.props.showLoanInfo}></LoanInfo>
          </TabPane>
          <TabPane tab="还款计划" key="2"><RepaymentPlan></RepaymentPlan></TabPane>
          <TabPane tab="还款明细" key="3"><LoanRepayment></LoanRepayment></TabPane>
        </Tabs>
      </Layout>
    )
  }
}

export default RepaymentDetail;

