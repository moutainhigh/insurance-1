import React, {Component} from "react";
import {Link, Router, Route, hashHistory} from "react-router";
import {Layout, Menu, Icon,Breadcrumb} from "antd";
import styles from "components/common/Common.less";
import connectToStores from "alt-utils/lib/connectToStores";
import LayoutStore from "../../flux/stores/LayoutStore";
import LayoutAction from "actions/LayoutAction";
const Item = Menu.Item;
const SubMenu = Menu.SubMenu;
const {Header, Sider, Content,Footer} = Layout;

const show = (info) => {
  console.log("jsx MenuLayout:  " + JSON.stringify(info));
}
class MenuLayout extends Component {
  static getStores() {
    return [LayoutStore]
  }

  static getPropsFromStores() {
    let state = LayoutStore.getState();
    let urlArr = [];
    hashHistory.listen((event)=> {
      urlArr = event.pathname.split("/");
    });
	if (urlArr[1] == "riskgrail") {
      return {
        current: "11",
      }
    }
    else if (urlArr[1] == "riskRule") {
      return {
        current: "21",
      }
    }

    else if (urlArr[1] == "basicVarGroup") {
    return {
      current: "31",
    }
  }

  else if (urlArr[1] == "log") {
      return {
        current: "41",
      }
    } else if(urlArr[1] == "mq"){
	    return {
	      current: "42",
      }
  }

    return {
      current: state.current,
      dealerUser: state.dealerUser
    }
  }

    selectClick = (e) => {
    show(e.key)
    LayoutAction.setCurrent(e.key);
  }

  componentDidMount() {
    console.log('layout:getLoginINfo');
    LayoutAction.getLoginInfo();
  }

  render() {
    return (
      <div>
        <Layout style={{ minHeight: '100vh'}}>
          <Sider style={{overflow: 'auto', background: 'black'}}>
            <div style={{marginTop:10}}>
              <img alt="logo" style={{height:50, width:50}} src="/resources/pic/logo.png"/>
              <span><font color="#49a9ee" size="3">乐意保险管理系统</font></span>
            </div>
            <Menu  style={{marginTop:10}} theme="dark" onSelect={this.selectClick} selectedKeys={[this.props.current]}
                   mode="inline" defaultOpenKeys={['1','2','3','31','4','5']}>
              <SubMenu key="2" title={<span><Icon type="folder" />投保管理</span>}>
                <Menu.Item key="21"><Link to="/loanlist">分期管理</Link></Menu.Item>
              </SubMenu>
              <SubMenu key="3" title={<span><Icon type="folder" />客户管理</span>}>
                <Menu.Item key="31"><Link to="/customerlist">保险客户</Link></Menu.Item>

              </SubMenu>
              <SubMenu key="4" title={<span><Icon type="folder" />系统管理</span>}>
                <Menu.Item key="41"><Link to="/dealeruserlist">员工管理</Link></Menu.Item>
                {/*<Menu.Item key="42"><Link to="/#">角色管理</Link></Menu.Item>*/}
              </SubMenu>

            </Menu>
          </Sider>
          <Layout>
            <Header style={{ background: '#fff', padding: 0 }} >
              <div style={{ textAlign: 'right',marginRight:50 }}>您好，{this.props.dealerUser.name+'('+this.props.dealerUser.dealerName+')'} <a onClick={LayoutAction.loginOut}>退出</a></div>
            </Header>
            <Content style={{ margin: '0 12px' }}>
              <Breadcrumb style={{ margin: '12px 0' }}>
                <Breadcrumb.Item>乐意保险</Breadcrumb.Item>
                <Breadcrumb.Item>{this.props.title}</Breadcrumb.Item>
              </Breadcrumb>
              <div style={{ padding: 24, background: '#fff', minHeight: 480 }}>
                {this.props.children}
              </div>
            </Content>
            <Footer style={{ textAlign: 'center' }}>
               ©2018 Created
            </Footer>
          </Layout>
        </Layout>
      </div>
    )
  }
}
export default connectToStores(MenuLayout);

