package waffles.utils.lang.metric.calendar;

import waffles.utils.lang.metric.calendar.format.TimeFormat;
import waffles.utils.lang.utilities.ISO;
import waffles.utils.lang.utilities.patterns.moments.ISOMomentary;
import waffles.utils.tools.primitives.Longs;

/**
 * The {@code Time} interface defines a generic time-like object.
 * It can be parsed into a string with a {@code TimeFormat}.
 * 
 * @author Waffles
 * @since 26 Jul 2020
 * @version 1.1
 * 
 * 
 * @see ISOMomentary
 */
public interface Time extends ISOMomentary<Time>
{		
	/**
	 * Returns the seconds of the {@code Time}.
	 * 
	 * @return  time seconds
	 */
	public abstract long Seconds();
	
	/**
	 * Returns the minutes of the {@code Time}.
	 * 
	 * @return  time minutes
	 */
	public abstract long Minutes();
	
	/**
	 * Returns the hours of the {@code Time}.
	 * 
	 * @return  time hours
	 */
	public abstract long Hours();


	@Override
	public default TimeFormat Formatter()
	{
		return Formatter(ISO.Format.LONG);
	}
	
	@Override
	public default TimeFormat Formatter(ISO.Format fmt)
	{
		switch(fmt)
		{
		case LONG:
			return TimeFormat.LONG;
		case SHORT:
			return TimeFormat.SHORT;
		default:
			return null;
		}
	}
		
	@Override
	public default int compareTo(Time t)
	{
		long h1 =   Hours();
		long h2 = t.Hours();
		
		long m1 =   Minutes();
		long m2 = t.Minutes();
		
		long s1 =   Seconds();
		long s2 = t.Seconds();
		
		
		long dh = Longs.sign(h1 - h2);
		long dm = Longs.sign(m1 - m2);
		long ds = Longs.sign(s1 - s2);
		
		if(dh != 0l)
			return (int) dh;
		if(dm != 0l)
			return (int) dm;
		return (int) ds;
	}
}