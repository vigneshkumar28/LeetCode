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
    public void reorderList(ListNode head) {
        ListNode slow =  head;
        ListNode fast = head;
        //find middle
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalf =slow.next;
        slow.next=null;
        //reverse the second half
        ListNode prev=null;
        ListNode curr=secondHalf;
        ListNode next;
        while(curr !=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        secondHalf=prev;
        //merge
        ListNode firstHalf=head;
        while(secondHalf != null){
            ListNode nextFirst=firstHalf.next;
            ListNode nextSecond=secondHalf.next;
            firstHalf.next=secondHalf;
            secondHalf.next=nextFirst;
            firstHalf=nextFirst;
            secondHalf=nextSecond;
        }
    }
}