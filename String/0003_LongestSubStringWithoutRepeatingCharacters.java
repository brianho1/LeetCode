//https://leetcode.com/problems/longest-substring-without-repeating-characters/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        /**
       
        if (s.length() == 0) return 0;
        Set<Character> set = new HashSet<>();
        int j = 0;
        int i = 0;
        int res = Integer.MIN_VALUE;
        while (i < s.length() && j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                    set.add(s.charAt(j++));
                    res = Math.max(res, j-i);
                } 
            else {
                set.remove(s.charAt(i++));
            }
        }
        return res;
         **/
        
        if (s.length() == 0) return 0;
        char[] ch = new char[128];
        int i = 0;
        int j = 0;
        int res = Integer.MIN_VALUE;
        while (i < s.length() && j < s.length()) {
            if (ch[s.charAt(j)] == 0) {
                ch[s.charAt(j++)]++;
                res = Math.max(res, j - i);
            }
            else {
                ch[s.charAt(i++)]--;
            }
        }
        return res;
        }
    }

// pwwkew
// p -> 1
// w -> 1
// 