class Solution {
    public int minGroups(int[][] intervals) {
        int n=intervals.length;
        int[] start=new int[n];
        int[] end=new int[n];
        for(int i=0;i<n;i++){
            start[i]=intervals[i][0];
            end[i]=intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int s=0,e=0;
        int cnt=0;
        int max=0;
        while(s<n){
            if(start[s]<=end[e]){
                cnt++;
                s++;
            }
            else{
                cnt--;
                e++;
            }
            max=Math.max(max,cnt);
        }
        return max;
    }
}