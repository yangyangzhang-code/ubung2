import static org.junit.Assert.*;
import org.junit.*;
import java.lang.reflect.*;
import java.util.*;

public class TrianglePublicTest {
	// ========== SYSTEM ==========
	static final String TRIANGLE_TYPE = "TriangleType";
	static final String TRIANGLE_CLASSIFY = "Triangle.classify";
	static final String TRIANGLE_COMPUTE = "Triangle.compute";
	// --------------------

	// ========== TEST DATA ==========
	private static final Random RND = new Random(4711_0815_666L);

	// ========== PUBLIC TEST ==========
	@Test(timeout = 666)
	public void pubTest__TriangleType() {
		Class<TriangleType> clazz = TriangleType.class;
		assertTrue(clazz + " muss eine Aufzaehlung sein!", clazz.isEnum());
		assertSame(clazz + " soll genau eine bestimmte Super-Klasse haben!", Enum.class, clazz.getSuperclass());
		assertEquals(clazz + " soll keine Schnittstellen implementieren!", 0, clazz.getInterfaces().length);
		assertEquals(clazz + " soll keine inneren Klassen haben!", 0, getDeclaredClasses(clazz).length);
		assertEquals(clazz + " soll keine inneren Annotationen haben!", 0, clazz.getDeclaredAnnotations().length);
		assertEquals(clazz + " soll genau die vorgegebene Anzahl Attribute haben!", 7, getDeclaredFields(clazz).length);
		assertEquals(clazz + " soll genau die vorgegebene Anzahl Konstruktoren (ggf. inkl. default cons) haben!", 1, getDeclaredConstructors(clazz).length);
		assertEquals(clazz + " soll genau die vorgegebene Anzahl Methoden haben!", 2, getDeclaredMethods(clazz).length);
		assertFalse("gleichseitig".equals(TriangleType.EQUILATERAL.toString()) && "gleichschenklig".equals(TriangleType.ISOSCELES.toString()) && "unregelmaessig".equals(TriangleType.SCALENE.toString()));
		assertFalse("spitzwinklig".equals(TriangleType.ACUTE.toString()) && "rechtwinklig".equals(TriangleType.RIGHT.toString()) && "stumpfwinklig".equals(TriangleType.OBTUSE.toString()) && "ungueltige Eingabe".equals(TriangleType.ILLEGAL.toString()));
	}

	@Test(timeout = 666)
	public void pubTest__classifyBySides() {
		for (int pass = 0; pass < 42; pass++) {
			long a = 666 + RND.nextInt(42);
			long b = a - 42 - RND.nextInt(42);
			long c = a + 42 + RND.nextInt(42);
			TrianglePublicTest.check__classifyBySides(a, b, c, TriangleType.SCALENE, false);
			TrianglePublicTest.check__classifyBySides(a, b, a, TriangleType.ISOSCELES, false);
			TrianglePublicTest.check__classifyBySides(a, a, a, TriangleType.EQUILATERAL, false);
			TrianglePublicTest.check__classifyBySides(0, 0, 0, TriangleType.ILLEGAL, false);
		}
	}

	@Test(timeout = 666)
	public void pubTest__classifyByAngles() {
		for (int pass = 0; pass < 42; pass++) {
			long alpha = 46 + RND.nextInt(44);
			long beta = 46 + RND.nextInt(44);
			long gamma = 180 - alpha - beta;
			TrianglePublicTest.check__classifyByAngles(alpha, beta, gamma, TriangleType.ACUTE, false);
			TrianglePublicTest.check__classifyByAngles(90, beta, 180 - 90 - beta, TriangleType.RIGHT, false);
			TrianglePublicTest.check__classifyByAngles(alpha - 45, beta - 45, gamma + 90, TriangleType.OBTUSE, false);
			TrianglePublicTest.check__classifyByAngles(180, 0, 0, TriangleType.OBTUSE, false);
			TrianglePublicTest.check__classifyByAngles(0, 0, 0, TriangleType.ILLEGAL, false);
		}
	}

	@Test(timeout = 6666)
	public void pubTest__compute() {
		for (int pass = 0; pass < 100; pass++) {
			double a = 666 + RND.nextInt(42);
			double b = a - 42 - RND.nextInt(42);
			double c = a + 42 + RND.nextInt(42);
			double alpha = 46 + RND.nextInt(44);
			double beta = 46 + RND.nextInt(44);
			double gamma = 180 - alpha - beta;
			TrianglePublicTest.check__compute(a, b, c, Double.NaN, Double.NaN, Double.NaN, false); // SSS
			TrianglePublicTest.check__compute(Double.NaN, Double.NaN, c, alpha, beta, Double.NaN, false); // WSW
			TrianglePublicTest.check__compute(a, b, a + b + 0.5, Double.NaN, Double.NaN, Double.NaN, true); // SSS-fail
			TrianglePublicTest.check__compute(Double.NaN, Double.NaN, Double.NaN, alpha, beta, gamma, true); // WWW-fail
		}
	}

