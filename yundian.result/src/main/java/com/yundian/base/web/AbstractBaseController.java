package com.yundian.base.web;

import com.yundian.result.PaginatedResult;
import com.yundian.result.Result;
import com.yundian.toolkit.utils.DataPage;
import com.yundian.toolkit.utils.WebUtil;
//import org.apache.poi.ss.formula.functions.T;
import org.apache.xpath.operations.Bool;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
//import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: jiyanbin@zafh.com.cn
 * JDK: 1.8
 * Created on 15/11/9.
 */
@Controller
public abstract class AbstractBaseController {

    protected static final String SESSION_KEY_USER = "CURRENT_USER";
    protected static final String SESSION_KEY_ORG = "CURRENT_ORG";
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
//
//    protected DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//    protected DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//    protected DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm");
//    protected DateTimeFormatter formatterFullTime = DateTimeFormatter.ofPattern("HH:mm:ss");

    public static final String RESULT_STATUS = "code";
    public static final String RESULT_MESSAGE = "message";
    public static final String RESULT_DATA = "data";
    public static final String RESULT_ROWS = "rows";
    public static final String RESULT_OFFSET = "page";
    public static final String RESULT_TOTAL_COUNT = "totalCount";
    public static final String RESULT_PAGE_SIZE = "pageSize";

    public static final String CT_JSON = "application/json; charset=utf-8";


    /**
     * 直接返回客户端个性化的json字符串
     *
     * @param response
     * @param dataPage
     * @throws Exception
     */
    protected <T> void response(HttpServletResponse response, PaginatedResult<T> dataPage) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
        response.setContentType(CT_JSON);
        Map resultMap = new HashMap();
        resultMap.put(RESULT_STATUS, WebConstants.SUCCESS);
        resultMap.put(RESULT_MESSAGE, "");
        resultMap.put(RESULT_DATA, dataPage.getRows());
        resultMap.put(WebUtil.JSON_RESULT_TOTAL, dataPage.getTotal());
        objectMapper.writeValue(response.getWriter(), resultMap);
    }

    /**
     * 返回消息
     *
     * @param response
     * @throws Exception
     */
    protected <T> void response(HttpServletResponse response, Result<T> result) throws Exception {
        response(response,result,false);
    }

    /**
     * 返回消息
     *
     * @param response
     * @throws Exception
     */
    protected <T> void response(HttpServletResponse response, Result<T> result, Boolean isContainNull) throws Exception {
        Map resultMap = new HashMap();
        resultMap.put(RESULT_STATUS, result.getCode());
        resultMap.put(RESULT_MESSAGE, result.getMessage());
        T body = result.getData();
        if (body != null) {
            resultMap.put(RESULT_DATA, body);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        if(isContainNull){
            objectMapper.setSerializationInclusion(JsonSerialize.Inclusion.ALWAYS);
        } else {
            objectMapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
        }

        response.setContentType(CT_JSON);
        objectMapper.writeValue(response.getWriter(), resultMap);
        response.getWriter().flush();
    }


    @ExceptionHandler(Exception.class)
    public <E extends Exception> void handleException(HttpServletResponse response, E ex) throws Exception {
        Map resultMap = new HashMap();
        resultMap.put(RESULT_DATA, "");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
        response.setContentType(CT_JSON);
        objectMapper.writeValue(response.getWriter(), resultMap);
        response.getWriter().flush();
    }

}
