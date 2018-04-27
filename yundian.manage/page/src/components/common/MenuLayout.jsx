import React, {Component} from "react";
import {Link, Router, Route, hashHistory} from "react-router";
import {Layout, Menu, Icon} from "antd";
import styles from "components/common/Common.less";
import connectToStores from "alt-utils/lib/connectToStores";
import LayoutStore from "../../flux/stores/LayoutStore";
import LayoutAction from "actions/LayoutAction";
const Item = Menu.Item;
const SubMenu = Menu.SubMenu;
const {Header, Sider, Content} = Layout;

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
      current: state.current
    }
  }

    selectClick = (e) => {
    show(e.key)
    LayoutAction.setCurrent(e.key);
  }

  componentDidMount() {
  }

  render() {
    return (
      <div>
        <Layout style={{height: 'auto', background: 'white'}}>
          <Sider style={{overflow: 'auto', background: 'white'}}>
			<div style={{marginTop:10}}>
				<img alt="logo" style={{height:50, width:50}} src="/resources/pic/logo2.png"/>
				<span><font color="#49a9ee" size="3">保险分期运营管理系统</font></span>
			</div>
            <Menu style={{marginTop:10}} theme="light" onSelect={this.selectClick} selectedKeys={[this.props.current]}
                   mode="inline" defaultOpenKeys={['1','2','3','31','4','5','6','7']}>
				<SubMenu key="1" title={<span><Icon type="folder" />订单管理</span>}>
					<Menu.Item key="11"><Link to="/loan">订单审核</Link></Menu.Item>
				</SubMenu>
        <SubMenu key="2" title={<span><Icon type="folder" />经销商管理</span>}>
                <Menu.Item key="21"><Link to="/dealer">经销商</Link></Menu.Item>
         </SubMenu>
        <SubMenu key="3" title={<span><Icon type="folder" />贷后管理</span>}>
          <Menu.Item key="31"><Link to="/repayment">还款管理</Link></Menu.Item>

        </SubMenu>
				<SubMenu key="4" title={<span><Icon type="folder" />系统管理</span>}>
          <Menu.Item key="41"><Link to="/adminUser">用户管理</Link></Menu.Item>
				</SubMenu>

            </Menu>
          </Sider>
          <Content style={{margin: '72px 16px 0', overflow: 'initial'}}>
            <div className={styles.content}>{this.props.children}</div>
          </Content>
        </Layout>
      </div>
    )
  }
}
export default connectToStores(MenuLayout);

