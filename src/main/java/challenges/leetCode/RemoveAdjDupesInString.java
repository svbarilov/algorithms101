package challenges.leetCode;

//Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.
//
//        We repeatedly make duplicate removals on S until we no longer can.
//
//        Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.
//
//        Example 1:
//
//        Input: "abbaca"
//        Output: "ca"
//        Explanation:
//        For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
//
//        Note:
//
//        1 <= S.length <= 20000
//        S consists only of English lowercase letters.


public class RemoveAdjDupesInString {

        public static void main(String[] args) {
        String s = "abbaca";
        System.out.println(removeDuplicates(s));

    }

    public static String removeDuplicates(String S) {
        char[] arr = S.toCharArray();
        StringBuilder stack = new StringBuilder();
        stack.append(arr[0]);
        char lastStackChar = arr[0];
        for (int i = 1; i < S.length(); i++) {
            if (arr[i] == lastStackChar) {
                stack.deleteCharAt(stack.length()-1);
                int stackLength = stack.length();
                lastStackChar = (stackLength == 0) ? '\u0000' : stack.toString().toCharArray()[stackLength-1];
                continue;
            } else {
                stack.append(arr[i]);
                lastStackChar = arr[i];
            }
        }
        return stack.toString();
    }


}
