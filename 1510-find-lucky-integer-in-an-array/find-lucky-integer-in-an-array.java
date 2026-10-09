class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

       int max = -1;


        for (int key : map.keySet()) {
            int ans = map.get(key);
            if(key == ans){
                max = key;
            }

          
        }
        if(max != -1){
        return max;
        }
        else{
            return -1;
        }

        
    }
}

