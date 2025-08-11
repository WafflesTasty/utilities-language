package waffles.utils.lang.measure;

import waffles.utils.lang.measure.iso.ISOMetric;
import waffles.utils.lang.tokens.Token;
import waffles.utils.lang.tokens.format.Format;
import waffles.utils.lang.utilities.patterns.Labelled;
import waffles.utils.tools.patterns.properties.values.Valuable;

/**
 * A {@code Metric} defines a value with a unit of measure.
 *
 * @author Waffles
 * @since 10 Aug 2025
 * @version 1.1
 *
 * 
 * @see Valuable
 * @see Token
 */
@FunctionalInterface
public interface Metric extends Token, Valuable<Double>
{	
	/**
	 * Returns the prefix of the {@code Metric}.
	 * 
	 * @return  a measure prefix
	 * 
	 * 
	 * @see Prefix
	 */
	public default Prefix Prefix()
	{
		return () -> 0;
	}
	
	/**
	 * Returns the unit of the {@code Metric}.
	 * 
	 * @return  a measure unit
	 * 
	 * 
	 * @see Labelled
	 */
	public default Labelled Unit()
	{
		return () -> "";
	}


	@Override
	public default Format<?> Formatter()
	{
		return ISOMetric.STANDARD;
	}
}