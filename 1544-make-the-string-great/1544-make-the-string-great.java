class Solution {
    public String makeGood(String s) {
        StringBuffer result= new StringBuffer();
        for(char c: s.toCharArray()){
            int len = result.length();
            if(len >0 && Math.abs(result.charAt(len-1)-c)==32){
                result.deleteCharAt(len-1);
            }else{
                result.append(c);
            }
        }
        return result.toString();
    }
}