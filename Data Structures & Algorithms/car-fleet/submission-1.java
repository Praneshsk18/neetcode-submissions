class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int answer = 0;
        Integer[] posarr  =Arrays.stream(position).boxed().toArray(Integer[]::new);
        HashMap<Integer,Integer> map = new HashMap<>();
        Stack<Double> stack = new Stack<>();
        for(int i=0; i<speed.length; i++){
            map.put(posarr[i], speed[i]);
        }
        Arrays.sort(posarr,Collections.reverseOrder());
        for(int i : posarr){
            double t = (double) (target - i) / map.get(i);
            if(!stack.isEmpty() && stack.peek() >= t){
                continue;
            }else{
                stack.push(t);
            }
        }
        return stack.size();
    }
}