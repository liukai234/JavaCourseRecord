
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
        while(l1.next != null && l2.next != null) {
            if(l1.val >= l2.val) {
                c.val = l2.val;
                c.next = l2.next;
                l2 = l2.next;
            } else {
                c.val = l1.val;
                c.next = l1.next;
                l1 = l1.next;
            }
        }
        while(l1.next != null) {
            c.val = l1.val;
            c.next = l1.next;
            l1 = l1.next;
        }
        while(l2.next != null) {
            c.val = l2.val;
            c.next = l2.next;
            l2 = l2.next;
        }
        return c;
    }
}