package waffles.utils.lang;

import waffles.utils.tools.primitives.Array;

/**
 * The {@code Format} class is an abstract superclass designed for string formatting.
 * Given a format string and a delimiter, the formatter separates the string into
 * an array of {@code Chunks} for further processing by the subclass.
 * 
 * @author Waffles
 * @since 26 Jul 2020
 * @version 1.0
 * 
 * 
 * @param <O>  an object type
 */
public abstract class Format<O>
{
	/**
	 * The {@code Chunk} interface defines a single format chunk.
	 *
	 * @author Waffles
	 * @since 26 Jul 2020
	 * @version 1.0
	 * 
	 * 
	 * @param <O>  an object type
	 */
	@FunctionalInterface
	public static interface Chunk<O>
	{
		/**
		 * Parses an object through the {@code Chunk}.
		 * 
		 * @param obj  an object to parse
		 * @return  a parsed string
		 * 
		 * 
		 * @see String
		 */
		public abstract String parse(O obj);
	}

	
	private Chunk<O>[] chunks;
		
	/**
	 * Creates a new {@code Format}.
	 * 
	 * @param format  a format string
	 * @param delim   a chunk delimiter
	 * 
	 * 
	 * @see String
	 */
	public Format(String format, String delim)
	{
		String curr = "";
		chunks = new Chunk[0];

		// For each character in the format string...
		for(String c : Strings.iterate(format))
		{
			// If the character is escaped...
			if(curr.length() > 0 && curr.endsWith("\\"))
			{
				// Replace the escaped character.
				curr = Strings.replaceLast(curr, "\\", c);
				// Continue to the next one.
				continue;
			}
			
			// If the character is a limiter...
			if(c.equals(delim))
			{
				// And the current string is non-empty...
				if(curr.length() > 0)
				{
					// Create a new group from the string.
					chunks = Array.add.to(chunks, create(curr));
					// Reset to an empty string.
					curr = "";
				}
				
				// Continue to the next one.
				continue;
			}
			
			// Otherwise, add it to the string.
			curr += c;
		}
		
		// If the final group has not been finished...
		if(curr.length() > 0)
		{
			// Create a new group from the string.
			chunks = Array.add.to(chunks, create(curr));
		}
	}
		
	/**
	 * Creates a chunk for the {@code Format}.
	 * 
	 * @param fmt  a format string
	 * @return  a format chunk
	 * 
	 * 
	 * @see String
	 * @see Chunk
	 */
	public abstract Chunk<O> create(String fmt);

	/**
	 * Parses an object in the {@code Format}.
	 * 
	 * @param object  a target object
	 * @return  a parsed string
	 * 
	 * 
	 * @see String
	 */
	public String parse(O object)
	{
		String parse = "";
		for(Chunk<O> chunk : chunks)
		{
			parse += chunk.parse(object);
		}
		
		return parse;
	}
}