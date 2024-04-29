class Solution {
    private long[][] table;
    private long mod=(long)1e9+7;
    public int numOfWays(int[] nums) {
        int n= nums.length;
        table= new long[n][n];
        for(int i=0;i<n;i++){
            table[i][0]=table[i][i]=1;
        }
        for(int i=2;i<n;i++){
            for(int j=1;j<i;j++){
                table[i][j]=(table[i-1][j-1]+table[i-1][j])%mod;
            }
        }
        List<Integer> result= Arrays.stream(nums).boxed().collect(Collectors.toList());
        return (int)((dfs(result)-1)%mod);
    }
    private long dfs(List<Integer> resultList){
        int n=resultList.size();
        if(n<3) return 1;
        List<Integer> leftNodes= new ArrayList<>();
        List<Integer> rightNodes= new ArrayList<>();
        for(int i=1;i<n;i++){
            if(resultList.get(i) <resultList.get(0)){
                leftNodes.add(resultList.get(i));
            }else{
                rightNodes.add(resultList.get(i));
            }
        }
        long leftPath= dfs(leftNodes)% mod;
        long rightPath= dfs(rightNodes)% mod;
        return (((leftPath*rightPath)%mod)*table[n-1][leftNodes.size()])%mod;
    }
}