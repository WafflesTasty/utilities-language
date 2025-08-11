package waffles.utils.lang.measure.iso;

import waffles.utils.lang.measure.Metric;
import waffles.utils.lang.measure.format.MetricFormat;

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
	/**
	 * Defines a {@code Format} for a standard metric string.
	 */
	public static MetricFormat STANDARD = new MetricFormat("§vvvvvvvv§ §P§§U§");
	
	/**
	 * Defines a {@code Format} for a scientific metric string.
	 */
	public static MetricFormat SCIENTIFIC = new MetricFormat("§vvvvvvvv§ x §R§^§E§");
	
	/**
	 * The {@code Format} defines basic isometric format types.
	 *
	 * @author Waffles
	 * @since 11 Aug 2025
	 * @version 1.1
	 */
	public static enum Format
	{
		/**
		 * Defines a scientific metric format.
		 */
		SCIENTIFIC,
		/**
		 * Defines a standard metric format.
		 */
		STANDARD;
	}
	
	
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
	
		
	/**
	 * Returns an {@code ISOMetric} formatter.
	 * 
	 * @param fmt  a format type
	 * @return  a metric formatter
	 * 
	 * 
	 * @see MetricFormat
	 * @see Format
	 */
	public MetricFormat Formatter(Format fmt)
	{
		switch(fmt)
		{
		case SCIENTIFIC:
			return SCIENTIFIC;
		case STANDARD:
			return STANDARD;
		default:
			return null;
		}
	}
	
	/**
	 * Condenses the metric into a string.
	 * 
	 * @param fmt  a format type
	 * @return   a metric string
	 */
	public String condense(Format fmt)
	{
		return condense(Formatter(fmt));
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