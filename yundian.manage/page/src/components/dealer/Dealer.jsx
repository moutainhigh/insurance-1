import React, {Component} from "react";
import Layout from "../common/MenuLayout";
import {FullWidthHR, MeBreadCrumb} from "../common/Common";
import DealerListSearchBox from "./DealerListSearchBox";
import DealerListDT from "./DealerListDT";

class Dealer extends Component {

  render() {
    return (
      <Layout>
        <MeBreadCrumb title="经销商管理"/>
        <FullWidthHR/>
        <DealerListSearchBox/>
        <FullWidthHR/>
        <DealerListDT/>
      </Layout>
    )
  }
}

export default Dealer;
