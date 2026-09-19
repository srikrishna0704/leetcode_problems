class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        int n=gifts.length;
        for(int i=0;i<n;i++){
            pq.add(gifts[i]);
        }
        for(int i=0;i<k;i++){
            int rem=pq.poll();
            int val=(int) (Math.sqrt(rem));
            pq.add(val);
        }
        long sum=0;
        for(int i: pq){
            sum+=i;
        }
        return sum;
    }
}