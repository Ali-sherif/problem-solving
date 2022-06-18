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

// [1,2,2,3,4,4]
// we will divide the list to sublists until reache to simplest sublist that contain only 1 node so the sublist will be empty []
// if current node in our list equal first node in the sublist we will igoner it from the sublist (remove it)
// else they two node  are not the same move pn to next node    
// pn = 1 sublist(pn.next) = [2,2,3,4,4] 1 != 2 so will be pn = 2
// pn = 2 sublist(pn.next) = [2,3,4,4] 2 == 2 so pn.next will be = 3
// pn = 2 sublist(pn.next) = [3,4,4] 2 != 3   so will be pn = 3
// pn = 3 sublist(pn.next) = [4,4] 3 != 4   so will be pn = 4
// pn = 4 sublist(pn.next) = [4] 4 == 4   so pn.next will be = null
// pn = 4 sublist(pn.next) = []  it will beak from loop
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // if list is empty || only has one node  
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pn = head;

        while (pn.next != null) {
            if (pn.val == pn.next.val) {
                pn.next = pn.next.next;
            } else {
                pn = pn.next;
            }
        }
        return head;
    }
}
