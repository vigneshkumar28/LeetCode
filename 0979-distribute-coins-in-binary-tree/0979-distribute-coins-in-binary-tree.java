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
    int moves = 0;
    public int distributeCoins(TreeNode root) {
        dfsMinNoOfMoves(root);
        return moves;
    }
    private int dfsMinNoOfMoves(TreeNode root){
        if(root == null)
            return 0;
        int leftMoves = dfsMinNoOfMoves(root.left);
        int rightMoves = dfsMinNoOfMoves(root.right);
        moves = moves+ Math.abs(leftMoves)+Math.abs(rightMoves);
        return root.val+leftMoves+rightMoves-1;
    }
}