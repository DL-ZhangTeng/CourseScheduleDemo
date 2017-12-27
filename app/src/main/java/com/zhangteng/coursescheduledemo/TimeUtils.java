package com.zhangteng.coursescheduledemo;

import android.text.format.Time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtils {
	public static int getCurrentYear() {
		Time t = new Time();
		t.setToNow();
		return t.year;
	}
	
	public static int getCurrentMonth() {
		Time t = new Time();
		t.setToNow();
		return t.month + 1;
	}
	
	public static int getCurrentDay() {
		Time t = new Time();
		t.setToNow();
		return t.monthDay;
	}

	public static int getCurrentHour() {
		Time t = new Time();
		t.setToNow();
		return t.hour;
	}

	public static int getCurrentMinute() {
		Time t = new Time();
		t.setToNow();
		return t.minute;
	}
	
	public static int getTimeByPosition(int position, int originYear, int originMonth, String type) {
    	int year = originYear, month = originMonth;
    	if (position > 500) {
    		for (int i = 500; i < position; i++) {
    			month++;
    			if (month == 13) {
    				month = 1;
    				year++;
    			}
    		}
    	} else if (position < 500) {
    		for (int i = 500; i > position; i--) {
    			month--;
    			if (month == 0) {
    				month = 12;
    				year--;
    			}
    		}
    	}
    	if (type.equals("year")) {
    		return year;
    	}
    	return month;
	}
	
	public static int getWeekDay(String date) {  
        Calendar calendar = Calendar.getInstance();  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
        try {  
            calendar.setTime(sdf.parse(date));  
        } catch (ParseException e) {  
            e.printStackTrace();  
        }  
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);  
        if (dayOfWeek == 1) {
            dayOfWeek = 0;  
        }
        else {
            dayOfWeek -= 1; 
        }
        return dayOfWeek;  
    }  
	
	
	public static boolean isLeapYear(int year) {
		if (year % 400 == 0 || year % 100 != 0 && year % 4 == 0) {
			return true;
		}
		return false;
	}
	
	public static int getDaysOfMonth(int year, int month) {
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			return 31;
		case 4:
		case 6:
		case 9:
		case 11:
			return 30;
		default:
			if (isLeapYear(year)) {
				return 29;
			}
			return 28;
		}
	}
	
	public static String getFormatDate(int year, int month) {
    	String formatYear = year + "";
    	String formatMonth = "";
    	if (month < 10) {
    		formatMonth = "0" + month;
    	} else {
    		formatMonth = month + "";
    	}
    	return formatYear + "-" + formatMonth + "-01";
	}

	/**
	 * 获取当前日期
	 * @param dateType 日期格式 例如：yyyy-MM-dd hh:mm:ss     或者  yyyy年MM月dd日    HH:mm:ss
	 * @return
	 */
	public static String getCurrentDate(String dateType) {
		SimpleDateFormat formatter = new SimpleDateFormat(dateType);
		Date curDate = new Date(System.currentTimeMillis());//获取当前时间
		String str = formatter.format(curDate);
		return str;
	}
	
	public static String getFormatDate(int year, int month, int day) {
    	String formatYear = year + "";
    	String formatMonth = "";
    	String formatDay = "";
    	if (month < 10) {
    		formatMonth = "0" + month;
    	} else {
    		formatMonth = month + "";
    	}
    	if (day < 10) {
    		formatDay = "0" + day;
    	} else {
    		formatDay = day + "";
    	}
    	return formatYear + "-" + formatMonth + "-" + formatDay;
	}
}
