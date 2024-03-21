package waffles.utils.lang;

/**
 * A {@code Formattable} object has access to a formatter which parses the object into strings.
 * 
 * @author Waffles
 * @since Oct 3, 2016
 * @version 1.1
 */
public interface Formattable
{
	/**
	 * Returns a formatter for the {@code Formattable}.
	 * 
	 * @return  a default formatter
	 * 
	 * 
	 * @see Format
	 */
	public abstract Format<?> Formatter();	
	
	
	/**
	 * Parses a verbose string through the {@code Formattable}.
	 * 
	 * @return  a set of formatted strings
	 * 
	 * 
	 * @see Iterable
	 * @see String
	 */
	public default Iterable<String> verbose()
	{
		return verbose(Formatter());
	}
	
	/**
	 * Parses a verbose string through the {@code Formattable}.
	 * 
	 * @param fmt  an object formatter
	 * @return  a set of formatted strings
	 * 
	 * 
	 * @see Iterable
	 * @see Format
	 * @see String
	 */
	public default Iterable<String> verbose(Format<?> fmt)
	{
		return () -> fmt.castAndVerbose(this);
	}
	
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
	public default String parse(Format<?> fmt)
	{
		return fmt.castAndParse(this);
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
		return parse(Formatter());
	}
}