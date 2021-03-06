package com.clearpool.kodiak.feedlibrary.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class MdDateUtil
{
	public static final TimeZone DEFAULT_TIMEZONE = TimeZone.getTimeZone("America/New_York");
	public static final Date TODAY_EST = getToday().getTime();

	private static GregorianCalendar getToday()
	{
		GregorianCalendar calendar = new GregorianCalendar(DEFAULT_TIMEZONE);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar;
	}

	public static Date createTime(Date date, int hour, int minute, int second)
	{
		GregorianCalendar calendar = new GregorianCalendar(DEFAULT_TIMEZONE);
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, minute);
		calendar.set(Calendar.SECOND, second);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

}