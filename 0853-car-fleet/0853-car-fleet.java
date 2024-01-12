class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> carFleet = new Stack<>();
        int n=speed.length;
        int[][] cars = new int[n][2];
        for(int i=0; i<n; i++){
            cars[i] = new int[]{position[i], speed[i]};
        }
        Arrays.sort(cars, (a,b)->Integer.compare(b[0],a[0]));
        int count = 0;
        for(int i=0; i<n; i++){
            double timeTaken = (double)(target - cars[i][0])/cars[i][1];
            while(carFleet.isEmpty() || timeTaken>carFleet.peek()){
                count++;
                carFleet.push(timeTaken);
            }
        }
        return count;
    }
}