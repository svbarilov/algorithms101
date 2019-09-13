package challenges.leetCode.DP;

//Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
//
//        Example 1:
//
//        Input: [2,3,-2,4]
//        Output: 6
//        Explanation: [2,3] has the largest product 6.


public class MaximumProductSubarray {
//    Input: [2,3,-2,4]
//    Output: 6
//    Explanation: [2,3] has the largest product 6.

    public static void main(String args[]) {
        int[] nums = {2, 3, -2, 4};
//        int[] nums = {0, 2};
//        int[] nums = {3, -1, 4};
//        int[] nums = {-4, -3, -2};
//        int[] nums = {-2, 3, -4};
        int result = maxProduct(nums);
        System.out.println(result);
    }

//    public static int maxProduct(int[] nums) {
//        if (nums.length == 0) {
//            return 0;
//        } else if (nums.length == 1) {
//            return nums[0];
//        }
//        int curMax = Integer.MIN_VALUE;
//        for (int i = 0; i < nums.length; i++ ) {
//            int itMax = nums[i];
//            int sumSoFar = 1;
//            for (int j = i; j < nums.length; j++) {
//                sumSoFar *= nums[j];
//                itMax = Math.max(itMax, sumSoFar);
//            }
//            curMax = Math.max(curMax, itMax);
//        }
//        return curMax;
//    }

    public static int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int max = nums[0];
        int min = nums[0];
        int itMin = nums[0];
        int itMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tempMax;
            tempMax = Math.max(Math.max(nums[i], itMax*nums[i]), Math.max(nums[i], itMin*nums[i]));
            itMin = Math.min(Math.min(nums[i], itMax*nums[i]), Math.min(nums[i], itMin*nums[i]));
            itMax = tempMax;
            max = Math.max(itMax, max);
            min = Math.min(itMin, min);
        }
        return max;
    }



}


