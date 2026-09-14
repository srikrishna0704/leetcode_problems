class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return countAtMost(nums,k)-countAtMost(nums,k-1);
    }
    public int countAtMost(int[] a,int k){
        int n=a.length;
        int l=0,r=0,cnt=0,sum=0;
        while(r<n){
            sum+=a[r]%2;
            while(sum>k){
                sum-=a[l]%2;
                l++;
            }
            cnt+=(r-l+1);
            r++;
        }
        return cnt;
    }
}