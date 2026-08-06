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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode curr = head;
        ListNode prev = null;
        while (curr.next!=null) {
            prev = curr;
            curr = curr.next;
        }
        if (prev != null)
            prev.next = null;
        curr.next = head.next;
        head.next = curr;
        reorderList(head.next.next);
    }
}
