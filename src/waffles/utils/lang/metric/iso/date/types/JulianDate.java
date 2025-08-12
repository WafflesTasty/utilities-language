package waffles.utils.lang.metric.iso.date.types;

import waffles.utils.lang.metric.iso.ISODate;
import waffles.utils.lang.metric.iso.date.ISOMonth.Lunar;
import waffles.utils.lang.metric.iso.date.ISOMonth;
import waffles.utils.lang.metric.iso.date.ISOWeek;
import waffles.utils.lang.metric.iso.date.ISOYear;

/**
 * The {@code JulianDate} class defines a proleptic Julian calendar as
 * an implementation of {@code ISODate}. This date is accurate
 * up to 4 October 1852.
 * 
 * @author Waffles
 * @since 25 Jul 2020
 * @version 1.0
 * 
 * 
 * @see ISODate
 */
public class JulianDate implements ISODate
{		
	private ISOYear year;
	
	/**
	 * Creates a new {@code JulianDate}.
	 * 
	 * @param y  a julian year
	 * @param d  a julian day
	 */
	public JulianDate(long y, int d)
	{
		year = new ISOYear.Julian(y, d);
	}
	
	/**
	 * Creates a new {@code JulianDate}.
	 * 
	 * @param y  a julian year
	 * @param m  a julian month
	 * @param d  a julian day
	 * 
	 * 
	 * @see Lunar
	 */
	public JulianDate(long y, Lunar m, int d)
	{
		year = new ISOYear.Julian(y, m, d);
	}
	
	/**
	 * Creates a new {@code JulianDate}.
	 * 
	 * @param y  a julian year
	 * @param m  a julian month
	 * @param d  a julian day
	 */
	public JulianDate(long y, int m, int d)
	{
		this(y, Lunar.get(m), d);
	}

	
	@Override
	public ISOYear Year()
	{
		return year;
	}

	@Override
	public ISOMonth Month()
	{
		return new ISOMonth(this);
	}

	@Override
	public ISOWeek Week()
	{
		return new ISOWeek.Julian(this);
	}
}