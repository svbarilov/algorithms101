package challenges.leetCode.DP;

public class NumberFactors {

    public static void main(String[] args) {
        int n = 5;
        int[] nums = {1, 3, 4};
        int[] dp = new int[n + 1];
//        int result = numFacRec(nums, n, dp);
        int result = numFacBottomUp(nums, n, dp);
        System.out.println(result);
    }

    public static int numFacRec(int[] nums, int n, int[] dp) {
        if (n == 0 || n == 1 || n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        if (dp[n] != 0) {
            return dp[n];
        } else {
            int one = numFacRec(nums, n - 1, dp);
            int two = numFacRec(nums, n - 3, dp);
            int three = numFacRec(nums, n - 4, dp);
            dp[n] = one + two + three;
            return dp[n];
        }
    }

    public static int numFacBottomUp(int[] nums, int n, int[] dp) {
        dp[0] = dp[1] = dp[2] = 1;
        dp[3] = 2;
        for (int i = 4; i < n+1; i++) {
            dp[i] = dp[i-1] + dp[i-3] + dp[i-3];
        }
        return dp[n];
    }
}
