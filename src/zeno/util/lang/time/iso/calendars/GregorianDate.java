package zeno.util.lang.time.iso.calendars;

import waffles.util.tools.primitives.Longs;
import zeno.util.lang.time.iso.ISODate;
import zeno.util.lang.time.iso.enums.Month;
import zeno.util.lang.time.iso.enums.WeekDay;

/**
 * The {@code GregorianDate} class defines a proleptic Gregorian calendar.
 * </br> This date is accurate from 15 October 1852.
 * 
 * @author Waffles
 * @since 25 Jul 2020
 * @version 1.0
 * 
 * 
 * @see ISODate
 */
public class GregorianDate implements ISODate
{
	private static boolean isLeapYear(long year)
	{
		if(year % 4 != 0) return false;
		if(year % 100 != 0) return true;
		return year % 400 == 0;
	}
	
	private static int dayCount(long year, Month month)
	{
		switch(month)
		{
		case FEBRUARY:
			return 28 + (isLeapYear(year) ? 1 : 0);
		case JANUARY:
		case MARCH:
		case MAY:
		case JULY:
		case AUGUST:
		case OCTOBER:
		case DECEMBER:
			return 31;
		case APRIL:
		case JUNE:
		case SEPTEMBER:
		case NOVEMBER:
			return 30;
		default:
			return 0;
		}
	}
	
	private static int daysUntilMonth(long year, Month month)
	{
		int days = 0;
		for(int i = 1; i < month.Index(); i++)
		{
			Month m = Month.get(i);
			days += dayCount(year, m);
		}
		
		return days;
	}
		
	private static long approxYearsUntilDay(long days)
	{		
		return (400 * days + 145600) / 146097;
	}
	
	private static long daysUntilYear(long year)
	{
		return 365 * year - 366
			+ year / 4   + Longs.sign(year % 4)
			- year / 100 - Longs.sign(year % 100)
			+ year / 400 + Longs.sign(year % 400);
	}
	
	private static int dayCount(long year)
	{
		return isLeapYear(year) ? 366 : 365;
	}
	
		
	private long day, year;
	
	/**
	 * Creates a new {@code GregorianDate}.
	 * 
	 * @param y  a gregorian year
	 * @param d  a gregorian day
	 */
	public GregorianDate(long y, int d)
	{
		day = d + daysUntilYear(y);
		year = approxYearsUntilDay(day);
		day -= daysUntilYear(year);
		if(day > dayCount(year))
		{
			day -= dayCount(year);
			year++;
		}
	}
	
	/**
	 * Creates a new {@code GregorianDate}.
	 * 
	 * @param y  a gregorian year
	 * @param m  a gregorian month
	 * @param d  a gregorian day
	 */
	public GregorianDate(long y, int m, int d)
	{
		this(y, Month.get(m), d);
	}
	
	/**
	 * Creates a new {@code GregorianDate}.
	 * 
	 * @param y  a gregorian year
	 * @param m  a gregorian month
	 * @param d  a gregorian day
	 * 
	 * 
	 * @see Month
	 */
	public GregorianDate(long y, Month m, int d)
	{
		this(y, daysUntilMonth(y, m) + d);
	}

		
	@Override
	public Month Month()
	{
		long days = day;
		for(int i = 1; i <= 12; i++)
		{
			Month m = Month.get(i);
			int count = dayCount(year, m);
			if(days <= count)
			{
				return m;
			}
			
			days -= count;
		}
		
		return null;
	}
	
	@Override
	public WeekDay DayOfWeek()
	{
		return WeekDay.get((int) ((daysUntilYear(year) + day - 1) % 7 + 1));
	}
			
	@Override
	public long DayOfMonth()
	{
		long days = day;
		for(Month m : Month.values())
		{
			int count = dayCount(year, m);
			if(days <= count)
			{
				return (int) days;
			}
			
			days -= count;
		}
		
		return 0;
	}

	@Override
	public long DayOfYear()
	{
		return day;
	}

	@Override
	public long Year()
	{
		return year;
	}
}