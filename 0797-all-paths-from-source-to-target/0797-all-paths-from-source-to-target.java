class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currPath = new ArrayList<>();
        dfs(graph, 0, graph.length-1, result, currPath);
        return result;
    }
    private void dfs(int[][] graph, int start, int end, List<List<Integer>> result,List<Integer> currPath){
        currPath.add(start);
        if(start == end){
            result.add(new ArrayList<>(currPath));
        }else{
            for(int neighour: graph[start]){
                dfs(graph, neighour, end, result, currPath);
            }
        }
        //backtracking
        currPath.remove(currPath.size()-1);
    }
}