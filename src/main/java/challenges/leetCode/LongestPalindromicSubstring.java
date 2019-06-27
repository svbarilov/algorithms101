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


//        pointer goes through string and calls expandAroundCenter
//        expandAround center is called for i and i+1 to account for 2 possible centers
//        One with the actual altter and one between letters
//        then we pick the max palindrome length of these two
//        we calculate substring based on i and longest length


    public String longestPalindrome(String s) {

        if (s == null || s.length() < 1) {
            return s;
        }
        int result = 0;
        int start = 0; int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int pol1 = expandAroundCenter(s, i, i);
            int pol2 = expandAroundCenter(s, i, i+1);
            int len = Math.max(pol1, pol2);
            if (result < len) {
                result = len;
                start = i - (result-1)/2;
                end = i + result/2;
            }
        }
        return s.substring(start, end+1);
    }

    private int expandAroundCenter(String s, int l, int r) {
        while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }






    public static void main(String[] args) {
        LongestPalindromicSubstring prog = new LongestPalindromicSubstring();
        String testString = "cccc";
        prog.longestPalindrome(testString);
    }
}


// Solution from leetCode
//    public String longestPalindrome(String s) {
//        if (s == null || s.length() < 1) return "";
//        int start = 0, end = 0;
//        for (int i = 0; i < s.length(); i++) {
//            int len1 = this.expandAroundCenter(s, i, i);
//            int len2 = expandAroundCenter(s, i, i + 1);
//            int len = Math.max(len1, len2);
//            if (len > end - start) {
//                start = i - (len - 1) / 2;
//                end = i + len / 2;
//            }
//        }
//        return s.substring(start, end + 1);
//    }
//
//    private int expandAroundCenter(String s, int left, int right) {
//        int L = left, R = right;
//        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
//            L--;
//            R++;
//        }
//        return R - L - 1;
//    }



//  My solution with recalculating substrings
//    public String longestPalindrome(String s) {
//
//        if (s == null || s.length() < 1) {
//            return s;
//        }
//        String longest = String.valueOf(s.charAt(0));
//        for (int i = 0; i < s.length(); i++) {
//            String pol1 = expandAroundCenter(s, i, i);
//            String pol2 = expandAroundCenter(s, i, i+1);
//            String pol3 = pol1.length() > pol2.length() ? pol1 : pol2;
//            longest = longest.length() > pol3.length() ? longest : pol3;
//        }
//        return longest;
//    }
//
//    private String expandAroundCenter(String s, int l, int r) {
//        String pol = "";
//        while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)) {
//            pol = s.substring(l, r+1);
//            l--;
//            r++;
//        }
//        return pol;
//    }
