public class Physics {
	/**
	 * Computes and returns the pressure p corresponding to v and t.
	 *
	 * @param v gas-volume in cubic meter
	 * @param t temperature in K (Kelvin)
	 * @return pressure p in Pa (Pascal)
	 */
	public static double computeP(double v, double t) {
		return 0.0; // TODO
	}

	/**
	 * Computes and returns the gas-volume v corresponding to p and t.
	 *
	 * @param p pressure in Pa (Pascal)
	 * @param t temperature in K (Kelvin)
	 * @return gas-volume v in cubic meter
	 */
	public static double computeV(double p, double t) {
		return 0.0; // TODO
	}

	/**
	 * Computes and returns the temperature t corresponding to p and v.
	 *
	 * @param p pressure in Pa (Pascal)
	 * @param v gas-volume in cubic meter
	 * @return temperature t in K (Kelvin)
	 */
	public static double computeT(double p, double v) {
		return 0.0; // TODO
	}

	/**
	 * Computes and returns the change in pressure corresponding to the given change in temperature (while keeping constant gas-volume).
	 *
	 * @param v      gas-volume (cubic meter)
	 * @param deltaT change in temperature (K)
	 * @return change in pressure (Pa)
	 */
	public static double computeDeltaPisochore(double v, double deltaT) {
		return 0.0; // TODO
	}

	/**
	 * Computes and returns the change in pressure corresponding to the given change in gas-volume (while keeping constant temperature).
	 *
	 * @param v      initial gas-volume (cubic meter)
	 * @param t      temperature (K)
	 * @param deltaV change in gas-volume (cubic meter)
	 * @return change in pressure (Pa)
	 */
	public static double computeDeltaPisotherm(double v, double t, double deltaV) {
		return 0.0; // TODO
	}

	/**
	 * Computes and returns the <b>mean</b> speed of a gas particle at the given temperature and molar mass.
	 * For details see <a href="https://de.wikipedia.org/wiki/Maxwell-Boltzmann-Verteilung#Mittlere_Geschwindigkeit">Maxwell-Boltzmann distribution</a>
	 *
	 * @param t temperature (K)
	 * @param m molar mass of a gas particle (kg/mol)
	 * @return average speed of a gas particle (m/s)
	 */
	public static double computeAverageSpeed(double t, double m) {
		return 0.0; // TODO
	}
}
