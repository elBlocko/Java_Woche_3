/**
 * Klasse LeereEingabeException
 * @author A. Fletcher
 * @date 2021-09-06
 */
package uebung8;

public class LeereEingabeException extends NumberFormatException{
	public LeereEingabeException() {
		super();
	}
	
	public LeereEingabeException(String s) {
		super(s);
	}
}
