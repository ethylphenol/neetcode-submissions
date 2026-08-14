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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int len = 0;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        int complement = len - n;
        int i = 0;
        ListNode prev = head;
        for (temp = head; temp != null; prev = temp, temp = temp.next, i++) {
            if (i == complement) {
                prev.next = temp.next;
                return i == 0 ? head.next : head;
            }
        }
        return null;
    }
}
