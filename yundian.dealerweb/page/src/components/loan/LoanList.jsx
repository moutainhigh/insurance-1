import React, {Component} from "react";
import Layout from "../common/MenuLayout";
import {FullWidthHR, MeBreadCrumb} from "../common/Common";
import LoanListSearchBox from "./LoanListSearchBox";
import LoanListDT from "./LoanListDT";

class LoanList extends Component {

  render() {
    return (
      <Layout>
        <MeBreadCrumb title="保险分期"/>
        <FullWidthHR/>
        <LoanListSearchBox/>
        <FullWidthHR/>
        <LoanListDT/>
      </Layout>
    )
  }
}

export default LoanList;
