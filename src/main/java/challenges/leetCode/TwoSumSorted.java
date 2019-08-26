package challenges.leetCode;

//Given an array of integers, return indices of the two numbers such that they add up to a specific target.
//
//        You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//        Example:
//
//        Given nums = [2, 7, 11, 15], target = 9,
//
//        Because nums[0] + nums[1] = 2 + 7 = 9,
//        return [0, 1].


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


