package leetcode.editor.cn;

//给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = [1,2,3]
//输出：[1,2,4]
//解释：输入数组表示数字 123。
// 
//
// 示例 2： 
//
// 
//输入：digits = [4,3,2,1]
//输出：[4,3,2,2]
//解释：输入数组表示数字 4321。
// 
//
// 示例 3： 
//
// 
//输入：digits = [0]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= digits.length <= 100 
// 0 <= digits[i] <= 9 
// 
// Related Topics 数组 
// 👍 612 👎 0

import java.util.Stack;

public class PlusOne {
    public static void main(String[] args) {
        Solution solution = new PlusOne().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] plusOne(int[] digits) {
            // 特殊情况 9 99 999 9999

            for (int i = digits.length - 1; i >= 0; i--) {
                // 1、不等于9说明不进位了，直接+1后返回
                if (digits[i] != 9) {
                    digits[i]++;
                    return digits;
                }
                // 2、在1的基础上(该位等于9)，且为首位，则说明是特殊情况。特殊情况则重新构造数组 长度+1
                if (i == 0) {
                    break;
                }
                // 在1 2 的基础上能到这说明不是首位 且该位为9 ，则变该位为0后继续循环
                digits[i] = 0;
            }
            // 经过循环后且没有return 则是特殊情况。用长度构造新数组返回即可
            int[] result = new int[digits.length+1];
            result[0] = 1;
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}