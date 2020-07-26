package zeno.util.lang.format;

import zeno.util.lang.Strings;
import zeno.util.tools.helper.Array;

/**
 * The {@code Format} class performs formatting for {@code Formattable} objects.
 * </br> It precompiles format strings making them easier to reuse.
 * 
 * @author Zeno
 * @since 26 Jul 2020
 * @version 1.0
 * 
 * 
 * @param <O>  an object type
 */
public abstract class Format<O>
{
	/**
	 * The {@code Group} interface defines a single format group.
	 * </br> Each non-static group must be surrounded by limiters.
	 *
	 * @author Zeno
	 * @since 26 Jul 2020
	 * @version 1.0
	 * 
	 * 
	 * @param <O>  an object type
	 */
	@FunctionalInterface
	public static interface Group<O>
	{
		/**
		 * Parses an object through the {@code Group}.
		 * 
		 * @param obj  an object to parse
		 * @return  a parsed string
		 * 
		 * 
		 * @see String
		 */
		public abstract String parse(O obj);
	}

	/**
	 * Defines the limiter that must surround each format group.
	 */
	public static final String LIMITER = "%";
		
	
	static <O> Group<O> Static(String text)
	{
		return date -> text;
	}
	
	
	private Group<O>[] groups;
	
	/**
	 * Creates a new {@code Format}.
	 * 
	 * @param format  a format string
	 * 
	 * 
	 * @see String
	 */
	public Format(String format)
	{
		String curr = "";
		groups = new Group[0];
		for(String c : Strings.iterate(format))
		{
			if(!c.equals(LIMITER) || curr.endsWith("\\"))
				curr += c;
			else
			{
				if(curr.length() == 0)
				{
					curr += LIMITER;
					continue;
				}
				
				if(curr.startsWith(LIMITER))
				{
					curr = curr.substring(1);
					curr = curr.replace("\\" + LIMITER, LIMITER);
					groups = Array.add.to(groups, create(curr));
					curr = "";
					continue;
				}
				
				curr = curr.replace("\\" + LIMITER, LIMITER);
				groups = Array.add.to(groups, Static(curr));
				curr = LIMITER;
				continue;
			}
		}
		
		if(curr.length() != 0)
		{
			curr = curr.replace("\\" + LIMITER, LIMITER);
			groups = Array.add.to(groups, Static(curr));
		}
	}
		
	/**
	 * Creates a group for the {@code Format}.
	 * 
	 * @param fmt  a format string
	 * @return  a format group
	 * 
	 * 
	 * @see String
	 * @see Group
	 */
	public abstract Group<O> create(String fmt);

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
		String result = "";
		for(Group<O> grp : groups)
		{
			result += grp.parse(object);
		}
		
		return result;
	}
}