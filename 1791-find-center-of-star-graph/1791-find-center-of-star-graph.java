class Solution {
    public int findCenter(int[][] edges) {
      Map<Integer, Integer> result = new HashMap<>();
      for(int[] i: edges){
        result.put(i[0], result.getOrDefault(i[0], 0)+1);
        result.put(i[1], result.getOrDefault(i[1], 0)+1);
      }
      for(Map.Entry<Integer, Integer> i: result.entrySet()){
        if(i.getValue() == edges.length){
          return i.getKey();
        }
      }
      return -1;
    }
}