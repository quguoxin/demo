package leetcode.editor.cn;

//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 
//
// 示例 1: 
//
// 输入: 123
//输出: 321
// 
//
// 示例 2: 
//
// 输入: -123
//输出: -321
// 
//
// 示例 3: 
//
// 输入: 120
//输出: 21
// 
//
// 注意: 
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。 
// Related Topics 数学 
// 👍 2388 👎 0

public class ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new ReverseInteger().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {

            //===================优美==========================
            /*long n = 0;
            while(x != 0) {
                n = n*10 + x%10;
                x = x/10;
            }
            return (int)n==n? (int)n:0;*/


            //=============================================
            if (x == 0) {
                return 0;
            }
            String str = Integer.toString(x);
            // 符号
            int flag = 1;
            if (x < 0) {
                flag = -1;
                str = str.substring(1);
            }

            // 反转 使用StringBuffer逆序方法去做
            str = new StringBuffer(str).reverse().toString();
            int result;
            try { // 超过32为即int的最大最小区间，转换会报错抛出异常，此时按照题目要求返回0就好
                result = Integer.parseInt(str) * flag;
            } catch (Exception e) {
                return 0;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}