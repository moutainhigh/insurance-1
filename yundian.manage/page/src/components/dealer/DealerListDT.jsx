import DealerStore from 'stores/DealerStore';
import React, {Component} from 'react';
import connectToStores from 'alt-utils/lib/connectToStores';
import {Row, Col, Table, Icon, Form, Input, Button, Cascader, Radio, Select, Layout, Spin} from 'antd';
import DealerAction from 'actions/DealerAction';
import DealerAddModal from './DealerAddModal';
import { Popconfirm, message } from 'antd';
import {Link} from 'react-router';
//************************ 用于打印log的 **************************
const show = (info) => {
  console.log(" DealerListDT stjsx  : " + JSON.stringify(info));
}
//****************************************************************
class DealerListDT extends Component {
  static getStores() {
    return [DealerStore];
  }

  static getPropsFromStores() {
    let state = DealerStore.getState();
    return {
      loading: state.loading,
      pagination: state.pagination,
      dataList: state.dataList,
      addModalVisible: state.addModalVisible,
      dealerInfo:state.dealerInfo


    };
  }

  columns = [
    {
      title: '序号', dataIndex: 'dealerId', key: 'dealerId', width: 100,
    }, {
      title: '名称', dataIndex: 'dealerName', key: 'dealerName', width: 300
    },
    {
      title: '省份', dataIndex: 'provinceName', key: 'provinceName', width: 150

    },
    {
      title: '城市', dataIndex: 'cityName', key: 'cityName', width: 150
    },
    {
      title: '公司地址', dataIndex: 'street', key: 'street', width: 220
    },
    {
      title: '联系人', dataIndex: 'contactor', key: 'contactor', width: 180
    },
    {
      title: '联系人电话', dataIndex: 'phone', key: 'phone', width: 120
    },
   {
      title: '操作', dataIndex: 'handle', key: 'handle', width: 120,
      render(text, record, index){
        return(
          <div>
            <span className="ant-divider" />
            <a onClick={()=>DealerAction.openUpdateModal({dealerId : record.dealerId})}>编辑</a>
          </div>
        )
      }
    }
  ];

  componentDidMount() {
    DealerAction.initDataListInfo({page: 1, pageSize: this.props.pagination.pageSize});
  }

  handleTableChange = (pagination) => {
    show(pagination)
    DealerAction.setPagination({page: pagination.current, pageSize: pagination.pageSize});
  };


  render() {
    return (
      <div>
        <DealerAddModal  dealerInfo={this.props.dealerInfo} addModalVisible={this.props.addModalVisible}/>
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

export default connectToStores(DealerListDT);
