package waffles.utils.lang.math;

/**
 * The {@code Sign} enumeration defines the three possible signs of a real value.
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
	 * Returns the {@code Sign} of a value.
	 * 
	 * @param value  a value to check
	 * @return  the value's sign
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
	 * Returns the value of the {@code Sign}.
	 * 
	 * @return the sign's value
	 */
	public int Value()
	{
		return value;
	}
}