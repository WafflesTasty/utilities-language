package waffles.utils.lang.tokens;

import waffles.utils.lang.tokens.format.Format;

/**
 * A {@code Token} defines a {@code Format} allowing it to be parsed into a {@code String}.
 *
 * @author Waffles
 * @since 07 Aug 2025
 * @version 1.1
 */
@FunctionalInterface
public interface Token
{
	/**
	 * Returns a {@code Token} formatter.
	 * 
	 * @return  a default formatter
	 * 
	 * 
	 * @see Format
	 */
	public abstract Format<?> Formatter();	

	
	/**
	 * Describes the {@code Token} in a string iterable.
	 * 
	 * @return  a string iterable
	 * 
	 * 
	 * @see Iterable
	 */
	public default Iterable<String> describe()
	{
		return describe(Formatter());
	}

	/**
	 * Describes the {@code Token} in a string iterable.
	 * 
	 * @param fmt  a token formatter
	 * @return  a string iterable
	 * 
	 * 
	 * @see Iterable
	 * @see Format
	 */
	public default Iterable<String> describe(Format<?> fmt)
	{
		return fmt.castAndDescribe(this);
	}
			
	
	/**
	 * Condenses the {@code Token} into a string.
	 * 
	 * @param fmt  a token formatter
	 * @return  a token string
	 * 
	 * 
	 * @see Format
	 */
	public default String condense(Format<?> fmt)
	{
		return fmt.castAndParse(this);
	}
		
	/**
	 * Condenses the {@code Token} into a string.
	 * 
	 * @return  a token string
	 */
	public default String condense()
	{
		return condense(Formatter());
	}
}