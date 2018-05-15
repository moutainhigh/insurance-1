package com.yundian.dealerweb.excel;

import com.alibaba.fastjson.JSON;
import com.yundian.fssapi.domain.FssDealerCustomerModel;
import com.yundian.toolkit.excel.ExcelUtil;

import java.util.List;

/**
 * excel导出
 *
 * @author jnx
 * @create 2018/5/3
 */
public class TestExcel {


    public static void main(String[] args){

        String xlsPath="/Users/jnx/Documents/客户.xls";
        List<FssDealerCustomerModel> list = ExcelUtil.xlsToModel(xlsPath, FssDealerCustomerModel.class);
        System.out.printf(JSON.toJSONString(list));
    }
}
