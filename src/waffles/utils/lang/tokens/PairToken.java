package waffles.utils.lang.tokens;

import waffles.utils.lang.tokens.format.Format;
import waffles.utils.lang.tokens.format.PairFormat;
import waffles.utils.sets.utilities.keymaps.Pair;

/**
 * A {@code PairToken} defines a {@code Token} consisting of a key-value {@code Pair}.
 * A {@link PairFormat} is used as a formatter using its default settings.
 *
 * @author Waffles
 * @since 15 Mar 2024
 * @version 1.1
 * 
 * 
 * @param <K>  a key type
 * @param <V>  a value type
 * @see Token
 * @see Pair
 */
public interface PairToken<K extends Token, V extends Token> extends Pair<K, V>, Token
{
	/**
	 * Returns a {@code PairToken} formatter.
	 * 
	 * @param s  a key-value separator
	 * @return   a pair formatter
	 * 
	 * 
	 * @see PairFormat
	 */
	public default Format<?> Formatter(char s)
	{
		return new PairFormat<>(s);
	}
	
	
	@Override
	public default Format<?> Formatter()
	{
		return new PairFormat<>();
	}
}