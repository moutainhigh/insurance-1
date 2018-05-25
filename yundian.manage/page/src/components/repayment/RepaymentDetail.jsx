import React, {Component} from "react";
import LoanInfo from "../loan/LoanInfo";
import {Tabs} from "antd";

class RepaymentPlan extends Component{

  render(){

   let  columns = [
      {
        title: '期次号', dataIndex: 'period', key: 'period', width: 100,
      }, {
        title: '约定还款日', dataIndex: 'agreedRepaymentDate', key: 'agreedRepaymentDate', width: 120
      },
      {
        title: '实际还款日', dataIndex: 'repaymentDate', key: 'repaymentDate', width: 120
      },
      {
        title: '逾期天数', dataIndex: 'overdueDays', key: 'overdueDays', width: 120
      },
      {
        title: '还款金额', dataIndex: 'payAmount', key: 'payAmount', width: 180
      },
      {
        title: '应还月供', dataIndex: 'planAmount', key: 'planAmount', width: 180
      },
     {
       title: '本金', dataIndex: 'planCaptialAmount', key: 'planCaptialAmount', width: 120
     },
     {
       title: '利息', dataIndex: 'planInterestAmount', key: 'planInterestAmount', width: 120
     },
      {
        title: '滞纳金', dataIndex: 'payFee', key: 'payFee', width: 120
      },

      {
        title: '还款状态', dataIndex: 'repaymentStatus', key: 'repaymentStatus', width: 280
      }
    ];

    return (
      <div>
        <Table columns={columns}
               dataSource={this.props.repaymentPlans}
        />
      </div>
    )
  }
}

// class LoanRepayment extends Component{
//
//   render(){
//     return (
//       <div>
//
//       </div>
//     )
//   }
// }

class RepaymentDetail extends Component {
  handleShowCancel= ()=>{

  }
  render() {
    return (
      <div>
      <Modal width={1000} visible={this.props.showModalVisible} title="查看还款明细" onCancel={this.handleShowCancel}
          footer={[<Button key="back" type="ghost" size="large" onClick={this.handleShowCancel}>返回</Button>]}>
      <Tabs  type="card">
        <TabPane tab="基本信息" key="1">
          <LoanInfo showLoanInfo={this.props.showLoanInfo}></LoanInfo>
        </TabPane>
        <TabPane tab="还款计划" key="2"><RepaymentPlan repaymentPlans={this.props.repaymentPlans}></RepaymentPlan></TabPane>
        {/*<TabPane tab="还款明细" key="3"><LoanRepayment loanRepayments={this.props.loanRepayments}></LoanRepayment></TabPane>*/}
    </Tabs>
    </Modal>
    </div>
    )
  }
}


export default RepaymentDetail;

