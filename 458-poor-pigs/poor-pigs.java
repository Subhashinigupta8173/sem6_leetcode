class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int rounds  = minutesToTest / minutesToDie;
        int state = rounds + 1 ;
        int pig  = 0;
        int possibilities =1;
        while(possibilities  < buckets){
            possibilities *= state;
            pig++;
        }
        return pig;
    }
}