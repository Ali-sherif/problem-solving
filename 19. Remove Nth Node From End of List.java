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

        ListNode dummy = new ListNode(0, head);
        ListNode l = dummy;
        ListNode r = head;

        //Move  in front so that the gap between slow and fast becomes n
        for (int i = 1; i <= n; i++) {
            r = r.next;
        }
        //Move fast to the end, maintaining the gap
        while (r != null) {
            r = r.next;
            l = l.next;
        }
        //Skip the desired node
        l.next = l.next.next;
        return dummy.next;
    }
}


// Anthor solution

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode pn = head;
        int size = 0;

        while (pn != null) {
            pn = pn.next;
            size++;
        }

        if (size - n == 0) {
            head = head.next;
        } else {
            if (size == 1) head = null;
            else {
                pn = head;
                for (int i = 1; i < size - n; i++) {
                    pn = pn.next;
                }
                pn.next = pn.next.next;
            }
        }
        return head;
    }
}