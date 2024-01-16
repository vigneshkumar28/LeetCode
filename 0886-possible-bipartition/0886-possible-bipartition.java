class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] i: dislikes){
            graph.computeIfAbsent(i[0], k-> new ArrayList<>()).add(i[1]);
            graph.computeIfAbsent(i[1], k-> new ArrayList<>()).add(i[0]);
        }
        int[] vis = new int[n+1];
        for(int i=1; i<=n; i++){
            if(vis[i]!=0) continue;
            if(!dfs(i, 1, graph, vis)){
                return false;
            }
        }
        return true;
    }
    private boolean dfs(int person, int shaded, Map<Integer, List<Integer>> graph, int[] vis){
        vis[person]=shaded;
        if(graph.containsKey(person)){
            for(int neighbour: graph.get(person)){
                if(vis[neighbour] == shaded)
                    return false;
                if(vis[neighbour] != 0) continue;
                if(!dfs(neighbour, -shaded, graph, vis)){
                    return false;
                }
            }
        }
        return true;
    }
}