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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(ListNode i: lists){
            ListNode curr = i;
            while(curr != null){
                minHeap.add(curr.val);
                curr = curr.next;
            }
        }
        return listHelper(minHeap);
    }
    private static ListNode listHelper(PriorityQueue<Integer> pq){
        ListNode node = new ListNode();
        ListNode curr = node;
        while(!pq.isEmpty()){
            curr.next = new ListNode(pq.poll());
            curr = curr.next;
        }
        return node.next;
    }
}