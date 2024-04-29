class Solution {
    private class CustomComparator implements Comparator<String>{
        @Override
        public int compare(String a, String b){
            String possible1=a+b;
            String possible2=b+a;
            return possible2.compareTo(possible1);
        }
    }
    
    public String largestNumber(int[] nums) {
        String[] asString= new String[nums.length];
        for(int i=0;i<nums.length;i++){
            asString[i]=String.valueOf(nums[i]);
        }
        Arrays.sort(asString, new CustomComparator());
        if(asString[0].equals("0")){
            return "0";
        }
        String largestNum = new String();
        for(String i: asString){
            largestNum +=i;
        }
        return largestNum;
    }
}