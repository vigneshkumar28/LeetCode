class Solution {
    public List<List<String>> partition(String s) {
        String[] str = s.split("");
        List<List<String>> results = new ArrayList<>();
        checkCombinations(results, new ArrayList<>(), str, 0);
        return results;
    }
    private static void checkCombinations(List<List<String>> results, List<String> temp, String[] str, int start){
        int n = str.length;
        if(start == n){
            results.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start; i<n; i++){
            if(isPlaindrome(str, start, i)){
             temp.add(String.join("",Arrays.copyOfRange(str, start, i+1)));
             checkCombinations(results, temp, str, i+1);
             temp.remove(temp.size()-1);   
            }
        }
    }
    private static boolean isPlaindrome(String[] str, int start, int end){
        while(start<end){
            if(!str[start].equals(str[end]))
                return false;
            start++;
            end--;
        }
        return true;
    }
}