package waffles.utils.lang.tokens.values;

import waffles.utils.lang.tokens.Token;
import waffles.utils.lang.tokens.format.Format;
import waffles.utils.lang.tokens.format.values.ValueFormat;
import waffles.utils.lang.tokens.format.values.ValueFormat.Hints;
import waffles.utils.tools.patterns.properties.values.Valuable;

/**
 * A {@code ValueToken} defines a token for a {@code Valuable} object.
 *
 * @author Waffles
 * @since 04 Nov 2025
 * @version 1.1
 *
 *
 * @param <O>  a value type
 * @see Valuable
 * @see Token
 */
public interface ValueToken<O> extends Valuable<O>, Token
{
	/**
	 * Returns a {@code ValueToken} formatter.
	 * 
	 * @param h  format hints
	 * @return  a formatter
	 * 
	 * 
	 * @see Format
	 * @see Hints
	 */
	public default Format<?> Formatter(Hints h)
	{
		return new ValueFormat<>(h);
	}
	
	@Override
	public default Format<?> Formatter()
	{
		return Formatter(() -> "");
	}
}