class Solution {
    public boolean halvesAreAlike(String s) {
        Set<Character> map = new HashSet<>();
        map.add('a');
        map.add('e');
        map.add('i');
        map.add('o');
        map.add('u');
        map.add('A');
        map.add('E');
        map.add('I');
        map.add('O');
        map.add('U');
        int n = s.length();
        int mid = n/2;
        int countS1 = 0; int countS2 = 0;
        for(int i=0; i<n; i++){
            if(i<mid){
                if(map.contains(s.charAt(i))){
                    countS1++;
                }
            }else{
                if(map.contains(s.charAt(i))){
                    countS2++;
                }
            }
        }
        return countS1 == countS2;
    }
}