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
    public ListNode doubleIt(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode prev= dummy;
        ListNode curr= head;
        while(curr != null){
            int mul = curr.val * 2;
            curr.val = mul%10;
            if(mul >= 10){
                prev.val += 1;
            }
            prev = curr;
            curr = curr.next;
        }
        if(dummy.val != 0) return dummy;
        return dummy.next;
    }
}