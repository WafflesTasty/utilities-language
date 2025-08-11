package waffles.utils.lang.measure.iso.units;

import waffles.utils.lang.measure.iso.ISOMetric;
import waffles.utils.lang.measure.iso.ISOPrefix;
import waffles.utils.lang.utilities.patterns.Labelled;

/**
 * An {@code ISOMeter} defines an {@code ISOMetric} for length.
 *
 * @author Waffles
 * @since 11 Aug 2025
 * @version 1.1
 *
 * 
 * @see ISOMetric
 */
public class ISOMeter extends ISOMetric
{
	/**
	 * Defines the label of the {@code ISOMeter}.
	 */
	public static final String LABEL = "meters";
	
	/**
	 * An {@code ISOMeter.Unit} defines a {@code Unit} for length.
	 *
	 * @author Waffles
	 * @since 11 Aug 2025
	 * @version 1.1
	 *
	 * 
	 * @see Labelled
	 */
	public static class Unit implements Labelled
	{
		@Override
		public String Label()
		{
			return LABEL;
		}	
	}
	
	
	/**
	 * Creates a new {@code ISOMeter}.
	 * 
	 * @param v  an iso value
	 */
	public ISOMeter(double v)
	{
		super(v);
	}
		
	/**
	 * Creates a new {@code ISOMeter}.
	 * 
	 * @param v  an iso val
	 * @param p  an iso pfx
	 * 
	 * 
	 * @see ISOPrefix
	 */
	public ISOMeter(double v, ISOPrefix p)
	{
		super(v, p);
	}
	
	
	@Override
	public Labelled Unit()
	{
		return new Unit();
	}
}