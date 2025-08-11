package waffles.utils.lang.measure;

import waffles.utils.lang.utilities.patterns.Labelled;

/**
 * A {@code Prefix} defines the labelled exponent of a {@code Unit}.
 *
 * @author Waffles
 * @since 10 Aug 2025
 * @version 1.1
 *
 * 
 * @see Labelled
 */
@FunctionalInterface
public interface Prefix extends Labelled
{	
	/**
	 * Returns the radix of the {@code Prefix}.
	 * 
	 * @return  a radix
	 */
	public abstract int Radix();
	
	/**
	 * Returns the exponent of the {@code Prefix}.
	 * 
	 * @return  an exponent
	 */
	public default int Exponent()
	{
		return 0;
	}


	@Override
	public default String Label()
	{
		return "";
	}
}