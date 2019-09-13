package challenges.leetCode.DP;

//You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
//
//        Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
//
//        Example 1:
//
//        Input: [1,2,3,1]
//        Output: 4
//        Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//        Total amount you can rob = 1 + 3 = 4.


public class HouseTheif {

//    Input: [2,7,9,3,1]
//    Output: 12
//    Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
//    Total amount you can rob = 2 + 9 + 1 = 12.

    public static void main(String args[]) {
//        int nums[] = {2,7,9,3,1};
//        int nums[] = {2, 1, 1, 2};
        int nums[] = {1, 2, 3, 1};
        int result = houseTheif(nums);
//        int result = houseTheifBottomUp(nums);
        System.out.println(result);
    }

    public static int houseTheif(int[] nums) {
        int i = 0;
        int[] dp = new int[nums.length];
        return houseTheifRecHelper(dp, nums, i);
    }

    public static int houseTheifRecHelper(int[] dp,  int[] nums, int i) {
        if (i > nums.length - 1) {
            return 0;
        }
        if (dp[i] == 0) {
            int take  = nums[i] + houseTheifRecHelper(dp, nums, i + 2);
            int skip = houseTheifRecHelper(dp, nums, i + 1);
            int value =  Math.max(take, skip);
            dp[i] = value;
        } else {
            return dp[i];
        }

        return dp[i];
    }


    public static int houseTheifBottomUp(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return (Math.max(nums[0], nums[1]));
        }
        int[] dp = new int[nums.length];
        return houseTheifBottomUpHelper(dp, nums);
    }


    public static int houseTheifBottomUpHelper(int[] dp,  int[] nums) {
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max((dp[i - 2] + nums[i]), dp[i-1]);
        }
        return dp[nums.length  - 1];
    }





//    public static int houseTheifCircular(int[] nums) {
//        if (nums.length == 0) {
//            return 0;
//        }
//        if (nums.length == 1) {
//            return nums[0];
//        }
//        if (nums.length == 2) {
//            return (Math.max(nums[0], nums[1]));
//        }
//        int i = 0;
//        int[] dp = new int[nums.length];
//        int[] nums1 = nums.clone();
//        nums1[0] = 0;
//        int[] nums2 = nums.clone();
//        nums2[nums2.length - 1]  = 0;
//        return Math.max(houseTheifRecHelperCirc(dp, nums1, i), houseTheifRecHelperCirc(dp, nums2, i));
//    }
//
//    public static int houseTheifRecHelperCirc(int[] dp,  int[] nums, int i) {
//        if (i > nums.length - 1) {
//            return 0;
//        }
//        if (dp[i] == 0) {
//            int take  = nums[i] + houseTheifRecHelperCirc(dp, nums, i + 2);
//            int skip = houseTheifRecHelperCirc(dp, nums, i + 1);
//            int value =  Math.max(take, skip);
//            dp[i] = value;
//        } else {
//            return dp[i];
//        }
//        return dp[i];
//    }


}
