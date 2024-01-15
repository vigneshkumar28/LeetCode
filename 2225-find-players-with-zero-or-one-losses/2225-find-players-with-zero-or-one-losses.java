class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Set<Integer> set1 = new TreeSet<>();
        Set<Integer> set2 = new TreeSet<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for(int[] i: matches){
            set1.add(i[0]);
            set2.add(i[1]);
            map2.put(i[1], map2.getOrDefault(i[1], 0)+1);
        }
        List<Integer> win = new ArrayList<>();
        List<Integer> loss = new ArrayList<>();
        for(int i: set1){
            if(!set2.contains(i)){
                win.add(i);
            }
        }
        for(int i:set2){
            if(map2.get(i) == 1){
                loss.add(i);
            }
        }
        return new ArrayList<>(Arrays.asList(win, loss));
    }
}