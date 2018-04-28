import React, {Component} from "react";
import { Select} from "antd";
import connectToStores from "alt-utils/lib/connectToStores";
import CommonAction from 'actions/CommonAction';
import CommonStore from 'stores/CommonStore';
import {isEmptyObject} from 'services/functions'
const show = (info) => {
  console.log("jsx SelectData:  " + JSON.stringify(info));
}
const Option = Select.Option;

class SelectData extends Component {
  static getStores() {
    return [CommonStore]
  }

  static getPropsFromStores() {
    let state = CommonStore.getState();
    return {
      codeList:state.codeList
    }
  }


  componentDidMount() {
    CommonAction.getCodeList(this.props.codeType);
  }
  render() {
    const selectProps ={
      placeholder:this.props.placeholder,
      attachOption:this.props.attachOption==null?true:this.props.attachOption,
      value:this.props.value,
      onChange:this.props.onChange,

    };
    show(this.props.codeList);
    show(!isEmptyObject(this.props.codeList));
    let options = [];
    if(this.props.attachOption)
      options.push(<Option value={null}>全部</Option>);
      if(!isEmptyObject(this.props.codeList)) {
        options = this.props.codeList.map((item,index) => {
           return <Option value={item.codeId} key={index}>{item.codeName}</Option>;
        });
      }
    // show(options);
    return (
      <div>
        <Select  {...selectProps}>

          {options}
        </Select>
      </div>
    )
  }
}
export default connectToStores(SelectData);

