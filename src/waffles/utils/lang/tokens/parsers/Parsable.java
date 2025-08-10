package waffles.utils.lang.tokens.parsers;

import waffles.utils.tools.patterns.Consumable;
import waffles.utils.tools.patterns.basic.Resettable;

/**
 * A {@code Parsable} consume characters sequentially to generate objects.
 *
 * @author Waffles
 * @since 08 Dec 2023
 * @version 1.1
 * 
 * 
 * @param <O>  an object type
 * @see Consumable
 * @see Resettable
 */
public interface Parsable<O> extends Consumable<Character>, Resettable
{
	/**
	 * A {@code Parser.Error} is thrown whenever a parser fails to generate a token.
	 *
	 * @author Waffles
	 * @since Sep 17, 2019
	 * @version 1.0
	 * 
	 * 
	 * @see RuntimeException
	 */
	public static class Error extends RuntimeException
	{
		private static final long serialVersionUID = -3602621371383175152L;


		/**
		 * Creates a new {@code Error}.
		 * 
		 * @param desc  a description text
		 */
		public Error(String desc)
		{
			super(desc);
		}
	}
		
	
	/**
	 * Generates an object from the {@code Parser}.
	 * All currently consumed symbols should be used.
	 * 
	 * 
	 * @return  a parsed object
	 */
	public abstract O generate();
}