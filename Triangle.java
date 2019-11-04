import static java.lang.Math.*;
import static java.lang.Double.isNaN;

public class Triangle {
	/**
	 * Classifies the triangle according to the lengths of its sides.
	 * If no triangle can be built from the given side lengths, then its type is {@link TriangleType#ILLEGAL}.
	 *
	 * @param a length of side a
	 * @param b length of side b
	 * @param c length of side c
	 * @return the type of the triangle according to the lengths of its sides.
	 */
	public static TriangleType classifyBySides(long a, long b, long c) {
		if((a+b < c) || (a+c < b) || (b+c < a) || (a==0) || (b==0) || (c==0) ){
			return TriangleType.ILLEGAL;
		}else if ((a==b) && (b==c)){
			return TriangleType.EQUILATERAL;
		}else if ((a == b) || (a== c) || (b== c)){
			return TriangleType.ISOSCELES;
		}else{
			return TriangleType.SCALENE;
		}
	}

	/**
	 * Classifies the triangle according to the internal angles measured in degrees.
	 * If no triangle can be built from the given angles, then its type is {@link TriangleType#ILLEGAL}.
	 *
	 * @param alpha angle opposite to side a in degrees
	 * @param beta  angle opposite to side b in degrees
	 * @param gamma angle opposite to side c in degrees
	 * @return the type of the triangle according to the internal angles measured in degrees.
	 */
	public static TriangleType classifyByAngles(long alpha, long beta, long gamma) {
		if (alpha + beta + gamma == 180) {
			if (alpha == 90 || beta == 90 || gamma == 90) {
				return TriangleType.RIGHT;
			} else if (alpha > 90 || beta > 90 || gamma > 90) {
				return TriangleType.OBTUSE;
			} else {
				return TriangleType.ACUTE;
			}
		} else {
			return TriangleType.ILLEGAL;
		}
	}
	/**
	 * Computes the unknown parts of the triangle (marked {@link Double#NaN} as argument), as far as possible.
	 * Returns an array containing the given resp. computed lengths of the sides and angles in the order given as method parameters.
	 *
	 * @param a     length of side a ({@link Double#NaN} if initially unknown)
	 * @param b     length of side b ({@link Double#NaN} if initially unknown)
	 * @param c     length of side c ({@link Double#NaN} if initially unknown)
	 * @param alpha angle opposite to side a in degrees ({@link Double#NaN} if initially unknown)
	 * @param beta  angle opposite to side b in degrees ({@link Double#NaN} if initially unknown)
	 * @param gamma angle opposite to side c in degrees ({@link Double#NaN} if initially unknown)
	 * @return an array containing the given resp. computed lengths of the sides and angles in the order given as method parameters.
	 */
	public static double[] compute(double a, double b, double c, double alpha, double beta, double gamma) {
		a/Math.sin(alpha) = b/Math.sin(beta) = c/Math.sin(gamma);
		Math.pow(a,2) = Math.pow(b,2)+Math.pow(c,2) - 2*b*c*Math.cos(alpha);
		Math.pow(b,2) = Math.pow(a,2)+Math.pow(c,2) - 2*a*c*Math.cos(beta );
		Math.pow(c,2) = Math.pow(a,2)+Math.pow(b,2) - 2*a*b*Math.cos(gamma);
		return compute( double a, double b, double c, double alpha, double beta, double gamma ) ; // TODO
	}
}??????