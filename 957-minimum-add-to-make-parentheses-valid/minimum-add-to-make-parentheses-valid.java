class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        int c = 0;

        for (int i = 0; i < s.length(); i++) {

            if (st.isEmpty()) {
                st.push(s.charAt(i));
            }
            else if (s.charAt(i) == ')' && st.peek() == '(') {
                st.pop();
                c++;
            }
            else {
                st.push(s.charAt(i));
            }
        }

        return s.length() - 2 * c;
    }
}