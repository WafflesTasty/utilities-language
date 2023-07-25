package zeno.util.lang.time.iso.date;

/**
 * The {@code WeekDay} enum defines all days in an ISO calendar week.
 *
 * @author Waffles
 * @since 25 Jul 2020
 * @version 1.0
 */
public enum WeekDay
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
	 * Returns the {@code WeekDay} at the specified index.
	 * 
	 * @param index  a week day index
	 * @return  a target week day
	 * 
	 * 
	 * @see WeekDay
	 */
	public static WeekDay get(int index)
	{
		for(WeekDay m : values())
		{
			if(m.Index() == index)
			{
				return m;
			}
		}
		
		return null;
	}
	
	
	private int index;
	private String name;
	
	private WeekDay(String name, int index)
	{
		this.index = index;
		this.name = name;
	}
	
	/**
	 * Returns the name of the {@code WeekDay}.
	 * 
	 * @return  a week day name
	 * 
	 * 
	 * @see String
	 */
	public String Name()
	{
		return name;
	}
	
	/**
	 * Returns the index of the {@code WeekDay}.
	 * 
	 * @return  a week day index
	 */
	public int Index()
	{
		return index;
	}
}