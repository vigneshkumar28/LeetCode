class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trustCount = new int[n+1];
        int[] trustedCount = new int[n+1];
        for(int[] i: trust){
            int ai = i[0];
            int bi = i[1];
            trustCount[ai]--;
            trustedCount[bi]++;
        }
        for(int i=1;i<=n;i++){
            if(trustCount[i] == 0 && trustedCount[i] ==n-1)
                return i;
        }
        return -1;
    }
}