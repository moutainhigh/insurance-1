import React, {Component} from "react";
import Layout from "../common/MenuLayout";
import {FullWidthHR, MeBreadCrumb} from "../common/Common";
import AdminUserListSearchBox from "./AdminUserListSearchBox";
import AdminUserListDT from "./AdminUserListDT";

class AdminUserList extends Component {

  render() {
    return (
      <Layout>
        <MeBreadCrumb title="员工管理"/>
        <FullWidthHR/>
        <AdminUserListSearchBox/>
        <FullWidthHR/>
        <AdminUserListDT/>
      </Layout>
    )
  }
}

export default AdminUserList;
