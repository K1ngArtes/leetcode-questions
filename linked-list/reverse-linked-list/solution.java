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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode previous;
        ListNode current = head;
        ListNode next = current.next;
        head.next = null;
        while(next != null) {
            previous = current;
            current = next;
            next = current.next;
            current.next = previous;
        }
        
        return current;
    }
}