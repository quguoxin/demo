package leetcode.editor.cn;

//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。 
//
// 示例 1: 
//
// 输入: [1,2,3,4,5,6,7] 和 k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
// 
//
// 示例 2: 
//
// 输入: [-1,-100,3,99] 和 k = 2
//输出: [3,99,-1,-100]
//解释: 
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100] 
//
// 说明: 
//
// 
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。 
// 要求使用空间复杂度为 O(1) 的 原地 算法。 
// 
// Related Topics 数组 
// 👍 765 👎 0

public class RotateArray {
    public static void main(String[] args) {
        Solution solution = new RotateArray().new Solution();
        solution.rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate(int[] nums, int k) {
            // 外层循环向右移动次数
            /*for (int j = 0; j < k; j++) {
                // 内层循环每一次向右移动一个
                int temp = nums[nums.length-1];
                int tempNew;
                for (int i = 0; i < nums.length; i++) {
                    tempNew = nums[i];
                    nums[i] = temp;
                    temp = tempNew;
                }
            }*/


            //2021-07-15--超时
            /*// 整体向右移动k次，转换为每轮向右每次移动1次，移动k轮
            for (int i = 1; i <= k; i++) {
                // 考虑到尾部会向前迁移，则从尾部作为第一个移动元素
                int tempA = nums[nums.length-1];
                for (int j = 0; j < nums.length; j++) {
                    int tempB = nums[j];
                    nums[j] = tempA;
                    tempA = tempB;
                }
            }*/


            // 2021-07-15--空间复杂度O(n),不是最优解
            /*int[] r = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                r[(i + k) % nums.length] = nums[i];
            }
            for (int i = 0; i < nums.length; i++) {
                nums[i] = r[i];
            }*/

            // 2021-07-15 翻转
            //          |+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //            操作	                                |       结果
            //            原始数组	                            |   1 2 3 4 5 6 7
            //            翻转所有元素	                        |   7 6 5 4 3 2 1
            //            翻转 [0, k%length - 1]区间的元素	    |   5 6 7 4 3 2 1
            //            翻转 [k%length, length - 1]区间的元素	|   5 6 7 1 2 3 4
            int n = nums.length;
            k %= n;
            reverse(nums, 0, n - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, n - 1);
        }

        private void reverse(int[] nums, int start, int end) {
            while (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}