class Solution {
    class Edge implements Comparable<Edge>{
        int src;
        int des;
        int weight;
        public Edge(int src, int des, int weight){
            this.src = src;
            this.des=des;
            this.weight=weight;
        }
        @Override
        public int compareTo(Edge temp){
            return this.weight-temp.weight;
        }
    }
    class UnionFind{
        int[] parent;
        public UnionFind(int n){
            parent = new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
            }
        }
        public int find(int x){
            if(parent[x] == x)
                return x;
            return parent[x]=find(parent[x]);
        }
        public void union(int x, int y){
            int findX = find(x);
            int findY = find(y);
            parent[findX]=findY;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        //krushal algo
        List<Edge> edges=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int distance=Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                edges.add(new Edge(i, j, distance));
            }
        }
        Collections.sort(edges);
        UnionFind uf = new UnionFind(n);
        int cost=0;
        int edgesCount=0;
        for(Edge e: edges){
            if(uf.find(e.src) != uf.find(e.des)){
                uf.union(e.src, e.des);
                cost += e.weight;
                edgesCount++;
                if(edgesCount == n-1)
                    break;
            }
        }
        return cost;
    }
}