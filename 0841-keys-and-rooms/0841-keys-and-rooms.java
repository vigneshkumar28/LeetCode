class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(rooms, visited, 0);
        for(boolean visit: visited){
            if(!visit)
                return false;
        }
        return true;
    }
    private void dfs(List<List<Integer>> rooms, boolean[] vis, int room){
        vis[room] = true;
        for(int r: rooms.get(room)){
            if(!vis[r])
                dfs(rooms, vis, r);
        }
    }
}