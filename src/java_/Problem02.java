package java_;

    /*
        You are given two non-empty linked lists representing two non-negative integers.

        The digits are stored in reverse order, and each of their nodes contains a single digit.

        Add the two numbers and return the sum as a linked list.

        You may assume the two numbers do not contain any leading zero, except the number 0 itself.
    */

public class Problem02 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode addTwoNumbers(ListNode a, ListNode b) {
            ListNode dummy = new ListNode(0);
            ListNode tail = dummy;

            int carry = 0;

            while (a != null || b != null) {
                int x = (a != null) ? a.val : 0;
                int y = (b != null) ? b.val : 0;

                int sum = carry + x + y;
                carry = sum / 10;
                tail.next = new ListNode(sum % 10);
                tail = tail.next;

                if (a != null) {
                    a = a.next;
                }
                if (b != null) {
                    b = b.next;
                }
            }

            if (carry > 0) {
                tail.next = new ListNode(carry);
            }
            return dummy.next;
        }
    }
}
