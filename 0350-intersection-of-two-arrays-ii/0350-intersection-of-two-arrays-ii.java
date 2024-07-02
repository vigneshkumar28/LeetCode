class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] countArr = new int[10001];
        for(int i =0; i< nums1.length;i++){
            countArr[nums1[i]]++;
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i< nums2.length;i++){
            if(countArr[nums2[i]]>0 ){
                list.add(nums2[i]);
                countArr[nums2[i]]--;
            }
        }
        int[] res = new int[list.size()];
        int i = 0;
        for(Integer num : list){
            res[i] = num;
            i++;
        }
        return res;
    }
}