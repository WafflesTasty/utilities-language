package waffles.utils.lang.measure.iso;

import waffles.utils.lang.measure.Metric;

/**
 * An {@code ISOMetric} implements a {@code Metric} according to the iso standard.
 *
 * @author Waffles
 * @since 10 Aug 2025
 * @version 1.1
 * 
 * 
 * @see Metric
 */
public class ISOMetric implements Metric
{
	private double val;
	private ISOPrefix pfx;
	
	/**
	 * Creates a new {@code ISOMetric}.
	 * 
	 * @param v  an iso value
	 */
	public ISOMetric(double v)
	{
		this(v, ISOPrefix.NONE);
	}
	
	/**
	 * Creates a new {@code ISOMetric}.
	 * 
	 * @param v  an iso value
	 * @param p  an iso prefix
	 * 
	 * 
	 * @see ISOPrefix
	 */
	public ISOMetric(double v, ISOPrefix p)
	{
		pfx = p;
		val = v;
	}
	
	
	@Override
	public ISOPrefix Prefix()
	{
		return pfx;
	}
	
	@Override
	public Double Value()
	{
		return val;
	}
}