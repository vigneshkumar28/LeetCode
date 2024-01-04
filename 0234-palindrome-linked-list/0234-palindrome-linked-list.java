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
    private ListNode start;
    public boolean isPalindrome(ListNode head) {
        start = head;
        return checkPalindrome(head);
    }
    private boolean checkPalindrome(ListNode curr){
        if(curr != null){
            if(!checkPalindrome(curr.next) || curr.val!= start.val)
                return false;
            start = start.next;
        }
        return true;
    }
}