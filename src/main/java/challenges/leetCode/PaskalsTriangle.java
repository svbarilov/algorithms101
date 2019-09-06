package challenges.leetCode;

import java.util.ArrayList;
import java.util.List;

//Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
//
//In Pascal's triangle, each number is the sum of the two numbers directly above it.
//
//        Example:
//
//        Input: 5
//        Output:
//        [
//        [1],
//        [1,1],
//        [1,2,1],
//        [1,3,3,1],
//        [1,4,6,4,1]
//        ]



public class PaskalsTriangle {

    public static void main(String[] args) {
//        int k = 5;
        int k = 0;
        List<List<Integer>> result = generate(k);
        printTriangle(result);
        printTriangle(result);
    }

    public static List<List<Integer>> generate(int k) {
        List<List<Integer>> tr = new ArrayList();
        tr.add(new ArrayList<>());
        tr.get(0).add(1);
        for (int row = 1; row < k; row++) {
            tr.add(new ArrayList<>());
            tr.get(row).add(1);
            for (int index = 1; index < row; index++) {
                int value = tr.get(row-1).get(index-1) + tr.get(row-1).get(index);
                tr.get(row).add(value);
            }
            tr.get(row).add(1);
        }
        return tr;
    }


    public static void printTriangle(List<List<Integer>>  N) {
        for (int i = 0; i < N.size(); i++) {
            System.out.print(N.get(i) + " ");
            System.out.print("\n");
        }
    }


}
