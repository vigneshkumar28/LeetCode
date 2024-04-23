class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1){
            return Collections.singletonList(0);
        }
        
        int graph[] =new int[n];
        Map<Integer, List<Integer>> map =new HashMap();
        for(int[] edge: edges) {
            graph[edge[0]]++;
            graph[edge[1]]++;
            map.putIfAbsent(edge[0], new ArrayList());
            map.putIfAbsent(edge[1], new ArrayList());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> q = new LinkedList();
        for(int i=0;i<graph.length;i++) {
            if(graph[i] == 1) {
                q.add(i);
            }
        }

        int processed = 0;
        while(n - processed > 2) {
            int size = q.size();
            processed += size;
            for(int i=0;i<size;i++) {
                int poll = q.poll();
                for(int adj: map.get(poll)) {
                    if(--graph[adj] == 1) {
                        q.add(adj);
                    }
                }
            }
        }

        List<Integer> list = new ArrayList();
        list.addAll(q);
        return list;
    }
}