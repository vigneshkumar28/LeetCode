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
        int count = 0;
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            count++;            
        }
        if(count == 1)
            return null;
        count = count - n;
        if(count == 0)
            return head.next;
        temp = head;
        for(int i= 0; i<count-1; i++){
            temp = temp.next;
        }
        temp.next =temp.next.next;
        return head;
    }
}