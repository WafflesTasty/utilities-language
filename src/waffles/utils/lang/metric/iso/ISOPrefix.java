package waffles.utils.lang.metric.iso;

import waffles.utils.lang.metric.Prefix;

/**
 * The {@code ISOPrefix} enum defines prefixes according to the ISO standard.
 * 
 * @author Waffles
 * @since Oct 1, 2016
 * @version 1.0
 * 
 * 
 * @see Prefix
 */
public enum ISOPrefix implements Prefix
{
	/**
	 * The {@code exa-} exponent +18.
	 */
	EXA(+18, "exa"),
	/**
	 * The {@code peta-} exponent +15.
	 */
	PETA(+15, "peta"),
	/**
	 * The {@code tera-} exponent +12.
	 */
	TERA(+12, "tera"),
	/**
	 * The {@code giga-} exponent +9.
	 */
	GIGA(+9, "giga"),
	/**
	 * The {@code mega-} exponent +6.
	 */
	MEGA(+6, "mega"),
	/**
	 * The {@code kilo-} exponent +3.
	 */
	KILO(+3, "kilo"),
	/**
	 * The {@code hecto-} exponent +2.
	 */
	HECTO(+2, "hecto"),
	/**
	 * The {@code deca-} exponent +1.
	 */
	DECA(+1, "deca"),
	/**
	 * The nameless exponent +0.
	 */
	NONE(0, ""),
	/**
	 * The {@code deci-} exponent -1.
	 */
	DECI(-1, "deci"),
	/**
	 * The {@code centi-} exponent -2.
	 */
	CENTI(-2, "centi"),
	/**
	 * The {@code milli-} exponent -3.
	 */
	MILLI(-3, "milli"),
	/**
	 * The {@code micro-} exponent -6.
	 */
	MICRO(-6, "micro"),
	/**
	 * The {@code nano-} exponent -9.
	 */
	NANO(-9, "nano"),
	/**
	 * The {@code pico-} exponent -12.
	 */
	PICO(-12, "pico"),
	/**
	 * The {@code femto-} exponent -15.
	 */
	FEMTO(-15, "femto"),
	/**
	 * The {@code atto-} exponent -18.
	 */
	ATTO(-18, "atto");
	
	/**
	 * Generates an {@code ISOPrefix} from an exponent.
	 * 
	 * @param e  a metric exponent
	 * @return   a metric prefix
	 */
	public static ISOPrefix get(int e)
	{
		switch(e)
		{
		case +18: return EXA;
		case +15: return PETA;
		case +12: return TERA;
		case  +9: return GIGA;
		case  +6: return MEGA;
		case  +3: return KILO;
		case  +2: return HECTO;
		case  +1: return DECA;
		case   0: return NONE;
		case  -1: return DECI;
		case  -2: return CENTI;
		case  -3: return MILLI;
		case  -6: return MICRO;
		case  -9: return NANO;
		case -12: return PICO;
		case -15: return FEMTO;
		case -18: return ATTO;
		default:
			return NONE;
		}
	}
	
	
	
	private int exp;
	private String pfx;

	private ISOPrefix(int e, String p)
	{
		exp = e;
		pfx = p;
	}

	
	@Override
	public String Label()
	{
		return pfx;
	}

	@Override
	public int Exponent()
	{
		return exp;
	}
	
	@Override
	public int Radix()
	{
		return 10;
	}
}