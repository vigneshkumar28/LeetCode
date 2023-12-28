class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        dfs(rooms, visited, 0);
        for(boolean visitedOrNot: visited){
            if(!visitedOrNot)
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