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
        if (len == 1) return null;
        int complement = len - n;
        int i = 0;
        ListNode dummy = new ListNode();
        dummy.next = head;
        temp = head;
        ListNode prev = dummy;
        while (temp != null) {
            if (i == complement) {
                prev.next = temp.next;
                break;
            }
            prev = temp;
            temp = temp.next;
            i++;
        }
        return dummy.next;
    }
}
