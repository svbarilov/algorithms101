package challenges.leetCode.ArrayString;

//Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
//
//        The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
//
//        You may assume the integer does not contain any leading zero, except the number 0 itself.
//
//        Example 1:
//
//        Input: [1,2,3]
//        Output: [1,2,4]
//        Explanation: The array represents the integer 123.


public class PlusOne {

    public static void main(String[] args) {
//        int[] digits = {1, 2, 9};
//        int[] digits = {1, 3, 4};
        int[] digits = {9, 9, 9};
        int[] result = plusOne(digits);
        System.out.println(result);

    }

    public static int[] plusOne(int[] digits) {
        int length = digits.length;
        if (digits[length - 1] < 9) {
            digits[length - 1] += 1;
            return digits;
        }
        int carry = 1;
        for (int i = length - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            digits[i]  = sum % 10;
            carry = sum / 10;
        }
        int[] res = new int[length + 1];
        if (carry == 1) {
            res[0] = 1;
            for (int i = 0; i < length; i++) {
                res[i+1] = digits[i];
            }
            return res;
        }
        return digits;
    }

}
