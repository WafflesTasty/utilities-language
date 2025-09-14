package waffles.utils.lang.utilities.patterns.moments;

import waffles.utils.lang.tokens.format.Format;
import waffles.utils.lang.utilities.ISO;

/**
 * An {@code ISOMomentary} defines a {@code Momentary} for ISO metrics.
 *
 * @author Waffles
 * @since 11 Aug 2025
 * @version 1.1
 *
 *
 * @param <M>  a momentary type
 * @see Momentary
 */
public interface ISOMomentary<M extends ISOMomentary<?>> extends Momentary<M>
{
	/**
	 * Returns a formatter for the {@code ISOMomentary}.
	 * 
	 * @param fmt  a format type
	 * @return  a formatter
	 * 
	 * 
	 * @see Format
	 */
	public abstract Format<?> Formatter(ISO.Format fmt);

	/**
	 * Condenses the {@code ISOMomentary} into a string.
	 * 
	 * @param fmt  a format type
	 * @return  a condensed string
	 */
	public default String condense(ISO.Format fmt)
	{
		return Formatter(fmt).castAndParse(this);
	}
}