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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // O (n+m) time. O (1) space
        ListNode head = null;
        if (list1!=null || list2!=null) head = new ListNode();
        ListNode curr = head;
        ListNode prev = head;
        while (list1 != null || list2 != null) {
            prev = curr;
            if (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    curr.val = list1.val;
                    curr.next = new ListNode();
                    curr = curr.next;
                    list1 = list1.next;
                } else {
                    curr.val = list2.val;
                    curr.next = new ListNode();
                    curr = curr.next;
                    list2 = list2.next;
                }
            } else if (list1 != null) {
                curr.val = list1.val;
                curr.next = new ListNode();
                curr = curr.next;
                list1 = list1.next;
            } else {
                curr.val = list2.val;
                curr.next = new ListNode();
                curr = curr.next;
                list2 = list2.next;
            }
        }
        if (prev != null)
            prev.next = null;
        return head;
    }
}