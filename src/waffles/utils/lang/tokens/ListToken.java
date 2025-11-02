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
	
	
	/**
	 * Returns a {@code ListToken} formatter.
	 * 
	 * @param low  a lower delimiter
	 * @param sep  a character separator
	 * @param upp  a upper delimiter
	 * @return  a list formatter
	 * 
	 * 
	 * @see Format
	 */
	public default Format<?> Formatter(char low, char sep, char upp)
	{
		return new ListFormat<>(low, sep, upp);
	}
	
	/**
	 * Returns a {@code ListToken} formatter.
	 * 
	 * @param low  a lower delimiter
	 * @param upp  a upper delimiter
	 * @return  a list formatter
	 * 
	 * 
	 * @see Format
	 */
	public default Format<?> Formatter(char low, char upp)
	{
		return new ListFormat<>(low, upp);
	}
	
	@Override
	public default Format<?> Formatter()
	{
		return new ListFormat<>();
	}
}