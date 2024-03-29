package waffles.utils.lang.time;

import waffles.utils.lang.Formattable;
import waffles.utils.lang.time.format.FMTTime;
import waffles.utils.lang.util.ISO;
import waffles.utils.tools.primitives.Longs;

/**
 * The {@code Time} interface defines a generic time-like object.
 *
 * @author Waffles
 * @since 26 Jul 2020
 * @version 1.1
 * 
 * 
 * @see Formattable
 * @see Comparable
 */
public interface Time extends Comparable<Time>, Formattable
{	
	/**
	 * Defines a {@code Format} for a short time string.
	 */
	public static FMTTime SHORT_TIME = new FMTTime("§hh§:§mm§", "§");
	
	/**
	 * Defines a {@code Format} for a long time string.
	 */
	public static FMTTime LONG_TIME = new FMTTime("§hh§:§mm§:§ss§", "§");
		
	
	@Override
	public default FMTTime Formatter()
	{
		return LONG_TIME;
	}
	
	@Override
	public default int compareTo(Time t)
	{
		if(Hours() < t.Hours()) return -1;
		if(t.Hours() < Hours()) return +1;
		if(Minutes() < t.Minutes()) return -1;
		if(t.Minutes() < Minutes()) return +1;
		return (int) Longs.sign(Seconds() - t.Seconds());
	}
	
	
	/**
	 * Parses an {@code ISO Format} from the {@code Time}.
	 * 
	 * @param fmt  an iso format
	 * @return  a parsed string
	 * 
	 * 
	 * @see String
	 * @see ISO
	 */
	public default String parse(ISO.Format fmt)
	{
		switch(fmt)
		{
		case SHORT:
			return parse(SHORT_TIME);
		case LONG:
			return parse(LONG_TIME);
		default:
			return null;
		}
	}
	
	/**
	 * Checks if the time exists before another {@code Time}.
	 * 
	 * @param d  a time to compare with
	 * @return  {@code true} if this time is earlier
	 */
	public default boolean before(Time d)
	{
		return compareTo(d) < 0;
	}
	
	/**
	 * Checks if the time exists after another {@code Time}.
	 * 
	 * @param d  a time to compare with
	 * @return  {@code true} if this time is later
	 */
	public default boolean after(Time d)
	{
		return compareTo(d) > 0;
	}
		
		
	/**
	 * Returns the seconds in the {@code Time}.
	 * 
	 * @return  a second
	 */
	public abstract long Seconds();
	
	/**
	 * Returns the minutes in the {@code Time}.
	 * 
	 * @return  a minute
	 */
	public abstract long Minutes();
	
	/**
	 * Returns the hours in the {@code Time}.
	 * 
	 * @return  an hour
	 */
	public abstract long Hours();
}