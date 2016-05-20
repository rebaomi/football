package com.rebaomi.util;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

public class StringUtil
{
	/**
	 * 日期类型转换为字符串格式，包含具体时间
	 * @param date 待转换的日期
	 * @return 转换之后的字符串
	 */
	public static String dateToString(Date date)
	{
		return dateToString(date, "yyyy-MM-dd HH:mm:ss");
	}
	
	/**
	 * 根据指定的格式将日期类型转换为字符串格式
	 * @param date 待转换的日期
	 * @param pattern 指定的格式
	 * @return 转换之后的字符串
	 */
	public static String dateToString(Date date, String pattern)
	{
		if (date == null)
		{
			return "";
		}
		
		SimpleDateFormat formater = new SimpleDateFormat(pattern);
		return formater.format(date);
	}


	public static boolean isBlank(String str)
	{
		return org.apache.commons.lang.StringUtils.isBlank(str);
	}

	public static String nvl(String remark)
	{
		return (null == remark ? "" : remark);
	}

	public static String splitAndFilterString(String input, int length)
	{
		if (input == null || input.trim().equals(""))
		{
			return "";
		}
		// 去掉所有html元素,
		String str = input.replaceAll("\\&[a-zA-Z]{1,10};", "").replaceAll(
				"<[^>]*>", "");
		str = str.replaceAll("[(/>)<]", "");
		int len = str.length();
		if (len <= length || length == 0)
		{
			return str;
		}
		else
		{
			str = str.substring(0, length);
			str += "...";
		}
		return str;
	}

	public static String getAge(Date birthDay)
	{
		Calendar cal = Calendar.getInstance();

		if (cal.before(birthDay))
		{
			return "0";
		}

		int yearNow = cal.get(Calendar.YEAR);
		int monthNow = cal.get(Calendar.MONTH);
		int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);

		cal.setTime(birthDay);
		int yearBirth = cal.get(Calendar.YEAR);
		int monthBirth = cal.get(Calendar.MONTH);
		int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

		int age = yearNow - yearBirth;
		if (monthNow <= monthBirth)
		{
			if (monthNow == monthBirth)
			{
				// monthNow==monthBirth
				if (dayOfMonthNow < dayOfMonthBirth)
				{
					age--;
				}
			}
			else
			{
				// monthNow>monthBirth
				age--;
			}
		}

