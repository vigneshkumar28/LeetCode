/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        iterHelper(root, pq);
        int smallest = -1;
        while(k != 0){
            smallest = pq.remove();
            k--;
        }
        return smallest;
    }
    private void iterHelper(TreeNode root, PriorityQueue<Integer> pq){
        if(root == null)
            return;
        pq.add(root.val);
        iterHelper(root.right, pq);
        iterHelper(root.left, pq);
    }
}