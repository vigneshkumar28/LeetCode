import java.util.Random;

class Solution {
    int numOfPoints;
    List<Integer> sumCount= new ArrayList<>();
    int[][] rectangles;
    Random random = new Random();
    public Solution(int[][] rects) {
        numOfPoints=0;
        rectangles=rects;
        for(int[] rec: rectangles){
            numOfPoints+= (rec[2]-rec[0]+1) *(rec[3]-rec[1]+1);
            sumCount.add(numOfPoints);
        }
    }
    
    public int[] pick() {
        int id= random.nextInt(numOfPoints);
        //binary search
        int l=0,r=rectangles.length-1;
        while(l<r){
            int mid=l+(r-l)/2;
            if(sumCount.get(mid)<= id){
                l=mid+1;
            }else{
                r=mid;
            }
        }
        //find x points and y points and total num of points
        int[] rect = rectangles[l];
        int x = rect[0] + (id - (l > 0 ? sumCount.get(l - 1) : 0)) % (rect[2] - rect[0] + 1);
        int y = rect[1] + (id - (l > 0 ? sumCount.get(l - 1) : 0)) / (rect[2] - rect[0] + 1);
        return new int[]{x, y};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */