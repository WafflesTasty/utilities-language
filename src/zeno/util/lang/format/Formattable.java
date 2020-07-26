package zeno.util.lang.format;

/**
 * The {@code Formattable} interface defines an object formattable into a string.
 * 
 * @author Zeno
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
	 * @param fmt  a formatter string
	 * @return  a default formatter
	 * 
	 * 
	 * @see Format
	 * @see String
	 */
	public abstract Format<O> Formatter(String fmt);
		
	/**
	 * Formats a string through the {@code Formattable}.
	 * 
	 * @param fmt  an object formatter
	 * @return  a formatted string
	 * 
	 * 
	 * @see Format
	 * @see String
	 */
	public default String format(Format<O> fmt)
	{
		return fmt.parse((O) this);
	}
	
	/**
	 * Formats a string through the {@code Formattable}.
	 * 
	 * @param fmt  an object formatter
	 * @return  a formatted string
	 * 
	 * 
	 * @see Format
	 * @see String
	 */
	public default String format(String fmt)
	{
		return format(Formatter(fmt));
	}
}