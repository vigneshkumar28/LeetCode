class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deadSet= new HashSet<>(Arrays.asList(deadends));
        if(deadSet.contains("0000"))
            return -1;
        Queue<String> q= new LinkedList<>();
        Set<String> visited= new HashSet<>();
        q.offer("0000");
        visited.add("0000");
        int depth=0;
        while(!q.isEmpty()){
            int size= q.size();
            for(int i=0;i<size; i++){
                String current= q.poll();
                if(current.equals(target))
                    return depth;
                for(int j=0;j<4;j++){
                    for(int k=-1;k<=1; k+=2){
                        char[] currArr= current.toCharArray();
                        int digit= (currArr[j]-'0'+k+10)%10;
                        currArr[j]=(char)(digit+'0');
                        String neighbour = new String(currArr);
                        if(!visited.contains(neighbour) && !deadSet.contains(neighbour)){
                            q.offer(neighbour);
                            visited.add(neighbour);
                        }
                    }
                }
            }
            depth++;
        }
        return -1;
    }
}