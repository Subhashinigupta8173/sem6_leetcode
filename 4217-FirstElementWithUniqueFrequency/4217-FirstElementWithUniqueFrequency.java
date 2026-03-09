// Last updated: 3/9/2026, 10:15:05 AM
class Solution {
    public int firstUniqueFreq(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
         HashMap<Integer, Integer> freqCount = new HashMap<>();
        for(int i=0; i<nums.length; i++){
           map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            
        }
        for(int freq: map.values()){
           freqCount.put(freq, freqCount.getOrDefault(freq, 0) + 1);
        }
        for(int i=0; i<nums.length; i++){
              if (freqCount.get(map.get(nums[i])) == 1) {
                return nums[i];
            }
        }
            
        return -1;
        
    }
}