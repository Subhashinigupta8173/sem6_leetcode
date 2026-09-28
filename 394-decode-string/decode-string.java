class Solution {
    public String decodeString(String s) {
        Stack<Integer> count = new Stack<>();
        Stack<String>  Stringcount = new Stack<>();    
        StringBuilder current= new StringBuilder();
        int num =0 ;
        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch)){
                num = num * 10 + (ch - '0');

            }
            else if(ch == '['){
                count.push(num);
                Stringcount.push(current.toString());

                num = 0;
                current = new StringBuilder();
            }
            else if(ch == ']'){
                int c  = count.pop();
                String previous = Stringcount.pop();
                StringBuilder temp = new StringBuilder(previous);
                for(int i = 0; i< c; i++){
                    temp.append(current);

                }
                current = temp;


            }
            else{
                current.append(ch);
            }
        }
        return current.toString();            
    }
}