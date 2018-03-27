package com.yundian.fssapi.enums;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * 征信调查状态枚举
 *

 */
public enum FssCreditAuditStatusEnum {

	/**
	 * 未提交
	 */
	UNSUBMIT("UNSUBMIT","未提交"){
		 
	},
	/**
	 * 待审核
	 */
	WAIT_ADUIT("WAIT_ADUIT","待调查"){
		 
	},
	/**
	 * 通过
	 */
	ADUIT_PASS("CREDIT_PASS","征信通过"),
	/**
	 * 不通过
	 */
	AUDIT_NOT_PASS("CREDIT_NOT_PASS","征信不通过"){
       
	},
	/**
	 * 退回
	 */
	AUDIT_BACK("CREDIT_BACK","退回"){
        
	};


	
	private String code;
	private String desc;
	private FssCreditAuditStatusEnum(String code,String desc){
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


	 
	public static FssCreditAuditStatusEnum getInstance(String code){
		return Stream.of(FssCreditAuditStatusEnum.values())
				.filter(e -> Objects.equals(e.code(),code))
				.findAny()
				.orElseThrow(() -> new RuntimeException("业务状态[" + code + "]不存在，请检查数据是否正确！"));
	}
	
	
	public static void main(String[] args)
	{
 
		
		FssCreditAuditStatusEnum en= FssCreditAuditStatusEnum.getInstance("CREDIT_PASS1");
		System.out.println(en.desc);
	}
}
