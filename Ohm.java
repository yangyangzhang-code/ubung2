import java.util.DoubleSummaryStatistics;

/* Ohm's law: U = R*I */
public class Ohm {
	/* Calculate the voltage using Ohm's law */
	public static double voltage(double resistance, double current) {
		return  (resistance *  current) ; // TODO
	}

	/* Calculate the current using Ohm's law */
	public static double current(double voltage, double resistance) {
		return (voltage / resistance) ; // TODO
	}

	/* Calculate the resistance using Ohm's law */
	public static double resistance(double voltage, double current) {
		return  (voltage / current) ; // TODO
	}

	/* Calculate the resistance of two serial connected resistances */
	public static double resistanceSerialConnection2(double r1, double r2) {
		return (r1 + r2); // TODO
	}

	/* Calculate the resistance of two parallel connected resistances */
	public static double resistanceParallelConnection2(double r1, double r2) {
		return ( (r1* r2) / (r1 + r2) ) ; // TODO
	}

	/* Calculate the resistance of N serial connected resistances */
	public static double resistanceSerialConnectionN(double[] rs) {
		double sum = 0;
		int i ;
		for(i=0;i< rs.length;i++){
			sum = sum + rs[i];
		}
		return sum ; // TODO
	}

	/* Calculate the resistance of N parallel connected resistances */
	public static double resistanceParallelConnectionN(double[] rs) {
		double r=0;
		int i  ;
		for(i = 0;i< rs.length;i++){
		    r= r + 1/rs[i];
		}
		return 1/r  ; // TODO
	}
}