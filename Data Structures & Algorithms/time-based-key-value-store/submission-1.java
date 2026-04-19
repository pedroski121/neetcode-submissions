class TimeMap {

    private Map<String, Map<Integer, List<String>>> keystore;

    public TimeMap() {
        keystore = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!keystore.containsKey(key)){
            Map<Integer, List<String>> mp = new HashMap<>();
            keystore.put(key, mp); 
        }

        Map<Integer, List<String>> mp = keystore.get(key);
        List<String> ls = mp.getOrDefault(timestamp, new ArrayList<>());
        ls.add(value);
        mp.put(timestamp, ls);
        keystore.put(key, mp);

    }
    
    public String get(String key, int timestamp) {
        if(!keystore.containsKey(key)){
            return "";
        }
        Map<Integer, List<String>> mp = keystore.get(key);
        Integer lowerTimeStamp = 0;
        for(Map.Entry<Integer, List<String>> entry: mp.entrySet()){
          
            if(entry.getKey() <= timestamp){
                lowerTimeStamp = Math.max(lowerTimeStamp, entry.getKey());
            }
        }
        if(lowerTimeStamp == 0) return "";
        return keystore.get(key).get(lowerTimeStamp).get(0);
        
    }
}
