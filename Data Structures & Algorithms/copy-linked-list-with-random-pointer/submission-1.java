/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> originalToNew = new HashMap<>();
        Node temp = head;
        while (temp != null) {
            originalToNew.put(temp, new Node(temp.val));
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            Node copy = originalToNew.get(temp);
            Node next = temp.next != null ? originalToNew.get(temp.next) : null;
            Node rand = temp.random != null ? originalToNew.get(temp.random) : null;
            copy.next = next;
            copy.random = rand;
            temp = temp.next;
        }
        return head != null ? originalToNew.get(head) : null;
    }
}
