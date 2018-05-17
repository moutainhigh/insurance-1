import React, {Component} from "react";
import Layout from "../common/MenuLayout";
import {FullWidthHR, MeBreadCrumb} from "../common/Common";
import LoanListSearchBox from "./RepaymentSearchBox";
import LoanListDT from "./RepaymentDT";

class RepaymentList extends Component {

  render() {
    return (
      <Layout>
        <MeBreadCrumb title="还款"/>
        <FullWidthHR/>
        <RepaymentSearchBox/>
        <FullWidthHR/>
        <RepaymentDT/>
      </Layout>
    )
  }
}

export default RepaymentList;
