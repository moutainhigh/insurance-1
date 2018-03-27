package com.yundian.toolkit.utils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
/**
 * 
 * @author hehaibo
 *
 */
public class BeanUtilsExt {

    private static final String CONVERT_TYPE_DATE_TO_STRING = "DATE_TO_STRING";
    private static final String CONVERT_TYPE_STRING_TO_DATE = "STRING_TO_DATE";

    /**
     * 拷贝对象处理null值的情况
     * 
     * @param dest
     *            目标对象
     * @param orig
     *            原始对象
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws ParseException 
     */
    public static void copyPropertiesDealNullValue(Object dest, Object orig)
                                                                            throws IllegalAccessException,
                                                                            InvocationTargetException, ParseException {
        checkParam(dest, orig);
        // Copy the properties, converting as necessary
        if (orig instanceof DynaBean) {
            throw new IllegalArgumentException("not support DynaBean copy!");
        } else if (orig instanceof Map) {
            dealMap(dest, orig, null, null);
        } else {
            dealStandardJavaBeanConvertDateToString(dest, orig, null, null);
        }
    }

    private static void checkParam(Object dest, Object orig) throws IllegalAccessException,
                                                            InvocationTargetException {
        if (dest == null) {
            throw new IllegalArgumentException("No destination bean specified");
        }
        if (orig == null) {
            throw new IllegalArgumentException("No origin bean specified");
        }
    }
    @SuppressWarnings("rawtypes")
    private static void dealMap(Object dest, Object orig, String dateFormat, String converType)
                                                                                               throws IllegalAccessException,
                                                                                               InvocationTargetException, ParseException {
		Iterator names = ((Map) orig).keySet().iterator();
        while (names.hasNext()) {
            String name = (String) names.next();
            if (BeanUtilsBean.getInstance().getPropertyUtils().isWriteable(dest, name)) {
                Object value = ((Map) orig).get(name);
                dealDateProperties(dest, value, name, dateFormat, converType);
            }
        }
    }

    /**
     * 将orig对象的值拷贝到dest对象，并且将orig对象的Date类型值转为dest的字符串串值
     * 
     * 
     * @param dest
     * @param orig
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws ParseException 
     */
    public static void copyPropertiesConvertOrigDateToString(Object dest, Object orig,
                                                             String dateFormat)
                                                                               throws IllegalAccessException,
                                                                               InvocationTargetException, ParseException {
        checkParam(dest, orig);
        if (StringUtils.isEmpty(dateFormat)) {
            throw new IllegalArgumentException("dateFormat is not empty!");
        }
        // Copy the properties, converting as necessary
        if (orig instanceof DynaBean) {
            throw new IllegalArgumentException("not support DynaBean copy!");
        } else if (orig instanceof Map) {
            dealMap(dest, orig, dateFormat, CONVERT_TYPE_DATE_TO_STRING);
        } else {
            dealStandardJavaBeanConvertDateToString(dest, orig, dateFormat,
                CONVERT_TYPE_DATE_TO_STRING);
        }
    }

    public static Map<String, Object> copyPropertiesToMap(Object object) {
        return copyPropertiesToMap(object, new HashMap<String, Object>(), null);
    }

    public static Map<String, Object> copyPropertiesToMap(Object object, String dateFormat) {
        return copyPropertiesToMap(object, new HashMap<String, Object>(), dateFormat);
    }

    public static Map<String, Object> copyPropertiesToMap(Object object, Map<String, Object> map) {
        return copyPropertiesToMap(object, map, null);
    }

