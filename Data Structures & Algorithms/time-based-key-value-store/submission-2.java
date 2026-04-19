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

        for(Pair<Integer, String> pair: list){
            if(pair.getTimeStamp() <= timestamp){
                if(currentPair == null) {
                    currentPair = pair;
                } else {
                    if(pair.getTimeStamp() > currentPair.getTimeStamp()){
                       currentPair = pair; 
                    }
                }
            }
        }
        if(currentPair == null) return "";
        return currentPair.getValue(); 
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
