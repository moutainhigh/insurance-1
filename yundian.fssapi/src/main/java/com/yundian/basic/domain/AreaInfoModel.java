package com.yundian.basic.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 地域信息
 */

public class AreaInfoModel implements Serializable {

	private static final long serialVersionUID = 7026265188272344459L;

	/**
	 * 省下面的 市
	 */
	private List<AreaInfoModel> citys;

	/**
	 * 选中标志，selected=selected选中
	 */
	private String selected;
	/**
	 * 入库时间
	 */
	private Date ctime;

	/**
	 * 修改时间
	 */
	private Date mtime;

	/**
	 * 修改记录
	 */
	private String remark;

	/**
	 * 是否有效
	 */
	private double isvalid;

	/**
	 * 地域编码
	 */
	private String areacode;

	/**
	 * 省份
	 */
	private String province;

	/**
	 * 城市
	 */
	private String city;

	/**
	 * 县
	 */
	private String county;

	private int type;

	private String first_py;
	/**
	 * 是否被选中
	 */
	private String isselect;

	public List<AreaInfoModel> getCitys() {
		return citys;
	}

	public void setCitys(List<AreaInfoModel> citys) {
		this.citys = citys;
	}

	public String getSelected() {
		return selected;
	}

	public void setSelected(String selected) {
		this.selected = selected;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	/**
	 * 入库时间
	 */
	public Date getCtime() {
		return ctime;
	}

	/**
	 * 入库时间
	 */
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}

	/**
	 * 修改时间
	 */
	public Date getMtime() {
		return mtime;
	}

	/**
	 * 修改时间
	 */
	public void setMtime(Date mtime) {
		this.mtime = mtime;
	}

	/**
	 * 修改记录
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 修改记录
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * 是否有效
	 */
	public double getIsvalid() {
		return isvalid;
	}

	/**
	 * 是否有效
	 */
	public void setIsvalid(double isvalid) {
		this.isvalid = isvalid;
	}

	/**
	 * 地域编码
	 */
	public String getAreacode() {
		return areacode;
	}

	/**
	 * 地域编码
	 */
	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}

	/**
	 * 省份
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * 省份
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * 城市
	 */
	public String getCity() {
		return city;
	}

	/**
	 * 城市
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * 县
	 */
	public String getCounty() {
		return county;
	}

	/**
	 * 县
	 */
	public void setCounty(String county) {
		this.county = county;
	}

	public String getIsselect() {
		return isselect;
	}

	public void setIsselect(String isselect) {
		this.isselect = isselect;
	}

	public String getFirst_py() {
		return first_py;
	}

	public void setFirst_py(String first_py) {
		this.first_py = first_py;
	}

}
