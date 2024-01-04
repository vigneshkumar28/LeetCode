class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        int n= friends.length;
        //bfs - add in q and check size, pop and travel it
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        boolean[] vis = new boolean[n];
        vis[id] =true;
        int l = 0;
        // find id = 1,2 example 1 using q via bfs
        while(l < level){
            int size = q.size();
            while(size >0){
                for(int friend: friends[q.poll()]){
                    if(vis[friend] == false){
                        vis[friend] = true;
                        q.add(friend);   
                    }
                }
                size--;
            }
            l++;
        }
        // count freq based on q's value which is 0's connected value C:2, B:1
        HashMap<String, Integer> freqMap = new HashMap<>();
        while(!q.isEmpty()){
            for(String video: watchedVideos.get(q.poll())){
                freqMap.put(video, freqMap.getOrDefault(video, 0)+1);
            }
        }
        //sort C:2, B:1 and lexographical sort also needs to do
        List<String> result = new ArrayList<>(freqMap.keySet());
        //freq are diff - return a1-b1 else b1-a1
        result.sort((a,b)->{
            int a1 = freqMap.get(a);
            int b1 = freqMap.get(b);
            if(a1!=b1){
                //freq different
                return a1-b1;
            }else{
                // lexographic, freq are same
                return a.compareTo(b);
            }
        });
        return result;
    }
}