package waffles.utils.lang.calendar.iso;

import waffles.utils.lang.calendar.Time;

/**
 * The {@code ISOTime} class defines a time as stated by {@code ISO-8601}.
 *
 * @author Zeno
 * @since 26 Jul 2020
 * @version 1.0
 * 
 * 
 * @see Time
 */
public class ISOTime implements Time
{
	private long hour, secs;
		
	/**
	 * Creates a new {@code ISOTime}.
	 * 
	 * @param h  an iso hour
	 * @param m  an iso minute
	 */
	public ISOTime(long h, long m)
	{
		this(h, m, 0);
	}
	
	/**
	 * Creates a new {@code ISOTime}.
	 * 
	 * @param h  an iso hour
	 * @param m  an iso minute
	 * @param s  an iso second
	 */
	public ISOTime(long h, long m, long s)
	{
		hour = h + (60 * m + s) / 3600;
		secs = (60 * m + s) % 3600;
	}

	/**
	 * Creates a new {@code ISOTime}.
	 * 
	 * @param h  an iso hour
	 */
	public ISOTime(long h)
	{
		this(h, 0, 0);
	}
	
	
	@Override
	public long Seconds()
	{
		return secs % 60;
	}

	@Override
	public long Minutes()
	{
		return secs / 60;
	}

	@Override
	public long Hours()
	{
		return hour;
	}
}