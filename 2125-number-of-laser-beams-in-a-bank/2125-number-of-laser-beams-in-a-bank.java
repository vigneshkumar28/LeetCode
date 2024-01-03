class Solution {
    public int numberOfBeams(String[] bank) {
        int n = bank.length;
        int count = 0;
        int before = 0;
        for(int i=0; i<n; i++){
           int ones = countOne(bank[i]);
           if( ones > 0){
                count += (ones * before);
                before = ones;
            }
        }
        return count;
    }
    private static int countOne(String b){
        int count = 0;
        for(int i=0; i<b.length(); i++){
            if(b.charAt(i) == '1')
                count++;
        }
        return count;
    }
}