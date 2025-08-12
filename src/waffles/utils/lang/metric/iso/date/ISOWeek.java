package waffles.utils.lang.metric.iso.date;

import waffles.utils.lang.metric.calendar.date.Week;
import waffles.utils.lang.metric.iso.ISODate;
import waffles.utils.lang.utilities.patterns.Labelled;
import waffles.utils.tools.patterns.properties.counters.Discernible;
import waffles.utils.tools.primitives.Longs;

/**
 * An {@code ISOWeek} defines a week in a {@code ISODate}.
 *
 * @author Waffles
 * @since 11 Aug 2025
 * @version 1.1
 *
 * 
 * @see Week
 */
public abstract class ISOWeek implements Week
{	
	/**
	 * An {@code ISOWeek.Day} defines all iso weekdays.
	 *
	 * @author Waffles
	 * @since 11 Aug 2025
	 * @version 1.1
	 * 
	 * 
	 * @see Discernible
	 * @see Labelled
	 */
	public static enum Day implements Discernible, Labelled
	{
		/**
		 * Day of Máni.
		 */
		MONDAY("Monday", 1),
		/**
		 * Day of Tyr.
		 */
		TUESDAY("Tuesday", 2),
		/**
		 * Day of Odin.
		 */
		WEDNESDAY("Wednesday", 3),
		/**
		 * Day of Thor.
		 */
		THURSDAY("Thursday", 4),
		/**
		 * Day of Frigg.
		 */
		FRIDAY("Friday", 5),
		/**
		 * Day of Saturn.
		 */
		SATURDAY("Saturday", 6),
		/**
		 * Day of Sól.
		 */
		SUNDAY("Sunday", 7);
		
		/**
		 * Returns an {@code ISOWeek.Day} by index.
		 * 
		 * @param id  a day index
		 * @return  a weekday
		 * 
		 * 
		 * @see Day
		 */
		public static Day get(int id)
		{
			for(Day t : Day.values())
			{
				if(t.ID() == id)
				{
					return t;
				}
			}
			
			return null;
		}
		

		private int index;
		private String name;
		
		private Day(String n, int i)
		{
			index = i;
			name = n;
		}


		@Override
		public String Label()
		{
			return name;
		}

		@Override
		public int ID()
		{
			return index;
		}
	}
	
	/**
	 * A {@code Gregorian ISOWeek} follows the Gregorian calendar.
	 *
	 * @author Waffles
	 * @since 11 Aug 2025
	 * @version 1.1
	 *
	 * 
	 * @see ISOYear
	 */
	public static class Gregorian extends ISOWeek
	{
		/**
		 * Creates a new {@code Gregorian ISOWeek}.
		 * 
		 * @param d  a parent date
		 * 
		 * 
		 * @see ISODate
		 */
		public Gregorian(ISODate d)
		{
			super(d);
		}

		@Override
		protected long Day()
		{
			return Date().Year().TotalDayCount() - 1;
		}
	}
	
	/**
	 * A {@code Julian ISOWeek} follows the Julian calendar.
	 *
	 * @author Waffles
	 * @since 11 Aug 2025
	 * @version 1.1
	 *
	 * 
	 * @see ISOYear
	 */
	public static class Julian extends ISOWeek
	{
		/**
		 * Creates a new {@code Julian ISOWeek}.
		 * 
		 * @param d  a parent date
		 * 
		 * 
		 * @see ISODate
		 */
		public Julian(ISODate d)
		{
			super(d);
		}

		@Override
		protected long Day()
		{
			return Date().Year().TotalDayCount() - 3;
		}
	}
	
	
	private ISODate date;
	
	/**
	 * Creates a new {@code ISOWeek}.
	 * 
	 * @param d  a parent date
	 * 
	 * 
	 * @see ISODate
	 */
	public ISOWeek(ISODate d)
	{
		date = d;
	}
	
	
	protected ISODate Date()
	{
		return date;
	}

	protected abstract long Day();
		
	@Override
	public String DayName()
	{
		return Day.get((int) (Longs.mod(Day(), 7) + 1)).Label();
	}
}
