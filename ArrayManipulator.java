/**
 * This class provides several methods for converting arrays between different dimensions.
 */
public class ArrayManipulator {
	/**
	 * Converts a 2D array into an 1D array by concatenating the rows of the argument array.
	 * If and only if the input is {@literal null}, then this method returns {@literal null} as well.
	 * Empty or {@literal null} rows are skipped and ignored.
	 * <ul>
	 *     <li><p>Example:</p>
	 *     <p><kbd>{{0,1,2},{3,4,5}}</kbd> => <samp>{0,1,2,3,4,5}</samp></p></li>
	 * </ul>
	 *
	 * @param input the 2D array to be converted into an 1D array
	 * @return an 1D array containing exactly the elements from the input array in original order
	 */
	public static int[] convertTo1D(int[][] input) {
		if (input == null) return null;
		else {
			int[] n;
			int len = 0;
			// 计算一维数组长度
			for (int[] element : input) {
				len += element.length;
			}
			// 复制元素
			n = new int[len];
			int index = 0;
			for (int[] element : input) {
				for (int element2 : element) {
					n[index++] = element2;
				}
			}
			return n; // TODO
		}
	}

	/**
	 * Converts a 3D array into an 1D array by concatenating the entries of the argument array in lexicographic order of their cell address.
	 * If and only if the input is {@literal null}, then this method returns {@literal null} as well.
	 * Empty or {@literal null} sub-dimensions are skipped and ignored.
	 * <ul>
	 *     <li><p>Example:</p>
	 *     <p><kbd>{{{0,1},{2,3}},{{4,5},{6,7}}}</kbd> => <samp>{0,1,2,3,4,5,6,7}</samp></p></li>
	 * </ul>
	 *
	 * @param input the 3D array to be converted into an 1D array
	 * @return an 1D array containing exactly the elements from the input array in original order
	 */
	public static int[] convertTo1D(int[][][] input) {
		if (input == null) return null;
		else { // 遍历三维数组
			int[] n;
			int len = 0;
			// 计算一维数组长度
			for (int[][] element : input) {
				for (int[] element2 : element) {
					len += element2.length;
				}
			}
			// 复制元素
			n = new int[len];
			int index = 0;
			for (int[][] element : input) {
				for (int[] element2 : element) {
					for (int element3 : element2) {
						n[index++] = element3;
					}
				}
			}
			return n; // TODO
		}
	}

	/**
	 * Converts an 1D array into a quadratic 2D array, if the number of the elements in the input array is a square number.
	 * Otherwise, the last row of the resulting array is shortened to perfectly fit the remaining values or removed entirely.
	 * In any case, the number of columns in each row must be the same for all rows (except possibly for the last row) and
	 * the number of rows (r) of the resulting array is the same (if possible) or smaller by at most one (if needed) than the number of columns (c) in the first row (c-1 <= r <= c).
	 * If and only if the input is {@literal null}, then this method returns {@literal null} as well.
	 * <ul>
	 *     <li><p>Example:</p>
	 *     <p><kbd>{0,1,2,3,4,5,6,7}</kbd> => <samp>{{0,1,2},{3,4,5},{6,7}}</samp></p></li>
	 * </ul>
	 *
	 * @param input the 1D array to be converted into an almost quadratic 2D array
	 * @return an almost quadratic 2D array containing exactly the elements from the input array in original order
	 */
	public static int[][] convertTo2D(int[] input) {
		if (input == null) return null;
		else {
			int r;
			int c;
			int[][] arr;
			int len = input.length;
			r = (int) Math.sqrt(len);
			if (len % r == 0) {
				r = r - 1;//rows
				c = r; //colums
			} else {
				c = r;
				r = len / (r + 1);
			}
			arr = new int[r][c];
			int num = -1;
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					num++;
					arr[i][j] = input[num];
				}
			}
			return arr; // TODO
		}
	}

	/**
	 * Converts an 1D array into a 2D array according to the given distribution:
	 * <ul>
	 *     <li>the length of the resulting array is the same as the length of the {@code distribution} array</li>
	 *     <li>the length of the i-th row in the resulting array is determined by the i-th entry in the distribution array as long as there are enough values to be taken from the {@code input} (respecting the {@code circular} flag!) - otherwise, the row is shortened accordingly to just fit to the remaining values (a row might be empty, but never {@literal null})</li>
	 *     <li>the values filled into the resulting array are taken from {@code input} in the given order</li>
	 *     <li>if the input has less values than required to satisfy the conditions above, then {@code input} is traversed from the beginning iff {@code circular} is {@literal true}, otherwise the last row(s) are shorter or even empty</li>
	 * </ul>
	 * If and only if at least on of the input arrays is {@literal null}, then this method returns {@literal null} as well.
	 * <ul>
	 *     <li><p>Example I:</p>
	 *     <p><kbd>({0,1,2,3,4,5,6,7}, {3,4,3}, false)</kbd> => <samp>{{0,1,2},{3,4,5,6},{7}}</samp></p></li>
	 *     <li><p>Example II:</p>
	 *     <p><kbd>({0,1,2,3,4,5,6,7}, {4,3,4}, true)</kbd> => <samp>{{0,1,2,3},{4,5,6},{7,0,1,2}}</samp></p></li>
	 * </ul>
	 *
	 * @param input        the 1D array to be converted into a 2D array
	 * @param distribution the distribution describing the shape of the resulting 2D array
	 * @param circular     flag to denote, whether additional elements required for the shape are taken from the beginning of the input array
	 * @return 2D array containing exactly the elements from the input array in their (possibly circular) order, shaped as required by the distribution array
	 */
	public static int[][] convertTo2D(int[] input, int[] distribution, boolean circular) {
		if (input == null) return null;
		else {
			int h=input.length;
			int i=0;
			int j=0;
			int k=0;
			int[][] con;
			con = new int[i][j];
			int num = 0;
			for (i = 0; i < distribution.length ; i++) {
				for (j = 0; j < distribution[k] ; j++) {
					num++;
					if (circular) {
						if (num <= h) {
							con[i][j] = input[num];
						} else {
							con[i][j] = input[num  - h];
						}
					} else {
						con[i][j] = input[num];
					}
				}
			}
			return con; // TODO
		}
	}
}