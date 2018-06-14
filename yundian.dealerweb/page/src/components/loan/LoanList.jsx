import React, {Component} from "react";
import Layout from "../common/MenuLayout";
import {FullWidthHR, MeBreadCrumb} from "../common/Common";
import LoanListSearchBox from "./LoanListSearchBox";
import LoanListDT from "./LoanListDT";

class LoanList extends Component {

  render() {
    return (
      <Layout title="分期">
        <LoanListSearchBox/>
        <FullWidthHR/>
        <LoanListDT/>
      </Layout>
    )
  }
}

export default LoanList;
