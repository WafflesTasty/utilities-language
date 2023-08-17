package waffles.utils.lang.math.measure;

import java.math.BigDecimal;

/**
 * The {@code Measure} interface defines a unit of measurement.
 * 
 * @author Waffles
 * @since Oct 1, 2016
 * @version 1.0
 * 
 * 
 * @see Quantity
 */
@FunctionalInterface
public interface Measure
{
	/**
	 * Converts a value from this unit to another {@code Measure}.
	 * 
	 * @param value  a value in this unit
	 * @param unit   a unit to convert to
	 * @return  a converted quantity
	 * 
	 * 
	 * @see BigDecimal
	 * @see Quantity
	 */
	public abstract Quantity convert(BigDecimal value, Measure unit);
}