package challenges.leetCode.Recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class AllPermutationsMy {
    public static void main(String[] args) {
        int[] input = {1,2,3,4,5};
        permutation(input);
    }

    /**
     * Returns all the permutations of elements of the given array
     * @param input
     */
    public static void permutation(int[] input){
        Arrays.sort(input);
        permutation(input,new ArrayList<>(),new boolean[input.length]);
    }


    // base case: if size = input.length
    // iterate over candidates, for each to partial and recurse, then undo the add
    public static void permutation(int[] input, ArrayList<Integer> partial, boolean[] used) {
        if (partial.size() == input.length) {
            System.out.println(partial.toString());
        }
        for (int i = 0; i < input.length; i++) {
            if (!used[i]) {
                partial.add(input[i]);
                used[i] = true;
                permutation(input, partial, used);
                partial.remove(partial.size() - 1);
                used[i] = false;
            }
        }

    }
}
