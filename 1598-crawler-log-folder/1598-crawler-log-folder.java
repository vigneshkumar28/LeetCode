class Solution {
    public int minOperations(String[] logs) {
        //O(n) -time, O(1) - space
        int folderDepth=0;
        for(String currentOperation: logs){
            if(currentOperation.equals("../"))
                folderDepth = Math.max(0, folderDepth-1);
            else if(!currentOperation.equals("./"))
                folderDepth++;
        }
        return folderDepth;
    }
}