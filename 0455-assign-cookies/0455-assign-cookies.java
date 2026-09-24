class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int n=g.length;
        int n1=s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0,j=0;
        while(i<n && j<n1){
            if(s[j]>=g[i]){
                i++;
            }
            j++;
        }
        return i;
    }
}