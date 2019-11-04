import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class HangmanPublicTest {
	// ========== SYSTEM ==========
	static final String HANGMAN_createHidden = "Hangman.createHidden";
	static final String HANGMAN_uncover = "Hangman.uncover";
	static final String HANGMAN_hasWon = "Statistics.hasWon";
	static final String HANGMAN_toUpperCase = "Statistics.toUpperCase";
	static final String HANGMAN_isPalindrome = "Statistics.isPalindrome";
	// --------------------

	// ========== TEST DATA ==========
	private static final Random RND = new Random(4711_0815_666L);

	@Test(timeout = 666)
	public void pubTest__createHidden() {
		for (int pass = 0; pass < 42; pass++) {
			String expectedExample = "_ _ _ _ _ _ _ _ _ _ _   _ _ _   _ _ _ _ _ _ _ _ _ _ _ _ _ _ _";
			String actualExample = Hangman.createHidden("Algorithmen und Datenstrukturen");
			assertEquals("Failed.", expectedExample, actualExample);
			// --------------------
			HangmanPublicTest.pubTest__createHidden__random();
		}
	}

	static void pubTest__createHidden__random() {
		int len = 7 + RND.nextInt(42);
		String confidential = "", expected = "";
		for (; len-- > 0; ) {
			char c = (char) (RND.nextBoolean() ? 'a' + RND.nextInt('z' - 'a' + 1) : 'A' + RND.nextInt('Z' - 'A' + 1));
			confidential += c;
			expected += len > 0 ? "_ " : "_";
		}
		String actual = Hangman.createHidden(confidential);
		assertEquals("Failed for \"" + confidential + "\".", expected, actual);
	}

	@Test(timeout = 666)
	public void pubTest__uncover() {
		for (int pass = 0; pass < 42; pass++) {
			String expectedExample = "A _ _ _ _ _ _ _ _ _ _   _ _ _   _ a _ _ _ _ _ _ _ _ _ _ _ _ _";
			String actualExample = Hangman.uncover("Algorithmen und Datenstrukturen", "_ _ _ _ _ _ _ _ _ _ _   _ _ _   _ _ _ _ _ _ _ _ _ _ _ _ _ _ _", 'a');
			assertEquals("Failed.", expectedExample, actualExample);
			// --------------------
			HangmanPublicTest.pubTest__uncover__random();
		}
	}

	static void pubTest__uncover__random() {
		int len = 7 + RND.nextInt(42);
		String confidential = "", hidden = "", expected = "";
		char character = (char) ('a' + RND.nextInt('z' - 'a' + 1));
		for (; len-- > 0; ) {
			char c = (char) (RND.nextBoolean() ? 'a' + RND.nextInt('z' - 'a' + 1) : 'A' + RND.nextInt('Z' - 'A' + 1));
			confidential += c;
			hidden += len > 0 ? "_ " : "_";
			expected += (c == character || character - 'a' + 'A' == c ? c : '_') + (len > 0 ? " " : "");
		}
		String actual = Hangman.uncover(confidential, hidden, character);
		assertEquals("Failed for (\"" + confidential + "\", \"" + hidden + "\", '" + character + "').", expected, actual);
		String actualAgain = Hangman.uncover(confidential, hidden, character);
		assertEquals("Failed for (\"" + confidential + "\", \"" + hidden + "\", '" + character + "').", expected, actualAgain);
	}

	@Test(timeout = 666)
	public void pubTest__hasWon() {
		HangmanPublicTest.pubTest__hasWon__random();
	}

	static void pubTest__hasWon__random() {
		for (int pass = 0; pass < 42; pass++) {
			assertTrue("Failed.", Hangman.hasWon(""));
			// --------------------
			int len = 7 + RND.nextInt(42);
			String hidden = "", unhidden = "";
			for (; len-- > 0; ) {
				char c = (char) (RND.nextBoolean() ? 'a' + RND.nextInt('z' - 'a' + 1) : 'A' + RND.nextInt('Z' - 'A' + 1));
				hidden += len > 0 ? "_ " : "_";
				unhidden += c + (len > 0 ? " " : "");
			}
			boolean actualFalse = Hangman.hasWon(hidden);
			assertFalse("Failed for \"" + hidden + "\".", actualFalse);
			boolean actualTrue = Hangman.hasWon(unhidden);
			assertTrue("Failed for \"" + unhidden + "\".", actualTrue);
		}
	}

	@Test(timeout = 666)
	public void pubTest__toUpperCase() {
		HangmanPublicTest.pubTest__toUpperCase__random();
	}

	static void pubTest__toUpperCase__random() {
		for (int pass = 0; pass < 42; pass++) {
			int len = 7 + RND.nextInt(42);
			String text = "", hidden = "";
			for (; len-- > 0; ) {
				char c = (char) (RND.nextBoolean() ? 'a' + RND.nextInt('z' - 'a' + 1) : 'A' + RND.nextInt('Z' - 'A' + 1));
				text += c;
				hidden += len > 0 ? "_ " : "_";
			}
			String actual = Hangman.toUpperCase(text);
			assertEquals("Failed for \"" + text + "\".", text.toUpperCase(), actual);
			assertEquals("Failed for \"" + hidden + "\".", hidden.toUpperCase(), Hangman.toUpperCase(hidden));
		}
	}

	@Test(timeout = 666)
	public void pubTest__isPalindrome() {
		assertTrue("Failed.", Hangman.isPalindrome(""));
		// --------------------
		HangmanPublicTest.pubTest__isPalindrome__random();
	}

	static void pubTest__isPalindrome__random() {
		for (int pass = 0; pass < 42; pass++) {
			int len = 7 + RND.nextInt(42);
			String text = "", textNot = text + "";
			for (; len-- > 0; ) {
				char c = (char) (RND.nextBoolean() ? 'a' + RND.nextInt('z' - 'a' + 1) : 'A' + RND.nextInt('Z' - 'A' + 1));
				char cNot = (char) (('a' <= c && c <= 'z') ? c - 'a' + 'A' : c - 'A' + 'a');
				text = c + text + c;
				textNot = c + text + cNot;
			}
			boolean actualTrue = Hangman.isPalindrome(text);
			assertTrue("Failed for \"" + text + "\".", actualTrue);
			boolean actualFalse = Hangman.isPalindrome(textNot);
			assertFalse("Failed for \"" + textNot + "\".", actualFalse);
		}
	}
}
