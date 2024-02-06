class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> out = new ArrayList<>();
        Map<String, List<String>> results = new HashMap<>();
        for(String s: strs){
          char[] chArr = s.toCharArray();
          Arrays.sort(chArr);
          String sortStr = new String(chArr);
          results.computeIfAbsent(sortStr, key -> new ArrayList<>()).add(s);
        }
      for(List<String> l : results.values()){
        Collections.sort(l);
        out.add(l);
      }
      return out;
    }
}