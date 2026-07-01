class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder sb=new StringBuilder();
        Stack<Character> s=new Stack<>();

        for(int i=0;i<num.length();i++){
            char ch=num.charAt(i);
           
            while(!s.isEmpty() && k>0 && s.peek()>ch){
                s.pop();
                k--;
            }
            s.push(ch);
            
            
        }
        while(k > 0 && !s.isEmpty()){
    s.pop();
    k--;
}

for(char c : s){
    sb.append(c);
}

while(sb.length() > 1 && sb.charAt(0) == '0'){
    sb.deleteCharAt(0);
}

if(sb.length() == 0){
    return "0";
}

return sb.toString();
        
    }
}