package waffles.utils.lang.measure.iso;

import waffles.utils.lang.measure.Measure;

/**
 * An {@code ISOMeasure} implements a {@code Measure} according to the iso standard.
 *
 * @author Waffles
 * @since 10 Aug 2025
 * @version 1.1
 * 
 * 
 * @see Measure
 */
public class ISOMeasure implements Measure
{
	private double val;
	private ISOPrefix pfx;
	
	/**
	 * Creates a new {@code ISOMeasure}.
	 * 
	 * @param v  an iso value
	 */
	public ISOMeasure(double v)
	{
		this(v, ISOPrefix.NONE);
	}
	
	/**
	 * Creates a new {@code ISOMeasure}.
	 * 
	 * @param v  an iso value
	 * @param p  an iso prefix
	 * 
	 * 
	 * @see ISOPrefix
	 */
	public ISOMeasure(double v, ISOPrefix p)
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