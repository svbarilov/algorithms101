package challenges.leetCode;

import java.util.HashMap;
import java.util.Map;


//Given a column title as appear in an Excel sheet, return its corresponding column number.
//
//        For example:
//
//        A -> 1
//        B -> 2
//        C -> 3
//        ...
//        Z -> 26
//        AA -> 27
//        AB -> 28
//        ...
//        Example 1:
//
//        Input: "A"
//        Output: 1



public class ExcelColumnNumber {

    public int columns(String st) {
        Map<String, Integer> alph = new HashMap<>();
        alph.put("A", 1); alph.put("B", 2); alph.put("C", 3); alph.put("D", 4); alph.put("E", 5);
        alph.put("F", 6); alph.put("G", 7); alph.put("H", 8); alph.put("I", 9); alph.put("J", 10);
        alph.put("K", 11); alph.put("L", 12); alph.put("M", 13); alph.put("N", 14); alph.put("O", 15);
        alph.put("P", 16); alph.put("Q", 17); alph.put("R", 18); alph.put("S", 19); alph.put("T", 20);
        alph.put("U", 21); alph.put("V", 22); alph.put("W", 23); alph.put("X", 24); alph.put("Y", 25); alph.put("Z", 26);
        int ans = run(st, alph);
        return ans;
    }


    private int run(String st, Map<String, Integer> alph) {
        int res = 0;
        int mul = 1;
        if (st.length() == 0) {
            return res;
        }
        for (int i = st.length() - 1; i >= 0; i--) {
            res = res + mul*alph.get(String.valueOf(st.charAt(i)));
            mul = mul*26;
        }
        return res;
    }



    public static void main(String[] args) {
        ExcelColumnNumber col = new ExcelColumnNumber();
//        String test = "Z";
        String test = "BC";
        col.columns(test);
    }
}
