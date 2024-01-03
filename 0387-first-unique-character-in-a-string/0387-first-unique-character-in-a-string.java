class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
            queue.offer(c);
        }
        while(!queue.isEmpty()){
            char curr = queue.poll();
            if(map.get(curr) == 1){
                return s.indexOf(curr);
            }
        }
        return -1;
    }
}