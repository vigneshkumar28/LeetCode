class Solution {
    public String maximumOddBinaryNumber(String s) {
        char[] arr = s.toCharArray();
        int n=arr.length;
        Arrays.sort(arr);
        int last2 = n-2;
        for(int i=0;i<n/2; i++){
            char c=arr[i];
            arr[i]=arr[last2-i];
            arr[last2-i]=c;
        }
        return new String(arr);
    }
}