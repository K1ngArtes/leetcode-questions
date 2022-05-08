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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addNums(l1, l2);
    }
    
    private ListNode addNums(ListNode l1, ListNode l2) {
        int num = l1.val + l2.val;
        int carryOver = num / 10;
        int res = num % 10;
        ListNode head = new ListNode(res);
        ListNode current = head;
        l1 = l1.next;
        l2 = l2.next;
        while(l1 != null && l2 != null) {
            num = l1.val + l2.val + carryOver;
            carryOver = num / 10;
            res = num % 10;
            current.next = new ListNode(res);
            l1 = l1.next;
            l2 = l2.next;
            current = current.next;
        }
        
        while(l1 != null) {
            num = l1.val + carryOver;
            carryOver = num / 10;
            res = num % 10;
            current.next = new ListNode(res);
            current = current.next;
            l1 = l1.next;
        }
        
        while(l2 != null) {
            num = l2.val + carryOver;
            carryOver = num / 10;
            res = num % 10;
            current.next = new ListNode(res);
            current = current.next;
            l2 = l2.next;
        }
        
        if(carryOver == 1) {
            current.next = new ListNode(1);
        }
        
        return head;
    }
}