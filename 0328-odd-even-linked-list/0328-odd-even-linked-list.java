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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null)
          return head;
        ListNode odd = null;
        ListNode even = null;
        ListNode evenHead = null;
        ListNode oddHead = null;
        int i = 1;
        while(head != null){
          if(i%2 == 1){
            if(odd == null){
              odd = head;
              oddHead = head;
            }else{
              odd.next = head;
              odd = odd.next;
            }}
          else{
            if(even == null){
              even = head;
              evenHead = head;
            }else{
              even.next = head;
              even = even.next;
            }
          }
          head = head.next;
          i++;
          }
        odd.next = evenHead;
        if(even != null)
            even.next = null;
        return oddHead;
    }
}