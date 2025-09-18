package waffles.utils.lang.utilities.patterns.moments;

/**
 * A {@code Momentary} can check if other moments happened before or after.
 *
 * @author Waffles
 * @since 11 Aug 2025
 * @version 1.1
 *
 *
 * @param <C>  a comparable type
 * @see Comparable
 */
public interface Momentary<C> extends Comparable<C>
{
	/**
	 * Check if this happened before a {@code Momentary}.
	 * 
	 * @param c  a comparable
	 * @return  {@code true} if this exists before
	 */
	public default boolean isBefore(C c)
	{
		return compareTo(c) < 0;
	}

	/**
	 * Check if this happened after a {@code Momentary}.
	 * 
	 * @param c  a comparable
	 * @return  {@code true} if this exists after
	 */
	public default boolean isAfter(C c)
	{
		return compareTo(c) > 0;
	}
}