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
    int result=0;
    public int countPairs(TreeNode root, int distance) {
        dfs(root, distance);
        return result;
    }
    private int[] dfs(TreeNode node, int distance){
        int[] visited = new int[11];
        if(node == null)
            return visited;
        if(node.left == null && node.right==null)
            visited[1] = 1;
        int[] left = dfs(node.left, distance);
        int[] right = dfs(node.right, distance);
        for(int i=1; i<distance; i++){
            for(int j=1; j<=distance-i; j++){
                result += (left[i] * right[j]);
            }
        }
        for(int i=2;i<11; i++){
            visited[i] += left[i-1]+right[i-1];
        }
        return visited;
    }
    
}