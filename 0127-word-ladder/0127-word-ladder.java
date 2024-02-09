class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord))return 0;
        //bfs
        Queue<String> q=new LinkedList<>();
        Set<String> vis = new HashSet<>();
        q.offer(beginWord);
        q.offer(beginWord);
        int lengthOfLadder=1;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                String word = q.poll();
                if(word.equals(endWord))return lengthOfLadder;
                char[] wordArr=word.toCharArray();
                for(int j=0;j<word.length();j++){
                    char ch= wordArr[j];
                    for(char c='a';c<='z';c++){
                        if(wordArr[j]==c) continue;
                        wordArr[j]=c;
                        String newWord = new String(wordArr);
                        if(set.contains(newWord) && !vis.contains(newWord)){
                            q.add(newWord);
                            vis.add(newWord);
                        }
                    }
                    wordArr[j] = ch;
                }
            }
            lengthOfLadder++;
        }
        return 0;
    }
}