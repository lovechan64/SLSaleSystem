package org.slsale.common;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slsale.pojo.Function;

public class Util {
	
	/**
	 * 设置不需要的资源对象属性值为null
	 * @param funList
	 */
	public static void setPropertyNull(List<Function> funList){
		if(null!=funList && funList.size()>0){
			Function f = null;
			for(int i = 0;i<funList.size();i++){
				f = funList.get(i);
				f.setCreationTime(null);
				f.setEndTime(null);
				f.setFunctionCode(null);
				f.setPageSize(null);
				f.setRoleId(null);
				f.setSearchStr(null);
				f.setStarNum(null);
				f.setStartTime(null);
			}
		}
	}
	
	/**
	 * 设置不需要的资源对象属性值为null
	 * @param funList
	 */
	public static void setPropertyNull(List<Object> objList, List<String> fildList) {
		if (null != objList) {
			for (Object obj : objList) {

				String className = obj.getClass().getName();
				try {
					Class clazz = Class.forName(className);
					Field[] fields = clazz.getDeclaredFields();
					for (int i = 0; i < fields.length; i++) {
						if (fildList.contains(fields[i].getName())) {
							// 赋值为null
							Field field = clazz.getDeclaredField(fields[i]
									.getName());
							field.setAccessible(true);
							field.set(obj, null);
							// 获得get方法
							/*
							 * PropertyDescriptor pd=new
							 * PropertyDescriptor(f[i].
							 * getName(),obj.getClass()); Method getMethod =
							 * pd.getReadMethod(); Object o =
							 * getMethod.invoke(obj);//执行get方法返回一个Object
							 * System.out.println(o);
							 */
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 获取单据编号
	 * @return
	 */
	public static String getOrderNum(String type){
		String currentTime = String.valueOf(System.currentTimeMillis());
		
		return type + currentTime + new Random().nextInt(5);
	}
	
	/**
	 * 根据顶点totalCode获取以下4级（含本身）totalCoe集合
	 * @param parentCode
	 * @return
	 */
	public static List<String> getTotalCode(String parentCode){
		List<String> list = null;
		/*				               a
		 			   a0                            a1
 			 a00             a01             a10               a11
 		a000    a001    a010    a011    a100     a101     a110    a111 
		 */
		if(null!=parentCode){
			list = new ArrayList<String>();
			list.add(parentCode);
			list.add(parentCode+"0");
			list.add(parentCode+"1");
			list.add(parentCode+"00");
			list.add(parentCode+"01");
			list.add(parentCode+"10");
			list.add(parentCode+"11");
			list.add(parentCode+"000");
			list.add(parentCode+"001");
			list.add(parentCode+"010");
			list.add(parentCode+"011");
			list.add(parentCode+"100");
			list.add(parentCode+"101");
			list.add(parentCode+"110");
			list.add(parentCode+"111");
		}
		
		return list;
	}
	
	/**
	 * 根据顶点totalCode获取以下4级（含本身）totalCoe集合
	 * @param parentCode
	 * @return
	 */
	public static String getParentTotalCodeList(String totalCode){
		StringBuilder codeBuilder = new StringBuilder("");
		/*				               a
		 			   a0                            a1
 			 a00             a01             a10               a11
 		a000    a001    a010    a011    a100     a101     a110    a111 
		 */
		if(DateUtil.isNotEmpty(totalCode)){
			for(int i =1;i<totalCode.length();i++){
				if(codeBuilder.length()>0){
					codeBuilder.append(",");
				}
				codeBuilder.append("'"+totalCode.substring(0,totalCode.length()-i)+"'");
				if(i==15){
					break;
				}
			}
		}
		
		return codeBuilder.toString();
	}
	
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("loginCode");
		setPropertyNull(new ArrayList(),list);
	}
}
