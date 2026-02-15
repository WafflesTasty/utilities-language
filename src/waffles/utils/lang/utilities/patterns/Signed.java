package waffles.utils.lang.utilities.patterns;

import waffles.utils.lang.utilities.enums.Sign;

/**
 * A {@code Signed} object defines a {@code Sign}.
 *
 * @author Waffles
 * @since 15 Feb 2026
 * @version 1.1
 */
@FunctionalInterface
public interface Signed
{
	/**
	 * Returns the sign of the {@code Signed}.
	 * 
	 * @return  a sign
	 * 
	 * 
	 * @see Sign
	 */
	public abstract Sign Sign();
}