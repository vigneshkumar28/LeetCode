class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        List<Integer> safeNodes= new ArrayList<>();
        boolean[] isSafe=new boolean[n];
        boolean[] vis=new boolean[n];
        for(int i=0;i<n;i++){
            dfs(i, graph, isSafe, vis);
        }
        for(int i=0;i<n;i++){
            if(!isSafe[i]){
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }
    public boolean dfs(int node, int[][] graph, boolean[] isSafe, boolean[] vis){
        if(isSafe[node])
            return true;
        if(vis[node])
            return false;
        vis[node]=true;
        isSafe[node]=true;
        for(int neighbor: graph[node]){
            if(dfs(neighbor, graph, isSafe, vis)){
                return true;
            }
        }
        isSafe[node]=false;
        return false;
    }
}