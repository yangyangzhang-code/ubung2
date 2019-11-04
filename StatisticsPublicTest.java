import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class StatisticsPublicTest {
	// ========== SYSTEM ==========
	protected static final String STATISTICS_MIN_MAX = "Statistics.min/max";
	protected static final String STATISTICS_AVERAGE = "Statistics.average";
	protected static final String STATISTICS_MEDIAN = "Statistics.median";
	// --------------------

	// ========== TEST DATA ==========
	private static final Random RND = new Random(4711_0815_666L);

	// ========== min/max ==========
	@Test(timeout = 666)
	public void pubTest_min2() {
		for (int pass = 0; pass < 42; pass++) {
			double a = rndDbl(), b = a + rndPosDbl();
			double actual1 = Statistics.min2(a, b);
			assertEquals(a, actual1, Double.MIN_VALUE);
			double actual2 = Statistics.min2(b, a);
			assertEquals(a, actual2, Double.MIN_VALUE);
		}
	}

	@Test(timeout = 666)
	public void pubTest_min3() {
		for (int pass = 0; pass < 42; pass++) {
			double a = rndDbl(), b = a + rndPosDbl(), c = a + rndPosDbl();
			double actual1 = Statistics.min3(a, b, c);
			assertEquals(a, actual1, Double.MIN_VALUE);
			double actual2 = Statistics.min3(b, a, c);
			assertEquals(a, actual2, Double.MIN_VALUE);
			double actual3 = Statistics.min3(b, c, a);
			assertEquals(a, actual3, Double.MIN_VALUE);
		}
	}

	@Test(timeout = 666)
	public void pubTest_min7() {
		for (int pass = 0; pass < 42; pass++) {
			double a = rndDbl(), b = a + rndPosDbl(), c = a + rndPosDbl(), d = a + rndPosDbl(), e = a + rndPosDbl(), f = a + rndPosDbl(), g = a + rndPosDbl();
			double actual1 = Statistics.min7(a, b, c, d, e, f, g);
			assertEquals(a, actual1, Double.MIN_VALUE);
			double actual4 = Statistics.min7(b, c, d, a, e, f, g);
			assertEquals(a, actual4, Double.MIN_VALUE);
			double actual7 = Statistics.min7(g, f, e, d, c, b, a);
			assertEquals(a, actual7, Double.MIN_VALUE);
		}
	}

	@Test(timeout = 666)
	public void pubTest_minN() {
		double actualNull = Statistics.minN(null);
		assertTrue(Double.isNaN(actualNull));
		double actualEmpty = Statistics.minN(new double[0]);
		assertTrue(Double.isNaN(actualEmpty));
		for (int pass = 0; pass < 42; pass++) {
			int len = 1 + RND.nextInt(42), minP = RND.nextInt(len);
			double[] x = new double[len];
			x[minP] = rndDbl();
			for (int i = 0; i < len; i++) {
				x[i] = i == minP ? x[minP] : x[minP] + rndPosDbl();
			}
			double actual1 = Statistics.minN(x);
			assertEquals(x[minP], actual1, Double.MIN_VALUE);
		}
	}

	@Test(timeout = 666)
	public void pubTest_max2() {
		for (int pass = 0; pass < 42; pass++) {
			double a = rndDbl(), b = a - rndPosDbl();
			double actual1 = Statistics.max2(a, b);
			assertEquals(a, actual1, Double.MIN_VALUE);
			double actual2 = Statistics.max2(b, a);
			assertEquals(a, actual2, Double.MIN_VALUE);
		}
	}

	@Test(timeout = 666)
	public void pubTest_max3() {
		for (int pass = 0; pass < 42; pass++) {
			double a = rndDbl(), b = a - rndPosDbl(), c = a - rndPosDbl();
			double actual1 = Statistics.max3(a, b, c);
			assertEquals(a, actual1, Double.MIN_VALUE);
			double actual2 = Statistics.max3(b, a, c);
			assertEquals(a, actual2, Double.MIN_VALUE);
			double actual3 = Statistics.max3(b, c, a);
			assertEquals(a, actual3, Double.MIN_VALUE);
		}
	}

	@Test(timeout = 666)
	public void pubTest_max7() {
		for (int pass = 0; pass < 42; pass++) {
			double a = rndDbl(), b = a - rndPosDbl(), c = a - rndPosDbl(), d = a - rndPosDbl(), e = a - rndPosDbl(), f = a - rndPosDbl(), g = a - rndPosDbl();
			double actual1 = Statistics.max7(a, b, c, d, e, f, g);
			assertEquals(a, actual1, Double.MIN_VALUE);
			double actual4 = Statistics.max7(b, c, d, a, e, f, g);
			assertEquals(a, actual4, Double.MIN_VALUE);
			double actual7 = Statistics.max7(g, f, e, d, c, b, a);
			assertEquals(a, actual7, Double.MIN_VALUE);
		}
	}

	@Test(timeout = 666)
	public void pubTest_maxN() {
		for (int pass = 0; pass < 42; pass++) {
			int len = 1 + RND.nextInt(42), maxP = RND.nextInt(len);
			double[] x = new double[len];
			x[maxP] = rndDbl();
			for (int i = 0; i < len; i++) {
				x[i] = i == maxP ? x[maxP] : x[maxP] - rndPosDbl();
			}
			double actual1 = Statistics.maxN(x);
			assertEquals(x[maxP], actual1, Double.MIN_VALUE);
		}
	}

	// ========== average ==========
	@Test(timeout = 666)
	public void pubTest_average3() {
		double expected1 = 1806.41483333333333;
		double actual1 = Statistics.average3(4711.0815d, 42.0815d, 666.0815d);
		assertEquals(expected1, actual1, 1e-12);
		double expected2 = 908.421;
		double actual2 = Statistics.average3(2017.10, 42.0815, 666.0815);
		assertEquals(expected2, actual2, 1e-12);
	}

	@Test(timeout = 666)
	public void pubTest_averageN() {
		for (int pass = 0; pass < 42; pass++) {
			int len = 1 + RND.nextInt(42);
			double[] x = new double[len];
			double s = 0;
			for (int i = 0; i < len; i++) {
				s += x[i] = rndDbl();
			}
			double expected = s / len;
			double actual = Statistics.averageN(x);
			assertEquals(expected, actual, expected * 1e-42);
		}
	}

	// ========== median ==========
	@Test(timeout = 666)
	public void pubTest_median3() {
		for (int pass = 0; pass < 42; pass++) {
			double a = rndDbl(), b = a + rndPosDbl(), c = a - rndPosDbl();
			double actual1 = Statistics.median3(a, b, c);
			assertEquals(a, actual1, Double.MIN_VALUE);
			double actual2 = Statistics.median3(b, a, c);
			assertEquals(a, actual2, Double.MIN_VALUE);
			double actual3 = Statistics.median3(c, b, a);
			assertEquals(a, actual3, Double.MIN_VALUE);
		}
	}

	@Test(timeout = 666)
	public void pubTest_median4() {
		for (int pass = 0; pass < 42; pass++) {
			List<Double> abcd = new ArrayList<>(Arrays.asList(rndDbl(), rndDbl(), rndDbl(), rndDbl()));
			List<Double> abcdS = new ArrayList<>(abcd);
			Collections.shuffle(abcd);
			Collections.sort(abcdS);
			double a = abcd.get(0), b = abcd.get(1), c = abcd.get(2), d = abcd.get(3);
			String message = "median4(" + abcd.toString() + ")";
			double expected = (abcdS.get(1) + abcdS.get(2)) / 2;
			double actual = Statistics.median4(a, b, c, d);
			assertEquals(message, expected, actual, Double.MIN_VALUE);
		}
	}

	@Test(timeout = 6666)
	public void pubTest_medianN() {
		for (int pass = 0; pass < 42; pass++) {
			int lenOdd = 2 * RND.nextInt(42) + 1;
			List<Double> xOddL = new ArrayList<>(), xEvenL = new ArrayList<>();
			for (int i = 0; i < lenOdd; i++) {
				xOddL.add(rndDbl());
				xEvenL.add(rndDbl());
			}
			xEvenL.add(rndDbl()); // make it even ;)
			List<Double> xOddLS = new ArrayList<>(xOddL), xEvenLS = new ArrayList<>(xEvenL);
			Collections.shuffle(xOddL);
			Collections.sort(xOddLS);
			Collections.shuffle(xEvenL);
			Collections.sort(xEvenLS);
			double[] xOdd = new double[xOddL.size()], xEven = new double[xEvenL.size()];
			for (int i = 0; i < xOddL.size(); i++) {
				xOdd[i] = xOddL.get(i);
			}
			for (int i = 0; i < xEvenL.size(); i++) {
				xEven[i] = xEvenL.get(i);
			}
			String messageOdd = "medianN(" + Arrays.toString(xOdd) + ")";
			String messageEven = "medianN(" + Arrays.toString(xEven) + ")";
			double expectedOdd = xOddLS.get(xOddLS.size() / 2), expectedEven = (xEvenLS.get(xEvenLS.size() / 2 - 1) + xEvenLS.get(xEvenLS.size() / 2)) / 2;
			double actualOdd = Statistics.medianN(xOdd);
			double actualEven = Statistics.medianN(xEven);
			assertEquals(messageOdd, expectedOdd, actualOdd, Double.MIN_VALUE);
			assertEquals(messageEven, expectedEven, actualEven, Double.MIN_VALUE);
		}
	}

	private double rndPosDbl() {
		return 4711.0815 * RND.nextDouble();
	}

	private double rndDbl() {
		return (RND.nextBoolean() ? 4711.0815 : -4711.0815) * RND.nextDouble();
	}
}