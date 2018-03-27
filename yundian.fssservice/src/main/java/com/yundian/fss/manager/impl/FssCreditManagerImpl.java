package com.yundian.fss.manager.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.yundian.fss.dao.FssCreditLogModelMapper;
import com.yundian.fss.dao.FssCreditModelMapper;
import com.yundian.fss.exception.FssLoanBizException;
import com.yundian.fss.manager.FssCreditMananger;
import com.yundian.fssapi.domain.FssCreditLogModel;
import com.yundian.fssapi.domain.FssCreditModel;
import com.yundian.fssapi.dto.param.FssCreditQueryParam;
import com.yundian.fssapi.enums.FssCreditStatusEnum;
import com.yundian.result.PaginatedResult;
import com.yundian.result.Paginator;
import com.yundian.result.ResultCodeContants;
import com.yundian.toolkit.utils.BeanUtilsExt;

/**
 * 征信查询表服务实现
 * 
 * @author haibo.he
 * @version $Id: FssCreditManagerImpl.java, v 0.1 2016年7月26日 下午8:59:44 haibo.he Exp $
 */
@Transactional
public class FssCreditManagerImpl implements FssCreditMananger{
	private static final Logger logger=LoggerFactory.getLogger(FssCreditManagerImpl.class);
	@Autowired
	private FssCreditModelMapper  fssCreditModelMapper;
	@Autowired
	private FssCreditLogModelMapper fssCreditLogModelMapper;
	private FssCreditLogModel createFssCreditLogModel(){
		FssCreditLogModel obj=new FssCreditLogModel();
//		obj.setId (fss_credit_log.getId());// 主键ID
//		obj.setCreditId (fss_credit_log.getCreditId());// 征信申请id
		obj.setNode (FssCreditStatusEnum.SUBMITED.code());// 节点编号
		obj.setNodeName (FssCreditStatusEnum.SUBMITED.name());// 节点名称
		obj.setBankId (1L);// 银行id
		obj.setBankName ("银行名称");// 银行名称
		obj.setBankUserId (1L);// 银行审核人id
		obj.setBankUserName ("张三");// 银行审核人姓名
		obj.setAuditStatus (FssCreditStatusEnum.SUBMITED.code());// 审核状态
		obj.setAuditContent ("审核内容");// 审核内容
		obj.setAuditTime (new Date());// 审核时间
//		obj.setCtime (fss_credit_log.getCtime());// 创建时间
//		obj.setMtime (fss_credit_log.getMtime());// 修改时间
		obj.setRemark ("备注");// 备注
		
		return obj;
	}
	public Long insertFssCredit (FssCreditModel fssCreditModel){
		 this.fssCreditModelMapper.insert( fssCreditModel);
		 FssCreditLogModel fssCreditLogModel=this.createFssCreditLogModel();
		 fssCreditLogModel.setCreditId(fssCreditModel.getCreditId());
		 fssCreditLogModelMapper.insert(fssCreditLogModel);
		 return fssCreditModel.getCreditId();
	}
	
	public Integer updateFssCredit(FssCreditModel fssCreditModel){
		return this.fssCreditModelMapper.updateByPrimaryKey( fssCreditModel);
	}
	public Integer updateFssCreditSelective(FssCreditModel fssCreditModel){
		return this.fssCreditModelMapper.updateByPrimaryKeySelective( fssCreditModel);
	}

	
	
			
	public Integer deleteFssCreditByCreditId ( Long creditId )
	{
		return 0;
	}
																																																																																																																					
	public FssCreditModel getFssCreditAndCreditLogById(Long id){
		FssCreditModel fssCreditModel= this.fssCreditModelMapper.selectByPrimaryKey(id);
		if(fssCreditModel!=null){
			List<FssCreditLogModel> fssCreditLogList=this.fssCreditLogModelMapper.getFssCreditLogListByCreditId(id);
			fssCreditModel.setFssCreditLogList(fssCreditLogList);
		}
		return fssCreditModel;
	}


	public PaginatedResult<FssCreditModel> getPaginatorFssCredit(
            Paginator<FssCreditQueryParam> paginator){
		try {
			HashMap<String, Object> param = new HashMap<String, Object>();
			param.put("_limit", paginator.getPageSize());
			param.put("_offset",
					(paginator.getCurrentPage() - 1) * paginator.getPageSize());
			BeanUtilsExt.copyPropertiesToMap(paginator.getParam(), param);

			List<FssCreditModel> list = this.fssCreditModelMapper
					.getPaginatorFssCredit(param);
			Integer count = fssCreditModelMapper.getPaginatorFssCreditCount(param);
			PaginatedResult<FssCreditModel> paginatedResult = new PaginatedResult<FssCreditModel>();
			paginatedResult.setRows(list);
			paginatedResult.setTotal(count);
			return paginatedResult;
		} catch (Exception e) {
			logger.error(
					String.format("分页查询征信信息异常:%s",
							ToStringBuilder.reflectionToString(paginator)), e);
			throw new FssLoanBizException(ResultCodeContants.failed,
					"分页查询银行信息异常", e);
		}
		
    }
	@Override
	public Map<String, Integer> getCreditStatusStat(Long guaranteeId,
			Long bankId) {
		return fssCreditModelMapper.getCreditStatusStat(guaranteeId, bankId);
	}

}
