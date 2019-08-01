package challenges.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumIterative {

    public List<List<Integer>> threeSum(int[] nums) {

//        1. Sort all element of array
//        2. Run loop from i=0 to n-2.
//        Initialize two index variables l=i+1 and r=n-1
//        4. while (l < r)
//            Check sum of arr[i], arr[l], arr[r] is
//        zero or not if sum is zero then print the
//        triplet and do l++ and r--.

//        for unique set solution have separate loops for l and r that run while l < r
//        and duplicates appear then increment

//        5. If sum is less than zero then l++
//                6. If sum is greater than zero then r--
//                7. If not exist in array then print not found.

        int n = nums.length;
        List result = new ArrayList();
        Arrays.sort(nums);
        for (int i = 0; i < n -2; i++) {
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                if (i == 0 || (i > 0 && nums[i] != nums[i -1])) {
                    int sum = nums[i] + nums[l] + nums[r];
                    if (sum == 0) {
                        System.out.println("Answer: " + nums[i] + " " + nums[l] + " " + nums[r] + "\n");
                        List triple = new ArrayList();
                        triple.add(nums[i]);
                        triple.add(nums[l]);
                        triple.add(nums[r]);
                        result.add(triple);
                        while (l < r && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        while (l < r && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        l++;
                        r--;
                    } else if (sum > 0) {
                        r--;

                    } else if (sum < 0) {
                        l++;
                    }
                }
            }
        }
        return result;
    }

    public  static void main(String args[]) {
//        int nums[] = { 0, 0, 0, 0 };
//        int nums[] = {-1, 0, 1, 2, -1, -4};
        int[] nums = {-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
        ThreeSumIterative sum = new ThreeSumIterative();
        sum.threeSum(nums);
    }
}
