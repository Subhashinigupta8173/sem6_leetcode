class Solution { 
    public int maxScoreWords(String[] words, char[] letters, int[] score) { 
        int n = words.length; 
        int[] result = new int[n]; 
         
        for(int i = 0 ;i < n;i++){ 
            int sum = 0; 
            for(char ch : words[i].toCharArray()){ 
                sum += score[ch - 'a']; 
            } 
            result[i] = sum; 
        } 
 
        HashMap<Character,Integer> map = new HashMap<>(); // freq 
        for (int i = 0; i < letters.length; i++) { 
            map.put(letters[i], map.getOrDefault(letters[i], 0) + 1); 
        } 
 
        return Result(words,0,map,result,0); 
         
    } 

    public static int Result(String[] words,int i,HashMap<Character,Integer> freq,int[] res,int currentSum){ 

        if(i >= words.length) return currentSum; 
 
        int leave = Result(words,i+1,freq,res,currentSum); 
 
        String word = words[i]; 
        boolean canTake = true; 
        HashMap<Character, Integer> freq2 = new HashMap<>(); 

        for(int j = 0; j < word.length(); j++) 
            freq2.put(word.charAt(j),freq2.getOrDefault(word.charAt(j),0) + 1); 
         
        for(char ch: freq2.keySet()){ 
            int required = freq2.get(ch); 
            int available = freq.getOrDefault(ch,0); 

            if(required > available){ 
                canTake  = false; 
                break; 
            } 
        } 

        int take = 0;

        if(canTake){ 
            for(char ch : freq2.keySet()){ 
                freq.put(ch, freq.get(ch) - freq2.get(ch)); 
            } 
 
            take = Result(words,i+1,freq,res,currentSum + res[i]); 

            //undo
            for (char ch : freq2.keySet()) { 
                freq.put(ch, freq.get(ch) + freq2.get(ch)); 
            } 
        } 
 
        return Math.max(leave,take); 
    } 

    /** 
    int leave = value1;
    take if possible:
        modify variables
        then int take = value2
        undo variables
    return Math.max(leave,take)
    */ 
}