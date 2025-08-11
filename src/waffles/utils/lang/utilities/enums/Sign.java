package waffles.utils.lang.utilities.enums;

/**
 * The {@code Sign} enum defines all real value signs.
 * 
 * @author Waffles
 * @since Oct 16, 2014
 * @version 1.0
 */
public enum Sign
{
	/**
	 * A negative sign.
	 */
	NEGATIVE(-1),
	/**
	 * A positive sign.
	 */
	POSITIVE(1),
	/**
	 * A neutral sign.
	 */
	ZERO(0);

	
	/**
	 * Returns the {@code Sign} value.
	 * 
	 * @param value  a value to check
	 * @return  a value sign
	 */
	public static Sign of(double value)
	{
		if(value < 0)
			return NEGATIVE;
		
		if(value > 0)
			return POSITIVE;
		
		return ZERO;
	}
	
	/**
	 * Returns the {@code Sign} value.
	 * 
	 * @param value  a value to check
	 * @return  a value sign
	 */
	public static Sign of(float value)
	{
		if(value < 0)
			return NEGATIVE;
		
		if(value > 0)
			return POSITIVE;
		
		return ZERO;
	}
	
	
	private int value;
	
	private Sign(int value)
	{
		this.value = value;
	}
	
	/**
	 * Returns the {@code Sign} value.
	 * 
	 * @return a sign value
	 */
	public int Value()
	{
		return value;
	}
}