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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafOfRoot1 = new ArrayList<>();
        List<Integer> leafOfRoot2 = new ArrayList<>();
        dfs(root1, leafOfRoot1);
        dfs(root2, leafOfRoot2);
        return leafOfRoot1.equals(leafOfRoot2);
    }
    private void dfs(TreeNode root, List<Integer> list){
        if(root == null)
            return;
        if(root.left == null && root.right == null)
            list.add(root.val);
        dfs(root.right, list);
        dfs(root.left, list);
    }
}