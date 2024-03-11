class Solution {
    public String customSortString(String order, String s) {
        String result="";
        Map<Character, Integer> freqMap =new HashMap<>();
        for(char c: s.toCharArray()){
            freqMap.put(c, freqMap.getOrDefault(c, 0)+1);
        }
        for(char c: order.toCharArray()){
            while(freqMap.getOrDefault(c, 0) >0){
                result += c;
                freqMap.put(c, freqMap.get(c)-1);
            }
        }
        for(Map.Entry<Character, Integer> i: freqMap.entrySet()){
            while(i.getValue() > 0){
                result += i.getKey();
                freqMap.put(i.getKey(), freqMap.getOrDefault(i.getKey(), 0)-1);
            }
        }
        return result;
    }
}