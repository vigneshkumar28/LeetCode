class RandomizedCollection {
    List<Integer> list;
    public RandomizedCollection() {
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(list.contains(val)){
            list.add(val);
            return false;
        }
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(list.contains(val)){
            int id = list.indexOf(val);
            list.remove(id);
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        Random rand = new Random();
        int id = rand.nextInt(list.size());
        return list.get(id); 
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */