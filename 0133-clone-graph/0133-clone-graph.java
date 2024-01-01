/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node n) {
        if(n==null){
            return n;
        }
        Map<Node, Node> cloneMap = new HashMap<>();
        return cloneNodeDFS(cloneMap, n);
    }
    // in map node, clonedNode to know the neighbours
    private Node cloneNodeDFS(Map<Node, Node> map, Node n){
        if(map.containsKey(n))
            return map.get(n);
        Node clonedNode = new Node(n.val);
        map.put(n, clonedNode);
        for(Node neighbor: n.neighbors){
            clonedNode.neighbors.add(cloneNodeDFS(map, neighbor));
        }
        return clonedNode;
    }
}