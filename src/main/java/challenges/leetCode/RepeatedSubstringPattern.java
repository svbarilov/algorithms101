package challenges.leetCode;

public class RepeatedSubstringPattern {

    public static void main(String[] args) {
//        String s = "abcabcabcabc";
//        String s = "aba";
//        String s = "abac";
//        String s = "aabaaba";
        String s = "abaababaab";
        boolean result = repeatedSubstringPattern(s);
        System.out.println(result);
    }

    public static boolean repeatedSubstringPattern(String s) {
        for (int i = 0; i < s.length()/2; i++) {
            if (i == 0 || s.length() % (i+1) == 0) {
                char[] chars = s.substring(0, i+1).toCharArray();
                int i2 = 0;
                int j = i+1;
                while (j < s.length() && chars[i2] == s.charAt(j)) {
                    i2++;
                    j++;
                    if (i2 > i) {
                        i2  = 0;
                    }
                }
                if (j == s.length() && i2 == 0) {
                    return true;
                }
            }

        }
        return  false;
    }

//    public boolean repeatedSubstringPattern(String str) {
//        String s = str + str;
//        return s.substring(1, s.length() - 1).contains(str);
//    }


}
