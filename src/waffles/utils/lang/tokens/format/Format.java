package waffles.utils.lang.tokens.format;

import waffles.utils.lang.tokens.Token;
import waffles.utils.tools.collections.Iterables;

/**
 * A {@code Format} parses {@code Token} objects into strings.
 * 
 * @author Waffles
 * @since 26 Jul 2020
 * @version 1.1
 * 
 * 
 * @param <T>  a token type
 * @see Token
 */
@FunctionalInterface
public interface Format<T extends Token>
{	
	/**
	 * Parses a {@code Token} in the {@code Format}.
	 * 
	 * @param tkn  a token object
	 * @return     a token string
	 */
	public abstract String parse(T tkn);
		
	/**
	 * Casts and parses a {@code Token} in the {@code Format}.
	 * 
	 * @param tkn  a token object
	 * @return     a token string
	 */
	public default String castAndParse(Object tkn)
	{
		return parse((T) tkn);
	}
		
	
	/**
	 * Casts and describes a {@code Token} in the {@code Format}.
	 * 
	 * @param tkn  a token object
	 * @return  a string iterable
	 * 
	 * 
	 * @see Iterable
	 */
	public default Iterable<String> castAndDescribe(Object tkn)
	{
		return describe((T) tkn);
	}
	
	/**
	 * Describes a {@code Token} in the {@code Format}.
	 * 
	 * @param tkn  a token object
	 * @return  a string iterable
	 */
	public default Iterable<String> describe(T tkn)
	{
		return Iterables.singleton(parse(tkn));
	}
}