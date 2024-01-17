class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new TreeSet<>();
        Set<Integer> set2 = new TreeSet<>();
        for(int i: nums1)
            set1.add(i);
        for(int i: nums2)
            set2.add(i);
        List<Integer> result= new ArrayList<>();
        for(int i: set1){
            if(set2.contains(i))
                result.add(i);
        }
        int[] arr=new int[result.size()];
        for(int i=0; i<result.size(); i++){
            arr[i] = result.get(i);
        }
        return arr;
    }
}