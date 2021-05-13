package leetcode.editor.cn;

//
// 
// 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连
//。 
//
// 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。 
//
// 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 
//isConnected[i][j] = 0 表示二者不直接相连。 
//
// 返回矩阵中 省份 的数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 200 
// n == isConnected.length 
// n == isConnected[i].length 
// isConnected[i][j] 为 1 或 0 
// isConnected[i][i] == 1 
// isConnected[i][j] == isConnected[j][i] 
// 
// 
// 
// Related Topics 深度优先搜索 并查集 
// 👍 546 👎 0

import java.util.*;

public class NumberOfProvinces {
    public static void main(String[] args) {
        Solution solution = new NumberOfProvinces().new Solution();
        int[][] a = {{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}};
        solution.findCircleNum(a);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findCircleNum(int[][] isConnected) {
            // 省份编码
            int CircleNo = 0;
            // 省份数
            int CircleNum = 0;
            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < isConnected.length; i++) {
                for (int j = 0; j < isConnected.length; j++) {
                    // 相连
                    if (isConnected[i][j] == 1) {
                        if (map.containsKey(i) && !map.containsKey(j)) {
                            map.put(j, map.get(i));
                        } else if (map.containsKey(j) && !map.containsKey(i)) {
                            map.put(i, map.get(j));
                        } else if (map.containsKey(j) && map.containsKey(i)) {
                            // 省份不一致，合并
                            if ((int) map.get(i) != map.get(j)) {
                                // 合并J所在的组到i
                                int removeNo = map.get(j);
                                int addNo = map.get(i);
                                for (Integer key : map.keySet()) {
                                    if (map.get(key) == removeNo) {
                                        map.put(key, addNo);
                                    }
                                }
                                CircleNum--;
                            }
                        } else if (!map.containsKey(i) && !map.containsKey(j)) {
                            map.put(i, CircleNo);
                            map.put(j, CircleNo);
                            CircleNo++;
                            CircleNum++;
                        }
                    } else {
                        if (!map.containsKey(i)) {
                            map.put(i, CircleNo);
                            CircleNo++;
                            CircleNum++;
                        }
                        if (!map.containsKey(j)) {
                            map.put(j, CircleNo);
                            CircleNo++;
                            CircleNum++;
                        }
                    }
                }
            }
            return CircleNum;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}