class Solution {
    public int numSteps(String s) {
        int carry=0;
        int operations=0;
        for(int i=s.length()-1; i>0; i--){
            if(s.charAt(i)-'0'+carry == 1){
                operations++;
                carry=1;
            }
            operations++;
        }
        return operations+carry;
    }
}