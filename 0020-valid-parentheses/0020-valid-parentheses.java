class Solution {
    public boolean isValid(String s) {
          Stack<Character> st = new Stack<>();
          for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[')
                st.push(ch);  // Push opening brackets to stack
            else {
                if (st.isEmpty()) return false;  // No matching opening bracket
                char top = st.pop();

                // Check for matching pair
                if ((ch == ')' && top == '(') ||
                    (ch == ']' && top == '[') ||
                    (ch == '}' && top == '{'))
                    continue;
                else
                    return false;
            }
        }
        return st.isEmpty();
    }
}