public class Solution {
    public int minEatingSpeed(int[] piles, int h) {
   List<Integer> ls = new ArrayList<>();

      for(int pile:piles){
        ls.add(pile);
      }

      int max = Collections.max(ls);


      int l = 1; 
      int r = max;
      int k = max;

      while(l <= r) {
        int mid = (l + r)/2;
        int hours = 0;
        for(int pile:piles){
            hours += (int)Math.ceil((double)pile/mid);
        }
        if(hours <= h){
            k = Math.min(mid, k);
        }
        if(hours > h){
            l = mid + 1;
        }
        else {
            r = mid - 1;
        }
      }
      return k;
    }
}