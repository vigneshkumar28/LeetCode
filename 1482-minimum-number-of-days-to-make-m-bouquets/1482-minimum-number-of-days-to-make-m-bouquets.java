class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        // m -> required bouquets as per k adjacenet flowers
        int n = bloomDay.length;
        long val = m*1L*k;
        if(val > n){
            return -1;
        }
        int l = Arrays.stream(bloomDay).min().getAsInt();
        int h = Arrays.stream(bloomDay).max().getAsInt();
        while(l<h){
            int mid = l + (h-l)/2;
            if(checkBouquet(bloomDay, m, k, mid)){
                h = mid;
            }else{
                l = mid+1;
            }
        }
        return l;
    }
    private static boolean checkBouquet(int[] bloomDay, int reqBouq, int reqFlow, int days){
        int bouquets = 0;
        int flowers = 0;
        for(int i=0; i<bloomDay.length; i++){
            if(bloomDay[i]<=days)
                flowers++;
            else
                flowers =0;
            if(flowers == reqFlow){
                bouquets++;
                flowers = 0;
            }
        }
        return bouquets >= reqBouq;
    }
}