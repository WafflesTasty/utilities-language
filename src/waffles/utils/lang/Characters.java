package waffles.utils.lang;

/**
 * The {@code Characters} class defines basic operations for character values.
 *
 * @author Waffles
 * @since 09 Aug 2025
 * @version 1.1
 */
public final class Characters
{
	// Checks
	
	/**
	 * Checks if a string contains a whitespace character.
	 * 
	 * @param c  a source character
	 * @return  {@code true} if the character is whitespace
	 */
	public static boolean isWhiteSpace(char c)
	{
		return Character.isWhitespace(c);
	}
	
	
	// Manipulators
	
	/**
	 * Changes a character to lower case.
	 * 
	 * @param c  a source character
	 * @return  a lowercase character
	 */
	public static char toLowerCase(char c)
	{
		return Character.toLowerCase(c);
	}

	/**
	 * Changes a character to upper case.
	 * 
	 * @param c  a source character
	 * @return  an uppercase character
	 */
	public static char toUpperCase(char c)
	{
		return Character.toUpperCase(c);
	}
	
	
	private Characters()
	{
		// NOT APPLICABLE
	}
}