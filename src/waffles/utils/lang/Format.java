package waffles.utils.lang;

/**
 * A {@code Format} is capable of formatting objects into strings.
 * 
 * @author Waffles
 * @since 26 Jul 2020
 * @version 1.1
 * 
 * 
 * @param <O>  an object type
 */
@FunctionalInterface
public interface Format<O>
{
	/**
	 * Parses an object in the {@code Format}.
	 * 
	 * @param obj  a target object
	 * @return  a parsed string
	 * 
	 * 
	 * @see String
	 */
	public abstract String parse(O obj);
}