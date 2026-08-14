/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode temp = head;
        int prijenos = 0;
        while (l1 != null || l2 != null || prijenos != 0) {
            int a = l1 != null ? l1.val : 0;
            int b = l2 != null ? l2.val : 0;
            int sum = (a+b) + prijenos;
            temp.val = sum % 10;
            prijenos = sum / 10;

            if (l1!=null) l1 = l1.next;
            if (l2!=null) l2 = l2.next;
            if (l1 == null && l2 == null && prijenos == 0) break;
            temp.next = new ListNode();
            temp = temp.next;
        }
        return head;
    }
}
