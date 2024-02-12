class Solution {
    public int rearrangeCharacters(String s, String target) {
        Map<Character, Integer> sFreqMap = updateFreq(s);
        Map<Character, Integer> targetFreqMap = updateFreq(target);
        int possibleCount=101;
        for(char c: target.toCharArray()){
            int sCount = sFreqMap.getOrDefault(c, 0);
            int targetCount = targetFreqMap.get(c);
            if(sCount < targetCount)
                return 0;
            possibleCount = Math.min(possibleCount, sCount/targetCount);
        }
        return possibleCount;
    }
    private Map<Character, Integer> updateFreq(String str){
        Map<Character, Integer> map = new HashMap<>();
        for(char c: str.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        return map;
    }
}