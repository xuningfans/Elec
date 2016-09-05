package com.netease.course.utils;

import java.lang.reflect.ParameterizedType;

public class TUtils {

	/**
	 * 泛型转换真实类型
	 * 
	 * @param clazz
	 * @return
	 */
	public static Class<?> getTClass(Class<?> clazz) {
		ParameterizedType type = (ParameterizedType) clazz.getGenericSuperclass();
		Class<?> entityClass = (Class<?>) type.getActualTypeArguments()[0];
		return entityClass;
	}

}
