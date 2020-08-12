// https://leetcode.com/problems/pascals-triangle-ii/submissions/

class Solution {
    public List<Integer> getRow(int rowIndex) {
        
//         List<List<Integer>> list = new ArrayList<List<Integer>>();
//         list.add(Arrays.asList(1));
//         list.add(Arrays.asList(1,1));
//         for (int i = 2; i <= rowIndex; i++) {
//             List<Integer> l2 = list.get(i-1);
//             List<Integer> l3 = new ArrayList<>();
//             for (int j = 0; j <= i; j++) {
//                 if (j == 0 || j == i) { 
//                     l3.add(1);
//                     continue;
//                 } else {
//                     l3.add(l2.get(j) + l2.get(j-1));
//                 }
                
//             }
//             list.add(l3);
//         }
//         return list.get(rowIndex);
        
        List<Integer> dp = new ArrayList<>();
        dp.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            dp.add(1);
            for (int j = i-1; j >= 1; j--) {
                dp.set(j, dp.get(j) + dp.get(j-1));
            }
        }
        return dp;
    }
}