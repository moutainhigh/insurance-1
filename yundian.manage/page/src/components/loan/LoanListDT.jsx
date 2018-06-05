import LoanListStore from "stores/LoanListStore.js";
import React, {Component} from "react";
import connectToStores from "alt-utils/lib/connectToStores";
import {Table} from "antd";
import LoanListAction from "actions/LoanListAction";
import LoanInfoShowModal from "./LoanInfoShowModal";
import LoanGrantModal from "./LoanGrantModal";
import LoanAuditModal from "./LoanAuditModal";
//************************ 用于打印log的 **************************
const show = (info) => {
  console.log(" jsx  : " + JSON.stringify(info));
}
//****************************************************************
let loanListList = null;
class LoanListDT extends Component {
  static getStores() {
    return [LoanListStore];
  }

  static getPropsFromStores() {
    let state = LoanListStore.getState();
    return {
      loading: state.loading,
      pagination: state.pagination,
      dataList: state.dataList,
      auditModalVisible: state.auditModalVisible,
      showModalVisible:state.showModalVisible,
      grantLoanModalVisible:state.grantLoanModalVisible,
      loanInfo:state.loanInfo,
      showLoanInfo:state.showLoanInfo,
      auditLoanInfo:state.auditLoanInfo


    };
  }

  columns = [
    {
      title: '订单号', dataIndex: 'loanCode', key: 'loanCode', width: 210,
    }, {
      title: '被保险人信息', dataIndex: 'insuresName', key: 'insuresName', width: 300,
      render(text, record){
        return <div><span>{record.insuresName}</span><span>{record.insuresPhone}</span> </div>
      }
    },
    {
      title: '保险公司', dataIndex: 'policyInsuranceCompany', key: 'policyInsuranceCompany', width: 150
    },
    {
      title: '保险总额(元)', dataIndex: 'policyTotalAmount', key: 'policyTotalAmount', width: 120
    },
    {
      title: '金融产品', dataIndex: 'planName', key: 'planName', width: 120
    },
    {
      title: '经销商', dataIndex: 'dealerName', key: 'dealerName', width: 180
    },
    {
      title: '提报时间', dataIndex: 'ctime', key: 'ctime', width: 120
    },

    {
      title: '订单状态', dataIndex: 'auditStatusName', key: 'auditStatusName', width: 200
    }, {
      title: '操作', dataIndex: 'handle', key: 'handle', width: 120,
      render(text, record, index){
        if(record.auditStatus == "AUDITING"){//待审核
          return(
            <div>
              <a onClick={()=>LoanListAction.openShowModal({loanId : record.loanId})}>查看</a>
              <span className="ant-divider" />
              <a onClick={()=>LoanListAction.openAuditModal({loanId : record.loanId})}>审核</a>
            </div>
          )
        }
          if(record.auditStatus == "WAITING_LOAN"){ //待放款
          return(
            <div>
              <a onClick={()=>LoanListAction.openShowModal({loanId : record.loanId})}>查看</a>
              <span className="ant-divider" />
              <a onClick={()=>LoanListAction.openLoanApplyModal({loanId : record.loanId})}>放款</a>
            </div>
          )
        }

        //
        else{
          return(
            <div>
              <a onClick={()=>LoanListAction.openShowModal({loanId : record.loanId})}>查看</a>
            </div>
          )
        }
      }
    }
  ];

  componentDidMount() {
    loanListList = this;
    LoanListAction.initDataListInfo({page: 1, pageSize: this.props.pagination.pageSize});

  }

  handleTableChange = (pagination) => {
    show(pagination)
    LoanListAction.setPagination({page: pagination.current, pageSize: pagination.pageSize});
  };


  render() {
    return (
      <div>
        <LoanInfoShowModal showLoanInfo={this.props.showLoanInfo}  showModalVisible={this.props.showModalVisible} />
        <LoanAuditModal auditLoanInfo={this.props.auditLoanInfo} auditModalVisible={this.props.auditModalVisible} />
        <LoanGrantModal loanInfo={this.props.loanInfo} grantLoanModalVisible={this.props.grantLoanModalVisible} />
        <Table columns={this.columns}
               dataSource={this.props.dataList}
               onChange={this.handleTableChange}
               pagination={this.props.pagination}
               loading={this.props.loading}
        />
      </div>
    )
  }
}

export default connectToStores(LoanListDT);
