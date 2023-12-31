class TrieNode{
  TrieNode[] child;
  TrieNode(){
    child = new TrieNode[2];
  }
}
class Solution {
    public int findMaximumXOR(int[] nums) {
      int maxXor = Integer.MIN_VALUE;
      TrieNode root = new TrieNode();
      for(int i: nums){
        TrieNode mainNode = root;
        TrieNode subNode = root;
        int xor = 0;
        for(int j=31;j>=0; j--){
          int bit = (i >>> j) & 1;
          if(mainNode.child[bit] == null)
            mainNode.child[bit] = new TrieNode();
          mainNode = mainNode.child[bit];
          int subBit = 1-bit;
          if(subNode.child[subBit] != null){
            subNode = subNode.child[subBit];
            xor |= (1<<j);
          }else{
            subNode =subNode.child[bit];
          }
        }
        maxXor = Math.max(maxXor, xor);
      }
      return maxXor;
    }
}