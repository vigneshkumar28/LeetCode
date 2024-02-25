class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length;
        //find & union with bfs
        int MAX = 100000;
        int N = nums.length;
        boolean[] vis = new boolean[MAX+1];
        for(int i:nums){
            vis[i]=true;
        }
        if(N==1)
            return true;
        if(vis[1])
            return false;
        int[] dp= new int[MAX+1];
        for(int i=2;i<=MAX;i++){
            if(dp[i]==0){
                for(int j=i;j<=MAX; j+=i){
                    dp[j]=i;
                }
            }
        }
        UnionFind uf= new UnionFind(2*MAX+1);
        for(int x: nums){
            int val=x;
            while(val>1){
                int prime=dp[val];
                int root= prime+MAX;
                if(uf.find(root) != uf.find(x)){
                    uf.unite(root,x);
                }
                while(val%prime==0)
                    val /= prime;
            }
        }
        int count=0;
        for(int i=2;i<=MAX;i++){
            if(vis[i] && uf.find(i)==i)
                count++;
        }
        return count == 1;
    }
}
class UnionFind{
    private int[] parent;
    private int[] rank;
    public UnionFind(int n){
        parent=new int[n+1];
        rank=new int[n+1];
        for(int i=0;i<=n;i++){
            parent[i]=i;
            rank[i]=1;
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
        if(px == py)
            return;
        if(rank[px] > rank[py]){
            int temp=px;
            px = py;
            py= temp;
        }
        parent[px]=py;
        rank[py] += rank[px];
    }
}