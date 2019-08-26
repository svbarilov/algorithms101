package challenges.leetCode;

//Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
//
//        Symbol       Value
//        I             1
//        V             5
//        X             10
//        L             50
//        C             100
//        D             500
//        M             1000
//        For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
//
//        Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
//
//        I can be placed before V (5) and X (10) to make 4 and 9.
//        X can be placed before L (50) and C (100) to make 40 and 90.
//        C can be placed before D (500) and M (1000) to make 400 and 900.
//        Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
//
//        Example 1:
//
//        Input: "III"
//        Output: 3


import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public int columns(String st) {
        Map<String, Integer> alph = new HashMap<>();
        alph.put("I", 1); alph.put("V", 5); alph.put("X", 10); alph.put("L", 50); alph.put("C", 100);
        alph.put("D", 500); alph.put("M", 1000);
        int ans = run(st, alph);
        return ans;
    }


    private int run(String st, Map<String, Integer> alph) {
        int result = 0;
        char[] arr = st.toCharArray();
        if (arr.length == 1) {
            return alph.get(String.valueOf(arr[0]));
        }
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1 || alph.get(String.valueOf(arr[i])) >= alph.get(String.valueOf(arr[i + 1]))) {
                result += alph.get(String.valueOf(arr[i]));
            } else if (alph.get(String.valueOf(arr[i])) < alph.get(String.valueOf(arr[i + 1]))){
                result -= alph.get(String.valueOf(arr[i]));
            }
        }
        return result;
    }



    public static void main(String[] args) {
        RomanToInteger rom = new RomanToInteger();
        String test = "MCMXCIV";
        rom.columns(test);
    }

}
