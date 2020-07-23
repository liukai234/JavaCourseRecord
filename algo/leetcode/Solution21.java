
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



public class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode c = new ListNode();
        ListNode head = c;

        while(l1 != null && l2 != null) {
            if(l1.val >= l2.val) {
                c.next = null;
                c.val = l2.val;
                l2 = l2.next;
            } else {
                c.val = l1.val;
                c.next = l1.next;
                c = c.next;
                l1 = l1.next;
            }
        }
        while(l1 != null) {
            c.val = l1.val;
            c.next = l1.next;
            c = c.next;
            l1 = l1.next;
        }
        while(l2 != null) {
            c.val = l2.val;
            c.next = l2.next;
            c = c.next;
            l2 = l2.next;
        }
        return head;
    }
}