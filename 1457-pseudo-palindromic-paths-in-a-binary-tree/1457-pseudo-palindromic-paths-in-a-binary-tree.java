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
    public int pseudoPalindromicPaths (TreeNode root) {
        //use Deque instead of Stack class for Stack operations because Deque is faster than stack and LinkedList queue
        Deque<Pair<TreeNode, Integer>> queue = new ArrayDeque();
        queue.offer(new Pair(root, 0));
        int path=0;
        int count=0;
        while(!queue.isEmpty()){
            Pair<TreeNode, Integer> freq = queue.pop();
            TreeNode keyNode = freq.getKey();
            path = freq.getValue();
            if(keyNode != null){
                path = path^(1<<keyNode.val);
                if(keyNode.left == null && keyNode.right == null){
                    if((path &(path-1))==0)
                        ++count;
                }else{
                    queue.offer(new Pair(keyNode.right, path));
                    queue.offer(new Pair(keyNode.left, path));
                }
            }
        }
        return count;
    }
}