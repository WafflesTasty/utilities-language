package waffles.utils.lang.tokens.format.regex;

/**
 * A {@code RegexValue} generates an object-related string.
 *
 * @author Waffles
 * @since 10 Aug 2025
 * @version 1.1
 * 
 * 
 * @param <O>  an object type
 */
@FunctionalInterface
public interface RegexValue<O>
{
	/**
	 * Generates a value string from a {@code Token}.
	 * 
	 * @param obj  a target object
	 * @param fmt  a format string
	 * @return  a value string
	 */
	public abstract String generate(O obj, String fmt);
}