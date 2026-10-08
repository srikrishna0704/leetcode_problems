class Solution {
    public int reverseBits(int n) {
        int result=0;
        for(int i=0;i<=31;i++){
            int bit=(n&1);
            result=bit|(result<<1);
            n=n>>1;
        }
        return result;
    }
}