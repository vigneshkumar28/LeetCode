class Solution {
    public int findFinalValue(int[] nums, int original) {
        Set<Integer> result = new TreeSet<>();
        for(int i: nums)
            result.add(i);
        while(result.contains(original))
            original *= 2;
        return original;
    }
}