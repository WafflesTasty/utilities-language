package waffles.utils.lang.tokens.parsers.choice.primitive;

import waffles.utils.lang.tokens.parsers.basic.primitive.BooleanParser;
import waffles.utils.lang.tokens.parsers.basic.primitive.FloatParser;
import waffles.utils.lang.tokens.parsers.basic.primitive.IntegerParser;
import waffles.utils.lang.tokens.parsers.basic.primitive.NullParser;
import waffles.utils.lang.tokens.parsers.choice.ChoiceParser;

/**
 * A {@code PrimitiveParser} parses a string to a primitive object.
 * As a subclass of {@code ChoiceParser} it attempts the following
 * primitive type parsers in succession.
 * <ul>
 * <li> {@code NullParser} </li>
 * <li> {@code BooleanParser} </li>
 * <li> {@code IntegerParser} </li>
 * <li> {@code FloatParser} </li>
 * </ul>
 * 
 *
 * @author Waffles
 * @since 16 Mar 2024
 * @version 1.1
 *
 * 
 * @param <O>  an output type
 * @see ChoiceParser
 */
public class PrimitiveParser<O> extends ChoiceParser<Object, O>
{
	/**
	 * Creates a new {@code PrimitiveParser}.
	 */
	public PrimitiveParser()
	{
		add(new NullParser<>());
		add(new BooleanParser());
		add(new IntegerParser());
		add(new FloatParser());
	}
}