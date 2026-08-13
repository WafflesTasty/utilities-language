package waffles.utils.lang.utilities.enums;

/**
 * An {@code Equation} is an equation method between two objects.
 * 
 * @author Waffles
 * @since Sep 12, 2016
 * @version 1.1
 */
public enum Equation
{
	/**
	 * Defines A greater or equal to B.
	 */
	GEQUAL,
	/**
	 * Defines A less or equal to B.
	 */
	LEQUAL,
	
	/**
	 * Defines A not equal to B.
	 */
	NOTEQUAL,
	/**
	 * Defines A equal to B.
	 */
	EQUAL,
	
	
	/**
	 * Defines A less than B.
	 */
	LESS,
	/**
	 * Defines A greater than B.
	 */
	GREATER,
	
	/**
	 * Defines  a true constant.
	 */
	ALWAYS,
	/**
	 * Defines a false constant.
	 */
	NEVER;
}