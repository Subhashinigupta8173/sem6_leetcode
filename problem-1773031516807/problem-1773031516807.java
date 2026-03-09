// Last updated: 3/9/2026, 10:15:16 AM
1class Solution {
2    public String longestCommonPrefix(String[] strs) {
3        if(strs==null || strs.length==0)
4            return "";
5        
6        String p=strs[0];
7        for(int i=1; i<strs.length; i++){
8            while(strs[i].indexOf(p)!=0){
9                p=p.substring(0,p.length()-1);
10                if(p.isEmpty()){
11                    return "";
12                }
13
14            }
15            
16        }
17         return p;
18    }
19
20}