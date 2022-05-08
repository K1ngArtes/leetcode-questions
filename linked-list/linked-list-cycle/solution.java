/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;    
        }
        if(head.next == head) {
            return true;
        }
        
        ListNode p1 = head;
        ListNode p2 = head.next;
        
        while(p1 != null && p2 != null && p1 != p2) {
            if(p2.next == null || p1.next == null) {
                return false;
            }
            
            p1 = p1.next;
            p2 = p2.next.next;
        }
        
        if(p1 == null || p2 == null) {
            return false;
        }
        
        return true;
    }
}