	// ========== HELPER ==========
	static void check__classifyBySides(long a, long b, long c, TriangleType expected, boolean not) {
		TriangleType actual = Triangle.classifyBySides(a, b, c);
		if (not) {
			assertNotSame("classifyBySides(a = " + a + ", b = " + b + ", c = " + c + ") should NOT give " + expected + ", but was " + actual, expected, actual);
		} else {
			assertSame("classifyBySides(a = " + a + ", b = " + b + ", c = " + c + ") should give " + expected + ", but was " + actual, expected, actual);
		}
	}

	static void check__classifyByAngles(long alpha, long beta, long gamma, TriangleType expected, boolean not) {
		TriangleType actual = Triangle.classifyByAngles(alpha, beta, gamma);
		if (not) {
			assertNotSame("classifyByAngles(alpha = " + alpha + ", beta = " + beta + ", gamma = " + gamma + ") should NOT give " + expected + ", but was " + actual, expected, actual);
		} else {
			assertSame("classifyByAngles(alpha = " + alpha + ", beta = " + beta + ", gamma = " + gamma + ") should give " + expected + ", but was " + actual, expected, actual);
		}
	}

	static void check__compute(double a, double b, double c, double alpha, double beta, double gamma, boolean not) {
		final double EPS = 1e-13;
		double[] in = {a, b, c, alpha, beta, gamma};
		double[] r = Triangle.compute(a, b, c, alpha, beta, gamma);
		assertNotNull("The array returned must NOT be null!", r);
		assertEquals("The array returned has wrong length.", in.length, r.length);
		for (int i = 0; i < in.length; i++) {
			if (!Double.isNaN(in[i])) {
				assertEquals("Array entry " + i + " is wrong (known value changed unexpectedly).", in[i], r[i], Double.MIN_VALUE);
			} else if (not) {
				assertTrue("Array entry " + i + " is wrong (unknown value cannot be computed).", Double.isNaN(r[i]));
			} else {
				assertFalse("Array entry " + i + " is wrong (unknown value should have been computed).", Double.isNaN(r[i]));
			}
		}
		double aR = r[0], bR = r[1], cR = r[2], alphaR = r[3], betaR = r[4], gammaR = r[5];
		if (!not) {
			assertEquals("Total angle sum is wrong!", 180, alphaR + betaR + gammaR, EPS);
			assertEquals("Formula a^2 = b^2 + c^2 - 2bc * cos(alpha) NOT satisfied!", aR * aR, bR * bR + cR * cR - 2 * bR * cR * Math.cos(Math.toRadians(alphaR)), aR * aR * EPS);
			assertEquals("Formula b^2 = a^2 + c^2 - 2ac * cos(beta) NOT satisfied!", bR * bR, aR * aR + cR * cR - 2 * aR * cR * Math.cos(Math.toRadians(betaR)), bR * bR * EPS);
			assertEquals("Formula c^2 = a^2 + b^2 - 2ab * cos(gamma) NOT satisfied!", cR * cR, aR * aR + bR * bR - 2 * aR * bR * Math.cos(Math.toRadians(gammaR)), cR * cR * EPS);
			double a2r = aR / Math.sin(Math.toRadians(alphaR)), b2r = bR / Math.sin(Math.toRadians(betaR)), c2r = cR / Math.sin(Math.toRadians(gammaR));
			if (alphaR != 0 && alphaR != 180 && betaR != 0 && betaR != 180) {
				assertEquals("Formula a / sin(alpha) = b / sin(beta) NOT satisfied!", a2r, b2r, a2r * EPS);
			}
			if (betaR != 0 && betaR != 180 && gammaR != 0 && gammaR != 180) {
				assertEquals("Formula b / sin(beta) = c / sin(gamma) NOT satisfied!", b2r, c2r, b2r * EPS);
			}
		}
	}

	// ========== HELPER: Intestines ==========
	// @AuD-STUDENT: DO NOT USE REFLECTION IN YOUR OWN SUBMISSION! BITTE KEINE REFLECTION IN DER EIGENEN ABGABE VERWENDEN! => "0 Punkte"!
	private static Class<?>[] getDeclaredClasses(Class<?> clazz) {
		List<Class<?>> declaredClasses = new ArrayList<>();
		for (Class<?> c : clazz.getDeclaredClasses()) {
			if (!c.isSynthetic()) {
				declaredClasses.add(c);
			}
		}
		return declaredClasses.toArray(new Class[0]);
	}

	private static Field[] getDeclaredFields(Class<?> clazz) {
		List<Field> declaredFields = new ArrayList<>();
		for (Field f : clazz.getDeclaredFields()) {
			if (!f.isSynthetic()) {
				declaredFields.add(f);
			}
		}
		return declaredFields.toArray(new Field[0]);
	}

	private static Constructor<?>[] getDeclaredConstructors(Class<?> clazz) {
		List<Constructor<?>> declaredConstructors = new ArrayList<>();
		for (Constructor<?> c : clazz.getDeclaredConstructors()) {
			if (!c.isSynthetic()) {
				declaredConstructors.add(c);
			}
		}
		return declaredConstructors.toArray(new Constructor[0]);
	}

	private static Method[] getDeclaredMethods(Class<?> clazz) {
		List<Method> declaredMethods = new ArrayList<>();
		for (Method m : clazz.getDeclaredMethods()) {
			if (!m.isBridge() && !m.isSynthetic()) {
				declaredMethods.add(m);
			}
		}
		return declaredMethods.toArray(new Method[0]);
	}
}
