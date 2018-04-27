package com.yundian.dealerweb.util;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;  
  
/** 
 *  
 */  
@ControllerAdvice(basePackages = "com.yundian.dealerweb.controller")
public class JsonpAdvice extends AbstractJsonpResponseBodyAdvice {  
    public JsonpAdvice() {  

        super("callback", "jsonp");
    }  
} 