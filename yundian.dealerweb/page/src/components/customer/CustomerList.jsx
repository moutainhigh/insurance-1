import React, {Component} from "react";
import Layout from "../common/MenuLayout";
import {FullWidthHR, MeBreadCrumb} from "../common/Common";
import CustomerListSearchBox from "./CustomerListSearchBox";
import CustomerListDT from "./CustomerListDT";

class CustomerList extends Component {

  render() {
    return (
      <Layout>
        <MeBreadCrumb title="客户管理"/>
        <FullWidthHR/>
        <CustomerListSearchBox/>
        <FullWidthHR/>
        <CustomerListDT/>
      </Layout>
    )
  }
}

export default CustomerList;
