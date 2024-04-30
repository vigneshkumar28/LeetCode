class Solution {
    public long wonderfulSubstrings(String word) {
        int n=word.length();
        Map<Integer, Integer> freqMap=new HashMap<>();
        freqMap.put(0,1);
        int mask=0;
        long res=0L;
        for(int i=0;i<n;i++){
            char c= word.charAt(i);
            int bit=c-'a';
            mask^=(1<<bit);
            res += freqMap.getOrDefault(mask, 0);
            freqMap.put(mask, freqMap.getOrDefault(mask, 0)+1);
            for(int oddChar=0; oddChar<10; oddChar++){
                res += freqMap.getOrDefault(mask ^ (1<< oddChar), 0);
            }
        }
        return res;
    }
}