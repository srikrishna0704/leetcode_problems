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
    public int maximalRectangle(char[][] matrix) {
        int max=0;
        int n=matrix.length;
        int m=matrix[0].length;
        int[] height=new int[m];
        for(int i=0;i<n;i++){
            for(int  j=0;j<m;j++){
                if(matrix[i][j]=='1')height[j]++;
                else height[j]=0;
            }
            max=Math.max(max,largestRectangleArea(height));
        }
        return max;
    }
}