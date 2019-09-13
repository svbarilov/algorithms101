package challenges.leetCode.Recursion;

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

    // to run on leetCode
//    public static List<List<String>> solveNQueens(int n) {
//        StringBuilder partialBuilder = new StringBuilder();
//        for (int z = 0; z < n; z++) {
//            partialBuilder.append(".");
//        }
//        List<List<String>> result = new ArrayList<>();
//        List<String> oneSolution= new ArrayList<>();
//        char queen = 'Q';
//        queensHelper(n, 0, partialBuilder, oneSolution, result, queen);
//        return result;
//    }



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
        }
    }

    public static boolean isValidPlacement(List<String> solution, int n, char queen) {
        if (solution.size() == 1) {
            return true;

        }
        for (int startRowIndex = 0; startRowIndex < solution.size() - 1 ; startRowIndex++) {
            String firstRowActual = solution.get(startRowIndex);
            int firstRowQIndex = 0;
            for(int z = 0; z < n; z++) {
                if(firstRowActual.charAt(z) == queen) {
                    firstRowQIndex = z;
                }
            }
            for (int j = 1; j < solution.size() - startRowIndex; j++) {
                if (solution.get(startRowIndex + j).charAt(firstRowQIndex) == queen ||
                        (firstRowQIndex + j < n && solution.get(startRowIndex + j).charAt(firstRowQIndex + j) == queen) ||
                        (firstRowQIndex - j >= 0 && solution.get(startRowIndex + j).charAt(firstRowQIndex - j) == queen)) {
                    return false;
                }
            }
        }
        return true;
    }



}  // end class
