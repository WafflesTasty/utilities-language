package waffles.utils.lang.tokens;

/**
 * A {@code MapToken} defines a {@code ListToken} that iterates {@code PairTokens}.
 *
 * @author Waffles
 * @since 08 Aug 2025
 * @version 1.1
 *
 *
 * @param <T>  a token type
 * @see ListToken
 * @see PairToken
 */
@FunctionalInterface
public interface MapToken<T extends PairToken<?, ?>> extends ListToken<T>
{
	// NOT APPLICABLE
}