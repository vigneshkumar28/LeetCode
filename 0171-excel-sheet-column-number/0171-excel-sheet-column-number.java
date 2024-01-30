class Solution {
    public int titleToNumber(String columnTitle) {
        int total = 0;
        int n=columnTitle.length()-1;
        while(n >= 0){
            total += (columnTitle.charAt(n) - 'A' +1) * Math.pow(26, columnTitle.length()-1-n);
            n--;
        }
        return total;
    }
}