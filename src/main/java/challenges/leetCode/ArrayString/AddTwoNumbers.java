package challenges.leetCode.ArrayString;

//You are given two non-empty linked lists representing two non-negative integers.
// The digits are stored in reverse order and each of their nodes contain a single digit.
// Add the two numbers and return it as a linked list.
//
//        You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//
//        Example:
//
//        Input (2 -> 4 -> 3) + (5 -> 6 -> 4)
//        Output: 7 -> 0 -> 8
//        Explanation: 342 + 465 = 807.:

public class AddTwoNumbers {

      public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
          public String toString() {
              ListNode node = this;
              while (node.next != null) {
                  System.out.println("value: " + this.val + " | " );
                  node = node.next;
              }
              return "";
          }
      }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        traverse lists while both #next are not null
//        find sum + carryover from previous iteration and save number to carry over
//        save result to new linked list
        ListNode n1 = l1;
        ListNode n2 = l2;
        int carryOver = 0;
        ListNode result = null;
        ListNode tempNode = null;
        int toSave;
        while (n1 != null || n2 != null || carryOver == 1) {
            if (n1 == null && n2 == null && carryOver == 1) {
                tempNode.next = new ListNode(carryOver);
                return result;
            }
            int sum = (n1 != null ? n1.val : 0) + (n2 !=  null ? n2.val : 0);
            sum += carryOver;
            if (sum > 9) {
                toSave = sum - 10 ;
                carryOver = 1;
            } else {
                toSave = sum;
                carryOver = 0;
            }
            if (result == null) {
                result = new ListNode(toSave);
                tempNode = result;
            } else {
                tempNode.next = new ListNode(toSave);
                tempNode = tempNode.next;
            }
            if (n1 != null) {
                n1 = n1.next;
            } else {
                n1 = null;
            }
            if (n2 != null) {
                n2 = n2.next;
            } else {
                n2 = null;
            }
        }
//        result.toString();
        return result;
    }

    public static void main(String[] args) {
//          ListNode l1 = new AddTwoNumbers.ListNode(2);
//          l1.next = new ListNode(4);
//          l1.next.next = new ListNode(3);
//
//          ListNode l2 = new AddTwoNumbers.ListNode(5);
//          l2.next = new ListNode(6);
//          l2.next.next = new ListNode(4);

        ListNode l1 = new AddTwoNumbers.ListNode(1);


        ListNode l2 = new AddTwoNumbers.ListNode(9);
        l1.next = new ListNode(9);


          AddTwoNumbers twoNumbers = new AddTwoNumbers();
          twoNumbers.addTwoNumbers(l1, l2);


    }

}
