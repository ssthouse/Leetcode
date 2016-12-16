package leetcode;

import java.util.Arrays;
import java.util.HashMap;

/* Given an array of integers, find two numbers such that they add up to a specific target 
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution.
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */
/* Time complexity of this solution: O(n)
 */
public class TwoSum3 {
	public int[] twoSum(int[] numbers, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < numbers.length; i++) {
			int x = numbers[i];
			if (map.containsKey(target - x)) {
				int[] res = { map.get(target - x) + 1, i + 1 };
				return res;
			}
			map.put(x, i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}


	/************* my solution **************************************/
    /**
     * 使用hashMap来存数  index 和 value 的方法
     */

    public int[] getResult(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        //先全部放进去
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        //遍历寻找target
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{Math.min(i, map.get(target - nums[i])), Math.max(i, map.get(target - nums[i]))};
            }
        }
        return null;
    }


    public static void main(String args[]) {
        int testArray[] = {2, 7, 11, 15};
        Arrays.sort(testArray);
        int testTarget = 9;
        int[] result = new TwoSum3().twoSum(testArray, testTarget);
        int[] myResult = new TwoSum3().getResult(testArray, testTarget);
        //输出结果
        System.out.println("result:\t" + Arrays.toString(result));
        System.out.println("myResult:\t" + Arrays.toString(myResult));

        int i=10;

        System.out.print(++i);
    }
}
