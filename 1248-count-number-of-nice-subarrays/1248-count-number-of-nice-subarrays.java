class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] freq = new int[n + 1];
        freq[0] = 1;
        int ans = 0, t = 0;
        for (int v : nums) {
            t += v & 1;
            if (t - k >= 0) {
                ans += freq[t - k];
            }
            freq[t]++;
        }
        return ans;
    }
}