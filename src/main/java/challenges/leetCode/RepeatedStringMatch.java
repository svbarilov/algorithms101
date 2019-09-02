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
//        String A = "abcd";
//        String B = "cdabcdab";
//        String A = "abcabcabcabc";
//        String B = "abac";
//        String A = "aaac";
//        String B ="aac";
        String A ="aabaa";
        String B = "aaab";
        int result = repeatedStringMatch(A, B);
        System.out.println(result);

    }


    public static int repeatedStringMatch(String A, String B) {
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        for (int Aind = 0; Aind < a.length; Aind++) {
            int Bind = 0;
            int iteration = 1;
            if (a[Aind] == b[Bind] && Bind < b.length) {
                int Ainner = Aind;
                while (a[Ainner] == b[Bind] && Bind <= b.length) {
                    if (Bind == b.length - 1) {
                        return iteration;
                    }
                    Bind++;
                    Ainner++;
                    if (Ainner >= a.length) {
                        Ainner = 0;
                        iteration+=1;
                    }
                }

            }
        }
        return -1;
    }



// Not my solution
//    public static int repeatedStringMatch(String A, String B) {
//        for (int i = 0; i < A.length(); i++) {
//            if (A.charAt(i) == B.charAt(0)) {
//                int count = 1;
//                int j = 0;
//                int startIx = i;
//                while (j < B.length() && A.charAt(startIx) == B.charAt(j)) {
//                    j++;
//                    startIx++;
//                    if (startIx >= A.length() && j < B.length()) {
//                        startIx = startIx % A.length();
//                        count++;
//                    }
//                }
//                if (j == B.length()) return count;
//            }
//        }
//        return -1;
//    }



}
