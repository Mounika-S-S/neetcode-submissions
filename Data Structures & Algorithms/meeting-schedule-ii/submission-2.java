/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> inter) {
        if(inter.size()==0) return 0;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        Collections.sort(inter,(a,b)->{
            if(a.start<b.start) return -1;
            if(a.start==b.start) return 0;
            return 1;
        });
        for(int i=0;i<inter.size();i++){
            if(!pq.isEmpty() && pq.peek()<=inter.get(i).start){
                pq.poll();
                
            }
            pq.add(inter.get(i).end);
        }
        return pq.size();
    }
}
