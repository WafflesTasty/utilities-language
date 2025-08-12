package waffles.utils.lang.metric.iso.date.types;

import waffles.utils.lang.metric.iso.ISODate;
import waffles.utils.lang.metric.iso.date.ISOMonth;
import waffles.utils.lang.metric.iso.date.ISOMonth.Lunar;
import waffles.utils.lang.metric.iso.date.ISOWeek;
import waffles.utils.lang.metric.iso.date.ISOYear;

/**
 * A {@code GregorianDate} defines a proleptic Gregorian calendar as
 * an implementation of {@code ISODate}. This date is accurate
 * from 15 October 1852 onwards.
 * 
 * @author Waffles
 * @since 25 Jul 2020
 * @version 1.0
 * 
 * 
 * @see ISODate
 */
public class GregorianDate implements ISODate
{
	private ISOYear year;
	
	/**
	 * Creates a new {@code GregorianDate}.
	 * 
	 * @param y  a gregorian year
	 * @param d  a gregorian day
	 */
	public GregorianDate(long y, int d)
	{
		year = new ISOYear.Gregorian(y, d);
	}
	
	/**
	 * Creates a new {@code GregorianDate}.
	 * 
	 * @param y  a gregorian year
	 * @param m  a gregorian month
	 * @param d  a gregorian day
	 * 
	 * 
	 * @see Lunar
	 */
	public GregorianDate(long y, Lunar m, int d)
	{
		year = new ISOYear.Gregorian(y, m, d);
	}
	
	/**
	 * Creates a new {@code GregorianDate}.
	 * 
	 * @param y  a gregorian year
	 * @param m  a gregorian month
	 * @param d  a gregorian day
	 */
	public GregorianDate(long y, int m, int d)
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
		return new ISOWeek.Gregorian(this);
	}
}