		return age + "";
	}

	
	/**
	 * 文本字符串转换为unicode字符串
	 * @param str 待转换的文本字符串
	 * @return unicode字符串
	 */
	public static String str2Unicode(String str)
	{
		StringBuffer sb = new StringBuffer();
        char[] charArr = str.toCharArray();
       
        for (char ch : charArr) 
        {
            if (ch > 128) 
            {
                sb.append("\\u" + Integer.toHexString(ch));
            }
            else 
            {
                sb.append(ch);
            }
        }
        
        return sb.toString();
	}
	
	/**
	 * unicode字符串转换为文本字符串
	 * @param unicode 待转换的unicode字符串
	 * @return 文本字符串
	 */
	public static String unicode2Str(String unicode)
	{
		StringBuffer sb = new StringBuffer();
        String[] arr = unicode.split("\\\\u");
        int len = arr.length;
        sb.append(arr[0]);
        
        for(int i = 1; i < len; i++)
        {
            String tmp = arr[i];
            char c = (char)Integer.parseInt(tmp.substring(0, 4), 16);
            sb.append(c);
            sb.append(tmp.substring(4));
        }
        
        return sb.toString();
	}
	
	public static int getIntervalMinute(long exp){
	    Date now = new Date();
        long expNow = now.getTime();
        long internal = expNow-exp;
        int minute = (int) (internal/(60 * 1000));
        
	    return minute;
	}
	
	public static String easyEncryPhone(String phone){
	    boolean isPhone = StringUtils.isEmpty(phone) ? false
                : Pattern.compile("^((13[0-9])|(14[0-9])|(15[^4,\\D])|(18[^1^4,\\D])|(17[0-9]))\\d{8}").matcher(phone)
                        .matches();
        if (isPhone) {
            return phone.substring(0, 3) + "****" + phone.substring(7);
        }
        return phone;
	}
	
	public static Integer[] list2Array(List<Integer> lists){
	    return (Integer[]) lists.toArray(new Integer[]{});
	}
	
	public static Integer[] splitStr2Array(String str, String splitChar){
	    String[]  splitStrArr = str.split(splitChar);
	    List<Integer> targetList = new ArrayList<Integer>();
	    for(String item : splitStrArr){
	        targetList.add(Integer.valueOf(item.trim()));
	    }
	    return  list2Array(targetList);
	}
	
	/**
	 * 参考了spring-test的源码<br/>
	 * org.springframework.util.ObjectUtils  addObjectToArray
	 * 将一个新对象加入数组
	 * @param args
	 */
	public static <A, O extends A> A[] addObjectToArray(A[] array, O obj){
	    Class<?> compType = Object.class;
	    if (array != null) {
	        compType = array.getClass().getComponentType();
	    }
	    else if (obj != null) {
	        compType = obj.getClass();
	    }
	    int newArrLength = (array != null ? array.length + 1 : 1);
	    @SuppressWarnings("unchecked")
        A[] newArr = (A[])Array.newInstance(compType, newArrLength);
	    if (array != null){
	        System.arraycopy(array, 0, newArr, 0, array.length);
	    }
	    newArr[newArr.length -1] = obj;
	    return newArr;
	}
	
	/**
	 * 同上
	 * @param args
	 */
	public static boolean isArray(Object obj) {
	    return (obj != null && obj.getClass().isArray());
	}
	
	public static boolean containsElement(Object[] array, Object element){
	    if(array == null){
	        return false;
	    }
	    for(Object arrayEle : array){
	        if(nullSafeEquals(arrayEle, element)){
	            return true;
	        }
	    }
	    return false;
	}
	
	public static boolean nullSafeEquals(Object o1, Object o2){
	    if( o1 == o2){
	        return true;
	    }
	    if( o1 == null || o2 == null){
	        return false;
	    }
	    
	    if(o1.equals(o2)){
	        return true;
	    }
	    if (o1.getClass().isArray() && o2.getClass().isArray()) {
            if (o1 instanceof Object[] && o2 instanceof Object[]) {
                return Arrays.equals((Object[]) o1, (Object[]) o2);
            }
            if (o1 instanceof boolean[] && o2 instanceof boolean[]) {
                return Arrays.equals((boolean[]) o1, (boolean[]) o2);
            }
            if (o1 instanceof byte[] && o2 instanceof byte[]) {
                return Arrays.equals((byte[]) o1, (byte[]) o2);
            }
            if (o1 instanceof char[] && o2 instanceof char[]) {
                return Arrays.equals((char[]) o1, (char[]) o2);
            }
            if (o1 instanceof double[] && o2 instanceof double[]) {
                return Arrays.equals((double[]) o1, (double[]) o2);
            }
            if (o1 instanceof float[] && o2 instanceof float[]) {
                return Arrays.equals((float[]) o1, (float[]) o2);
            }
            if (o1 instanceof int[] && o2 instanceof int[]) {
                return Arrays.equals((int[]) o1, (int[]) o2);
            }
            if (o1 instanceof long[] && o2 instanceof long[]) {
                return Arrays.equals((long[]) o1, (long[]) o2);
            }
            if (o1 instanceof short[] && o2 instanceof short[]) {
                return Arrays.equals((short[]) o1, (short[]) o2);
            }
        }
        return false;
	}
	
	public static void main(String[] args) {
        Integer[] a = StringUtil.splitStr2Array("601,595,591,589,559,293,175,95,24", ",");
        System.out.println(a);
    }
}
