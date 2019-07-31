package challenges.leetCode;

import java.util.ArrayList;

public class KIntegersFromArrayMy {

    // combination
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6};
        int k = 4;
//        combination(input, k, new ArrayList<>(), 0);
        combinationAlt(input, k, new ArrayList<>(), 0);
    }

    public static void combination(int[] input, int k, ArrayList<Integer> partial, int start) {
        if (partial.size() == k) {
            System.out.println(partial.toString());
            return;
        }
        if (start == input.length) {
            return;
        }
        for (int i = start; i < input.length; i++) {
            partial.add(input[i]);
            combination(input, k, partial, i + 1);
            partial.remove(partial.size() - 1);
        }
    }

    public static void combinationAlt(int[] input, int k, ArrayList<Integer> partial, int start) {
        if (partial.size() == k) {
            System.out.println(partial.toString());
            return;
        }
        if (start == input.length) {
            return;
        }
        partial.add(input[start]);
        combinationAlt(input, k, partial, start + 1);
        partial.remove(partial.size() - 1);
        combinationAlt(input, k, partial, start + 1);
    }

}
