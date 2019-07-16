package challenges.leetCode;

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
