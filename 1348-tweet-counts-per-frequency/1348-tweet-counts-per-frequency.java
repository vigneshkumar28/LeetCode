class TweetCounts {
    Map<String, List<Integer>> map;
    public TweetCounts() {
        map = new HashMap<>();
    }
    
    public void recordTweet(String tweetName, int time) {
        map.computeIfAbsent(tweetName, k-> new ArrayList<>()).add(time);
    }
    
    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        List<Integer> result = new ArrayList<>();
        if(!map.containsKey(tweetName))
            return result;
        int timeChunks = getInterval(freq);
        int currStartTime = startTime;
        List<Integer> tweetTime = map.get(tweetName);
        while(currStartTime <= endTime){
            int currEndTime = Math.min(currStartTime+timeChunks, endTime+1);
            int count = countTweetsInRange(tweetTime, currStartTime, currEndTime);
            result.add(count);
            currStartTime += timeChunks;
        }
        return result;
    }
    private int getInterval(String freq){
        switch(freq){
            case "minute": return 60;
            case "hour": return 3600;
            case "day": return 86400;
            default: return 1;
        }
    }
    private int countTweetsInRange(List<Integer> tweetTimes, int startTime, int endTime) {
        int count = 0;
        for (int time :tweetTimes) {
            if (time>=startTime && time<endTime) {
                count++;
            }
        }
        return count;
    }
}

/**
 * Your TweetCounts object will be instantiated and called as such:
 * TweetCounts obj = new TweetCounts();
 * obj.recordTweet(tweetName,time);
 * List<Integer> param_2 = obj.getTweetCountsPerFrequency(freq,tweetName,startTime,endTime);
 */