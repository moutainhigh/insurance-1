import CustomerStore from 'stores/CustomerStore.js';
import React, {Component} from 'react';
import connectToStores from 'alt-utils/lib/connectToStores';
import {Row, Col, Table, Icon, Form, Input, Button, Cascader, Radio, Select, Layout, Spin} from 'antd';
import CustomerAction from 'actions/CustomerAction';
import CustomerListAddModal from './CustomerListAddModal';
import { Popconfirm, message } from 'antd';
import {Link} from 'react-router';
//************************ 用于打印log的 **************************
const show = (info) => {
  console.log(" jsx  : " + JSON.stringify(info));
}
//****************************************************************
class CustomerListDT extends Component {
  static getStores() {
    return [CustomerStore];
  }

  static getPropsFromStores() {
    let state = CustomerStore.getState();
    return {
      loading: state.loading,
      pagination: state.pagination,
      dataList: state.dataList,
      addModalVisible: state.addModalVisible,
      customerInfo:state.customerInfo


    };
  }

  columns = [
    {
      title: '序号', dataIndex: 'id', key: 'id', width: 100,
    }, {
      title: '客户信息', dataIndex: 'insures_name', key: 'insuresName', width: 300,
      render(text, record){
        return <div><span>{record.insuresName}</span><span>{record.insuresPhone}</span> </div>
      }
    },{
      title: '车型', dataIndex: 'carModelName', key: 'carModelName', width: 210,
      render(text, record){
        return <div><span>{record.carVehicleName}</span><span>{record.carModelName}</span>
          <span>vin:{record.carVin}</span>
        </div>
      }
    },
    {
      title: '保险公司', dataIndex: 'policyInsuranceCompany', key: 'policyInsuranceCompany', width: 150
    },
    {
      title: '客户类型', dataIndex: 'insuresType', key: 'insuresType', width: 120
    },
    {
      title: '保险购买方式', dataIndex: 'policyBuyType', key: 'policyBuyType', width: 180
    },
    {
      title: '到期日期', dataIndex: 'policyExpireDate', key: 'policyExpireDate', width: 120
    },
   {
      title: '操作', dataIndex: 'handle', key: 'handle', width: 120,
      render(text, record, index){
        return(
          <div>
            <span className="ant-divider" />
            <a onClick={()=>CustomerAction.openUpdateModal({id : record.id})}>编辑</a>
          </div>
        )
      }
    }
  ];

  componentDidMount() {
    CustomerAction.initDataListInfo({page: 1, pageSize: this.props.pagination.pageSize});
  }

  handleTableChange = (pagination) => {
    show(pagination)
    CustomerAction.setPagination({page: pagination.current, pageSize: pagination.pageSize});
  };


  render() {
    return (
      <div>
        <CustomerListAddModal customerInfo={this.props.customerInfo} addModalVisible={this.props.addModalVisible}/>
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

export default connectToStores(CustomerListDT);
