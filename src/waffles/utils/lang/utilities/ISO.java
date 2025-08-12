package waffles.utils.lang.utilities;

import java.util.Calendar;

import waffles.utils.lang.metric.iso.ISODate;
import waffles.utils.lang.metric.iso.ISOTime;
import waffles.utils.lang.metric.iso.date.ISOMonth.Lunar;
import waffles.utils.lang.metric.iso.date.types.GregorianDate;
import waffles.utils.lang.metric.iso.date.types.JulianDate;
import waffles.utils.lang.utilities.errors.DateError;

/**
 * The {@code ISO} class defines utilities for the ISO standard.
 *
 * @author Waffles
 * @since 26 Jul 2020
 * @version 1.0
 */
public final class ISO
{
	/**
	 * An {@code ISO.Format} formats {@code ISODate} and {@code ISOTime} objects.
	 *
	 * @author Waffles
	 * @since 26 Jul 2020
	 * @version 1.0
	 */
	public static enum Format
	{
		/**
		 * A short ISO format.
		 */
		SHORT,
		/**
		 * A long ISO format.
		 */
		LONG;
	}
		
	/**
	 * The {@code Date} class provides static-access {@code ISODate} methods.
	 *
	 * @author Waffles
	 * @since 10 Aug 2025
	 * @version 1.1
	 */
	public static class Date
	{
		/**
		 * Defines the last day of the Julian calendar, 4 October 1852.
		 */
		public static final JulianDate LAST_JULIAN = new JulianDate(1582, Lunar.OCTOBER, 4);
		
		/**
		 * Defines the first day of the Gregorian calendar, 15 October 1852.
		 */
		public static final GregorianDate FIRST_GREGORIAN = new GregorianDate(1582, Lunar.OCTOBER, 15);
		
		
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
					throw new DateError(date);
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
					throw new DateError(date);
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
		
		
		private Date()
		{
			// NOT APPLICABLE
		}
	}
	
	/**
	 * The {@code Time} class provides static-access {@code ISOTime} methods.
	 *
	 * @author Waffles
	 * @since 10 Aug 2025
	 * @version 1.1
	 */
	public static class Time
	{
		/**
		 * Returns the current {@code Time} of today.
		 * 
		 * @return  a current time
		 * 
		 * 
		 * @see ISOTime
		 */
		public static ISOTime now()
		{
			Calendar c = Calendar.getInstance();
			
			long h = c.get(Calendar.HOUR_OF_DAY);
			long m = c.get(Calendar.MINUTE);
			long s = c.get(Calendar.SECOND);
			
			return new ISOTime(h, m, s);
		}
		
		
		private Time()
		{
			// NOT APPLICABLE
		}
	}
	
	
	private ISO()
	{
		// NOT APPLICABLE
	}
}