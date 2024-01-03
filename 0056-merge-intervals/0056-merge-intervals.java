class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, ((a, b) -> Integer.compare(a[0], b[0])));
        List<int[]> result = new ArrayList<>();
        int[] now = intervals[0];
        for(int i=1;i<intervals.length; i++){
            int[] nextInterval = intervals[i];
            if(now[1] >= nextInterval[0]){
                now[1] = Math.max(now[1], nextInterval[1]);
            }else{
                result.add(now);
                now = nextInterval;
            }
        }
        result.add(now);
        return result.toArray(new int[result.size()][]);
    }
}