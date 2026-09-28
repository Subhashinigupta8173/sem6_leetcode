class Solution {
    public char kthCharacter(int k) {
        StringBuilder original = new StringBuilder("a");
        StringBuilder temp = new StringBuilder();
        while (original.length() < k) {
            temp = new StringBuilder();
            for (int i = 0; i < original.length(); i++) {
                char ch = original.charAt(i);
                ch = (char) (ch + 1);
                temp.append(ch);
            }
            original.append(temp);
        }
        return original.charAt(k-1);
        

    }
}