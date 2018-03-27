package com.yundian.fssapi.enums;

import com.yundian.fssapi.domain.FssLoanModel;
import com.yundian.fssapi.exception.FssLoanStatusTransformException;
import com.yundian.fssapi.service.FssLoanStatusTransform;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * 贷款审核状态枚举
 *
 * /**                          |------------<----------提交-----------------------|
 * 订单状态转换图                 |                                                   |
 * (创建)UNSUBMIT|---->(提交)WAIT_ADUIT |--->(审核通过)ADUIT_PASS(结束状态)           |
 *                                      |--->(审核不通过)AUDIT_NOT_PASS(结束状态)-----|
 *
 * @author hehaibo
 *
 */
public enum FssLoanAuditStatusEnum implements FssLoanStatusTransform{

	/**
	 * 未提交
	 */
	UNSUBMIT("UNSUBMIT","未提交"){
		public void submit(FssLoanModel model) throws FssLoanStatusTransformException {
			model.setAuditStatus(WAIT_ADUIT.code);
		}
	},
	/**
	 * 待审核
	 */
	WAIT_ADUIT("WAIT_ADUIT","待审核"){
		public void pass(FssLoanModel model) throws FssLoanStatusTransformException {
			model.setAuditStatus(ADUIT_PASS.code());
		}
        public void reject(FssLoanModel model) throws FssLoanStatusTransformException {
            model.setAuditStatus(AUDIT_NOT_PASS.code());
        }
	},
	/**
	 * 通过
	 */
	ADUIT_PASS("ADUIT_PASS","通过"),
	/**
	 * 不通过
	 */
	AUDIT_NOT_PASS("AUDIT_NOT_PASS","不通过"){
        public void submit(FssLoanModel model) throws FssLoanStatusTransformException {
            model.setAuditStatus(WAIT_ADUIT.code);
        }
	},
	/**
	 * 退回
	 */
	AUDIT_BACK("AUDIT_BACK","退回"){
        public void submit(FssLoanModel model) throws FssLoanStatusTransformException {
            model.setAuditStatus(WAIT_ADUIT.code);
        }
	};


	
	private String code;
	private String desc;
	private FssLoanAuditStatusEnum(String code,String desc){
		this.code=code;
		this.desc=desc;
	}
	public String code() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String desc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}


	@Override
	public void submit(FssLoanModel model) throws FssLoanStatusTransformException {
		throw new FssLoanStatusTransformException("不允许提交贷款业务");
	}

	@Override
	public void pass(FssLoanModel model) throws FssLoanStatusTransformException {
		throw new FssLoanStatusTransformException("不允许审批通过贷款业务");
	}

	@Override
	public void reject(FssLoanModel model) throws FssLoanStatusTransformException {
		throw new FssLoanStatusTransformException("不允许拒绝贷款业务");
	}

	public static FssLoanAuditStatusEnum getInstance(String code){
		return Stream.of(FssLoanAuditStatusEnum.values())
				.filter(e -> Objects.equals(e.code(),code))
				.findAny()
				.orElseThrow(() -> new RuntimeException("业务状态[" + code + "]不存在，请检查数据是否正确！"));
	}
}
