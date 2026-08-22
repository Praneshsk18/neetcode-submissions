class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] arr = new int[k];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : nums){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else{
                map.put(i,1);
            }
        }
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b)->Integer.compare(b.getValue(),a.getValue()));
        for(Map.Entry m : map.entrySet()){
            pq.add(m);
        }
        for(int i=0;i<k;i++){
            arr[i]=pq.poll().getKey();
        }
        return arr;
    }
}