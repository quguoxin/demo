package leetcode.editor.cn;

//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,1]
//输出: 1
// 
//
// 示例 2: 
//
// 输入: [4,1,2,1,2]
//输出: 4 
// Related Topics 位运算 哈希表 
// 👍 1657 👎 0

import java.util.Arrays;

public class SingleNumber {
    public static void main(String[] args) {
        Solution solution = new SingleNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            //////////////////////////////////1
           /* Arrays.sort(nums);
            if (nums.length == 1) {
                return nums[0];
            }
            if (nums[0] != nums[ 1]) {
                return nums[0];
            }
            if (nums[nums.length - 1] != nums[nums.length - 2]) {
                return nums[nums.length - 1];
            }

            for (int i = 1; i < nums.length-1; i++) {
                if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
                    return nums[i];
                }
            }
            return 0;*/

            //////////////////////////////////2
            // ^异或位运算   转换成二进制后比较相同位结果为0 不同为1
            // 所以 A^A = 0   0^A = A
            int len = nums.length;
            int result = 0;
            for (int num : nums) {
                result ^= num;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}