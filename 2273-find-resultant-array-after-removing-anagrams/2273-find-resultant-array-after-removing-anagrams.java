class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        String prev = "";
        for(String i : words){
            String word = sortAndSplit(i);
            if(prev.equals(word)){
                continue;
            }
            result.add(i);
            prev= word;
        }
        return result;
    }
    private String sortAndSplit(String str){
        char[] c = str.toCharArray();
        Arrays.sort(c);
        return String.valueOf(c);
    }
}