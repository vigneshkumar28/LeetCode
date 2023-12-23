class Solution {
    public int[][] reconstructQueue(int[][] people) {
      List<int[]> result = new ArrayList<>();
      Arrays.sort(people, (a, b)->{
        if(a[0] != b[0])
          return Integer.compare(b[0], a[0]);
        else
          return Integer.compare(a[1], b[1]);
      });
      for(int[] i: people)
        result.add(i[1], i);
      return result.toArray(new int[people.length][2]);
    }
}