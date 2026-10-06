class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<(1<<n);i++){
            List<Integer> li=new ArrayList<>();
            for(int j=0;j<n;j++){
                if(getKB(i,j)==1){
                    li.add(nums[j]);
                }
            }
            list.add(li);
        }
        return list;
    }
    public int getKB(int n,int k){
        return (n>>k)&1;
    }
}