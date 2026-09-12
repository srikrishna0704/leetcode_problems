class StockSpanner {

   private Deque<int[]> st;
    private int index;

    public StockSpanner() {
        st = new ArrayDeque<>();
        index = 0;
    }
    
    public int next(int price) {
        // Pop elements while top price <= current price (same as finding PGE)
        while (!st.isEmpty() && st.peek()[0] <= price) {
            st.pop();
        }
        
        // If stack is empty, PGE index is -1; otherwise, it's the index at top of stack
        int pgeIndex = st.isEmpty() ? -1 : st.peek()[1];
        
        // Calculate span: current index - PGE index
        int span = index - pgeIndex;
        
        // Push current price and its day index onto the stack
        st.push(new int[]{price, index});
        
        // Increment the day index for the next call
        index++;
        
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */