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
	 * @return  a default formatter
	 * 
	 * 
	 * @see Format
	 */
	public abstract Format<O> Formatter();
	
	
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
	 * @return  a formatted string
	 * 
	 * 
	 * @see String
	 */
	public default String parse()
	{
		return Formatter().parse((O) this);
	}
}