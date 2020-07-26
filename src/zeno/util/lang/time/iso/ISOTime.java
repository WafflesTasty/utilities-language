package zeno.util.lang.time.iso;

import java.util.Calendar;

import zeno.util.lang.time.Time;

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
	/**
	 * Returns the current {@code Time} of today.
	 * 
	 * @return  a current time
	 * 
	 * 
	 * @see Time
	 */
	public static Time now()
	{
		Calendar c = Calendar.getInstance();
		
		long h = c.get(Calendar.HOUR_OF_DAY);
		long m = c.get(Calendar.MINUTE);
		long s = c.get(Calendar.SECOND);
		
		return new ISOTime(h, m, s);
	}

	
	private long hour, secs;
	
	/**
	 * Creates a new {@code ISOTime}.
	 * 
	 * @param h  an iso hour
	 */
	public ISOTime(long h)
	{
		this(h, 0, 0);
	}
	
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