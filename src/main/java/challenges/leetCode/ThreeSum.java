package challenges.leetCode;

//Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
//
//        Note:
//
//        The solution set must not contain duplicate triplets.
//
//        Example:
//
//        Given array nums = [-1, 0, 1, 2, -1, -4],
//
//        A solution set is:
//        [
//        [-1, 0, 1],
//        [-1, -1, 2]
//        ]


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {


    public List<List<Integer>> perform(int[] nums) {
//        Collections.sort(nums);
//        HashSet<HashSet<Integer>> result = new  HashSet<>();
//            // iterate and check for number in hash
//        for (int i = 0; i < nums.size() - 2; i++) {
//            if (nums.get(i) > 0) {
//                break;
//            }
//            if (i > 1 && nums.get(i).equals(nums.get(i - 1))) {
//                continue;
//            }
//            HashSet<Integer> map = new HashSet<>();
//
//            for(int j = i + 1; j < nums.size(); j++) {
//                if (map.contains( -nums.get(i) - nums.get(j))) {
//                    HashSet<Integer> entry = new HashSet<>();
//                    entry.add(-nums.get(i) - nums.get(j));
//                    entry.add(nums.get(i));
//                    entry.add(nums.get(j));
//                    result.add(entry);
//                } else {
//                    map.add(nums.get(j));
//                }
//            }
//        }
//        System.out.println(result.toString());
//        return result;


            List<Integer> lst = new ArrayList();
            for (int i = 0; i <=  nums.length - 1; i++) {
                lst.add(nums[i]);
            }
            Collections.sort(lst);
            HashSet<List<Integer>> result = new  HashSet<>();
            for (int i = 0; i < lst.size() - 2; i++) {
                if (lst.get(i) > 0) {
                    break;
                }
                if (i > 1 && lst.get(i).equals(lst.get(i - 1))) {
                    continue;
                }
                HashSet<Integer> map = new HashSet<>();

                for(int j = i + 1; j < lst.size(); j++) {
                    if (map.contains( -lst.get(i) - lst.get(j))) {
                        List<Integer> entry = new ArrayList<>();
                        entry.add(-lst.get(i) - lst.get(j));
                        entry.add(lst.get(i));
                        entry.add(lst.get(j));
                        result.add(entry);
                    } else {
                        map.add(lst.get(j));
                    }
                }
            }
            List<List<Integer>> toreturn = new ArrayList();
            for (List<Integer> res : result) {
                toreturn.add(res);
            }
            System.out.println(toreturn.toString());
            return toreturn;
        }


}
