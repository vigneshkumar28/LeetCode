class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b)-> Integer.compare(a[0], b[0]));
        int arrows = 1;
        int end = points[0][1];
        for(int i=1;i<points.length;i++){
            if(points[i][0] > end){
                arrows++;
                end = points[i][1];
            }
            else{
                //if overlap 
                end = Math.min(end, points[i][1]);
            }
        }
        return arrows;
    }
}