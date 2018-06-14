import React from "react";
import {Upload, Icon, Modal, message} from "antd";

/**
 * 组件输入参数：
 * 1.length 支持上传图片数，例如：1，2，3等
 * 2.maxFileSize 最大上传文件大小，单位：m
 * 3.value (upload组件的fileList数组)
 * [{
 *     uid: -1,
 *     name: 'xxx.png',
 *     status: 'done',
 *     url: 'https://zos.alipayobjects.com/rmsportal/jkjgkEfvpUPVyRjUImniVslZfWPnJuuZ.png',
 *}]
 * 4.onChange:组件上传状态变更的事件，参数是fileList({name, url: response.data, uid, status})
 */
const show = (info) => {
  console.log("jsx picturesSall: " + JSON.stringify(info));
}
class PicturesWall extends React.Component {

    state = {
        previewVisible: false,
      previewImage: '',
      length: this.props.length,
      maxFileSize: this.props.maxFileSize ? this.props.maxFileSize : 2,
      fileList: this.props.value instanceof Array ? this.props.value : [],
      data:{source:1020010},
      action: "/uploadfileforaliyun?source=1020010100",
      value:this.props.value instanceof Array ? this.props.value : [],

    };

    /**
     * 关闭预览
     */

    handleCancel = () => {
        this.setState({previewVisible: false});
    };

    /**
     * 查看预览
     * @param file
     */

    handlePreview = (file) => {
        this.setState({
            previewImage: file.url || file.thumbUrl,
            previewVisible: true,
        });
    };

    /**
     * 处理图片更新
     * @param e
     */

    handleChange = (e) => {
        let fileList = this.handleUpload(e);
        this.props.onChange(fileList);
    };

    /**
     * 处理更新
     * @param e
     * @returns {*}
     */

    handleUpload = (e) => {
        //再进行实际筛选，其实上面那一行没有用
        let fileList = e.fileList.map(file => {
            if (file.response) {
                //这个地方是上传结束之后会调用的方法，这边是判断success!!!
                if (file.response.success) {
                    return this.filter(file);
                }
            }
            return file;
        });
        this.setState({fileList: fileList,value:fileList});
        return fileList;
    };

    /**
     * 过滤服务器返回的数据
     * @param file
     */

    filter = (file) => {
        const {name, response, uid, status} = file;
        return {name, url: response.data.url, uid, status};
    };

    /**
     * 上传之前的验证
     */

    beforeUpload = (file) => {
        const maxFileSize = this.state.maxFileSize;
        if (maxFileSize) {
            const isLtMax = file.size / 1024 / 1024 < maxFileSize;
            if (!isLtMax) {
                message.error(`文件大小超过${maxFileSize}M限制`);
            }
            return isLtMax;
        }
    };

    render() {
        const {previewVisible, previewImage} = this.state;
      console.log("获取：this.props.value:"+this.props.value);
      console.log("获取：this.state.value:"+this.state.value);
        let initValue = this.props.value;
        if(this.props.value==undefined){
          initValue =this.state.value;
        }
        //一共有多少个图片
        const uploadButton = initValue.length >= this.props.length ? null : (
            <div>
                <Icon type="plus"/>
            </div>
        );

        const props = {
            action: this.state.action,
            fileList: this.props.value,
            // data: {
            // },
            headers: {'X-Requested-With': null},
            // accept: "image/*",
            accept: "image/jpg,image/jpeg,image/png,image/bmp",
            onChange: this.handleChange,
            beforeUpload: this.beforeUpload,
            onPreview: this.handlePreview,
            listType: "picture-card",
        };

        return (
            <div className="clearfix">
                <Upload {...props}>
                    {uploadButton}
                </Upload>
                <Modal visible={previewVisible} footer={null} onCancel={this.handleCancel}>
                    <img alt="preview" style={{width: '100%'}} src={previewImage}/>
                </Modal>
            </div>
        );

    }
}

export default PicturesWall;
