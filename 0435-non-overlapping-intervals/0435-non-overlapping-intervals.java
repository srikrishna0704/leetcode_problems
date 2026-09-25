class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);
        int remcount=0;
        int limit=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(limit>intervals[i][0]){
                remcount++;
            }
            else{
                limit=intervals[i][1];
            }
        }
        return remcount;
    }
}