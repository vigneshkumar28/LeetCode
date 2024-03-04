class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        //2 pointer
        int score =0;
        int low=0;
        int high=tokens.length-1;
        while(low <= high){
            if(power>=tokens[low]){
                score++;
                power -= tokens[low];
                low++;
            }else if(low < high && score>0){
                score--;
                power += tokens[high];
                high--;
            }
            else{
                return score;
            }
        }
        return score;
    }
}