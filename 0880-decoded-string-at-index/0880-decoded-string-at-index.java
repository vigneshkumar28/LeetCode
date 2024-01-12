class Solution {
    public String decodeAtIndex(String s, int k) {
        long max = 0;
        for(char c: s.toCharArray()){
            if(Character.isDigit(c))
                max *=(c-'0');
            else
                max++;
        }
        for(int i=s.length()-1; i>=0;i--){
            k %= max;
            char ch = s.charAt(i);
            if(k==0 && Character.isLetter(ch)){
                return ch+"";
            }
            if(Character.isDigit(ch)){
                max /= (ch-'0');
            }else{
                max--;
            }
        }
        return "";
    }
}