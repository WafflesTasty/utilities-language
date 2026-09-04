package waffles.utils.lang.utilities.patterns;

import waffles.utils.tools.patterns.properties.Immutable;

/**
 * A {@code Described} defines a description.
 *
 * @author Waffles
 * @since Sep 4, 2026
 * @version 1.1
 *
 * 
 * @see Immutable
 */
public interface Described extends Immutable
{
	/**
	 * A {@code Described.Mutable} can change its own description.
	 *
	 * @author Waffles
	 * @since Sep 4, 2026
	 * @version 1.1
	 *
	 * 
	 * @see Immutable
	 * @see Described
	 */
	public static interface Mutable extends Described, Immutable.Mutable
	{
		/**
		 * Changes the {@code Described} string.
		 * 
		 * @param dsc  a description
		 */
		public abstract void setDescription(String dsc);
	}
	
	/**
	 * Returns a {@code Described} string.
	 * 
	 * @return  a description
	 */
	public abstract String Description();
}