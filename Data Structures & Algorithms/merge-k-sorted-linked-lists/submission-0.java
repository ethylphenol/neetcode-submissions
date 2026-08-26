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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        while (lists.length > 1) {
            List<ListNode> merged = new ArrayList<>();
            for (int i = 0; i < lists.length; i += 2) {
                ListNode l1 = lists[i];
                ListNode l2 = (i + 1) < lists.length ? lists[i + 1] : null;
                merged.add(mergeTwoLists(l1, l2));
            }
            lists = merged.toArray(new ListNode[0]);
        }
        return lists[0];
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // O (n+m) time. O (1) space
        ListNode head = new ListNode();
        ListNode curr = head;
        while (list1 != null || list2 != null) {
            if (list1 != null && list2 != null) {
                // postoje oba
                if (list1.val < list2.val) {
                    curr.next = list1;
                    curr = curr.next;
                    list1 = list1.next;
                } else {
                    curr.next = list2;
                    curr = curr.next;
                    list2 = list2.next;
                }
            } else if (list1 != null) {
                curr.next= list1;
                curr = curr.next;
                list1 = list1.next;
            } else {
                curr.next= list2;
                curr = curr.next;
                list2 = list2.next;
            }
        }
        return head.next;
    }
}
