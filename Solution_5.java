import java.util.*;

class Solution_5 {
    public int lengthOfLongestSubstring(String s) {
        if(0 <= s.length() && s.length() <= (5 * Math.pow(10, 4))){
            Set<Character> set = new HashSet<Character>();
            for(int i=0; i<s.length(); i++){
                set.add(s.charAt(i));   
            }
            return set.size();
        }
        return 0;
    }
    public static void main(String args[]){
        Solution_5 s = new Solution_5();
        System.out.println(s.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(s.lengthOfLongestSubstring("bbbbb"));
        System.out.println(s.lengthOfLongestSubstring("pwwkew"));
    }
}