class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n=chalk.length;
        long[] prefixSum= new long[n];
        prefixSum[0]= chalk[0];
        for(int i=1;i<n;i++){
            prefixSum[i]= prefixSum[i-1]+chalk[i];
        }
        long sum= prefixSum[n-1];
        long remaningChalk = (k%sum);
        return binarySeach(prefixSum, remaningChalk);
    }
    private int binarySeach(long[] arr, long tar){
        int low=0, high= arr.length-1;
        while(low< high){
            int mid = low+(high-low)/2;
            if(arr[mid]<=tar){
                low = mid+1;
            }else{
                high=mid;
            }
        }
        return high;
    }
}