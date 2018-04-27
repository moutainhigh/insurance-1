import React,{ Component } from 'react'
import styles from 'components/common/Common.less';
import { Row, Col, Button, Modal,Breadcrumb, notification } from 'antd';
import { fenToYuan } from 'services/functions';

//通用水平分割线
export class HR extends Component {
    render(){
        return (
            <Row >
                <Col>
                    <hr className={styles.hr}/>
                </Col>
            </Row>
        )
    }
}

//通用全宽度水平分割线
export class FullWidthHR extends Component {
    render(){
        return (
            <Row >
                <Col>
                    <hr className={styles.fullHr}/>
                </Col>
            </Row>
        )
    }
}

export class MeBreadCrumb extends Component {
  render() {
    return (
      <div>
        <Row type="flex" justify="start">
          <Col span="6" className={styles.title}>
            <Breadcrumb>
              <Breadcrumb.Item>风险决策平台</Breadcrumb.Item>
              <Breadcrumb.Item>{this.props.title}</Breadcrumb.Item>
            </Breadcrumb>
          </Col>
        </Row>
      </div>
    )
  }
}

  //提示信息
  export function Notify(msg,desc,type) {
  switch (type) {
    case 'warn':
      notification.warn({message:msg,description:desc,duration:5});
      break;
    case 'success':
      notification.success({message:msg,description:desc,duration:5});
      break;
    case 'error' :
      notification.error({message:msg,description:desc,duration:5});
      break;
    default:
      notification.info({message:msg,description:desc,duration:5});
      break;
  }
}
