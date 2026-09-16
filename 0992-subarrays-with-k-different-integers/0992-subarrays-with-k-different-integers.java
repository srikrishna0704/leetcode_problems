class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return countSub(nums,k)-countSub(nums,k-1);
    }
    public int countSub(int[] a,int k){
        int l=0;
        int r=0;
        int n=a.length;
        int cnt=0;
        Map<Integer,Integer> map=new HashMap<>();
        while(r<n){
            map.put(a[r],map.getOrDefault(a[r],0)+1);
            while(map.size()>k){
                map.put(a[l],map.get(a[l])-1);
                if(map.get(a[l])==0){
                    map.remove(a[l]);
                }
                l++;
            }
            cnt+=(r-l+1);
            r++;
        }
        return cnt;
    }
}