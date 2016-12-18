package org.slsale.common;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;

public class DateUtil {

	public static SimpleDateFormat DATE_TIME_MS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
	public static SimpleDateFormat DATE_TIME = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static SimpleDateFormat DATE = new SimpleDateFormat("yyyy-MM-dd");
	public static SimpleDateFormat YEAR = new SimpleDateFormat("yyyy");
	public static SimpleDateFormat MONTH = new SimpleDateFormat("MM");
	public static SimpleDateFormat MONTH1 = new SimpleDateFormat("yyyyMM");
	public static SimpleDateFormat MONTH2 = new SimpleDateFormat("yyyy-MM");
	/**
	 * 得到当前系统的时间
	 * 
	 * @return 返回字符串 格式 yyyy-MM-dd HH:mm:ss SSS
	 */
	public static String getTableTS() {
		return getDateTimeMs(new Date(System.currentTimeMillis()), DateUtil.DATE_TIME_MS);
	}

	/**
	 * 返回带毫秒的日期时间字符串
	 * 
	 * @param date
	 * @param sdf
	 *            SimpleDateFormat 有静态常量 显示格式
	 * @return
	 */
	public static String getDateTimeMs(Date date, SimpleDateFormat sdf) {
		if (date == null) {
			return "";
		}
		return sdf.format(date);
	}

	/**
	 * 将字符串转化为Date
	 * 
	 * @param date
	 *            返回Date格式 yyyy-MM-dd
	 * @return
	 */
	public static Date doConvertToDate(String date) {
		Date result = null;
		try {
			result = DATE.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 返回带日期时间字符串 格式yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date
	 * @return
	 */
	public static String getDateTime(Date date) {

		return DATE_TIME.format(date);
	}

	/**
	 * 返回当前年份yyyy
	 * @return
	 */
	public static String getCurrentYear() {
		Date date = new Date();
		return YEAR.format(date);
	}	
	
	/**
	 * 返回当前月份MM
	 * @return
	 */
	public static String getCurrentMonth() {
		Date date = new Date();
		return MONTH.format(date);
	}
	
	/**
	 * 返回当前年月格式字符串YYYY-MM
	 * @return
	 */
	public static String getCurrentYearMonth(Date date) {
		
		return MONTH1.format(date != null ? date : new Date());
	}
	
	/**
	 * 返回当前年月格式字符串YYYY-MM
	 * @return
	 */
	public static String getCurrentYearMonth(String date) {
		String result = null;
		if(isNotEmpty(date)){
			result = date.replace("-", "");
		}else{
			result = MONTH1.format(new Date());
		}
		return result;
	}
	
	/**
	 * 返回带日期字符串 格式yyyy-MM-dd
	 * 
	 * @param date
	 * @return
	 */
	public static String getDate(Date date) {
		if (date == null) {
			return "";
		}
		return DATE.format(date);
	}

	/**
	 * 返回带日期和时间的字符串
	 * 
	 * @param date
	 * @param sdf
	 *            SimpleDateFormat 有静态常量 显示格式
	 * @return
	 */
	public static String getOpTime(Date date, SimpleDateFormat sdf) {
		if (date == null) {
			return "";
		}
		return sdf.format(date);
	}

	/**
	 * 将字符串转换为日期类型
	 * 
	 * @param date
	 *            日期字符串yyyy-MM-dd
	 * @return
	 */
	public static Date parseDate(String date) {
		Date d = null;
		try {
			d = DATE.parse(date);
		} catch (ParseException e) {
		}
		return d;
	}

	/**
	 * 将字符串转换为日期时间类型
	 * 
	 * @param date
	 *            日期日期字符串yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static Date parseDateTime(String date) {
		if (date == null || "".equals(date))
			return null;
		Date destDate = null;
		try {
			destDate = DATE_TIME.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return destDate;
	}

	/**
	 * 根据条件获取指定年份和月份
	 * @author 尚鸿运
	 * @version 2011-12-12
	 * @param monthNumber 要增加或减少的月份数
	 * @param dayNumber 要增加或减少的天数
	 * @return
	 */
	public static String getDateStrByValue(int monthNumber, int dayNumber) {
		DecimalFormat df = new DecimalFormat("00");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, monthNumber); // 得到当前月份+monthNumberge个月
		calendar.add(Calendar.DATE, dayNumber); // 得到当前日期+monthNumber天
		
		int year = calendar.get(Calendar.YEAR);// 获取当前年份
		int month = calendar.get(Calendar.MONTH) + 1;// 获取当前月份
		
		return year + df.format(month);
	}
	
	/**
	 * 根据条件获取指定年份和月份
	 * @author 尚鸿运
	 * @version 2011-12-12
	 * @param monthNumber 要增加或减少的月份数
	 * @param dayNumber 要增加或减少的天数
	 * @return
	 */
	public static Date getDateByValue(int monthNumber, int dayNumber,SimpleDateFormat sdf) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, monthNumber); // 得到当前月份+monthNumberge个月
		calendar.add(Calendar.DATE, dayNumber); // 得到当前日期+monthNumber天
		
