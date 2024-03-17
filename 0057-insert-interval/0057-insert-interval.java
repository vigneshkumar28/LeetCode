class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int n=intervals.length;
        int i=0;
        //left
        while(i<n && intervals[i][1]<newInterval[0]){
            result.add(intervals[i]);
            i++;
        }
        //new interval
        while(i<n && newInterval[1]>=intervals[i][0]){
            newInterval[0]=Math.min(intervals[i][0], newInterval[0]);
            newInterval[1]=Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        result.add(newInterval);
        //remaining intervals
        while(i<n){
            result.add(intervals[i]);
            i++;
        }
        return result.toArray(new int[result.size()][2]);
    }
}