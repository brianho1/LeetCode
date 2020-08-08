// 771 https://leetcode.com/problems/jewels-and-stones/submissions/
class Solution {
    public int numJewelsInStones(String J, String S) {
        char[] ch = new char[58];
        for (int i = 0; i < J.length(); i++) {
            ch[J.charAt(i) - 'A'] = 1;
        }
        int res = 0;
        for (int i = 0; i < S.length(); i++) {
            if (ch[S.charAt(i) -'A'] != 0) res++;
        }
        return res;
    }
}