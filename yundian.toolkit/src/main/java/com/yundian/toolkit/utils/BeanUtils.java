package com.yundian.toolkit.utils;

import java.lang.reflect.Field;

public class BeanUtils {
	public static <T> T copyProperty(Object orig, Class<T> destClass){
		if(orig==null)return null;
		try {
			return copyProperty(orig, destClass.newInstance());
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static <T> T copyProperty(Object orig, T dest){
		if(orig==null)return null;
		try {
			for(Field f:dest.getClass().getDeclaredFields()){
				f.setAccessible(true);
				try {
					Field field = orig.getClass().getDeclaredField(f.getName());
					field.setAccessible(true);
					Object v = field.get(orig);
					if(v!=null){
						if(field.getType().equals(f.getType())){
							f.set(dest, v);
						}else if(f.getType().isAssignableFrom(String.class)){
							f.set(dest, String.valueOf(v));
						}
					}
				} catch (NoSuchFieldException | SecurityException e) {
					//e.printStackTrace();
				}
			}
			return dest;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
}
