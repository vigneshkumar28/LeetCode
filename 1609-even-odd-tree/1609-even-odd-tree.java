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
    public boolean isEvenOddTree(TreeNode root) {
        //bfs
        TreeNode curr = root;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(curr);
        boolean even=true;
        while(!q.isEmpty()){
            int size= q.size();
            int prev=Integer.MAX_VALUE;
            if(even){
                prev = Integer.MIN_VALUE;
            }
            while(size>0){
                curr = q.poll();
                if((even && (curr.val %2==0 || curr.val<=prev)) || (!even && (curr.val %2 ==1 || curr.val >= prev)))
                    return false;
                prev = curr.val;
                if(curr.left!=null)
                    q.add(curr.left);
                if(curr.right!=null)
                    q.add(curr.right);
                size--;
            }
            even= !even;
        }
        return true;
    }
}