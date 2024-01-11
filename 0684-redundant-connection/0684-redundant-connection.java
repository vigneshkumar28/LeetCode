//Disjoint set using FindAndUnion
class FindAndUnion{
    int[] parent;
    int[] rank;
    public FindAndUnion(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
    }
    //path compression
    public int find(int i){
        if(parent[i] == i)
            return i;
        else{
            int result = find(parent[i]);
            parent[i] = result;
            return result;
        }
    }
    //normal union
    public void union(int i, int j){
        int iref = find(i);
        int jref = find(j);
        parent[iref] = jref;
    }
    //union by rank
    public boolean unionByRank(int i, int j){
        int irep = find(i);
        int jrep = find(j);
        //cycle found
        if(irep == jrep)
            return false;
        //based on rank optimzed union
        int irank = rank[irep];
        int jrank = rank[jrep];
        if(irank < jrank){
            parent[irep] = jrep;
        }else if(jrank <irank){
            parent[jrep] = irep;
        }else{
            parent[irep] = jrep;
            rank[jrep]++;
        }
        return true;
    }
}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n =edges.length;
        FindAndUnion fu = new FindAndUnion(n+1);
        int id=0;
        for(int[] edge: edges){
            if(!fu.unionByRank(edge[0], edge[1])){
                return edge;
            }
        }
        return edges[0];
    }
}