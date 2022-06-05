package leetcode.editor.cn;

//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：2
//解释：有两种方法可以爬到楼顶。
//1. 1 阶 + 1 阶
//2. 2 阶 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出：3
//解释：有三种方法可以爬到楼顶。
//1. 1 阶 + 1 阶 + 1 阶
//2. 1 阶 + 2 阶
//3. 2 阶 + 1 阶
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 45 
// 
// Related Topics 记忆化搜索 数学 动态规划 
// 👍 2452 👎 0

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new ClimbingStairs().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int climbStairs(int n) {

            // f(n)=f(n-1)+f(n-2)
            // f(n-1)=f(n-2)+f(n-3)
            // f(n-2)=f(n-3)+f(n-4)
            // .................
            // f(2)=f(1)+f(0)
            // f(1)=1
            // f(0)=1

            ////////// 递归 n较大时会超时
//            return recursion1(n);

            ////////// 递归优化 n较大时不会超时
//            return recursion2(n);

            ////////// 动态规划 不会超时
//        return dynamic(n);

            // 2022.6.5
//            return digui1(n);
            return digui2(n);

        }

        private int digui1(int n) {
            if (n == 2) {
                return 2;
            }
            if (n == 1) {
                return 1;
            }
            return digui1(n - 1) + digui1(n - 2);
        }

        private Map<Integer, Integer> digui2Map = new HashMap<>();

        private int digui2(int n) {
            if (digui2Map.containsKey(n)) {
                return digui2Map.get(n);
            }
            int r;
            if (n == 2) {
                r = 2;
            } else if (n == 1) {
                r = 1;
            } else {
                r = digui2(n - 1) + digui2(n - 2);
            }
            digui2Map.put(n, r);
            return r;
        }

        // 递归1，n较大时会超时
        private int recursion1(int n) {
            if (n == 0 || n == 1) {
                return 1;
            }
            return recursion1(n - 1) + recursion1(n - 2);
        }

        // 递归2，1的优化类型，减少递归过程中的重复计算，中间计算的n 对应的结果可以用map缓存起来
        HashMap<Integer, Integer> map = new HashMap();

        private int recursion2(int n) {
            if (map.containsKey(n)) {
                return map.get(n);
            }
            if (n == 0 || n == 1) {
                return 1;
            }
            int sum = recursion2(n - 1) + recursion2(n - 2);
            map.put(n, sum);
            return sum;
        }

        // 动态规划
        private int dynamic(int n) {
            if (n < 3) {
                return n;
            }
            int next1 = 1; // 跳上第1个台阶需要的方法f(n-2)（代表了跳上n-2个台阶需要的方法，初始值给1）
            int next2 = 2; // 跳上第2个台阶需要的方法f(n-1)（代表了跳上n-1个台阶需要的方法，初始值给2）
            for (int i = 3; i < n; i++) {
                int temp1 = next1;
                int temp2 = next2;
                next1 = temp2;          // f(n-2) = 上一个f(n-1)
                next2 = temp1 + temp2;  // f(n-1) = 上一个f(n) = 上一个f(n-1)+上一个f(n-2)
            }
            return next1 + next2;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}