class Solution {
    List<String> result = new ArrayList<>();
    TrieNode root;
    class TrieNode{
        char c;
        TrieNode[] child;
        int wc;
        TrieNode(char c){
            wc=0;
            this.c = c;
            child = new TrieNode[26];
        }
    } 
    public List<String> wordBreak(String s, List<String> wordDict) {
        root = new TrieNode(' ');
        for(String str: wordDict){
            insertInTries(str);
        }
        backTracking(s, 0, new StringBuilder());
        return result;
    }
    private void insertInTries(String word){
        TrieNode curr = root;
        int idx;
        for(int i=0; i<word.length();i++){
            idx = word.charAt(i) -'a';
            if(curr.child[idx] == null){
                curr.child[idx] = new TrieNode(word.charAt(i));
            }
            curr = curr.child[idx];
        }
        curr.wc += 1;
    }
    private boolean searchInTries(String word){
        TrieNode curr = root;
        int idx;
        for(int i=0;i<word.length();i++){
            idx =word.charAt(i)-'a';
            if(curr.child[idx]==null){
                return false;
            }
            curr = curr.child[idx];
        }
        return curr.wc >0;
    }
    private void backTracking(String str, int start, StringBuilder res){
        if(str.length() == start){
            result.add(res.toString().trim());
            return;
        }
        TrieNode curr = root;
        for(int i=start;i<str.length();i++){
            int idx = str.charAt(i) -'a';
            if(curr.child[idx] != null){
                curr = curr.child[idx];
                if(curr.wc > 0){
                    int length = res.length();
                    res.append(str, start, i+1).append(" ");
                    backTracking(str, i+1, res);
                    res.delete(length, res.length());
                }
            }else{
                break;
            }
        }
    }
}