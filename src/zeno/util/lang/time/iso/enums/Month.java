package zeno.util.lang.time.iso.enums;

/**
 * The {@code Month} enum defines all months in an ISO calender year.
 *
 * @author Waffles
 * @since 25 Jul 2020
 * @version 1.0
 */
public enum Month
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
	 * Returns the {@code Month} at the specified index.
	 * 
	 * @param index  a month index
	 * @return  a target month
	 * 
	 * 
	 * @see Month
	 */
	public static Month get(int index)
	{
		for(Month m : values())
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
	
	private Month(String name, int index)
	{
		this.index = index;
		this.name = name;
	}
	
	/**
	 * Returns the name of the {@code Month}.
	 * 
	 * @return  a month name
	 * 
	 * 
	 * @see String
	 */
	public String Name()
	{
		return name;
	}
	
	/**
	 * Returns the index of the {@code Month}.
	 * 
	 * @return  a month index
	 */
	public int Index()
	{
		return index;
	}
}