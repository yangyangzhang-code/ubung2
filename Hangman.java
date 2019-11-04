/**
 * This class provides several helper methods for the well known game <a href ="https://en.wikipedia.org/wiki/Hangman_(game)">Hangman</a>.
 */
public class Hangman {
	/**
	 * This method creates the encrypted (hidden) representation of the confidential phrase to be guessed.
	 * Each character in the original phrase (except for the white space character) is replaced by the underscore character.
	 * Consecutive characters (including white spaces) in the original phrase are separated by an additional white space character in the encrypted representation.
	 * <ul>
	 * <li><p>Example:</p>
	 * <p>Input: <kbd>"Algorithmen und Datenstrukturen"</kbd></p>
	 * <p>Output: <samp>"_ _ _ _ _ _ _ _ _ _ _ &nbsp; _ _ _ &nbsp; _ _ _ _ _ _ _ _ _ _ _ _ _ _ _"</samp></p>
	 * </ul>
	 *
	 * @param confidential the original phrase to be guessed
	 * @return the encrypted representation of the confidential phrase to be guessed.
	 */
	public static String createHidden(String confidential) {
		String cre;
		char[] temp;
		int i;
		for(i=0;i<confidential.length(); i++){
			temp = confidential.charAt(i);
			if (char.isLetter(temp)){
				temp = '_';
			}else {
				temp = '\b;
			}
			cre = cre + temp;
		}
		return cre  ; // TODO
	}

	/**
	 * This method uncovers all occurrences of the given character (i.e. the players guess) in the encrypted (hidden) representation of the confidential phrase to be guessed, without considering (upper and lower) case.
	 * <ul>
	 * <li><p>Example I:</p>
	 * <p>Input: <kbd>"Algorithmen und Datenstrukturen"</kbd>, <kbd>"_ _ _ _ _ _ _ _ _ _ _ &nbsp; _ _ _ &nbsp; _ _ _ _ _ _ _ _ _ _ _ _ _ _ _"</kbd>, <kbd>'a'</kbd></p>
	 * <p>Output: <samp>"A _ _ _ _ _ _ _ _ _ _ &nbsp; _ _ _ &nbsp; _ a _ _ _ _ _ _ _ _ _ _ _ _ _"</samp></p>
	 * <li><p>Example I:</p>
	 * <p>Input: <kbd>"Algorithmen und Datenstrukturen"</kbd>, <kbd>"_ _ _ _ _ _ _ _ _ _ _ &nbsp; _ _ _ &nbsp; _ _ _ _ _ _ _ _ _ _ _ _ _ _ _"</kbd>, <kbd>'E'</kbd></p>
	 * <p>Output: <samp>"A _ _ _ _ _ _ _ _ e _ &nbsp; _ _ _ &nbsp; _ a _ e _ _ _ _ _ _ _ _ _ e _"</samp></p>
	 * </ul>
	 *
	 * @param confidential the original phrase to be guessed
	 * @param hidden       the encrypted (hidden) representation of the confidential phrase
	 * @param character    the current guess of the player to be uncovered in the encrypted (hidden) representation
	 * @return the string from {@code hidden}, where every occurrence of {@code character} in {@code confidential} replaces the corresponding underscore in {@code hidden} without considering case
	 */
	public static String uncover(String confidential, String hidden, char character) {
		int i;
		char temp;
		String cre

		for(i=0;i<confidential.length();i++){
			temp = confidential.charAt(i);
			if(character == temp ){
				temp = character + " ";
				cre = cre + temp;
			}else{
				if (char.isLetter(temp)){
					temp = "_"+" ";
				}else {
					temp = "&nbsp;";
				}
				cre = cre + temp;
			}
		}
		return cre ; // TODO
	}

	/**
	 * Decides whether the player has already won the game.
	 *
	 * @param hidden the encrypted (hidden) representation of the confidential phrase
	 * @return {@literal true} if the player has won the game, {@literal false} otherwise
	 */
	public static boolean hasWon(String hidden) {
		int i;
		char temp;
		String cre;
		for(i=0;i<hidden.length();i++) {
			if (hidden.charAt(i) != "_") return true;
			else return false; // TODO
		}
	}

	/**
	 * This methods computes a representation of the input such that every low case letter is replaced by its corresponding upper case letter.
	 *
	 * @param text the input to be typeset in upper case letters
	 * @return
	 */
	public static String toUpperCase(String text) {
		int i;
		char temp;

		for(i=0;i<text.length();i++){
			temp = text.charAt(i);
			if(temp == "a" || temp =="A" ) temp = "A";
			else if (temp == "b" || temp =="B" ) temp = "B";
			else if (temp == "c" || temp =="C" ) temp = "C";
			else if (temp == "b" || temp =="D" ) temp = "D";
			else if (temp == "b" || temp =="E" ) temp = "E";
			else if (temp == "b" || temp =="F" ) temp = "F";
			else if (temp == "b" || temp =="G" ) temp = "G";
			else if (temp == "b" || temp =="H" ) temp = "H";
			else if (temp == "b" || temp =="I" ) temp = "I";
			else if (temp == "b" || temp =="J" ) temp = "J";
			else if (temp == "b" || temp =="K" ) temp = "K";
			else if (temp == "b" || temp =="M" ) temp = "M";
			else if (temp == "b" || temp =="B" ) temp = "B";
			else if (temp == "c" || temp =="C" ) temp = "C";
			else if (temp == "b" || temp =="D" ) temp = "D";
			else if (temp == "b" || temp =="E" ) temp = "E";
			else if (temp == "b" || temp =="F" ) temp = "F";
			else if (temp == "b" || temp =="G" ) temp = "G";
			else if (temp == "b" || temp =="H" ) temp = "H";
			else if (temp == "b" || temp =="I" ) temp = "I";
			else if (temp == "b" || temp =="J" ) temp = "J";
			else if (temp == "b" || temp =="K" ) temp = "K";
			else  (temp == "z" || temp =="Z" ) temp = "Z";
		}
		return temp ; // TODO
	}

	/**
	 * This methods checks whether the given text is a <a href="https://en.wikipedia.org/wiki/Palindrome">Palindrome</a>.
	 *
	 * @param text the input to be checked
	 * @return {@literal true} if {@code text} is a palindrome, {@literal false} otherwise
	 */
	public static boolean isPalindrome(String text) {
		char temp;
		int i;
		for (i=0;i<text.length();i++){
			if (text.charAt(i) == text.charAt(text.length()-i)) {
				return true;
			}else {
				return false;
			}
	}
}