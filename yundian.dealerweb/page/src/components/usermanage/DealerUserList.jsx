import React, {Component} from "react";
import Layout from "../common/MenuLayout";
import {FullWidthHR, MeBreadCrumb} from "../common/Common";
import DealerUserListSearchBox from "./DealerUserListSearchBox";
import DealerUserListDT from "./DealerUserListDT";

class DealerUserList extends Component {

  render() {
    return (
      <Layout title="员工管理">
        <DealerUserListSearchBox/>
        <FullWidthHR/>
        <DealerUserListDT/>
      </Layout>
    )
  }
}

export default DealerUserList;
