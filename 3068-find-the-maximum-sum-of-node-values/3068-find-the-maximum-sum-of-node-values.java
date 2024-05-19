class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        int N = nums.length;
        int[] netChange = new int[N];
        long nodeSum = 0;
        for(int i=0;i<N;i++){
            netChange[i] = (nums[i]^k)-nums[i];
            nodeSum += nums[i];
        }
        // sort & reverse
        Arrays.sort(netChange);
        for(int i=0;i<N/2; i++){
            int temp= netChange[i];
            netChange[i] = netChange[N-1-i];
            netChange[N-1-i]=temp;
        }
        for(int i=0;i<N; i+=2){
            if(i+1 == N){
              break;  
            }
            long pairSum = netChange[i]+netChange[i+1];
            if(pairSum > 0)
                nodeSum += pairSum;
        }
        return nodeSum;
    }
}