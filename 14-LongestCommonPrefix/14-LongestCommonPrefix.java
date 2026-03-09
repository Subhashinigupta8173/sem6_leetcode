// Last updated: 3/9/2026, 10:15:03 AM
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0)
            return "";
        
        String p=strs[0];
        for(int i=1; i<strs.length; i++){
            while(strs[i].indexOf(p)!=0){
                p=p.substring(0,p.length()-1);
                if(p.isEmpty()){
                    return "";
                }

            }
            
        }
         return p;
    }

}