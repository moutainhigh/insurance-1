import React, { Component } from "react";
import { Form, Row, Card, Col, Breadcrumb, Checkbox } from 'antd';
import Layout from "components/common/MenuLayout";
import styles from 'components/common/Common.less';
import {FullWidthHR} from "components/common/Common";
import connectToStores from 'alt-utils/lib/connectToStores';

import DashboardStore from 'stores/DashboardStore';

class DashboardIndex extends Component {

  static getStores() {
    return [DashboardStore];
  }

  static getPropsFromStores() {
    let state = DashboardStore.getState();
    return {
      pass: state.pass,
      passRate: state.passRate,
      reject: state.reject,
      rejectRate: state.rejectRate,
      review: state.review,
      reviewRate: state.reviewRate,
      sum: state.sum,
      checkboxStatus : state.todayData
    }
  }

  componentDidMount() {
    // DashboardAction.getData("111");
  }

  render() {
    const CheckboxGroup = Checkbox.Group;
    const plainOptions = [
      { label: '弹个车自营', value: 'tangeche_user_access' },
      { label: '弹个车天猫', value: 'tangeche_tmall_user_access' },
      { label: '弹个车车秒贷', value: 'tangeche_white_user_access' },
    ];

    return (
      <Layout>
        <div>
          <Row type="flex" justify="start">
            <Col span="6" className={styles.title}>
              <Breadcrumb>
                <Breadcrumb.Item>风险趋势</Breadcrumb.Item>
              </Breadcrumb>
            </Col>
          </Row>
          <Row>

          </Row>

        </div>
          <FullWidthHR/>
        <br/>

      </Layout>
    )
  }
}

export default connectToStores(DashboardIndex);
