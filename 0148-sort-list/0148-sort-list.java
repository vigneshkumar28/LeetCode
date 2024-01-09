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
    public ListNode sortList(ListNode head) {
        return sortNode(head, new PriorityQueue<>((a,b) -> a-b));
    }
    private ListNode sortNode(ListNode head, PriorityQueue<Integer> pq){
        if(head == null)
            return convertList(pq);
        pq.add(head.val);
        return sortNode(head.next, pq);
    }
    private ListNode convertList(PriorityQueue<Integer> pq){
        ListNode head = new ListNode();
        ListNode node = head;
        while(!pq.isEmpty()){
            node.next = new ListNode(pq.remove());
            node = node.next;
        }
        return head.next;
    }
}