class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> answer = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] carr = s.toCharArray();
            Arrays.sort(carr);
            String st = new String(carr);
            if(map.containsKey(st)){
                map.get(st).add(s);
            }else{
                List<String> l = new ArrayList<>();
                l.add(s);
                map.put(st,l);
            }
        }
        for(Map.Entry<String,List<String>> m : map.entrySet()){
                answer.add(m.getValue());
        }
        return answer;
    }
}
