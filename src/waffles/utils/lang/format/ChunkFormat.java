package waffles.utils.lang.format;

import waffles.utils.lang.Format;
import waffles.utils.lang.Strings;
import waffles.utils.tools.primitives.Array;

/**
 * The {@code ChunkFormat} is an abstract superclass designed for string formatting.
 * Given a format string and a delimiter, the formatter separates the string into
 * an array of {@code Chunks} for further processing by the subclass.
 * 
 * @author Waffles
 * @since 26 Jul 2020
 * @version 1.1
 * 
 * 
 * @param <O>  an object type
 * @see Format
 */
public abstract class ChunkFormat<O> implements Format<O>
{
	private Format<O>[] chunks;
		
	/**
	 * Creates a new {@code ChunkFormat}.
	 * 
	 * @param format  a format string
	 * @param delim   a chunk delimiter
	 * 
	 * 
	 * @see String
	 */
	public ChunkFormat(String format, String delim)
	{
		String curr = "";
		chunks = new Format[0];

		// For each character in the format string...
		for(char c : Strings.iterate(format))
		{
			// If the character is escaped...
			if(curr.length() > 0 && curr.endsWith("\\"))
			{
				// Replace the escaped character.
				curr = Strings.replaceLast(curr, "\\", "" + c);
				// Continue to the next one.
				continue;
			}
			
			// If the character is a limiter...
			if(delim.equals("" + c))
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
	 * @see Format
	 */
	public abstract Format<O> create(String fmt);

	
	@Override
	public String parse(O obj)
	{
		String parse = "";
		for(Format<O> chunk : chunks)
		{
			parse += chunk.parse(obj);
		}
		
		return parse;
	}
}