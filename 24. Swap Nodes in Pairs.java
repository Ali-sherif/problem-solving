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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode pq = dummy;
        ListNode pn = head;

        /*
        if there only one node or it is last node and it will not change becouse input( odd ) (pn.next will be null == null) yes 

        Short-circuit AND Operator so it prevent my from second condition be null.next != null
        */
        while (pn != null && pn.next != null) {

            pq.next = pn.next;
            pn.next = pq.next.next;
            pq.next.next = pn;
            pq = pn;
            pn = pn.next;
        }
        return dummy.next;
    }
}

// other solution using recursion o(n) space becouse stack

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if ((head == null) || (head.next == null))
            return head;
        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
    }
}