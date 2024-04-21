class Solution {
    class UnionFind{
        int[] parent;
        public UnionFind(int n){
            parent = new int[n];
            for(int i=0;i<n; i++){
                parent[i] = i;
            }
        }
        public int find(int x){
            if(parent[x] == x)
                return x;
            return parent[x] = find(parent[x]);
        }
        public void merge(int x, int y){
            int xVal = find(x);
            int yVal = find(y);
            if(xVal !=  yVal){
                parent[yVal]= xVal;
            }
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        UnionFind uf= new UnionFind(n);
        for(int[] edge: edges){
            uf.merge(edge[0], edge[1]);
        }
        int sourceVertex=uf.find(source);
        int destinationVertex=uf.find(destination);
        return sourceVertex == destinationVertex;
    }
}