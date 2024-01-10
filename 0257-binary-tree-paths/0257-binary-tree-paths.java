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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        return dfs(root, result, "");
    }
    private List<String> dfs(TreeNode root, List<String> result, String str){
        if(root == null){
            return result;
        }
        str += (str.isEmpty() ? "":"->")+root.val;
        if(root.left == null && root.right == null){
            result.add(str);
            return result;
        }
        dfs(root.left, result, str);
        dfs(root.right, result, str);
        return result;
    }
}