class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        // Loop until both strings are exhausted
        while (i >= 0 || j >= 0) {
            int sum = carry;
            
            // Subtract '0' to convert character to integer value
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';
            
            // Append the remainder (0 or 1) to our result
            sb.append(sum % 2);
            
            // Update carry (will be 1 if sum is 2 or 3, else 0)
            carry = sum / 2;
        }
        
        // If there's a leftover carry, append it
        if (carry != 0) {
            sb.append(carry);
        }
        
        // The characters were added backward, so reverse the string builder
        return sb.reverse().toString();
    }
}