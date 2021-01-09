package leetcode.editor.cn;

//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 
// 👍 908 👎 0

import java.util.Stack;

public class MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new MoveZeroes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            /////////////////////////////////////1
            /*Stack<Integer> stack = new Stack<>();
            int num = 0;
            for (int a : nums) {
                if (a != 0) {
                    stack.push(a);
                    continue;
                }
                num++;
            }
            for (int i = nums.length - 1; i >= 0; i--) {
                if (num > 0) {
                    nums[i] = 0;
                    num--;
                    continue;
                }
                nums[i] = stack.pop();
            }*/

            /////////////////////////////////////1
            // 将不为0的数依次放入到数组中的索引
            int index = 0;
            for (int i = 0; i < nums.length; i++) {
                // 将不为0的数依次放入到数组中
                if (nums[i] != 0) {
                    nums[index] = nums[i];
                    // 每次放入指针向后推一位
                    index++;
                }
            }
            // 开始从索引处补0，一直补到末尾
            while (index < nums.length) {
                nums[index] = 0;
                index++;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}