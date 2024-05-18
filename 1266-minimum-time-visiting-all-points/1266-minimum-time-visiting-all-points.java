class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int res=0;
        for(int i=0;i<points.length-1; i++){
            int currentX = points[i][0];
            int currentY = points[i][1];
            int destinationX = points[i+1][0];
            int destinationY = points[i+1][1];
            res += Math.max(Math.abs(destinationX - currentX), Math.abs(destinationY - currentY));
        }
        return res;
    }
}