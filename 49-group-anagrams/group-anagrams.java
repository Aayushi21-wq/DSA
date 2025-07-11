class Solution {
    boolean isAnagram(String first, String second){
        if(first.length()!=second.length()){
            return false;
        }
        char []x = first.toCharArray();
        char []y = second.toCharArray();
        Arrays.sort(x);
        Arrays.sort(y);
        return Arrays.equals(x,y); // if same so it return true otherwise return false
    }
    // TC (n^2 * n log n). - Brute Force 
    public List<List<String>> groupAnagramsBF(String[] strs) {
        List<List<String>> bigList = new ArrayList<>();
        for(String word : strs){
            boolean added = false; // flag to check is it already in the list
            for(List<String> smallList : bigList){
                if(isAnagram(smallList.get(0), word)){
                    smallList.add(word);
                    added = true;
                    break;
                }
            }
            if(!added){
                List<String> newSmallList = new ArrayList<>();
                newSmallList.add(word);
                bigList.add(newSmallList);
            }
        }
        return bigList;
    }
    // Approach - 2
    // N * N Log N
    public List<List<String>> groupAnagramsOld(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String word : strs){ // N
            char w[] = word.toCharArray();
            Arrays.sort(w); // N Log N
            String key = new String(w); 
            map.computeIfAbsent(key, k->new ArrayList<>()).add(word);

        }
        return new ArrayList<>(map.values());
    }
    // Approach - 3
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String word : strs){
            int countArr[] = new int[26]; // Constant Space
            for(char c : word.toCharArray()){
                countArr[c-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int k : countArr){
                sb.append(k).append('#'); // 1#1#1#
            }
            String key = sb.toString();
            map.computeIfAbsent(key, k->new ArrayList<>()).add(word);
        }
        return new ArrayList<>(map.values());
    }
}