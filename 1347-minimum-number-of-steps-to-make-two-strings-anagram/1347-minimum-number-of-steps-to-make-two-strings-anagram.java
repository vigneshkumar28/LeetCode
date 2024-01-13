class Solution {
    public int minSteps(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        for(char c: t.toCharArray()){
            map.put(c, map.getOrDefault(c, -1)-1);
        }
        int sum = 0;
        for(Map.Entry<Character, Integer> i: map.entrySet()){
            if(i.getValue()>0){
                sum += i.getValue();
            }
        }
        return sum;
    }
}