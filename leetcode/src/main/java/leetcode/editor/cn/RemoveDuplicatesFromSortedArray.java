package leetcode.editor.cn;

//给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。 
//
// 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。 
//
// 
//
// 示例 1: 
//
// 给定数组 nums = [1,1,2], 
//
//函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。 
//
//你不需要考虑数组中超出新长度后面的元素。 
//
// 示例 2: 
//
// 给定 nums = [0,0,1,1,1,2,2,3,3,4],
//
//函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
//
//你不需要考虑数组中超出新长度后面的元素。
// 
//
// 
//
// 说明: 
//
// 为什么返回数值是整数，但输出的答案是数组呢? 
//
// 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。 
//
// 你可以想象内部操作如下: 
//
// // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
//int len = removeDuplicates(nums);
//
//// 在函数里修改输入数组对于调用者是可见的。
//// 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//}
// 
// Related Topics 数组 双指针 
// 👍 1773 👎 0

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeDuplicates(int[] nums) {
            // 双指针   遍历一直到找到和当前元素不一样的元素，即代表前后元素不一样，此时将该不一样元素移动至该元素后面一位
            // 然后当前元素往后移动一位，继续找下一个元素和当前元素不一样的元素
            int slow = 0; // 第一个元素
            for (int i = 1; i < nums.length; i++) {
                if (nums[slow]!=nums[i]) { // 找到第二个不一样的元素
                    nums[slow+1] = nums[i];
                    slow++;// 此时继续找slow++后面的一位元素
                }
            }
            return slow+1;

           /* // 注意题目给的是一个排序数组
            // 且题目意思是控制台只会输出返回的长度范围内的元素
            // 综上两点可以用快慢指针去做

            // 慢指针从第一个开始
            int slow = 0;
            // 快指针从第二个开始
            for (int fast = 1; fast < nums.length; fast++) {
                // 找到不一样的元素，slow前移并接收那个不一样的值
                if (nums[slow] != nums[fast]) {
                    slow++;
                    nums[slow] = nums[fast];
                }
            }
            return slow + 1;*/

           // 2021-07-15
            /*int slow = 0;
            int fast = 1;
            for (int i = 0; i < nums.length-1; i++) {
                if (nums[slow] != nums[fast]) {
                    nums[slow + 1] = nums[fast];
                    slow++;
                }
                fast++;
            }
            return slow + 1;*/
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}