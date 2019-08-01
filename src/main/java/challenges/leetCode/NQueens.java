package challenges.leetCode;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    public static void main(String[] args) {
        int n = 4;
        solveNQueens(n);
    }

    public static void solveNQueens(int n) {
        StringBuilder partialBuilder = new StringBuilder();
        for (int z = 0; z < n; z++) {
            partialBuilder.append(".");
        }
        List<List<String>> result = new ArrayList<>();
        List<String> oneSolution= new ArrayList<>();
        char queen = 'Q';
        queensHelper(n, 0, partialBuilder, oneSolution, result, queen);

        ///////////////////////////////////////////////////////////////////////
        for (List<String> row : result) {
            System.out.println(row.toString() + " \n");
        }
        ///////////////////////////////////////////////////////////////////////
    }

    public static void queensHelper(int n, int row, StringBuilder template, List<String> oneSolution, List<List<String>> result, char queen) {
        StringBuilder partial = new StringBuilder(template);
        if (row == n) {
            result.add(new ArrayList<>(oneSolution));
        }
        for (int i = 0; i < n; i++) {
            partial.setCharAt(i, queen);
            oneSolution.add(partial.toString());
            if (isValidPlacement(oneSolution, n, queen)) {
                queensHelper(n, row + 1, template, oneSolution, result, queen);
            }
            oneSolution.remove(oneSolution.size()  - 1);
            partial.setCharAt(i, '.');
//            row = row - 1;
        }
    }

    public static boolean isValidPlacement(List<String> solution, int n, char queen) {
        if (solution.size() == 1) {
            return true;

        }
        for (int startRow = 0; startRow < solution.size() - 1 ; startRow++) {
            String firstRow = solution.get(startRow);
            int firstRowQ = 0;
            for(int z = 0; z < n; z++) {
                if(firstRow.charAt(z) == queen) {
                    firstRowQ = z;
                }
            }
            for (int j = startRow + 1; j < solution.size(); j++) {
                if (solution.get(j).charAt(firstRowQ) == queen || (firstRowQ + j < n && solution.get(j).charAt(firstRowQ + j) == queen) || (firstRowQ - j >= 0 && solution.get(j).charAt(firstRowQ - j) == queen)) {
                    return false;
                }
            }
        }
        return true;
    }



}  // end class
