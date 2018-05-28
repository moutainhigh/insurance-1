import React, {Component} from "react";
import Layout from "../common/MenuLayout";
import {FullWidthHR, MeBreadCrumb} from "../common/Common";
import RepaymentSearchBox from "./RepaymentSearchBox";
import RepaymentDT from "./RepaymentDT";

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
