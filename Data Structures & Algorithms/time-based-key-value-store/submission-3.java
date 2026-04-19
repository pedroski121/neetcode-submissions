class TimeMap {

    // create a pair method to accept a pair of integers and strings
    // initialize an empty hashmap - {key: Pair<Integer, String>[]}
    // Add key:Pair value in hashmap 
    // perform linear search on array to get most recent timestamp to given timestamp

    private Map<String, List<Pair<Integer, String>>> keystore;
    public TimeMap() {
        this.keystore = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!keystore.containsKey(key)){
            List<Pair<Integer, String>> list = new ArrayList<>();
            keystore.put(key, list);
        }
        Pair<Integer, String> pair = new Pair<>(timestamp, value);
        keystore.get(key).add(pair);
    }
    
    public String get(String key, int timestamp) {
        if(!keystore.containsKey(key)){
            return "";
        }
        List<Pair<Integer, String>> list = keystore.get(key);

        Pair<Integer, String> currentPair = null;   
        String value = null;

        int left = 0;
        int right = list.size() - 1;


        while(left <= right) {
            int mid = (left + right)/2;

            if(list.get(mid).getTimeStamp() <= timestamp){
                value = list.get(mid).getValue();
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        if(value == null) return "";
        return value; 
    }

    private static class Pair<K, V> {
        final private K key;
        final private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getTimeStamp() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
