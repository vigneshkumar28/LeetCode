class Solution {
    public int countTriplets(int[] arr) {
        //O(n) time complecity and O(n) space complexity - in case space not matter
        //One pass prefix xor
        int count=0;
        int prefix=0;
        Map<Integer, Integer> countMap= new HashMap<>();
        Map<Integer, Integer> totalMap= new HashMap<>();
        
        countMap.put(0, 1);
        for(int i=0;i<arr.length; i++){
            prefix ^= arr[i];
            count += countMap.getOrDefault(prefix, 0)*i - totalMap.getOrDefault(prefix, 0);
            //map update
            totalMap.put(prefix, totalMap.getOrDefault(prefix, 0)+i+1);
            countMap.put(prefix, countMap.getOrDefault(prefix, 0)+1);
        }
        return count;
    }
}