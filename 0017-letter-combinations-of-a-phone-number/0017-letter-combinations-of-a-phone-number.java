class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() == 0)
            return result;
        Map<Character, String> pair = new HashMap<>();
        pair.put('2',"abc");
        pair.put('3', "def");
        pair.put('4', "ghi");
        pair.put('5', "jkl");
        pair.put('6', "mno");
        pair.put('7', "pqrs");
        pair.put('8', "tuv");
        pair.put('9', "wxyz");
        backtrack(pair, result, digits, "", 0);
        return result;
    }
    private void backtrack(Map<Character, String> pair, List<String> result, String digits, String current, int index){
        if(index == digits.length()){
            result.add(current);
            return;
        }
        for(char letter: pair.get(digits.charAt(index)).toCharArray()){
            backtrack(pair, result, digits, current+letter, index+1);
        }
    }
}