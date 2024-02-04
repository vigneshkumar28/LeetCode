class Solution {
    public String minWindow(String s, String t) {
        if(s.equals(t))
            return s;
        int m= s.length();
        int n=t.length();
        if(s==null || t==null || m<n)
            return "";
        Map<Character, Integer> map = new HashMap<>();
        for(char c: t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        int right=0;
        int left=0;
        int minLength = Integer.MAX_VALUE;
        int minLeft =0;
        while(right < m){
            char c = s.charAt(right);
            if(map.containsKey(c)){
                if(map.get(c) >0)
                    n--;
                map.put(c, map.get(c)-1);
            }
            right++;
            while(n==0){
                if(right-left < minLength){
                    minLength= right-left;
                    minLeft=left;
                }
                char charLeft = s.charAt(left);
                if(map.containsKey(charLeft)){
                    map.put(charLeft, map.get(charLeft)+1);
                    if(map.get(charLeft)>0)
                        n++;
                }
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "": s.substring(minLeft, minLength+minLeft);
    }
}