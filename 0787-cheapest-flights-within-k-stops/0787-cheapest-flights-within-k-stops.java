class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //bfs
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for(int[] flight: flights){
            int from=flight[0];
            int to=flight[1];
            int price = flight[2];
            adj.computeIfAbsent(from, key->new ArrayList<>()).add(new int[]{to, price});
        }
        int[] distance= new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src]=0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src, 0});
        int stops=0;
        while(!q.isEmpty() && stops<=k){
            int tempSize = q.size();
            while(tempSize-- >0){
                int[] curr = q.poll();
                int node = curr[0];
                int dis = curr[1];
                if(!adj.containsKey(node)) continue;
                for(int[] i : adj.get(node)){
                    int neighbour = i[0];
                    int price = i[1];
                    if(price+dis >= distance[neighbour])continue;
                    distance[neighbour]=price+dis;
                    q.offer(new int[]{neighbour, distance[neighbour]});
                }
            }
            stops++;
        }
        return distance[dst] == Integer.MAX_VALUE ? -1: distance[dst];
    }
}