package waffles.utils.lang.utilities.patterns;

import waffles.utils.lang.tokens.format.Format;
import waffles.utils.lang.utilities.ISO;

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
	 * Returns a formatter for the {@code Momentary}.
	 * 
	 * @param fmt  a format type
	 * @return  a formatter
	 * 
	 * 
	 * @see Format
	 */
	public abstract Format<?> Formatter(ISO.Format fmt);

	/**
	 * Condenses the {@code Momentary} into a string.
	 * 
	 * @param fmt  a format type
	 * @return  a condensed string
	 */
	public default String condense(ISO.Format fmt)
	{
		return Formatter(fmt).castAndParse(this);
	}
	
	
	/**
	 * Check if this happened before a {@code Momentary}.
	 * 
	 * @param m  a momentary
	 * @return  {@code true} if this happened before
	 */
	public default boolean before(M m)
	{
		return compareTo(m) < 0;
	}

	/**
	 * Check if this happened after a {@code Momentary}.
	 * 
	 * @param m  a momentary
	 * @return  {@code true} if this happened after
	 */
	public default boolean after(M m)
	{
		return compareTo(m) > 0;
	}
}