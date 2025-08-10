package waffles.utils.lang.calendar.iso;

import waffles.utils.lang.calendar.Date;
import waffles.utils.lang.calendar.iso.enums.Month;
import waffles.utils.lang.calendar.iso.enums.WeekDay;

/**
 * The {@code ISODate} interface defines a date that uses a historically accurate calendar.
 * </br> Until 4 October 1852, it makes use of the Julian calendar, and then switches
 * over to 15 October 1852 where it makes use of the Gregorian calendar.
 * This standard is given by {@code ISO-8601}.
 *
 * @author Waffles
 * @since 26 Jul 2020
 * @version 1.0
 * 
 * 
 * @see Date
 */
public interface ISODate extends Date
{
	/**
	 * Returns the month of the {@code Calendar}.
	 * 
	 * @return  a calendar month
	 * 
	 * 
	 * @see Month
	 */
	public abstract Month Month();
	
	/**
	 * Returns the weekday of the {@code Calendar}.
	 * 
	 * @return  a day of the week
	 * 
	 * 
	 * @see WeekDay
	 */
	public abstract WeekDay DayOfWeek();
	
	
	@Override
	public default long MonthOfYear()
	{
		return Month().Index();
	}
	
	@Override
	public default String WeekDayName()
	{
		return DayOfWeek().Name();
	}
	
	@Override
	public default String MonthName()
	{
		return Month().Name();
	}
}