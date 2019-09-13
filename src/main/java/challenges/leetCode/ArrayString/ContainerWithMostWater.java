package challenges.leetCode.ArrayString;

//Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
//        n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
//        Find two lines, which together with x-axis forms a container,
//        such that the container contains the most water.
//        Note: You may not slant the container and n is at least 2.
//
//        Input: [1,8,6,2,5,4,8,3,7]
//        Output: 49


public class ContainerWithMostWater {

    //  Brute Force
//    public int maxArea(int[] height) {
//        int max = 0;
//        for (int i = 0; i < height.length; i++) {
//            for (int j = i; j >= 0; j--) {
//                    int tr = Math.min(height[i], height[j])*(i - j);
//                    max = Math.max(max, tr);
//            }
//        }
//        return max;
//    }

    // Single pass
    public int maxArea(int[] height) {
        int max = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            int tr = Math.min(height[l], height[r])*(r - l);
            max = Math.max(max, tr);
            if (height[l] > height[r]) {
                r --;
            } else {
                l++;
            }
        }
        return max;
    }




    public static void main(String[] args) {
        ContainerWithMostWater water = new ContainerWithMostWater();
        int test[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        water.maxArea(test);

    }
}
