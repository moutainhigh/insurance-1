import React, {Component} from "react";
import LoanInfo from "../loan/LoanInfo";
import {Tabs,Modal,Button,Table} from "antd";
import {Notify} from "../common/Common";
import RepaymentAction from "actions/RepaymentAction";
const TabPane = Tabs.TabPane;
const confirm = Modal.confirm;
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
        title: '滞纳金', dataIndex: 'payFee', key: 'payFee', width: 120
      },

      {
        title: '还款状态', dataIndex: 'repaymentStatus', key: 'repaymentStatus', width: 280
      }, {
       title: '操作', dataIndex: 'handle', key: 'handle', width: 120,
       render(text, record, index){
         if(record.repaymentStatus == 'HASREPAYMENT') {
           return (<div></div>)
         }else if(record.inPayment == 1&&record.repaymentStatus != 'HASREPAYMENT'){
           return (<div>已提交代扣</div>)
         }
         else {
           return (
             <div>
               <Button onClick={() => {
                 console.log('触发代扣！');
                 confirm({
                   title: '确认要发起代扣吗?',
                   content: '发起代扣后，会马上在用户卡上代扣相应金额！',
                   onOk() {
                     if (record.inPayment == 1 || record.repaymentStatus == 'HASREPAYMENT') {
                       Notify('触发代扣失败!', '计划状态为代扣中或已还款，无法发起代扣！', 'error')
                     } else {
                       RepaymentAction.witholding({planId: record.id});
                     }
                   },
                   onCancel() {
                     console.log('Cancel');
                   },
                 });
               }}>触发代扣</Button>
             </div>
           )
         }
       }
     }
    ];
console.log('plan:'+this.props.repaymentPlans);
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
    RepaymentAction.closeShowModal();
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

