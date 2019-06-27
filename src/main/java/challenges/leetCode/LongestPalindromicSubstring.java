package challenges.leetCode;

public class LongestPalindromicSubstring {

//    Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
//
//    Example 1:
//
//    Input: "babad"
//    Output: "bab"
//    Note: "aba" is also a valid answer.
//            Example 2:
//
//    Input: "cbbd"
//    Output: "bb"

    public String longestPalindrome(String s) {

//        pointer goes through string and checks for palindrome
//        if palindrome we try to increase the palindrome
//        if no we move the pointer
//        to check for palindrome at i we check if i-1 eq i+1 or
//        i eq i-1

        if (s.length() == 0) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        String longest = s.substring(0, 1);
        for (int i = 1; i < s.length() ; i++) {
            if  (i + 1 < s.length() && s.charAt(i - 1) == s.charAt(i + 1)){
                String substring = s.substring(i - 1, i + 1 + 1);
                longest = longest.length() > substring.length() ? longest : substring;
                for (int j = 1; i - j >= 0 && j + i < s.length(); ++j) {
                    if (s.charAt(i + j) == s.charAt(i - j)) {
                        String expandedSubstring =  s.substring(i - j, i + j + 1);
                        longest = longest.length() > expandedSubstring.length() ? longest : expandedSubstring;
                    } else {
                        continue;
                    }
                }
            } else if (s.charAt(i) == s.charAt(i - 1)) {
                String substring = s.substring(i - 1, i + 1);
                longest = longest.length() > substring.length() ? longest : substring;
                for (int j = 1; i - j - 1 >= 0 && j + i < s.length(); ++j) {
                    if (s.charAt(i + j) == s.charAt(i - j - 1)) {
                        String expandedSubstring = s.substring(i - j - 1, i + j + 1);
                        longest = longest.length() > expandedSubstring.length() ? longest : expandedSubstring;
                    } else {
                        continue;
                    }
                }
            } else {
                continue;
            }
        }
        return longest;
    }

    public static void main(String[] args) {

        LongestPalindromicSubstring prog = new LongestPalindromicSubstring();
        String testString = "ccc";
        prog.longestPalindrome(testString);
    }
}
