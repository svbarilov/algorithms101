package challenges.leetCode;

//Write a function that takes a string as input and reverse only the vowels of a string.
//
//        Example 1:
//
//        Input: "hello"
//        Output: "holle"


import java.util.HashSet;
import java.util.Set;

public class ReverseVowels {
    public static void main(String[] args) {
        String s =  "hello";
        String result = reverseVowels(s);
        System.out.println(result);

    }

    public static String reverseVowels(String s) {
        int length = s.length();
        int l = 0;
        int r = length - 1;
        char[] arr = s.toCharArray();
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('o');
        set.add('e');
        set.add('i');
        set.add('u');
        while (l < r) {
            while (l < r && !set.contains(arr[l])) {
                l++;
            }
            while (l < r && !set.contains(arr[r])) {
                r--;
            }
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
        return new String(arr);
    }


}
