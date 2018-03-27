package com.yundian.fssapi.domain.query;

import com.yundian.fssapi.domain.FssLoanModel;


/**
 * 贷款信息
 * 
 * @author hehaibo
 *
 */
public class FssLoanQueryModel extends FssLoanModel {
	private static final long serialVersionUID = 1L;

	/**
	 * 银行id
	 */
	private String bankName;

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}


}