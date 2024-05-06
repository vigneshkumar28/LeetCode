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
    public ListNode removeNodes(ListNode head) {
     if(head == null || head.next == null)
         return head;
        //recursion
        ListNode nextNode  =removeNodes(head.next);
        if(head.val <nextNode.val)
            return nextNode;
        head.next=nextNode;
        return head;
    }
}