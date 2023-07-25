package zeno.util.lang.time.iso;

import java.util.Calendar;

import zeno.util.lang.time.Date;
import zeno.util.lang.time.iso.calendars.GregorianDate;
import zeno.util.lang.time.iso.calendars.JulianDate;
import zeno.util.lang.time.iso.enums.Month;
import zeno.util.lang.time.iso.enums.WeekDay;
import zeno.util.lang.util.ISO;

/**
 * The {@code ISODate} interface defines a date that uses a historically accurate calendar.
 * </br> Until 4 October 1852, it makes use of the Julian calendar, and then switches
 * over to 15 October 1852 where it makes use of the Gregorian calendar.
 * This standard is given by {@code ISO-8601}.
 *
 * @author Waffles
 * @since 26 Jul 2020
 * @version 1.0
 * 
 * 
 * @see Date
 */
public interface ISODate extends Date
{
	/**
	 * Defines the first day of the Gregorian calendar, 15 October 1852.
	 */
	public static final GregorianDate FIRST_GREGORIAN = new GregorianDate(1582, Month.OCTOBER, 15);
	/**
	 * Defines the last day of the Julian calendar, 4 oktober 1852.
	 */
	public static final JulianDate LAST_JULIAN = new JulianDate(1582, Month.OCTOBER, 4);
	
	/**
	 * The {@code ExistenceError} is thrown when creating a non-existent {@code ISODate}.
	 *
	 * @author Waffles
	 * @since 26 Jul 2020
	 * @version 1.0
	 * 
	 * 
	 * @see RuntimeException
	 */
	public static class ExistenceError extends RuntimeException
	{
		private static final long serialVersionUID = 2899037336843828510L;

		
		/**
		 * Creates a new {@code ExistenceError}.
		 * 
		 * @param d  a target date
		 * 
		 *  
		 * @see Date
		 */
		public ExistenceError(Date d)
		{
			super("The date " + d.parse(ISO.Format.SHORT) + " does not exist in the ISO calendar.");
		}
	}

	
	/**
	 * Creates a new {@code ISODate}.
	 * 
	 * @param y  an iso year
	 * @param d  an iso day
	 * @return   a iso date object
	 */
	public static ISODate create(long y, int d)
	{
		ISODate date = new JulianDate(y, d);
		if(LAST_JULIAN.before(date))
		{
			date = new GregorianDate(y, d);
			if(FIRST_GREGORIAN.after(date))
			{
				throw new ExistenceError(date);
			}
		}
		
		return date;
	}
	
	/**
	 * Creates a new {@code ISODate}.
	 * 
	 * @param y  an iso year
	 * @param m  an iso month
	 * @param d  an iso day
	 * @return   a iso date object
	 */
	public static ISODate create(long y, int m, int d)
	{
		ISODate date = new JulianDate(y, m, d);
		if(LAST_JULIAN.before(date))
		{
			date = new GregorianDate(y, m, d);
			if(date.before(FIRST_GREGORIAN))
			{
				throw new ExistenceError(date);
			}
		}
		
		return date;
	}
	
	/**
	 * Converts a calendar into an {@code ISODate}.
	 * 
	 * @param cal  a calendar
	 * @return  an iso date
	 * 
	 * 
	 * @see Calendar
	 */
	public static ISODate from(Calendar cal)
	{
		int m = cal.get(Calendar.MONTH) + 1;
		int d = cal.get(Calendar.DAY_OF_MONTH);
		long y = cal.get(Calendar.YEAR);	
		
		return create(y, m, d);
	}
	
	/**
	 * Returns the current {@code ISODate}.
	 * 
	 * @return  a current date
	 */
	public static ISODate now()
	{
		return from(Calendar.getInstance());
	}
	
	
	/**
	 * Returns the month of the {@code Calendar}.
	 * 
	 * @return  a calendar month
	 * 
	 * 
	 * @see Month
	 */
	public abstract Month Month();
	
	/**
	 * Returns the weekday of the {@code Calendar}.
	 * 
	 * @return  a day of the week
	 * 
	 * 
	 * @see WeekDay
	 */
	public abstract WeekDay DayOfWeek();
	
	
	@Override
	public default long MonthOfYear()
	{
		return Month().Index();
	}
	
	@Override
	public default String WeekDayName()
	{
		return DayOfWeek().Name();
	}
	
	@Override
	public default String MonthName()
	{
		return Month().Name();
	}
}