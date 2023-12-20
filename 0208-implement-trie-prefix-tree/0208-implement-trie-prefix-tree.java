class TrieNode{
    public TrieNode[] children = new TrieNode[26];
    public boolean isWordEnd = false;
}
class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode temp = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(temp.children[ch-'a'] == null)
                temp.children[ch-'a'] = new TrieNode();
            temp = temp.children[ch-'a'];
        }
        temp.isWordEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode temp = root;
        for(int i=0;i<word.length(); i++){
            char ch = word.charAt(i);
            if(temp.children[ch-'a']== null)
                return false;
            // travel to next node of trie
            temp = temp.children[ch-'a'];
        }
        return temp.isWordEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode temp = root;
        for(int i=0; i<prefix.length(); i++){
            char ch = prefix.charAt(i);
            if(temp.children[ch-'a'] == null)
                return false;
            temp = temp.children[ch-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */