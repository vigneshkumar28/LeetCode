/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        Node temp = head;
        while(temp!=null){
            Node copyNode = new Node(temp.val);
            copyNode.next = temp.next;
            temp.next = copyNode;
            temp = copyNode.next;
        }
        temp = head;
        while(temp!=null){
            if(temp.random != null){
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }
        temp = head;
        Node tempNode=new Node(0);
        Node prev=tempNode;
        while(temp !=null){
            prev.next = temp.next;
            prev = prev.next;
            temp.next = temp.next.next;
            temp = temp.next;
        }
        return tempNode.next;
    }
}