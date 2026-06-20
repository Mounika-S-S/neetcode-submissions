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
    public boolean canAttendMeetings(List<Interval> inter) {
        if(inter.size()==0) return true;
        Collections.sort(inter,(a,b)->{
            if(a.start<b.start) return -1;
            if(a.start==b.start) return 0;
            return 1;
        });
        int ed=inter.get(0).end;
        for(int i=1;i<inter.size();i++){
            if(inter.get(i).start<ed) return false;
            else{
                ed=inter.get(i).end;
            }
        }
        return true;
    }
}
