class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1)
            return -1;
        int count = 0;
        //adjacency list
        List<Integer>[] graph = new List[n];
        for(int i=0; i<n; i++)
            graph[i] = new ArrayList<>();
        for(int[] c: connections){
            graph[c[0]].add(c[1]);
            graph[c[1]].add(c[0]);
        }
        boolean[] vis = new boolean[n];
        for(int i=0; i<n; i++){
            if(vis[i] == false){
                count++;
                dfs(i, graph, vis);
            }
        }
        return count-1;
    }
    private void dfs(int vertex,List<Integer>[] graph,boolean[] vis){
        vis[vertex] = true;
        for(int neighbour: graph[vertex]){
            if(vis[neighbour] == false){
                dfs(neighbour, graph, vis);
            }
        }
    }
}