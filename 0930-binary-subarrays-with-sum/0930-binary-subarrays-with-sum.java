class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return subArraySum(nums,goal)-subArraySum(nums,goal-1);
    }
    public int subArraySum(int[] a,int k){
        if(k<0) return 0;
        int l=0,r=0,cnt=0,sum=0;
        int n=a.length;
        while(r<n){
            sum+=a[r];
            while(sum>k){
                sum-=a[l];
                l++;
            }
            cnt+=(r-l+1);
            r++;
        }
        return cnt;

    }
}