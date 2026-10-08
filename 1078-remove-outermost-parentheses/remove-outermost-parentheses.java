class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder st = new StringBuilder();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                count++;

                if (count > 1) {
                    st.append(s.charAt(i));
                }
            }
            else {
                count--;

                if (count > 0) {
                    st.append(s.charAt(i));
                }
            }
        }

        return st.toString();
    }
}