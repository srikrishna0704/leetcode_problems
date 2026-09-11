class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> st=new ArrayDeque<>();
        int maxarea=0;
        int n=heights.length;
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[i]<heights[st.peek()]){
                int element=st.pop();
                int nse=i;
                int pse=st.isEmpty()?-1:st.peek();
                maxarea=Math.max(maxarea,heights[element]*(nse-pse-1));
            }
            st.push(i);
        }
        while(!st.isEmpty()){
                int element=st.pop();
                int nse=n;
                int pse=st.isEmpty()?-1:st.peek();
                maxarea=Math.max(maxarea,heights[element]*(nse-pse-1));

        }
        return maxarea;
    }
}