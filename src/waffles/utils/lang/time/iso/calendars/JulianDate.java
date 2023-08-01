package waffles.utils.lang.time.iso.calendars;

import waffles.utils.lang.time.iso.ISODate;
import waffles.utils.lang.time.iso.enums.Month;
import waffles.utils.lang.time.iso.enums.WeekDay;
import waffles.utils.tools.primitives.Longs;

/**
 * The {@code JulianDate} class defines a proleptic Julian calendar.
 * </br> This date is accurate up to 4 October 1852.
 * 
 * @author Waffles
 * @since 25 Jul 2020
 * @version 1.0
 * 
 * 
 * @see ISODate
 */
public class JulianDate implements ISODate
{
	private static boolean isLeapYear(long year)
	{
		return Longs.mod(year, 4) == 0;
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
		return (4 * days + 1460) / 1461;
	}
	
	private static long daysUntilYear(long year)
	{
		return 365 * year - 366 + year / 4 + Longs.sign(Longs.mod(year, 4));
	}
	
	private static int dayCount(long year)
	{
		return isLeapYear(year) ? 366 : 365;
	}
	
		
	private long day, year;
	
	/**
	 * Creates a new {@code JulianDate}.
	 * 
	 * @param y  a julian year
	 * @param d  a julian day
	 */
	public JulianDate(long y, int d)
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
	 * Creates a new {@code JulianDate}.
	 * 
	 * @param y  a julian year
	 * @param m  a julian month
	 * @param d  a julian day
	 */
	public JulianDate(long y, int m, int d)
	{
		this(y, Month.get(m), d);
	}
	
	/**
	 * Creates a new {@code JulianDate}.
	 * 
	 * @param y  a julian year
	 * @param m  a julian month
	 * @param d  a julian day
	 * 
	 * 
	 * @see Month
	 */
	public JulianDate(long y, Month m, int d)
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
		long weekday = daysUntilYear(year) + day - 3;
		return WeekDay.get((int) (Longs.mod(weekday, 7) + 1));
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