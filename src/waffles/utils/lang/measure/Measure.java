package waffles.utils.lang.measure;

import waffles.utils.lang.measure.format.MeasureFormat;
import waffles.utils.lang.tokens.Token;
import waffles.utils.lang.tokens.format.Format;
import waffles.utils.lang.utilities.ISO;
import waffles.utils.lang.utilities.patterns.Labelled;
import waffles.utils.tools.patterns.properties.values.Valuable;

/**
 * A {@code Measure} defines a value with a unit of measure.
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
public interface Measure extends Token, Valuable<Double>
{
	/**
	 * Defines a {@code Format} for a standard measure string.
	 */
	public static MeasureFormat STANDARD = new MeasureFormat("§vvvvvvvv§ §P§§U§");
	
	/**
	 * Defines a {@code Format} for a scientific measure string.
	 */
	public static MeasureFormat SCIENTIFIC = new MeasureFormat("§vvvvvvvv§ x §E§ §U§");
	
	
	/**
	 * Returns the prefix of the {@code Measure}.
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
	 * Returns the unit of the {@code Measure}.
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
	
	
	/**
	 * Condenses the {@code Measure} into a string.
	 * 
	 * @param fmt  a format type
	 * @return  a measure string
	 */
	public default String condense(ISO.Format fmt)
	{
		return condense(Formatter(fmt));
	}
	
	/**
	 * Returns a {@code Measure} formatter.
	 * 
	 * @param fmt  a format type
	 * @return  a measure formatter
	 * 
	 * 
	 * @see Format
	 */
	public default Format<?> Formatter(ISO.Format fmt)
	{
		switch(fmt)
		{
		case LONG:
			return SCIENTIFIC;
		case SHORT:
			return STANDARD;
		default:
			return null;
		}
	}
	
	
	@Override
	public default Format<?> Formatter()
	{
		return Formatter(ISO.Format.SHORT);
	}
}