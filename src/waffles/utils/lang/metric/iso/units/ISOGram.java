package waffles.utils.lang.metric.iso.units;

import waffles.utils.lang.metric.iso.ISOMetric;
import waffles.utils.lang.metric.iso.ISOPrefix;
import waffles.utils.lang.utilities.patterns.Labelled;

/**
 * An {@code ISOGram} defines an {@code ISOMetric} for weight.
 *
 * @author Waffles
 * @since 11 Aug 2025
 * @version 1.1
 *
 * 
 * @see ISOMetric
 */
public class ISOGram extends ISOMetric
{
	/**
	 * Defines the label of the {@code ISOGram}.
	 */
	public static final String LABEL = "grams";
	
	/**
	 * An {@code ISOGram.Unit} defines a {@code Unit} for weight.
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
	 * Creates a new {@code ISOGram}.
	 * 
	 * @param v  an iso value
	 */
	public ISOGram(double v)
	{
		super(v);
	}
		
	/**
	 * Creates a new {@code ISOGram}.
	 * 
	 * @param v  an iso value
	 * @param p  an iso prefix
	 * 
	 * 
	 * @see ISOPrefix
	 */
	public ISOGram(double v, ISOPrefix p)
	{
		super(v, p);
	}
	
	
	@Override
	public Labelled Unit()
	{
		return new Unit();
	}
}