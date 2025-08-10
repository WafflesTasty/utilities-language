package waffles.utils.lang.utilities.patterns;

/**
 * A {@code Named} object defines a name string.
 *
 * @author Waffles
 * @since 10 Jun 2025
 * @version 1.1
 */
@FunctionalInterface
public interface Named
{
	/**
	 * Returns the name of the {@code Named}.
	 * 
	 * @return  a name string
	 */
	public abstract String Name();
}