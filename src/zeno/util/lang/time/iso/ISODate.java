package zeno.util.lang.time.iso;

import java.util.Calendar;

import zeno.util.lang.time.Date;
import zeno.util.lang.time.iso.date.Month;
import zeno.util.lang.time.iso.date.WeekDay;
import zeno.util.lang.time.iso.types.GregorianDate;
import zeno.util.lang.time.iso.types.JulianDate;
import zeno.util.lang.util.ISO;

/**
 * The {@code ISODate} class defines a date that uses a historically accurate calendar.
 * </br> Until 4 October 1852, it makes use of the Julian calendar, and then switches
 * over to 15 October 1852 where it makes use of the Gregorian calendar.
 *
 * @author Waffles
 * @since 26 Jul 2020
 * @version 1.0
 * 
 * 
 * @see Date
 */
public class ISODate implements Date
{
	private static final GregorianDate FIRST_GREGORIAN = new GregorianDate(1582, Month.OCTOBER, 15);
	private static final JulianDate LAST_JULIAN = new JulianDate(1582, Month.OCTOBER, 4);
	
	/**
	 * The {@code ExistenceError} class defines an error thrown on creating a non-existent {@code Date}.
	 *
	 * @author Zeno
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
			super("The date " + d.toString(ISO.Format.SHORT) + " does not exist.");
		}
	}
	
	/**
	 * Converts a calendar into an {@code ISODate}.
	 * 
	 * @param cal  a calendar
	 * @return  an iso date
	 * 
	 * 
	 * @see Calendar
	 * @see ISODate
	 */
	public static ISODate from(Calendar cal)
	{
		int m = cal.get(Calendar.MONTH) + 1;
		int d = cal.get(Calendar.DAY_OF_MONTH);
		long y = cal.get(Calendar.YEAR);	
		
		return new ISODate(y, m, d);
	}
	
	/**
	 * Returns the current {@code Date} of today.
	 * 
	 * @return  a current date
	 * 
	 * 
	 * @see Date
	 */
	public static ISODate now()
	{
		return from(Calendar.getInstance());
	}

	
	private Date date;
	
	/**
	 * Creates a new {@code ISODate}.
	 * 
	 * @param y  an iso year
	 * @param d  an iso day
	 */
	public ISODate(long y, int d)
	{
		date = new JulianDate(y, d);
		if(LAST_JULIAN.before(date))
		{
			date = new GregorianDate(y, d);
			if(FIRST_GREGORIAN.after(date))
			{
				throw new ExistenceError(date);
			}
		}
	}
	
	/**
	 * Creates a new {@code JulianDate}.
	 * 
	 * @param y  an iso year
	 * @param m  an iso month
	 * @param d  an iso day
	 */
	public ISODate(long y, int m, int d)
	{
		this(y, Month.get(m), d);
	}
	
	/**
	 * Creates a new {@code JulianDate}.
	 * 
	 * @param y  an iso year
	 * @param m  an iso month
	 * @param d  an iso day
	 * 
	 * 
	 * @see Month
	 */
	public ISODate(long y, Month m, int d)
	{
		date = new JulianDate(y, m, d);
		if(LAST_JULIAN.before(date))
		{
			date = new GregorianDate(y, m, d);
			if(date.before(FIRST_GREGORIAN))
			{
				throw new ExistenceError(date);
			}
		}
	}


	@Override
	public Month Month()
	{
		return date.Month();
	}

	@Override
	public WeekDay DayOfWeek()
	{
		return date.DayOfWeek();
	}
	
	@Override
	public long DayOfMonth()
	{
		return date.DayOfMonth();
	}

	@Override
	public long DayOfYear()
	{
		return date.DayOfYear();
	}
	
	@Override
	public long Year()
	{
		return date.Year();
	}
}