package easy;

public class TwoSum {

	public static void main(String[] args) {
		int[] nums = { 2, 7, 11, 15 };
		int target = 9;
		int[] result = twoSum(nums, target);
		for (int a : result) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

	public static int[] twoSum(int[] numbers, int target) {
		int[] result = { 0, 0 };
		int length = numbers.length;
		int[] numbers2 = numbers.clone();
		qSort(numbers, 0, length - 1);

		for (int i = 0; i < length; ++i) {
			if (numbers[i] > target) {
				break;
			}
			int tmp = binarySearch(numbers, 0, length - 1, target - numbers[i]);
			if (tmp != -1) {
				for (int j = 0; j < length; ++j) {
					if (numbers2[j] == numbers[i]) {
						if (result[0] == 0) {
							result[0] = j + 1;
							continue;
						}
					}
					if (numbers2[j] == numbers[tmp]) {
						result[1] = j + 1;
					}
				}
				if (result[0] > result[1]) {
					int tmp2 = result[1];
					result[1] = result[0];
					result[0] = tmp2;
				}
				return result;
			}
		}
		return result;
	}

	public static int binarySearch(int[] numbers, int low, int high, int target) {
		while (low <= high) {
			int middle = low + (high - low) / 2;
			if (numbers[middle] == target) {
				return middle;
			} else if (numbers[middle] > target) {
				high = middle - 1;
			} else {
				low = middle + 1;
			}
		}
		return -1;
	}

	public static void qSort(int[] numbers, int low, int high) {
		if (low < high) {
			int pos = quickSort(numbers, low, high);
			qSort(numbers, low, pos - 1);
			qSort(numbers, pos + 1, high);
		}
	}

	public static int quickSort(int[] numbers, int low, int high) {
		// middle as pivot
		int middle = low + (high - low) / 2;
		int tmp = numbers[middle];
		numbers[middle] = numbers[low];
		numbers[low] = tmp;
		int pivot = numbers[low];
		while (low < high) {
			while (low < high && numbers[high] >= pivot)
				high--;
			numbers[low] = numbers[high];
			while (low < high && numbers[low] <= pivot)
				low++;
			numbers[high] = numbers[low];
		}
		numbers[low] = pivot;
		return low;
	}
}
