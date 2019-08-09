package challenges.leetCode;

import java.util.Arrays;

public class ZeroOneKnapsack {

    public static void main(String[] args) {
        int[] profits = {31, 26, 72, 17};
        int[] weights = {3, 1, 5, 2};
        int cap = 7;
        int result = kp(profits, weights, cap);
//        int result = kpButUp(profits, weights, cap);
        System.out.println(result);
    }

//    kp(p, w, c, i) = Max(p[i] + kp(p, w, i + 1, c - w[i]), kp(p, w, i+1, w))
    public static int kp(int[] profits, int[]  weights, int cap) {
        int i = 0;
        int length = profits.length;
        int[][] dp = new int[cap + 1][length+1];
        for (int w = 1; w < cap+1; w++) {
            Arrays.fill(dp[w], -1);
        }
        for (int j = 0; j < cap+1; j++) {
            dp[j][length] = 0;
        }
        return kp(profits, weights, i, cap, dp);
    }


    public static int kp(int[] profits, int[]  weights, int i, int cap, int[][] dp) {
        if (i > profits.length - 1|| cap < 0) {
            return 0;
        }
        if (dp[cap][i] == -1) {
            if (weights[i] <= cap) {
                int take = profits[i] + kp(profits, weights, i+1, cap - weights[i], dp);
                int skip = kp(profits, weights, i+1, cap, dp);
                dp[cap][i] = Math.max(take, skip);
                return dp[cap][i];
            } else {
                dp[cap][i] = kp(profits, weights, i+1, cap, dp);
                return dp[cap][i];
            }
        } else {
            return dp[cap][i];
        }
    }



    public static int kpButUp(int[] profits, int[]  weights, int cap) {
        int length = profits.length;
        int[][] dp = new int[cap+1][length+1];
        for (int w = 1; w < cap+1; w++) {
            Arrays.fill(dp[w], -1);
        }
        for (int j = 0; j < cap+1; j++) {
            dp[j][length] = 0;
        }
        for (int w = 1; w < cap+1; w++) {
            for (int i = length-1; i >= 0; i--) {
                int take = 0;
                int skip = 0;
                if (weights[i] <= w) {
                    take = profits[i] + dp[w-weights[i]][i+1];
                    skip = dp[w][i+1];
                    dp[w][i] = Math.max(take, skip);
                } else {
                    skip = dp[w][i+1];
                    dp[w][i] = skip;
                }
            }
        }
        return dp[cap][0];
    }



}
