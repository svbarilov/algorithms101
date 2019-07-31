package challenges.leetCode;

import java.util.ArrayList;

public class GeneratePowerSet {

    // combination
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6};
//        powerset(input, new ArrayList<>(), 0);
        powersetAlt(input, new ArrayList<>(), 0);
    }


    public static void powerset(int[] input, ArrayList<Integer> partial, int start) {
        System.out.println(partial.toString());
        for (int i = start; i < input.length; i++) {
            partial.add(input[i]);
            powerset(input, partial, i + 1);
            partial.remove(partial.size() - 1);
        }
    }

    public static void powersetAlt(int[] input, ArrayList<Integer> partial, int start) {
        if (start == input.length) {
            System.out.println(partial.toString());
            return;
        }
        partial.add(input[start]);
        powersetAlt(input, partial, start + 1);
        partial.remove(partial.size() - 1);
        powersetAlt(input, partial, start + 1);
    }



}
