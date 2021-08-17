package leetcode.editor.cn;

//给定一个整数数组，判断是否存在重复元素。 
//
// 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。 
//
// 
//
// 示例 1: 
//
// 
//输入: [1,2,3,1]
//输出: true 
//
// 示例 2: 
//
// 
//输入: [1,2,3,4]
//输出: false 
//
// 示例 3: 
//
// 
//输入: [1,1,1,3,3,4,3,2,4,2]
//输出: true 
// Related Topics 数组 哈希表 
// 👍 353 👎 0

import java.util.*;

public class ContainsDuplicate {
    public static void main(String[] args) {
        Solution solution = new ContainsDuplicate().new Solution();
        int[] nums = {3, 1};
        solution.containsDuplicate(nums);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsDuplicate(int[] nums) {
            //////////////////////////////////////1
            /*if (nums.length== 0) {
                return false;
            }
            Set set = new HashSet();
            Arrays.stream(nums).forEach(set::add);
            if (set.size() != nums.length) {
                return true;
            }
            return false;*/

            //////////////////////////////////////2
            /*if (nums.length== 0) {
                return false;
            }
            Arrays.sort(nums);
            for (int i = 0; i < nums.length -1; i++) {
                if (nums[i]==nums[i+1]) {
                    return true;
                }
            }
            return false;*/


            //////////////////////////////////////3
            /*if (nums.length== 0) {
                return false;
            }
            return Arrays.stream(nums).distinct().count()!=nums.length;*/

            return Arrays.stream(nums).distinct().count() != nums.length;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}