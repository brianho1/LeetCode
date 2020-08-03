class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        
        if (haystack.length() < needle.length()) {
            return -1;
        }
        
        for (int i = 0; i < haystack.length(); i++) {
            char c = haystack.charAt(i);
            if (c == needle.charAt(0)) {
                int j = 0;
                int pos = i;
                while ( j < needle.length() && i < haystack.length() && needle.charAt(j) == haystack.charAt(i)) { 
                    j++;
                    i++;
                }
                if (j == needle.length()) {
                    return pos;
                }
                else {
                    i = pos;
                }
            }
        }
        
        
        return -1;
    }
}