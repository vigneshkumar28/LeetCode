/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        preOrderHelper(root, result);
        return result;
    }
    private void preOrderHelper(Node root, List<Integer> result){
        if(root==null)
            return;
        result.add(root.val);
        if(root.children != null){
            for(Node child: root.children){
                preOrderHelper(child, result);
            }
        }
    }
}