    @SuppressWarnings("unchecked")
    public static Map<String, Object> copyPropertiesToMap(Object object, Map<String, Object> map,
                                                          String dateFormat) {
        if (object == null || map == null) {
            return map;
        }
        if (object instanceof Map) {
            Map<Object, Object> objectMap = (Map<Object, Object>) object;
            for (Map.Entry<Object, Object> entry : objectMap.entrySet()) {
                map.put(ObjectUtils.toString(entry.getKey()), entry.getValue());
            }
            return map;
        }
        try {
            PropertyDescriptor[] origDescriptors = BeanUtilsBean.getInstance().getPropertyUtils()
                .getPropertyDescriptors(object);
            for (int i = 0; i < origDescriptors.length; i++) {
                String name = origDescriptors[i].getName();
                if ("class".equals(name)) {
                    continue; // No point in trying to set an object's class
                }
                if (BeanUtilsBean.getInstance().getPropertyUtils().isReadable(object, name)) {
                    Object objValue = BeanUtilsBean.getInstance().getPropertyUtils()
                        .getSimpleProperty(object, name);
                    if (objValue instanceof Date && StringUtils.isNotEmpty(dateFormat)) {
                        map.put(name, DateUtils.format((Date) objValue, dateFormat));
                    } else {
                        map.put(name, objValue);
                    }
                }
            }
        } catch (Exception e) {
        }
        return map;
    }


    private static void dealStandardJavaBeanConvertDateToString(Object dest, Object orig,
                                                                String dateFormat,
                                                                String convertType)
                                                                                   throws IllegalAccessException,
                                                                                   InvocationTargetException, ParseException {
        PropertyDescriptor[] origDescriptors = BeanUtilsBean.getInstance().getPropertyUtils()
            .getPropertyDescriptors(orig);
        for (int i = 0; i < origDescriptors.length; i++) {
            String name = origDescriptors[i].getName();
            if ("class".equals(name)) {
                continue; // No point in trying to set an object's class
            }
            if (BeanUtilsBean.getInstance().getPropertyUtils().isReadable(orig, name)
                && BeanUtilsBean.getInstance().getPropertyUtils().isWriteable(dest, name)) {
                try {
                    Object value = BeanUtilsBean.getInstance().getPropertyUtils()
                        .getSimpleProperty(orig, name);
                    dealDateProperties(dest, value, name, dateFormat, convertType);
                } catch (NoSuchMethodException e) {
                }
            }
        }
    }

    private static void dealDateProperties(Object dest, Object value, String name,
                                           String dateFormat, String convertType)
                                                                                 throws IllegalAccessException,
                                                                                 InvocationTargetException, ParseException {
        try {

            PropertyDescriptor destDescriptor = BeanUtilsBean.getInstance().getPropertyUtils()
                .getPropertyDescriptor(dest, name);
            if (value == null) {
                destDescriptor.getWriteMethod().invoke(dest, new Object[] { value });
                return;
            }
            if (StringUtils.isNotEmpty(dateFormat)) {
                if (CONVERT_TYPE_DATE_TO_STRING.equals(convertType)) {
                    dealDateToString(destDescriptor, dest, name, value, dateFormat);
                    return;
                } else if (CONVERT_TYPE_STRING_TO_DATE.equals(convertType)) {
                    dealStringToDate(destDescriptor, dest, name, value, dateFormat);
                    return;
                }
            }
            BeanUtils.copyProperty(dest, name, value);
        } catch (NoSuchMethodException e) {
        }
    }

    private static void dealDateToString(PropertyDescriptor destDescriptor, Object dest,
                                         String name, Object valueParam, String dateFormat)
                                                                                           throws IllegalAccessException,
                                                                                           InvocationTargetException {
        Object value = valueParam;
        // 目标对象的属性类型是Date类型 BeanUtil 不支持将Date的值为null
        if (String.class == destDescriptor.getPropertyType() && value instanceof Date) {
            value = DateUtils.format((Date) value, dateFormat);
            if (value == null) {// 转化出错情况
                destDescriptor.getWriteMethod().invoke(dest, new Object[] { value });
                return;
            }
        }
        BeanUtils.copyProperty(dest, name, value);
    }

    private static void dealStringToDate(PropertyDescriptor destDescriptor, Object dest,
                                         String name, Object valueParam, String dateFormat)
                                                                                           throws IllegalAccessException,
                                                                                           InvocationTargetException, ParseException {
        Object value = valueParam;
        if (Date.class.isAssignableFrom(destDescriptor.getPropertyType())) {
            value = DateUtils.strToDate(value.toString(), dateFormat);
            if (value == null) {// 转化出错情况
                destDescriptor.getWriteMethod().invoke(dest, new Object[] { value });
            } else {
                BeanUtils.copyProperty(dest, name, value);
            }
            return;
        }

        BeanUtils.copyProperty(dest, name, value);
    }
}
