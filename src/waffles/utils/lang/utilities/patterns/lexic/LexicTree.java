package waffles.utils.lang.utilities.patterns.lexic;

import waffles.utils.sets.arboreal.binary.search.BSTree;
import waffles.utils.sets.arboreal.binary.search.IOTree;

/**
 * A {@code LexicTree} is a {@code BSTree} that stores strings in {@code LexicOrder}.
 *
 * @author Waffles
 * @since Sep 25, 2026
 * @version 1.1
 *
 * 
 * @see BSTree
 */
public class LexicTree extends BSTree<String>
{
	/**
	 * A {@code Query} defines a {@code LexicOrder} for a {@code LexicTree}.
	 *
	 * @author Waffles
	 * @since Sep 25, 2026
	 * @version 1.1
	 *
	 * 
	 * @see LexicOrder
	 * @see IOTree
	 */
	public class Query implements IOTree.Query<String>, LexicOrder<String>
	{
		@Override
		public int length(String s)
		{
			return s.length();
		}
		
		@Override
		public int compare(String s1, String s2, int ord)
		{
			char c1 = s1.charAt(ord);
			char c2 = s2.charAt(ord);
			
			return c1 - c2;
		}
		
		@Override
		public LexicTree Tree()
		{
			return LexicTree.this;
		}
	}


	@Override
	public int compare(String o1, String o2)
	{
		return Query().compare(o1, o2);
	}

	@Override
	public Query Query()
	{
		return new Query();
	}
}
