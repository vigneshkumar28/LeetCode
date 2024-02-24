class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        List<Integer> result = new ArrayList<>();
        //union find algo
        Arrays.sort(meetings, (a,b)->a[2]-b[2]);
        Map<Integer, List<int[]>> sameMeetingTimes = new TreeMap<>();
        for(int[] i: meetings){
            sameMeetingTimes.computeIfAbsent(i[2], k->new ArrayList<>()).add(new int[]{i[0], i[1]});
        }
        UnionFind graph = new UnionFind(n);
        graph.unite(firstPerson, 0);
        for(int i: sameMeetingTimes.keySet()){
            for(int[] meet: sameMeetingTimes.get(i)){
                graph.unite(meet[0], meet[1]);
            }
            for(int[] meet:sameMeetingTimes.get(i)){
                if(!graph.connected(meet[0],0)){
                    graph.reset(meet[0]);
                    graph.reset(meet[1]);
                }
            }
        }
        for(int i=0;i<n;i++){
            if(graph.connected(i, 0)){
                result.add(i);
            }
        }
        return result;
    }
}
class UnionFind{
    private int[] parent;
    private int[] rank;
    public UnionFind(int n){
        parent=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
    }
    public int find(int x){
        if(parent[x]!=x){
            parent[x]=find(parent[x]);
        }
        return parent[x];
    }
    public void unite(int x, int y){
        int px = find(x);
        int py= find(y);
        if(px != py){
            if(rank[px] > rank[py]){
                parent[py]=px;
            }else if(rank[px]<rank[py]){
                parent[px] = py;
            }else{
                parent[py]=px;
                rank[px]+=1;
            }
        }
    }
    public boolean connected(int x, int y){
        return find(x) == find(y);
    }
    public void reset(int x){
        parent[x]=x;
        rank[x]=0;
    }
}