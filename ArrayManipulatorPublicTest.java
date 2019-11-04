import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class ArrayManipulatorPublicTest {
	// ========== SYSTEM ==========
	static final String AM_2D_2_1D = "ArrayManipulator.2D-2-1D";
	static final String AM_3D_2_1D = "ArrayManipulator.3D-2-1D";
	static final String AM_1D_2_2D = "ArrayManipulator.1D-2-2D";
	static final String AM_1D_2_2D_SPECIAL = "ArrayManipulator.1D-2-2D - Special Edition";
	// --------------------

	// ========== TEST DATA ==========
	private static final Random RND = new Random(4711_0815_666L);

	// ========== PUBLIC TESTS ==========
	@Test(timeout = 3666)
	public void pubTest__AM_2D_2_1D() {
		for (int pass = 0; pass < 42; pass++) {
			ArrayManipulatorPublicTest.pubTest__AM_2D_2_1D__random();
		}
	}

	static void pubTest__AM_2D_2_1D__random() {
		int length = 7 + RND.nextInt(42);
		List<Integer> expectedsList = new LinkedList<>();
		int[][] input = new int[length][];
		for (int i = 0; i < length; i++) {
			int subLength = 7 + RND.nextInt(42);
			input[i] = new int[subLength];
			for (int j = 0; j < subLength; j++) {
				expectedsList.add(input[i][j] = RND.nextInt(4711) - 666);
			}
		}
		int[] expecteds = ArrayManipulatorPublicTest.list2array(expectedsList);
		int[] actuals = ArrayManipulator.convertTo1D(input);
		assertArrayEquals("Failed", expecteds, actuals);
	}

	// ----------------------------------------
	@Test(timeout = 6666)
	public void pubTest__AM_3D_2_1D() {
		for (int pass = 0; pass < 42; pass++) {
			ArrayManipulatorPublicTest.pubTest__AM_3D_2_1D__random();
		}
	}

	static void pubTest__AM_3D_2_1D__random() {
		int length = 7 + RND.nextInt(42);
		List<Integer> expectedsList = new LinkedList<>();
		int[][][] input = new int[length][][];
		for (int i = 0; i < length; i++) {
			int subLength = 7 + RND.nextInt(42);
			input[i] = new int[subLength][];
			for (int j = 0; j < subLength; j++) {
				int subSubLength = 7 + RND.nextInt(42);
				input[i][j] = new int[subSubLength];
				for (int k = 0; k < subSubLength; k++) {
					expectedsList.add(input[i][j][k] = RND.nextInt(4711) - 666);
				}
			}
		}
		int[] expecteds = ArrayManipulatorPublicTest.list2array(expectedsList);
		int[] actuals = ArrayManipulator.convertTo1D(input);
		assertArrayEquals("Failed", expecteds, actuals);
	}

	// ----------------------------------------
	@Test(timeout = 3666)
	public void pubTest__AM_1D_2_2D() {
		for (int pass = 0; pass < 42; pass++) {
			ArrayManipulatorPublicTest.pubTest__AM_1D_2_2D__random();
		}
	}

	static void pubTest__AM_1D_2_2D__random() {
		int length = 7 + RND.nextInt(42);
		int[][] expecteds = new int[length][length];
		int[] input = new int[length * length];
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				input[i * length + j] = expecteds[i][j] = RND.nextInt(4711) - 666;
			}
		}
		int[][] actuals = ArrayManipulator.convertTo2D(input);
		assertArrayEquals("Failed", expecteds, actuals);
	}

	// ----------------------------------------
	@Test(timeout = 3666)
	public void pubTest__AM_1D_2_2D_SPECIAL() {
		for (int pass = 0; pass < 42; pass++) {
			ArrayManipulatorPublicTest.pubTest__AM_1D_2_2D_SPECIAL__random();
		}
	}

	static void pubTest__AM_1D_2_2D_SPECIAL__random() {
		int length = 7 + RND.nextInt(42);
		int[][] expecteds = new int[length][];
		List<Integer> inputList = new LinkedList<>();
		int[] distribution = new int[length];
		for (int i = 0; i < length; i++) {
			int subLength = 7 + RND.nextInt(42);
			expecteds[i] = new int[subLength];
			distribution[i] = subLength;
			for (int j = 0; j < subLength; j++) {
				inputList.add(expecteds[i][j] = RND.nextInt(4711) - 666);
			}
		}
		int[] input = ArrayManipulatorPublicTest.list2array(inputList);
		int[][] actuals = ArrayManipulator.convertTo2D(input, distribution, RND.nextBoolean());
		assertArrayEquals("Failed.", expecteds, actuals);
	}

	// ========== HELPER ==========
	static int[] list2array(List<Integer> inList) {
		Integer[] inArray = inList.toArray(new Integer[0]);
		int[] out = new int[inArray.length];
		for (int i = 0; i < inArray.length; i++) {
			out[i] = inArray[i];
		}
		return out;
	}
}