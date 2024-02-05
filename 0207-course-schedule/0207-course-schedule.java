class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++)
            graph.add(new ArrayList<>());
        for(int[] i: prerequisites)
            graph.get(i[1]).add(i[0]);
        int[] indegrees = new int[numCourses];
        for(int[] i: prerequisites){
            indegrees[i[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegrees[i]==0)
                q.add(i);
        }
        //bfs
        while(!q.isEmpty()){
            int currCourse = q.poll();
            for(int neighbours: graph.get(currCourse)){
                indegrees[neighbours]--;
                if(indegrees[neighbours] == 0)
                    q.add(neighbours);
            }
        }
        for(int inDegree: indegrees){
            if(inDegree > 0)
                return false;
        }
        return true;
    }
}