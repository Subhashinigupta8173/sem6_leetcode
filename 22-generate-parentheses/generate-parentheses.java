class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ll=new ArrayList<>();
		Parentheses(n,0,0,"",ll); 
        return ll;
       
		
	}
    public static void Parentheses(int n, int o, int c, String ans, List<String> ll){
        if(o == n && c == n){
            ll.add(ans);
            return ;
        }
        if(o > n || c > o){
            return ;
        }
        Parentheses(n, o + 1, c, ans +"(", ll);
        Parentheses(n, o, c + 1, ans +")", ll);

    }


}