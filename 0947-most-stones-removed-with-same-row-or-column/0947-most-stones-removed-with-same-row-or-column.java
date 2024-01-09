class Solution {
    public int removeStones(int[][] stones) {
        int n= stones.length;
        int count = 0;
        boolean[] vis = new boolean[n];
        for(int i=0; i<n; i++){
            if(!vis[i]){
                count++;
                dfs(stones, vis, stones[i]);
            }
        }
        return n-count;
    }
    private void dfs(int[][] stones, boolean[] vis, int[] stone){
        for(int i=0; i<stones.length; i++){
            if(!vis[i] && (stone[0] == stones[i][0] || stone[1] == stones[i][1])){
                vis[i] = true;
                dfs(stones, vis, stones[i]);
            }
        }
    }
}