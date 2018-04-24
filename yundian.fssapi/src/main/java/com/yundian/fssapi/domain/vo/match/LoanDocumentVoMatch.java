package com.yundian.fssapi.domain.vo.match;

import com.yundian.fssapi.domain.FssLoanDocumentModel;
import com.yundian.fssapi.domain.vo.LoanDocumentVo;

import java.util.ArrayList;
import java.util.List;

/**
 * vo匹配
 *
 * @author jnx
 * @create 2018/4/24
 */
public class LoanDocumentVoMatch {

    /**
     * model to vo
     * @param fssLoanDocumentModel
     * @return
     */
    public static LoanDocumentVo match(FssLoanDocumentModel fssLoanDocumentModel) {
        if(fssLoanDocumentModel!=null){
            LoanDocumentVo vo = new LoanDocumentVo();
            vo.setName(fssLoanDocumentModel.getFileName());
            vo.setUrl(fssLoanDocumentModel.getFileUrl());
            vo.setUid(fssLoanDocumentModel.getId().toString());
            vo.setLoanId(fssLoanDocumentModel.getLoanId());
            vo.setDocumentType(fssLoanDocumentModel.getDocumentType());
            return vo;
        }
        return null;
    }

    /**
     * list model  to list vo
     * @param loanDocumentModelList
     * @return
     */
    public static List<LoanDocumentVo> matchList(List<FssLoanDocumentModel> loanDocumentModelList) {
        List<LoanDocumentVo> loanDocumentVoList = new ArrayList<>();
        if(loanDocumentModelList!=null&&loanDocumentModelList.size()>0) {

            for(FssLoanDocumentModel model:loanDocumentModelList){
                loanDocumentVoList.add(match(model));
            }
        }
        return loanDocumentVoList;
    }


    public static FssLoanDocumentModel reverseMatch(LoanDocumentVo loanDocumentVo) {

        if(loanDocumentVo!=null) {
            FssLoanDocumentModel fssLoanDocumentModel = new FssLoanDocumentModel();
            fssLoanDocumentModel.setFileUrl(loanDocumentVo.getUrl());
            fssLoanDocumentModel.setLoanId(loanDocumentVo.getLoanId());
            fssLoanDocumentModel.setDocumentType(loanDocumentVo.getDocumentType());
            fssLoanDocumentModel.setFileName(loanDocumentVo.getName());
            return fssLoanDocumentModel;
        }else{
            return null;
        }
    }

    public static List<FssLoanDocumentModel> reverseMatchList(List<LoanDocumentVo> loanDocumentVos){
        List<FssLoanDocumentModel> fssLoanDocumentModelList = new ArrayList<>();
        if(loanDocumentVos!=null&&loanDocumentVos.size()>0) {
            for (LoanDocumentVo model : loanDocumentVos) {
                fssLoanDocumentModelList.add(reverseMatch(model));
            }
        }
        return fssLoanDocumentModelList;
    }
}
