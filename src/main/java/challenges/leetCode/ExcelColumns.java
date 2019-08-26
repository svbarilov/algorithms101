package challenges.leetCode;

import java.util.ArrayList;
import java.util.List;


//Given a positive integer, return its corresponding column title as appear in an Excel sheet.
//
//        For example:
//
//        1 -> A
//        2 -> B
//        3 -> C
//        ...
//        26 -> Z
//        27 -> AA
//        28 -> AB
//        ...
//        Example 1:
//
//        Input: 1
//        Output: "A"

public class ExcelColumns {

    public String columns(int num) {
        String alph = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//        StringBuilder res = new StringBuilder();
        List<Character> res = new ArrayList();
        run(num, alph, res);
        String answ = res.toString();
        return  answ;
    }

//    private List<Character> run(int num, String alph, List res) {
//        while (num > 0) {
//            int rem = num % 26;
//            if (rem == 0 ) {
//                res.add(0, alph.charAt(26));
//                num = num/26 - 1;
//            } else {
//                res.add(0, alph.charAt(rem));
//                num /= 26;
//            }
//        }
//        return res;
//    }




    private void run(int num, String alph, List res) {
        if (num == 0) {
            return;
        } else {
            int rem = num % 26;
            if (rem == 0) {
                res.add(0, alph.charAt(26));
                run(num/26 - 1, alph, res);
            } else {
                res.add(0, alph.charAt(rem));
                run(num/26, alph, res);
            }
        }
    }




    public static void main(String[] args) {
        ExcelColumns col = new ExcelColumns();
//        int num = 702;
        int num = 53;
        col.columns(num);
    }
}
