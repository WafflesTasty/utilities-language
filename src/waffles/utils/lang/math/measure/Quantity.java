package waffles.utils.lang.math.measure;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * A {@code Quantity} represents a value of arbitrary precision that can be expressed in units.
 * The corresponding {@code Quantity.Unit} interface represents what unit the quantity is
 * expressed as, and allows conversion to other units.
 * 
 * 
 * @author Waffles
 * @since Oct 1, 2016
 * @version 1.0
 */
public class Quantity
{
	private Measure unit;
	private BigDecimal value;
	
	/**
	 * Creates a new {@code Quantity}.
	 * 
	 * @param value  a quantity value
	 * @param unit   a quatity unit
	 * 
	 * 
	 * @see BigDecimal
	 * @see Measure
	 */
	public Quantity(BigDecimal value, Measure unit)
	{
		this.value = value;
		this.unit  = unit;
	}
	
	/**
	 * Returns this quantity's value converted to a set of measures.
	 * 
	 * @param units  a set of units of measure
	 * @return  a set of quantities
	 * 
	 * 
	 * @see Measure
	 */
	public Quantity[] as(Measure... units)
	{
		int count = units.length;
		
		BigDecimal residu = Value();
		Quantity[] values = new Quantity[count + 1];
		for(int i = 0; i < count; i++)
		{
			Quantity cvt = Unit().convert(residu, units[i]);
			values[i] = new Quantity(cvt.Whole(), units[i]);
			cvt = units[i].convert(cvt.Fraction(), Unit());
			residu = cvt.Value();
		}
		
		values[count] = new Quantity(residu, Unit());
		
		return values;
	}

	/**
	 * Returns this quantity's value converted to another measure.
	 * 
	 * @param unit  a new unit of measure
	 * @return  a converted quantity
	 * 
	 * 
	 * @see Measure
	 */
	public Quantity as(Measure unit)
	{
		return Unit().convert(Value(), unit);
	}
	
	
	/**
	 * Returns the value of the {@code Quantity}.
	 * 
	 * @return  a quantity value
	 * 
	 * 
	 * @see BigDecimal
	 */
	public BigDecimal Value()
	{
		return value;
	}
	
	/**
	 * Returns the fractional part of the {@code Quantity}.
	 * 
	 * @return  a fractional part
	 * 
	 * 
	 * @see BigDecimal
	 */
	public BigDecimal Fraction()
	{
		return value.remainder(BigDecimal.ONE);
	}
	
	/**
	 * Returns the whole part of the {@code Quantity}.
	 * 
	 * @return  a whole part
	 * 
	 * 
	 * @see BigDecimal
	 */
	public BigDecimal Whole()
	{
		return value.setScale(0, RoundingMode.DOWN);
	}

	/**
	 * Returns the unit of the {@code Quantity}.
	 * 
	 * @return  a unit of measure
	 */
	public Measure Unit()
	{
		return unit;
	}	
}