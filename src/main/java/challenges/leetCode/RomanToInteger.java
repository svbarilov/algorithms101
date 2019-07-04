package challenges.leetCode;

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
