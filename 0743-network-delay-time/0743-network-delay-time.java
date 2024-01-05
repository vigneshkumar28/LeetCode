class Solution {
    //adjance list to store sourceNode, pair(weight/timetoReach, targetNode)
    Map<Integer, List<Pair<Integer, Integer>>> adj = new HashMap<>();
    //dijkstra algorithm
    private void dijkstra(int[] signalTimes, int k){
        Queue<Pair<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparing(Pair::getKey));
        pq.add(new Pair(0, k));
        signalTimes[k]=0;
        while(!pq.isEmpty()){
            Pair<Integer, Integer> top = pq.remove();
            int time = top.getKey();
            int target = top.getValue();
            if(time > signalTimes[target])
                continue;
            if(!adj.containsKey(target))
                continue;
            for(Pair<Integer, Integer> neighbour: adj.get(target)){
                int t = neighbour.getKey();
                int neighbourVertex = neighbour.getValue();
                if(t+time < signalTimes[neighbourVertex]){
                    signalTimes[neighbourVertex] = t+time;
                    pq.add(new Pair(t+time, neighbourVertex));
                }
            }
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        for(int[] time : times){
            int source = time[0];
            int target = time[1];
            int signalTime = time[2];
            adj.putIfAbsent(source, new ArrayList<>());
            adj.get(source).add(new Pair(signalTime, target));
        }
        int[] signalTimes = new int[n+1];
        Arrays.fill(signalTimes, Integer.MAX_VALUE);
        dijkstra(signalTimes, k);
        int networkDelayResult = Integer.MIN_VALUE;
        for(int i=1; i<=n; i++){
            networkDelayResult = Math.max(networkDelayResult, signalTimes[i]);
        }
        return networkDelayResult == Integer.MAX_VALUE ? -1 : networkDelayResult;
    }
}