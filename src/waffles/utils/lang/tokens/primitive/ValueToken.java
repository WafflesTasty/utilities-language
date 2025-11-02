package waffles.utils.lang.tokens.primitive;

import waffles.utils.lang.tokens.Token;
import waffles.utils.lang.tokens.format.Format;
import waffles.utils.tools.patterns.properties.values.Valuable;

/**
 * A {@code ValueToken} mimics a {@code StringToken} for {@code Valuable} objects.
 *
 * @author Waffles
 * @since 02 Nov 2025
 * @version 1.1
 *
 *
 * @param <V>  a value type
 * @see Valuable
 * @see Token
 */
public class ValueToken<V> implements Valuable<V>, Token
{
	private Valuable<V> obj;

	/**
	 * Creates a new {@code ValueToken}.
	 * 
	 * @param o  a valuable object
	 * 
	 * 
	 * @see Valuable
	 */
	public ValueToken(Valuable<V> o)
	{
		obj = o;
	}

	/**
	 * Returns a formatter for the {@code StringToken}.
	 * 
	 * @param d  a string delimiter
	 * @return   a string formatter
	 * 
	 * 
	 * @see PrimitiveToken
	 * @see Format
	 */
	public Format<?> Formatter(char d)
	{
		return new StringToken(Value()).Formatter(s -> true, d);
	}
	
	
	@Override
	public Format<?> Formatter()
	{
		return Formatter('\'');
	}
	
	@Override
	public V Value()
	{
		return obj.Value();
	}
}