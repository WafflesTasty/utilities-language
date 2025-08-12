package waffles.utils.lang.metric.iso.date;

import waffles.utils.lang.metric.calendar.date.Month;
import waffles.utils.lang.metric.iso.ISODate;
import waffles.utils.lang.utilities.patterns.Labelled;
import waffles.utils.tools.patterns.properties.counters.Discernible;

/**
 * An {@code ISOMonth} defines a month in an {@code ISODate}.
 *
 * @author Waffles
 * @since 11 Aug 2025
 * @version 1.1
 *
 * 
 * @see Month
 */
public class ISOMonth implements Month
{		
	/**
	 * An {@code ISOMonth.Lunar} defines all lunar iso months.
	 *
	 * @author Waffles
	 * @since 11 Aug 2025
	 * @version 1.1
	 * 
	 * 
	 * @see Discernible
	 * @see Labelled
	 */
	public static enum Lunar implements Discernible, Labelled
	{
		/**
		 * Month of Janus, god of beginnings and transitions.
		 */
		JANUARY("January", 1),
		/**
		 * Month of Februa, the purification.
		 */
		FEBRUARY("February", 2),
		/**
		 * Month of Mars, the god of war.
		 */
		MARCH("March", 3),
		/**
		 * Month of Aphrodite, the goddess of beauty.
		 */
		APRIL("April", 4),
		/**
		 * Month of Maia, goddess of fertility.
		 */
		MAY("May", 5),
		/**
		 * Month of Juno, wife of Jupiter, king of the gods.
		 */
		JUNE("June", 6),
		/**
		 * Month of Julius Caesar, great Roman warlord emperor.
		 */
		JULY("July", 7),
		/**
		 * Month of Augustus, first Roman emperor.
		 */
		AUGUST("August", 8),
		/**
		 * The seventh Roman month.
		 */
		SEPTEMBER("September", 9),
		/**
		 * The eighth Roman month.
		 */
		OCTOBER("October", 10),
		/**
		 * The ninth Roman month.
		 */
		NOVEMBER("November", 11),
		/**
		 * The tenth Roman month.
		 */
		DECEMBER("December", 12);
		
		/**
		 * Returns the days up to a {@code Lunar}.
		 * 
		 * @param m  a lunar month
		 * @return  a day count
		 */
		public static long daysUpTo(Lunar m)
		{
			long days = 0;
			for(int i = 1; i < m.ID(); i++)
			{
				days += get(i).Days();
			}
			
			return days;
		}
		
		/**
		 * Returns a {@code Lunar} by index.
		 * 
		 * @param i  a lunar index
		 * @return    an iso month
		 */
		public static Lunar get(int i)
		{
			return values()[i-1];
		}
		

		private int index;
		private String name;
		
		private Lunar(String n, int i)
		{
			index = i;
			name = n;
		}

		/**
		 * Returns the days of the month.
		 * 
		 * @return  a day count
		 */
		public long Days()
		{
			switch(this)
			{
			case FEBRUARY:
				return 28;
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

	
	private ISODate date;
	
	/**
	 * Creates a new {@code ISOMonth}.
	 * 
	 * @param d  a parent date
	 * 
	 * 
	 * @see ISODate
	 */
	public ISOMonth(ISODate d)
	{
		date = d;
	}
	
	/**
	 * Returns the lunar of the {@code ISOMonth}.
	 * 
	 * @return  a lunar type
	 * 
	 * 
	 * @see Lunar
	 */
	public Lunar Lunar()
	{
		long days = date.Year().Day();
		for(int i = 1; i <= Lunar.values().length; i++)
		{			
			Lunar m = Lunar.get(i);
			if(m == Lunar.FEBRUARY && date.Year().isLeap())
			{
				days--;
			}
			
			days -= m.Days();
			if(days <= 0)
			{
				return m;
			}
		}

		return null;
	}
	
	/**
	 * Returns the days up to the {@code ISOMonth}.
	 * 
	 * @return  a day count
	 */
	public long Days()
	{
		Lunar m = Lunar();
		if(m.ID() > Lunar.FEBRUARY.ID())
		{
			if(date.Year().isLeap())
			{
				return Lunar.daysUpTo(m) + 1;
			}
		}
		
		return Lunar.daysUpTo(m);
	}
		
	
	long Days(Lunar m)
	{
		long days = 0;
		for(int i = 1; i < m.ID(); i++)
		{
			Lunar month = Lunar.get(i);
			if(month == Lunar.FEBRUARY && date.Year().isLeap())
			{
				days++;
			}
			
			days += month.Days();
		}
		
		return days;
	}
	
	@Override
	public String Label()
	{
		return Lunar().Label();
	}
	
	@Override
	public long Day()
	{
		long days = date.Year().Day();
		for(Lunar type : Lunar.values())
		{
			long count = type.Days();
			if(type == Lunar.FEBRUARY
			&& date.Year().isLeap())
			{
				count++;
			}
			
			if(days <= count)
				return (int) days;
			days -= count;
		}
		
		return 0;
	}
	
	@Override
	public int ID()
	{
		return Lunar().ID();
	}
}