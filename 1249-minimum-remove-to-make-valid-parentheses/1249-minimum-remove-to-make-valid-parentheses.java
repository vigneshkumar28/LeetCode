class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuffer result=new StringBuffer(s);
        int count=0;
        for(int i=0;i<result.length();i++){
            char c= result.charAt(i);
            if(c=='(')
                count++;
            else if(c==')')
                count--;
            if(count <0){
                result.setCharAt(i, '.');
                count=0;
            }
        }
        count=0;
        for(int i=result.length()-1;i>=0;i--){
            char c=result.charAt(i);
            if(c==')')
                count++;
            else if(c =='(')
                count--;
            if(count<0){
                result.setCharAt(i, '.');
                count=0;
            }
        }
        s=result.toString();
        s = s.replace(".", "");
        return s;
    }
}