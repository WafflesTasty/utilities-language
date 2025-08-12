package waffles.utils.lang.metric.iso.date;

import waffles.utils.lang.metric.calendar.date.Year;
import waffles.utils.lang.metric.iso.date.ISOMonth.Lunar;
import waffles.utils.tools.primitives.Longs;

/**
 * An {@code ISOYear} defines a year in an {@code ISODate}.
 *
 * @author Waffles
 * @since 11 Aug 2025
 * @version 1.1
 *
 * 
 * @see Year
 */
public abstract class ISOYear implements Year
{	
	/**
	 * A {@code Gregorian ISOYear} follows the Gregorian calendar.
	 *
	 * @author Waffles
	 * @since 11 Aug 2025
	 * @version 1.1
	 *
	 * 
	 * @see ISOYear
	 */
	public static class Gregorian extends ISOYear
	{		
		/**
		 * Creates a new {@code Gregorian ISOYear}.
		 * 
		 * @param y  a gregorian year
		 * @param d  a gregorian days
		 */
		public Gregorian(long y, long d)
		{
			super(y, d);
		}

		/**
		 * Creates a new {@code Gregorian ISOYear}.
		 * 
		 * @param y  a gregorian year
		 * @param m  a gregorian month
		 * @param d  a gregorian days
		 * 
		 * 
		 * @see Lunar
		 */
		public Gregorian(long y, Lunar m, long d)
		{
			this(y, daysUpTo(y, m) + d);
		}
		
		/**
		 * Creates a new {@code Gregorian ISOYear}.
		 * 
		 * @param y  a gregorian year
		 * @param m  a gregorian month
		 * @param d  a gregorian days
		 */
		public Gregorian(long y, int m, long d)
		{
			this(y, Lunar.get(m), d);
		}

		
		static boolean isLeap(long y)
		{
			if(Longs.mod(y,   4) != 0) return false;
			if(Longs.mod(y, 100) != 0) return true;
			return Longs.mod(y, 400) == 0;
		}
				
		static long daysUpTo(long y, Lunar m)
		{
			long days = Lunar.daysUpTo(m);
			if(isLeap(y) && Lunar.FEBRUARY.ID() < m.ID())
			{
				days++;
			}
			
			return days;
		}
		
		@Override
		protected long approxYears(long d)
		{
			return (400 * d + 145600) / 146097;
		}
		
		@Override
		protected long daysUntil(long y)
		{
			return 365 * y - 366
				+ y / 4   + Longs.sign(Longs.mod(y,   4))
				- y / 100 - Longs.sign(Longs.mod(y, 100))
				+ y / 400 + Longs.sign(Longs.mod(y, 400));
		}
		
		@Override
		public boolean isLeap()
		{
			return isLeap(Index());
		}
	}
	
	/**
	 * A {@code Julian ISOYear} follows the Julian calendar.
	 *
	 * @author Waffles
	 * @since 11 Aug 2025
	 * @version 1.1
	 *
	 * 
	 * @see ISOYear
	 */
	public static class Julian extends ISOYear
	{
		/**
		 * Creates a new {@code Julian ISOYear}.
		 * 
		 * @param y  a julian year
		 * @param d  a julian days
		 */
		public Julian(long y, long d)
		{
			super(y, d);
		}

		/**
		 * Creates a new {@code Julian ISOYear}.
		 * 
		 * @param y  a julian year
		 * @param m  a julian month
		 * @param d  a julian days
		 * 
		 * 
		 * @see Lunar
		 */
		public Julian(long y, Lunar m, long d)
		{
			this(y, daysUpTo(y, m) + d);
		}
		
		/**
		 * Creates a new {@code Julian ISOYear}.
		 * 
		 * @param y  a julian year
		 * @param m  a julian month
		 * @param d  a julian days
		 */
		public Julian(long y, int m, long d)
		{
			this(y, Lunar.get(m), d);
		}
		
		
		static boolean isLeap(long y)
		{
			return Longs.mod(y, 4) == 0;
		}
				
		static long daysUpTo(long y, Lunar m)
		{
			long days = Lunar.daysUpTo(m);
			if(isLeap(y) && Lunar.FEBRUARY.ID() < m.ID())
			{
				days++;
			}
			
			return days;
		}
		
		@Override
		protected long approxYears(long d)
		{
			return (4 * d + 1460) / 1461;
		}
		
		@Override
		protected long daysUntil(long y)
		{
			return 365 * y - 366 + y / 4
				 + Longs.sign(Longs.mod(y, 4));
		}
		
		@Override
		public boolean isLeap()
		{
			return isLeap(Index());
		}
	}
	
	
	private long year, days;
	
	/**
	 * Creates a new {@code ISOYear}.
	 * 
	 * @param y  a year in the date
	 * @param d  a days in the year
	 */
	public ISOYear(long y, long d)
	{
		days = d + daysUntil(y);
		year = approxYears(days);
		days -= daysUntil(year);
		if(days > DayCount())
		{
			days -= DayCount();
			year++;
		}
	}
	
	
	/**
	 * Returns the approximate year of a days.
	 * This value is either correct, or 1 short.
	 * 
	 * @param d  a days since beginning of time
	 * @return  an approximate year
	 */
	protected abstract long approxYears(long d);
		
	/**
	 * Returns the days until a certain year.
	 * 
	 * @return  a days since beginning of time
	 */
	protected abstract long daysUntil(long y);
	
	/**
	 * Checks the leap year state of the {@code ISOYear}.
	 * 
	 * @return  {@code true} if a leap year
	 */
	public abstract boolean isLeap();
	
	/**
	 * Returns the total days up to the {@code ISOYear}.
	 * 
	 * @return  a days since beginning of time
	 */
	public long TotalDayCount()
	{
		return daysUntil(year) + days;
	}
	
	/**
	 * Returns the days count in the {@code ISOYear}.
	 * 
	 * @return  a days count
	 */
	public long DayCount()
	{
		return isLeap() ? 366 : 365;
	}
	
	
	@Override
	public long Index()
	{
		return year;
	}

	@Override
	public long Day()
	{
		return days;
	}
}