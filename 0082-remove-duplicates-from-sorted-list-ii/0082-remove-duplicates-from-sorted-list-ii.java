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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return head;
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode curr = head;
        ListNode prev = result;
        while(curr != null){
            boolean duplicateFound = false;
            while(curr.next != null && curr.val == curr.next.val){
                duplicateFound = true;
                curr = curr.next;
            }
            if(duplicateFound == true){
                prev.next = curr.next;
            }else{
                prev = prev.next;
            }
            curr = curr.next;
        }
        return result.next;
    }
}