import DealerUserStore from 'stores/DealerUserStore';
import React, {Component} from 'react';
import connectToStores from 'alt-utils/lib/connectToStores';
import {Row, Col, Table, Icon, Form, Input, Button, Cascader, Radio, Select, Layout, Spin} from 'antd';
import DealerUserAction from 'actions/DealerUserAction';
import DealerUserListAddModal from './DealerUserListAddModal';
import { Popconfirm, message } from 'antd';
import {Link} from 'react-router';
//************************ 用于打印log的 **************************
const show = (info) => {
  console.log(" jsx  : " + JSON.stringify(info));
}
//****************************************************************
class DealerUserListDT extends Component {
  static getStores() {
    return [DealerUserStore];
  }

  static getPropsFromStores() {
    let state = DealerUserStore.getState();
    return {
      loading: state.loading,
      pagination: state.pagination,
      dataList: state.dataList,
      addModalVisible: state.addModalVisible,
      dealerUserInfo:state.dealerUserInfo


    };
  }

  columns = [
    {
      title: '序号', dataIndex: 'userId', key: 'userId', width: 210
    },
    {
      title: '员工姓名', dataIndex: 'name', key: 'name', width: 210
    },
    {
      title: '手机号码', dataIndex: 'userName', key: 'userName', width: 120
    },
    {
      title: '所属角色', dataIndex: 'roleId', key: 'roleId', width: 150
    },
    {
      title: '账户状态', dataIndex: 'status', key: 'status', width: 120
    }, {
      title: '操作', dataIndex: 'handle', key: 'handle', width: 120,
      render(text, record, index){
        return(<div>
          <a onClick={()=>DealerUserAction.openUpdateModal({userId : record.userId})}>编辑</a>
          <span className="ant-divider" />
          <Popconfirm title={"你确定要重置密码吗?"}
                      onConfirm={() =>{DealerUserAction.resetPwd({userId : record.userId})}} okText="是" cancelText="取消">
            <a>重置密码</a>
          </Popconfirm>
          </div>)
      }
    }
  ];

  componentDidMount() {
    DealerUserAction.initDataListInfo({page: 1, pageSize: this.props.pagination.pageSize});
  }

  handleTableChange = (pagination) => {
    show(pagination)
    DealerUserAction.setPagination({page: pagination.current, pageSize: pagination.pageSize});
  };


  render() {
    return (
      <div>
        <DealerUserListAddModal dealerUserInfo={this.props.dealerUserInfo} addModalVisible={this.props.addModalVisible}/>
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

export default connectToStores(DealerUserListDT);
