package waffles.utils.lang.utilities.patterns.moments;

/**
 * A {@code Momentary} can check if other moments happened before or after.
 *
 * @author Waffles
 * @since 11 Aug 2025
 * @version 1.1
 *
 *
 * @param <M>  a momentary type
 * @see Comparable
 */
public interface Momentary<M extends Momentary<?>> extends Comparable<M>
{
	/**
	 * Check if this happened before a {@code Momentary}.
	 * 
	 * @param m  a momentary
	 * @return  {@code true} if this happened before
	 */
	public default boolean isBefore(M m)
	{
		return compareTo(m) < 0;
	}

	/**
	 * Check if this happened after a {@code Momentary}.
	 * 
	 * @param m  a momentary
	 * @return  {@code true} if this happened after
	 */
	public default boolean isAfter(M m)
	{
		return compareTo(m) > 0;
	}
}