		return  calendar.getTime(); 
	}

	/**
	 * 根据条件获取指定年份和月份
	 * @author 尚鸿运
	 * @version 2011-12-12
	 * @param monthNumber 要增加或减少的月份数
	 * @param dayNumber 要增加或减少的天数
	 * @return
	 */
	public static String getDateByValue(int monthNumber, int dayNumber) {
		DecimalFormat df = new DecimalFormat("00");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, monthNumber); // 得到当前月份+monthNumberge个月
		calendar.add(Calendar.DATE, dayNumber); // 得到当前日期+monthNumber天

		int year = calendar.get(Calendar.YEAR);// 获取当前年份
		int month = calendar.get(Calendar.MONTH) + 1;// 获取当前月份
		
		return year + df.format(month);
	}
	
	/**
	 * 根据条件获取指定年份和月份
	 * 
	 * @author 尚鸿运
	 * @version 2010-10-18
	 * @param monthNumber
	 *            要增加或减少的月份数
	 * @return
	 */
	public static String getDefaultDate(int monthNumber) {
		DecimalFormat df = new DecimalFormat("00");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, monthNumber); // 得到当前月份+monthNumberge个月

		int year = calendar.get(Calendar.YEAR);// 获取当前年份
		int month = calendar.get(Calendar.MONTH) + 1;// 获取当前月份

		return year + "-" + df.format(month);
	}

	/**
	 * 根据条件获取指定日期
	 * 
	 * @author 尚鸿运
	 * @version 2010-10-18
	 * @param monthNumber
	 *            要增加或减少的月份数
	 * @param dayNumber
	 *            要增加或减少的天数
	 * @return
	 */
	public static String getDefaultDate(int monthNumber, int dayNumber) {
		DecimalFormat df = new DecimalFormat("00");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, monthNumber); // 得到当前月份+monthNumberge个月
		calendar.add(Calendar.DATE, dayNumber); // 得到当前日期+monthNumber天

		int year = calendar.get(Calendar.YEAR);// 获取当前年份
		int month = calendar.get(Calendar.MONTH) + 1;// 获取当前月份
		int day = calendar.get(Calendar.DATE);// 获取当前日期

		return year + "-" + df.format(month) + "-" + df.format(day);
	}

	public static int parseInt(String str) {
		int n = 0;
		try {
			n = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return n;
	}

	public static float parseFloat(String str) {
		float f = 0f;
		try {
			f = Float.parseFloat(str);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return f;
	}

	/**
	 * 将NULL字符串转为""
	 * 
	 * @param str
	 * @return
	 */
	public static String nvl(Object str) {
		return str == null ? "" : str.toString();
	}

	/**
	 * java方式获取32位UUID
	 * 
	 * @author 尚鸿运
	 * @version 2010-9-16
	 * @return
	 */
	public static String getUuid() {
		UUID uuid = UUID.randomUUID();

		return uuid.toString().replaceAll("-", "");
	}

	/**
	 * 值是否为空
	 * 
	 * @author 尚鸿运
	 * @version 2010-9-19
	 * @param value
	 * @return
	 */
	public static boolean isNotEmpty(String value) {
		
		return null != value && !value.trim().equals("") && !value.equals("undefined") && !value.trim().equals("null");
	}
	
	/**
	 * 值是否为空
	 * 
	 * @author 尚鸿运
	 * @version 2014-4-23
	 * @param value
	 * @return
	 */
	public static boolean isEmpty(String value) {

		return null == value || value.trim().equals("") || value.equals("undefined") || value.trim().equals("null");
	}

	/**
	 * 功能: 拼加查询条件
	 * 
	 * @author GZZ
	 * @param propertyName
	 *            属性名称
	 * @param strSQL
	 *            拼加目标语句字符串
	 * @return src_sql 拼加后的查询语句
	 */
	public static String addCondition(String propertyName, String strSQL) {
		String return_sql = "";

		if (null == strSQL) {
			strSQL = "";
		}
		if (StringUtils.isNotEmpty(propertyName)) {
			return_sql += strSQL;
		}
		return return_sql;
	}
	
	/**
	 * 格式化浮点数
	 * @param f
	 * @return
	 */
	public static String formatFloat(double f) {
		java.text.DecimalFormat df = new java.text.DecimalFormat("#0.00");
		String sj = df.format(f);
		return sj;
	}
	
	/**
	 * 比较两个字符串时间的大小
	 * @param t1     时间1
	 * @param t2     时间2
	 * @param parrten 时间格式 :yyyy-MM-dd
	 * @return 返回long =0相等，>0 t1>t2，<0 t1<t2
	 */
	public static long compareStringTime(String t1, String t2, String parrten) {
		SimpleDateFormat formatter = new SimpleDateFormat(parrten);
		ParsePosition pos = new ParsePosition(0);
		ParsePosition pos1 = new ParsePosition(0);
		Date dt1 = formatter.parse(t1, pos);
		Date dt2 = formatter.parse(t2, pos1);
		long l = dt1.getTime() - dt2.getTime();
		return l;
	}
	
	private static java.text.DecimalFormat df = new java.text.DecimalFormat("#0.0000");
	public static double formatDouble(Double d){
		if(d == null){
			return 0.0000d;
		}else{
			return new Double(df.format(d));
		}
	}
	
	private static java.text.DecimalFormat df2 = new java.text.DecimalFormat("#0.00");
	public static double formatDouble2(Double d){
		if(d == null){
			return 0.00d;
		}else{
			return new Double(df2.format(d));
		}
	}
	
	/**
	 * 得到动态表名
	 * @param tableName	表名
	 * @param date	日期
	 * @param dsf  表名后缀格式
	 * 			SimpleDateFormat 有静态常量 显示格式
	 * @return	表名_日期  XXTable_201112
	 */
	public static String getDynamicTableName(String tableName, Date date, SimpleDateFormat dsf){
		String suffix = getDateTimeMs(date, dsf);
		return tableName + "_" + suffix;
	}
	
	/**
	 * 得到动态表名 (当前时间)
	 * @param tableName	表名
	 * @param dsf  表名后缀格式
	 * 			SimpleDateFormat 有静态常量 显示格式
	 * @return	表名_日期  XXTable_201112
	 */
	public static String getDynamicTableName(String tableName, SimpleDateFormat dsf){
		String suffix = getDateTimeMs(new Date(), dsf);
		return tableName + "_" + suffix;
	}
	
	/**
	 * 方便打印输出带时间的日志
	 * @param out
	 */
	public static void out(String out){
		String dt = getDateTime(Calendar.getInstance().getTime());
		System.out.println(dt+":"+out);
	}
	
}
