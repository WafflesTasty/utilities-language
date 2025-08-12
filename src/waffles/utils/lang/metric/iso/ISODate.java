package waffles.utils.lang.metric.iso;

import waffles.utils.lang.metric.calendar.Date;
import waffles.utils.lang.metric.iso.date.ISOMonth;
import waffles.utils.lang.metric.iso.date.ISOWeek;
import waffles.utils.lang.metric.iso.date.ISOYear;

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
	@Override
	public abstract ISOYear Year();

	@Override
	public abstract ISOMonth Month();
	
	@Override
	public abstract ISOWeek Week();
}