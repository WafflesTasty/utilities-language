package waffles.utils.lang.time;

import waffles.utils.lang.Format;
import waffles.utils.lang.Formattable;
import waffles.utils.lang.time.format.FMTDate;
import waffles.utils.lang.util.ISO;
import waffles.utils.tools.primitives.Longs;

/**
 * The {@code Date} interface defines a generic date-like object.
 *
 * @author Waffles
 * @since 26 Jul 2020
 * @version 1.1
 * 
 * 
 * @see Formattable
 * @see Comparable
 */
public interface Date extends Comparable<Date>, Formattable
{	
	/**
	 * Defines a {@code Format} for a long date string.
	 */
	public static FMTDate LONG_DATE = new FMTDate("§WEEKDAY§, §D§ §MONTH§ §Y§", "§");
	
	/**
	 * Defines a {@code Format} for a short date string.
	 */
	public static FMTDate SHORT_DATE = new FMTDate("§dd§-§mm§-§yyyy§", "§");
	
	
	@Override
	public default Format<Date> Formatter()
	{
		return SHORT_DATE;
	}
	
	@Override
	public default int compareTo(Date d)
	{
		if(Year() < d.Year()) return -1;
		if(d.Year() < Year()) return +1;
		return (int) Longs.sign(DayOfYear() - d.DayOfYear());
	}
	
	
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
	public default String parse(ISO.Format fmt)
	{
		switch(fmt)
		{
		case SHORT:
			return parse(SHORT_DATE);
		case LONG:
			return parse(LONG_DATE);
		default:
			return null;
		}
	}
		
	/**
	 * Checks if the date exists before another {@code Date}.
	 * 
	 * @param d  a date to compare with
	 * @return  {@code true} if this date is earlier
	 */
	public default boolean before(Date d)
	{
		return compareTo(d) < 0;
	}
	
	/**
	 * Checks if the date exists after another {@code Date}.
	 * 
	 * @param d  a date to compare with
	 * @return  {@code true} if this date is later
	 */
	public default boolean after(Date d)
	{
		return compareTo(d) > 0;
	}
			
	
	/**
	 * Returns the month name in the {@code Date}.
	 * 
	 * @return  a month name
	 * 
	 * 
	 * @see String
	 */
	public abstract String MonthName();
	
	/**
	 * Returns the week day name in the {@code Date}.
	 * 
	 * @return  a week day name
	 * 
	 * 
	 * @see String
	 */
	public abstract String WeekDayName();

	/**
	 * Returns the month of the year in the {@code Date}.
	 * 
	 * @return  a month of the year
	 */
	public abstract long MonthOfYear();
	
	/**
	 * Returns the day of the month in the {@code Date}.
	 * 
	 * @return  a day of the month
	 */
	public abstract long DayOfMonth();
	
	/**
	 * Returns the day of the year in the {@code Date}.
	 * 
	 * @return  a day of the year
	 */
	public abstract long DayOfYear();
	
	/**
	 * Returns the year in the {@code Date}.
	 * 
	 * @return  a year
	 */
	public abstract long Year();
}