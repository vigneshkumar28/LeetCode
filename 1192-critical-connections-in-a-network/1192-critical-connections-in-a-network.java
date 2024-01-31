class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
     List<Integer>[] graph = new ArrayList[n];
      for(int i=0; i<n; i++)
        graph[i] = new ArrayList<>();
      for(List<Integer> c: connections){
        int u = c.get(0);
        int v = c.get(1);
        graph[u].add(v);
        graph[v].add(u);
      }
      int[] temp = new int[n];
      Arrays.fill(temp, -1);
      int[] tempL = new int[n];
      List<List<Integer>> result = new ArrayList<>();
      dfs(0, -1, graph, temp, tempL, result, 0);
      return result;
    }
  private static void dfs(int node, int p, List<Integer>[] graph, int[] temp, int[] tempL,List<List<Integer>> result, int t){
    temp[node] = t;
    tempL[node] = t;
    for(int n: graph[node]){
      if(n == p)
        continue;
      if(temp[n] == -1){
        dfs(n, node, graph, temp, tempL, result, t+1);
        tempL[node] = Math.min(tempL[node], tempL[n]);
        if(tempL[n] > temp[node]){
          result.add(Arrays.asList(node, n));
        }
      }
      else{
        tempL[node] = Math.min(tempL[node], temp[n]);
      }
    }
  }
}