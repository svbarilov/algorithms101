package challenges.leetCode;

//Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.
//
//        For example, with A = "abcd" and B = "cdabcdab".
//
//        Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").
//
//        Note:
//        The length of A and B will be between 1 and 10000.


public class RepeatedStringMatch {

        public static void main(String[] args) {
        String A = "abcd";
        String B = "cdabcdab";
//        String A = "abcabcabcabc";
//        String B = "abac";
        int result = repeatedStringMatch(A, B);
        System.out.println(result);

    }

//    public static int repeatedStringMatch(String A, String B) {
//            char[] a = A.toCharArray();
//            char[] b = B.toCharArray();
//            int bIn = 0;
//            int iter = 0;
//            while (bIn < b.length) {
//                for (int aIn = 0; aIn < a.length &&  bIn < b.length; aIn++) {
//                    if (a[aIn] != b[bIn] && (iter > 1 || bIn == b.length - 1) ) {
//                        return -1;
//                    } else if (iter == 1 && a[aIn] != b[bIn]) {
//                        continue;
//                    } else if (a[aIn] == b[bIn]) {
//                        bIn +=1;
//                    }
//                }
//                iter += 1;
//            }
//            return iter;
//    }


    public static int repeatedStringMatch(String A, String B) {
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == B.charAt(0)) {
                int count = 1;
                int j = 0;
                int startIx = i;
                while (j < B.length() && A.charAt(startIx) == B.charAt(j)) {
                    j++;
                    startIx++;
                    if (startIx >= A.length() && j < B.length()) {
                        startIx = startIx % A.length();
                        count++;
                    }
                }
                if (j == B.length()) return count;
            }
        }
        return -1;
    }



}
