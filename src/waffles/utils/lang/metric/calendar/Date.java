package waffles.utils.lang.metric.calendar;

import waffles.utils.lang.metric.calendar.date.Month;
import waffles.utils.lang.metric.calendar.date.Week;
import waffles.utils.lang.metric.calendar.date.Year;
import waffles.utils.lang.metric.calendar.format.DateFormat;
import waffles.utils.lang.tokens.Token;
import waffles.utils.lang.utilities.ISO;
import waffles.utils.lang.utilities.patterns.Momentary;
import waffles.utils.tools.primitives.Longs;

/**
 * The {@code Date} interface defines a generic date-like object.
 *
 * @author Waffles
 * @since 26 Jul 2020
 * @version 1.1
 * 
 * 
 * @see Momentary
 * @see Token
 */
public interface Date extends Momentary<Date>, Token
{	
	/**
	 * Returns the week of the {@code Date}.
	 * 
	 * @return  a date week
	 * 
	 * 
	 * @see Week
	 */
	public abstract Week Week();
	
	/**
	 * Returns the month of the {@code Date}.
	 * 
	 * @return  a date month
	 * 
	 * 
	 * @see Month
	 */
	public abstract Month Month();
	
	/**
	 * Returns the year of the {@code Date}.
	 * 
	 * @return  a date year
	 * 
	 * 
	 * @see Year
	 */
	public abstract Year Year();
	
	
	@Override
	public default DateFormat Formatter()
	{
		return Formatter(ISO.Format.SHORT);
	}
	
	@Override
	public default DateFormat Formatter(ISO.Format fmt)
	{
		switch(fmt)
		{
		case LONG:
			return DateFormat.LONG;
		case SHORT:
			return DateFormat.SHORT;
		default:
			return null;
		}
	}
	
	@Override
	public default int compareTo(Date d)
	{
		long y1 =   Year().Index();
		long y2 = d.Year().Index();
		
		long d1 =   Year().Day();
		long d2 = d.Year().Day();
		
		
		long dy = Longs.sign(y1 - y2);
		long dd = Longs.sign(d1 - d2);
		
		if(dy != 0l)
			return (int) dy;
		return (int) dd;
	}
}