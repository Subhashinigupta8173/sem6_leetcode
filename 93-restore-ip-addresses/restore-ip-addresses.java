import java.util.*;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, List<String> path, List<String> result) {
        
        if (path.size() == 4) {
            
            if (start == s.length()) {
                result.add(String.join(".", path));
            }
            return;
        }

        
        for (int len = 1; len <= 3; len++) {
            if (start + len > s.length()) break; 
            String segment = s.substring(start, start + len);

            
            if (segment.startsWith("0") && segment.length() > 1) continue;

            int value = Integer.parseInt(segment);
            if (value > 255) continue;

           
            path.add(segment);

            
            backtrack(s, start + len, path, result);

          
            path.remove(path.size() - 1);
        }
    }
}