class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int[] hashmap=new int[256];
        Arrays.fill(hashmap,-1);
        int l=0,r=0;
        int max=0;
        while(r<n){
            if(hashmap[s.charAt(r)]!=-1 && hashmap[s.charAt(r)]>=l){
                l=hashmap[s.charAt(r)]+1;
            }
            int len=r-l+1;
            max=Math.max(len,max);
            hashmap[s.charAt(r)]=r;
            r++;
        }
        return max;
    }
}