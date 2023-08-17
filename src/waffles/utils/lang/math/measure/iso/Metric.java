package waffles.utils.lang.math.measure.iso;

import java.math.BigDecimal;

import waffles.utils.lang.math.measure.Measure;
import waffles.utils.lang.math.measure.Quantity;

/**
 * The {@code Metric} class defines quantity units according to the metric system.
 * 
 * @author Waffles
 * @since Oct 1, 2016
 * @version 1.0
 * 
 * 
 * @see Measure
 */
public class Metric implements Measure
{
	/**
	 * The {@code exa-} unit.
	 */
	public static final Metric EXA   = new Metric(+18, "E");
	/**
	 * The {@code peta-} unit.
	 */
	public static final Metric PETA  = new Metric(+15, "P");
	/**
	 * The {@code tera-} unit.
	 */
	public static final Metric TERA  = new Metric(+12, "T");
	/**
	 * The {@code giga-} unit.
	 */
	public static final Metric GIGA  = new Metric( +9, "G");
	/**
	 * The {@code mega-} unit.
	 */
	public static final Metric MEGA  = new Metric( +6, "M");
	/**
	 * The {@code kilo-} unit.
	 */
	public static final Metric KILO  = new Metric( +3, "k");
	/**
	 * The {@code hecto-} unit.
	 */
	public static final Metric HECTO = new Metric( +2, "h");
	/**
	 * The {@code deca-} unit.
	 */
	public static final Metric DECA  = new Metric( +1, "da");
	/**
	 * The base metric unit.
	 */
	public static final Metric NONE  = new Metric(  0, "");
	/**
	 * The {@code deci-} unit.
	 */
	public static final Metric DECI  = new Metric( -1, "d");
	/**
	 * The {@code centi-} unit.
	 */
	public static final Metric CENTI = new Metric( -2, "c");
	/**
	 * The {@code milli-} unit.
	 */
	public static final Metric MILLI = new Metric( -3, "m");
	/**
	 * The {@code micro-} unit.
	 */
	public static final Metric MICRO = new Metric( -6, "\u00B5");
	/**
	 * The {@code nano-} unit.
	 */
	public static final Metric NANO  = new Metric( -9, "n");
	/**
	 * The {@code pico-} unit.
	 */
	public static final Metric PICO  = new Metric(-12, "p");
	/**
	 * The {@code femto-} unit.
	 */
	public static final Metric FEMTO = new Metric(-15, "f");
	/**
	 * The {@code atto-} unit.
	 */
	public static final Metric ATTO  = new Metric(-18, "a");
	
	/**
	 * Returns a metric corresponding to an exponent of ten.
	 * 
	 * @param exp  an exponent value
	 * @return  a metric unit
	 */
	public static Metric get(int exp)
	{
		switch(exp)
		{
		case +18: return EXA;
		case +15: return PETA;
		case +12: return TERA;
		case +9:  return GIGA;
		case +6:  return MEGA;
		case +3:  return KILO;
		case +2:  return HECTO;
		case +1:  return DECA;
		case  0:  return NONE;
		case -1:  return DECI;
		case -2:  return CENTI;
		case -3:  return MILLI;
		case -6:  return MICRO;
		case -9:  return NANO;
		case -12: return PICO;
		case -15: return FEMTO;
		case -18: return ATTO;
		}
		
		return new Metric(exp, "");
	}
	
	
	
	private int exp;
	private String prefix;
	
	/**
	 * Creates a new {@code Metric}.
	 * 
	 * @param exp  an exponent value
	 * @param pfx  a metric prefix
	 */
	public Metric(int exp, String pfx)
	{
		this.prefix = pfx;
		this.exp = exp;
	}

	/**
	 * Returns the prefix of the {@code Metric}.
	 * 
	 * @return  a metric prefix
	 * 
	 * 
	 * @see String
	 */
	public String Prefix()
	{
		return prefix;
	}
	
	
	@Override
	public Quantity convert(BigDecimal value, Measure unit)
	{
		if(unit instanceof Metric)
		{
			int oExp = exp - ((Metric) unit).exp;
			BigDecimal val = value.scaleByPowerOfTen(oExp);
			return new Quantity(val, unit);
		}
		
		return null;
	}
	
	@Override
	public String toString()
	{
		return Prefix();
	}
}