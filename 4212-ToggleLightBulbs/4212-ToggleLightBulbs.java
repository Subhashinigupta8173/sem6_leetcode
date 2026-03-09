// Last updated: 3/9/2026, 10:15:07 AM
class Solution {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        List<Integer> ll=new ArrayList<>();
        int c=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<bulbs.size(); i++){
            int bulb=bulbs.get(i);
        map.put(bulb,map.getOrDefault(bulb,0)+1);
               
                
            }
            
    for(int bulb:map.keySet()){
        
    
    if(map.get(bulb)%2!=0){
            ll.add(bulb);
        }
    }
       
            Collections.sort(ll);
        return ll;
        
        
    }
}