package waffles.utils.lang.tokens;

import waffles.utils.lang.tokens.format.Format;
import waffles.utils.lang.tokens.format.ListFormat;

/**
 * A {@code ListToken} defines a {@code Token} consisting of a {@code Token} list.
 * A {@link ListFormat} is used as a formatter using its default settings.
 *
 * @author Waffles
 * @since 15 Mar 2024
 * @version 1.1
 * 
 * 
 * @param <T>  a token type
 * @see Token
 */
public interface ListToken<T extends Token> extends Token
{
	/**
	 * Returns the tokens of the {@code ListToken}.
	 * 
	 * @return  a token iterable
	 * 
	 * 
	 * @see Iterable
	 */
	public abstract Iterable<T> Tokens();
	
	
	@Override
	public default Format<?> Formatter()
	{
		return new ListFormat<>();
	}
}