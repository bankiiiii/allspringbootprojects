//package com.blogpost.blogpost.utils;
//
//import org.apache.commons.beanutils.BeanUtilsBean;
//import org.apache.commons.beanutils.PropertyUtils;
//
//import java.beans.PropertyDescriptor;
//import java.lang.reflect.InvocationTargetException;
//
//
//public class BeanUtilsWithNullHandler {
//
//    public static void copyPropertiesIgnoreNull(Object dest, Object orig) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
//        PropertyDescriptor[] origDescriptors = PropertyUtils.getPropertyDescriptors(orig);
//        BeanUtilsBean beanUtils = new BeanUtilsBean();
//
//        for (PropertyDescriptor origDescriptor : origDescriptors) {
//            String name = origDescriptor.getName();
//            Object value = PropertyUtils.getSimpleProperty(orig, name);
//            if (value != null) {
//                beanUtils.copyProperty(dest, name, value);
//            }
//        }
//    }
//}
