import LoanListStore from 'stores/LoanListStore.js';
import React, {Component} from 'react';
import connectToStores from 'alt-utils/lib/connectToStores';
import {Row, Col, Table, Icon, Form, Input, Button, Cascader, Radio, Select, Layout, Spin} from 'antd';
import LoanListAction from 'actions/LoanListAction';
import LoanListAddModal from './LoanListAddModal';
import { Popconfirm, message } from 'antd';
import {Link} from 'react-router';
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
      addModalVisible: state.addModalVisible,
      loanInfo:state.loanInfo


    };
  }

  columns = [
    {
      title: '订单号', dataIndex: 'loanCode', key: 'loanCode', width: 210,
    }, {
      title: '被保险人信息', dataIndex: 'insures_name', key: 'insuresName', width: 300,
      render(text, record){
        return <div><span>{record.insuresName}</span><span>{record.insuresPhone}</span> </div>
      }
    },{
      title: '车型', dataIndex: 'carModelName', key: 'carModelName', width: 210
    },
    {
      title: '车牌号码', dataIndex: 'carPlateNumber', key: 'carPlateNumber', width: 120
    },
    {
      title: '保险公司', dataIndex: 'policyInsuranceCompany', key: 'policyInsuranceCompany', width: 150
    },
    {
      title: '生效日期', dataIndex: 'policyEffectDate', key: 'policyEffectDate', width: 120
    },
    {
      title: '到期日期', dataIndex: 'policyExpireDate', key: 'policyExpireDate', width: 120
    },
    {
      title: '提报时间', dataIndex: 'ctime', key: 'ctime', width: 120
    },
    {
      title: '提报人', dataIndex: 'submitPerson', key: 'submitPerson', width: 180
    },
    {
      title: '订单状态', dataIndex: 'auditStatus', key: 'auditStatus', width: 200
    }, {
      title: '操作', dataIndex: 'handle', key: 'handle', width: 120,
      render(text, record, index){
        if(record.auditStatus == "WAITING_LOAN"||
          record.auditStatus == "AUDITING"){
          return(
            <div>
              <a>查看</a>
              <span className="ant-divider" />
              <a onClick={()=>LoanListAction.openUpdateModal({loanId : record.loanId})}>审核</a>
            </div>
          )
        }else{
          return(
            <div>
              <a>查看</a>
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
        <LoanListAddModal loanInfo={this.props.loanInfo} addModalVisible={this.props.addModalVisible}/>
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
