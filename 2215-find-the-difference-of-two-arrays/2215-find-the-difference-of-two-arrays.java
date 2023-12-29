class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> result = new TreeSet<>();
        List<List<Integer>> output = new ArrayList<>();
        boolean found = false;
        for(int i: nums1){
            found = false;
            for(int j: nums2){
                if( i == j){
                    found = true;
                    break;
                }
            }
            if(!found) result.add(i);
        }
        output.add(new ArrayList<>(result));
        result = new TreeSet<>();
        for(int i: nums2){
            found = false;
            for(int j: nums1){
                if( i == j){
                    found = true;
                    break;
                }
            }
            if(!found) result.add(i);
        }
        output.add(new ArrayList<>(result));
        result = new TreeSet<>();
        return output;
    }
}