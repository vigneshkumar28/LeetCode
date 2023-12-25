class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int connected = 0;
        boolean[] visited = new boolean[n];
        for(int i=0; i<n; i++){
            if(visited[i] == false){
                visited[i] = true;
                connected++;
                dfs(isConnected, visited, i);   
            }
        }
        return connected;
    }
    private static void dfs(int[][] isConnected, boolean[] visited, int i){
        for(int j=0; j<isConnected.length; j++)
        if(isConnected[i][j] == 1 && visited[j] == false ){
            visited[i] = true;
            dfs(isConnected, visited, j);
        }
    }
}