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

// iterative solution
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pq = null;

        while (head != null) {
            ListNode pn = head.next;
            head.next = pq;
            pq = head;
            head = pn;

        }
        return pq;
    }
}




/* recursive solution */
class Solution {
    public ListNode reverseList(ListNode head) {

        return reverseListInt(head, null);



    }
    private ListNode reverseListInt(ListNode head, ListNode newHead) {
        if (head == null)
            return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return reverseListInt(next, head);
    }
}