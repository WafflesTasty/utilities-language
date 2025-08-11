package waffles.utils.lang.measure.iso.units;

import waffles.utils.lang.measure.iso.ISOMeasure;
import waffles.utils.lang.measure.iso.ISOPrefix;
import waffles.utils.lang.utilities.patterns.Labelled;

/**
 * An {@code ISOSecond} defines an {@code ISOMeasure} for time.
 *
 * @author Waffles
 * @since 11 Aug 2025
 * @version 1.1
 *
 * 
 * @see ISOMeasure
 */
public class ISOSecond extends ISOMeasure
{
	/**
	 * Defines the label of the {@code ISOSecond}.
	 */
	public static final String LABEL = "seconds";
	
	/**
	 * An {@code ISOSecond.Unit} defines a {@code Unit} for time.
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
	 * Creates a new {@code ISOSecond}.
	 * 
	 * @param v  an iso value
	 */
	public ISOSecond(double v)
	{
		super(v);
	}
		
	/**
	 * Creates a new {@code ISOSecond}.
	 * 
	 * @param v  an iso value
	 * @param p  an iso prefix
	 * 
	 * 
	 * @see ISOPrefix
	 */
	public ISOSecond(double v, ISOPrefix p)
	{
		super(v, p);
	}
	
	
	@Override
	public Labelled Unit()
	{
		return new Unit();
	}
}