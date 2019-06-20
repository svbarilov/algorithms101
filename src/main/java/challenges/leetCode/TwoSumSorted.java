package challenges.leetCode;

import java.util.Arrays;

public class TwoSumSorted {

//    Given nums = [2, 7, 11, 15], [3, 2, 4] target = 9,

    public int[] twoSum(int[] nums, int target) {
        //loop with two indicies, if smaller we increment, if larger we decrement
        Arrays.sort(nums);
        int[] result = new int[2];
        int si = 0;
        int bi = nums.length - 1;
        while (si < bi) {
            if (nums[si] + nums[bi] == target) {
                result[0] = si;
                result[1] = bi;
                System.out.println("{" + si + "}" + " " + "{" + bi + "}");
                si++;
                bi--;
            } else if (nums[si] + nums[bi] < target) {
                si++;

            } else if (nums[si] + nums[bi] > target) {
                bi--;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        TwoSumSorted twoSum = new TwoSumSorted();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        twoSum.twoSum(nums, target);
    }

}


