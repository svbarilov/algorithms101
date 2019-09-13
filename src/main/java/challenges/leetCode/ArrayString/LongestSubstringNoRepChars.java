package challenges.leetCode.ArrayString;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringNoRepChars {
//    Given a string, find the length of the longest substring without repeating characters.
//
//    Example 1:
//
//    Input: "abcabcbb"
//    Output: 3
//    Explanation: The answer is "abc", with the length of 3.
//    Example 2:
//
//    Input: "bbbbb"
//    Output: 1
//    Explanation: The answer is "b", with the length of 1.
//    Example 3:
//
//    Input: "pwwkew"
//    Output: 3
//    Explanation: The answer is "wke", with the length of 3.
//    Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

    public int lengthOfLongestSubstring(String s) {

//        have two indexes, l and r that start at 0
//        initialize ans as 0
//        increment r by 1 till we find dupe
//        when we find dupe we increment l till we reach that char

        int ans = 0; int l = 0; int r = 0;
        Set enc = new HashSet();
        while (l < s.length() || r < s.length()) {
            if (!enc.contains(s.charAt(r))) {
                enc.add(s.charAt(r++));
                ans = Math.max(ans, r - l);
            } else {
                enc.remove(s.charAt(l++));
            }
        }
        return ans;
    }



    public static void main(String[] args) {

        LongestSubstringNoRepChars prog = new LongestSubstringNoRepChars();
        String testString = "pwwkew";
        prog.lengthOfLongestSubstring(testString);

    }
}
