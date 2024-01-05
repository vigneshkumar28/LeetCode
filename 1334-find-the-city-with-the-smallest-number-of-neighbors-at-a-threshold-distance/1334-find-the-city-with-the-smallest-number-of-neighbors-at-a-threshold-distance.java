class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] distanceArr = new int[n][n];
        int max = 100001; // define max value for overcome overlapping
        for(int i=0; i<n ;i++){
            for(int j=0; j<n; j++){
                distanceArr[i][j] = max;
            }
        }
        for(int[] edge: edges){
            distanceArr[edge[0]][edge[1]] = distanceArr[edge[1]][edge[0]] = edge[2];
        }
        for(int i=0; i<n; i++){
            distanceArr[i][i] = 0;
        }
        //Flyod Warshall Algorithm - n3 or v3
        for(int k=0; k<n; k++){
            for(int u=0; u<n; u++){
                for(int v=0; v<n; v++){
                    distanceArr[u][v] = Math.min(distanceArr[u][v], distanceArr[u][k]+distanceArr[k][v]);
                }
            }
        }
                                 
        //output
        int cityExploredByVertix = n+1;
        int result = -1;
        for(int i=0; i<n; i++){
            int cities = 0; 
            for(int j=0; j<n; j++){
                if(distanceArr[i][j] <= distanceThreshold){
                 cities++;   
                }
            }
            if(cities<=cityExploredByVertix){
                cityExploredByVertix = cities;
                result = i;
            }
        }
        return result;
    }
}