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

// Runtime: 0 ms & Memory Usage: 43.1 MB
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode pn = list1;
        ListNode pq = list2;
        ListNode current;

        if (pn == null) return pq;
        if (pq == null) return pn;

        if (pn.val >= pq.val) {
            current = pq;
            pq = pq.next;
        } else {
            current = pn;
            pn = pn.next;
        }

        while (pn != null && pq != null) {

            if (pn.val >= pq.val) {
                current.next = pq;
                current = pq;
                pq = pq.next;
            } else {
                current.next = pn;
                current = pn;
                pn = pn.next;
            }
        }

        if (pn != null) {
            current.next = pn;
        } else {
            current.next = pq;
        }

        return (list1.val >= list2.val) ? list2 : list1;

    }
}

// other solution 
// Runtime: 1 ms & Memory Usage: 42.8 MB

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode pn = new ListNode(0);
        ListNode current = pn;

        if (list1 == null) return list2;
        if (list2 == null) return list1;

        while (list1 != null && list2 != null) {

            if (list1.val > list2.val) {
                current.next = list2;
                list2 = list2.next;
            } else {
                current.next = list1;
                list1 = list1.next;
            }
            current = current.next;
        }

        if (list1 == null) {
            current.next = list2;
        } else {
            current.next = list1;
        }


        return pn.next;
    }
}