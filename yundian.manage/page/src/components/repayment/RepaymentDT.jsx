import React, {Component} from "react";
import connectToStores from "alt-utils/lib/connectToStores";
import {Table} from "antd";
import RepaymentAction from "actions/RepaymentAction";
import LoanListAction from "actions/LoanListAction";
import RepaymentDetail from "./RepaymentDetail";
import RepaymentStore from "stores/RepaymentStore";

//************************ 用于打印log的 **************************
const show = (info) => {
  console.log(" jsx  : " + JSON.stringify(info));
}
//****************************************************************
let loanListList = null;
class RepaymentDT extends Component {
  static getStores() {
    return [RepaymentStore];
  }

  static getPropsFromStores() {
    let state = RepaymentStore.getState();
    return {
      loading: state.loading,
      pagination: state.pagination,
      dataList: state.dataList,
      showModalVisible:state.showModalVisible,
      loanInfo:state.loanInfo,
      showLoanInfo:state.showLoanInfo,
      repaymentPlans:state.repaymentPlans


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

          return(
            <div>
              <a onClick={()=>RepaymentAction.openShowModal({loanId : record.loanId})}>查看</a>
              <span className="ant-divider" />
            </div>
          )
    }
  }
  ];

  componentDidMount() {
    loanListList = this;
    RepaymentAction.initDataListInfo({page: 1, pageSize: this.props.pagination.pageSize});

  }

  handleTableChange = (pagination) => {
    show(pagination)
    RepaymentAction.setPagination({page: pagination.current, pageSize: pagination.pageSize});
  };


  render() {
    return (
      <div>
        <RepaymentDetail showModalVisible={this.props.showModalVisible}
                         showLoanInfo={this.props.showLoanInfo}
                         repaymentPlans={this.props.repaymentPlans}></RepaymentDetail>
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

export default connectToStores(RepaymentDT);
