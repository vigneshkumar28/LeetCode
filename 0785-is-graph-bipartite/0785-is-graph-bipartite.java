class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);
        color[0]=0;
        for(int i=0;i<graph.length; i++){
            for(int edge: graph[i]){
                if(color[edge] == -1){
                    color[edge]=1-color[i];
                }
                else if(color[edge] == color[i])
                    return false;
            }
        }
        return true;
    }
}