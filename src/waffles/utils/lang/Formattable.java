package waffles.utils.lang;

/**
 * A {@code Formattable} object has access to a formatter which parses the object into strings.
 * 
 * @author Waffles
 * @since Oct 3, 2016
 * @version 1.0
 * 
 * 
 * @param <O>  an object type
 */
public interface Formattable<O>
{
	/**
	 * Returns a formatter for the {@code Formattable}.
	 * 
	 * @param fmt    a format string
	 * @param delim  a chunk delimiter
	 * @return  a default formatter
	 * 
	 * 
	 * @see Format
	 * @see String
	 */
	public abstract Format<O> Formatter(String fmt, String delim);
		
	
	/**
	 * Parses a string through the {@code Formattable}.
	 * 
	 * @param fmt  an object formatter
	 * @return  a formatted string
	 * 
	 * 
	 * @see Format
	 * @see String
	 */
	public default <P extends O> String parse(Format<P> fmt)
	{
		return fmt.parse((P) this);
	}
	
	/**
	 * Parses a string through the {@code Formattable}.
	 * 
	 * @param fmt    a format string
	 * @param delim  a chunk delimiter
	 * @return  a formatted string
	 * 
	 * 
	 * @see Format
	 * @see String
	 */
	public default String parse(String fmt, String delim)
	{
		return parse(Formatter(fmt, delim));
	}
}