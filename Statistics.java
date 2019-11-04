/**
 * <p>This class provides different convenient methods for statistical operations.</p>
 * <p>The arguments provided to the methods may be or contain {@link Double#NEGATIVE_INFINITY} or {@link Double#POSITIVE_INFINITY} (handled here as usual in mathematics), but must <b>NOT</b> be or contain {@link Double#NaN}.</p>
 * <p>The methods do <b>not handle overflows</b> in any specific way (e.g. if the sum of the arguments exceed the double value range, the result of the average computation may be wrong).</p>
 */
public class Statistics {
	// ==================== min ====================

	/**
	 * Computes the minimum of its two arguments.
	 *
	 * @param a the first argument
	 * @param b the second argument
	 * @return the minimum of its two arguments.
	 */
	public static double min2(double a, double b) {
		double c;
		if (a< b){
			c=a ;
		}else{
			c= b ;
		}
		return  c ;// TODO
	}

	/**
	 * Computes the minimum of its three arguments.
	 *
	 * @param a the first argument
	 * @param b the second argument
	 * @param c the third argument
	 * @return the minimum of its three arguments.
	 */
	public static double min3(double a, double b, double c) {
		double d = 0;
		if( (a<b)&(a<c) ){
			d = a ;
		}
		if((b<a) & (b<c)){
			d=b;
		}
		if ((c<a)&(c<b)){
			d= c;
		}
		return d ; // TODO
	}

	/**
	 * Computes the minimum of its seven arguments.
	 *
	 * @param a the first argument
	 * @param b the second argument
	 * @param c the third argument
	 * @param d the fourth argument
	 * @param e the fifth argument
	 * @param f the sixth argument
	 * @param g the seventh argument
	 * @return the minimum of its seven arguments.
	 */
	public static double min7(double a, double b, double c, double d, double e, double f, double g) {
		double h;
		if(a<b){
			h=a;
		}else{
			h= b;
		}
		if(c<h){
			h=c;
		}
		if (d<h){
			h=d;
		}
		if(e<h){
			h=e;
		}
		if(f<h){
			h=f;
		}
		if(g<h){
			h=g;
		}
		return h ; // TODO
	}

	/**
	 * Computes the minimum of the values in the argument array. If this array is null or empty, then this method returns {@link Double#NaN}.
	 *
	 * @param x the argument array
	 * @return the minimum of the values in the argument array.
	 */
	public static double minN(double[] x) {
		if (x == null) return Double.NaN;
		if(x.length == 0) return Double.NaN ;

		double min = x[0];
		for (int i = 1; i < x.length; i++) {
			if (min > x[i])  min = x[i];
		}
		return min ;
	}

	// ==================== max ====================

	/**
	 * Computes the maximum of its two arguments.
	 *
	 * @param a the first argument
	 * @param b the second argument
	 * @return the maximum of its two arguments.
	 */
	public static double max2(double a, double b) {
		double max = a ;
		if(max < b ) max = b ;
		return max ; // TODO
	}

	/**
	 * Computes the maximum of its three arguments.
	 *
	 * @param a the first argument
	 * @param b the second argument
	 * @param c the third argument
	 * @return the maximum of its three arguments.
	 */
	public static double max3(double a, double b, double c) {
		double max = a;
		if (max < b ) max = b;
		if (max < c ) max = c;
		return max ; // TODO
	}

	/**
	 * Computes the maximum of its seven arguments.
	 *
	 * @param a the first argument
	 * @param b the second argument
	 * @param c the third argument
	 * @param d the fourth argument
	 * @param e the fifth argument
	 * @param f the sixth argument
	 * @param g the seventh argument
	 * @return the maximum of its seven arguments.
	 */
	public static double max7(double a, double b, double c, double d, double e, double f, double g) {
		double max = a;
		if (max < a) max = a;
		if (max < b) max = b;
		if (max < c) max = c;
		if (max < d) max = d;
		if (max < e) max = e;
		if (max < f) max = f;
		if (max < g) max = g;
		return max;
	}


		/**
	 * Computes the maximum of the values in the argument array. If this array is null or empty, then this method returns {@link Double#NaN}.
	 *
	 * @param x the argument array
	 * @return the maximum of the values in the argument array.
	 */
	public static double maxN(double[] x) {
		double max = x[0];
		for (int i=0;i< x.length;i++){
			if(x[i]>max) x[i]= max;
		}
		return max ; // TODO
	}

	// ==================== Mittelwert ====================

	/**
	 * Computes the arithmetic average of its three arguments. This method does <b>not handle overflows</b> in any specific way.
	 *
	 * @param a the first argument
	 * @param b the second argument
	 * @param c the third argument
	 * @return the arithmetic average of its three arguments.
	 */
	public static double average3(double a, double b, double c) {
		double ave = (a+b+c ) / 3;
		return ave ; // TODO
	}

	/**
	 * Computes the arithmetic average of the values in the argument array. If this array is null or empty, then this method returns {@link Double#NaN}. This method does <b>not handle overflows</b> in any specific way.
	 *
	 * @param x the argument array
	 * @return the arithmetic average of the values in the argument array.
	 */
	public static double averageN(double[] x) {
		double sum = 0 ;
		int h=0;
		for (int i = 0; i < x.length;i++){
			sum = sum + x[i];
			h = h+1;
		}
		return (sum/h); // TODO
	}

	// ==================== Median ====================

	/**
	 * Computes the median of its three arguments, i.e. the <b>middle</b> value.
	 *
	 * @param a the first argument
	 * @param b the second argument
	 * @param c the third argument
	 * @return the median of its three arguments, i.e. the <b>middle</b> value.
	 */
	public static double median3(double a, double b, double c) {
		double[] arr = {a,b,c};
		for (int i = 0;i<arr.length-1;i++){
			for (int j = 0;j< arr.length - 1-i ;j++){
				if (arr[j]>arr[j+1]){
					double temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		return arr[1] ; // TODO
	}

	/**
	 * Computes the median of its four arguments, i.e. the <b>average of the two middle</b> values.
	 *
	 * @param a the first argument
	 * @param b the second argument
	 * @param c the third argument
	 * @param d the fourth argument
	 * @return the median of its four arguments, i.e. the <b>average of the two middle</b> values.
	 */
	public static double median4(double a, double b, double c, double d) {
        double[] arr = {a,b,c,d };
        for (int i = 0;i<arr.length-1;i++){
            for (int j = 0;j< arr.length - 1-i ;j++){
                if (arr[j]>arr[j+1]){
                    double temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return (arr[1]+arr[2])/2 ; // TODO
	}

	/**
	 * Computes the median of the values in the argument array. If this array is null or empty, then this method returns {@link Double#NaN}.
	 *
	 * @param x the argument array
	 * @return the median of the values in the argument array.
	 */
	public static double medianN(double[] x) {
		int i,j;
		for (i = 0;i < x.length-1;i++){
			for (j = 0;j < x.length-1-i;j++){
				double temp = x[j];
				if(x[j] > x[j+1]){
					x[j] = x[j+1];
					x[j+1]=temp;
				}
			}
		}
		if(x.length%2 == 0) {
			return (x[x.length / 2] + x[x.length / 2 - 1]) / 2; // TODO
		}else {
			return x[(x.length - 1) / 2];
		}
	}
}