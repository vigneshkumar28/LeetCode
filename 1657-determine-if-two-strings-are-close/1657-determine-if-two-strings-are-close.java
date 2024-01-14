class Solution {
    private Map<Character, Integer> getWordFreq(String word){
        Map<Character, Integer> map = new HashMap<>();
        for(char c: word.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        return map;
    }
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length())
            return false;
        Map<Character, Integer> map1 = getWordFreq(word1);
        Map<Character, Integer> map2 = getWordFreq(word2);
        if(!map1.keySet().equals(map2.keySet()))
            return false;
        List<Integer> list1 = new ArrayList<>(map1.values());
        List<Integer> list2 = new ArrayList<>(map2.values());
        Collections.sort(list1);
        Collections.sort(list2);
        if(!list1.equals(list2))
            return false;
        return true;
    }
}