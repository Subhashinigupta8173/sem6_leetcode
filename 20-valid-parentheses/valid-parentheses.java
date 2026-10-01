class Solution {
    public boolean isValid(String s) {
         Stack<Character> st = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            // Push opening brackets
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else {
                // If stack empty and closing bracket appears -> NOT valid
                if (st.isEmpty()) return false;
                
                char top = st.pop();
                
                // Check mismatch
                if (ch == ')' && top != '(') return false;
                if (ch == '}' && top != '{') return false;
                if (ch == ']' && top != '[') return false;
            }
        }
        
        // At end stack must be empty
        return st.isEmpty();
        
    }
}