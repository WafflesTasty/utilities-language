package zeno.util.lang.time;

import zeno.util.lang.format.Format;
import zeno.util.lang.format.Formattable;
import zeno.util.lang.format.types.FMTTime;
import zeno.util.lang.util.ISO;
import zeno.util.tools.Longs;

/**
 * The {@code Time} interface defines a generic time-like object.
 *
 * @author Zeno
 * @since 26 Jul 2020
 * @version 1.0
 * 
 * 
 * @see Formattable
 * @see Comparable
 */
public interface Time extends Comparable<Time>, Formattable<Time>
{		
	/**
	 * Defines a {@code Format} for a long time string.
	 */
	public static FMTTime LONG_TIME = new FMTTime("%hh%:%mm%:%ss%");
	
	/**
	 * Defines a {@code Format} for a short time string.
	 */
	public static FMTTime SHORT_TIME = new FMTTime("%hh%:%mm%");
	
	
	/**
	 * Parses an {@code ISO Format} from the {@code Date}.
	 * 
	 * @param fmt  an iso format
	 * @return  a parsed string
	 * 
	 * 
	 * @see String
	 * @see ISO
	 */
	public default String toString(ISO.Format fmt)
	{
		switch(fmt)
		{
		case SHORT:
			return format(SHORT_TIME);
		case LONG:
			return format(LONG_TIME);
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
		
	
	@Override
	public default Format<Time> Formatter(String fmt)
	{
		return new FMTTime(fmt);
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