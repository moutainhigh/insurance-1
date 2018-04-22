package com.yundian.toolkit.utils;

import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Field;
import java.util.Dictionary;
import java.util.Map;

/**
 * ant-design 表单初始化数据
 *
 * @author jnx
 * @create 2018/4/20
 */
public class BeanPropFieldUtil {

    public static JSONObject toPropField(Object object)
    {

        JSONObject propField = new JSONObject();

        if(object!=null)
        {
           Field[] fields = object.getClass().getDeclaredFields();
           for(Field field:fields)
           {
               // 获取原来的访问控制权限
               boolean accessFlag = field.isAccessible();
               // 修改访问控制权限
               field.setAccessible(true);
               try {
                   if(field.get(object)!=null) {
                       PropFieldItem item = new PropFieldItem(field.get(object));
                       propField.put(field.getName(), item);
                   }
               }catch (Exception e){
                   System.out.printf("toPropField error"+e.getMessage());
               }
               field.setAccessible(accessFlag);
           }

        }
        return propField;
    }


}
