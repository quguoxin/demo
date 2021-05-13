package leetcode.editor.cn;

//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,-1], k = 1
//输出：[1,-1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [9,11], k = 2
//输出：[11]
// 
//
// 示例 5： 
//
// 
//输入：nums = [4,-2], k = 2
//输出：[4] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// -104 <= nums[i] <= 104 
// 1 <= k <= nums.length 
// 
// Related Topics 堆 Sliding Window 
// 👍 976 👎 0

import java.util.*;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum().new Solution();
        solution.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            /*int[] result = new int[nums.length - k + 1];
            int num = 0;
            if (k <= 0) {
                return new int[]{};
            }
            if (k == nums.length) {
                return new int[]{Arrays.stream(nums).sorted().toArray()[nums.length - 1]};
            }
            for (int i = 0; i < nums.length - k; i++) {
                result[num] = getMax(nums, i, k);
                num++;
            }
            return result;
        }

        int getMax(int[] nums, int dex, int k) {
            List list = new ArrayList();
            for (int i = 0; i < nums.length; i++) {
                if (i >= dex && i <= dex + nums.length - k) {
                    list.add(nums[i]);
                }
            }
            Collections.sort(list);
            return (int) list.get(list.size() - 1);
        }*/

            int[] re = new int[nums.length - k + 1];

            // 暴力法会超时，可以使用双向列表去做
            // i 代表窗口的末端坐标
            LinkedList<Integer> que = new LinkedList<>();
            for (int i = 0; i < nums.length; i++) {
                // 如果当前元素大于等于队列尾元素则移除，直到为空或不大于队尾元素
                while (!que.isEmpty() && nums[que.getLast()] <= nums[i]) {
                    que.pollLast();
                }

                // 此时满足当前元素大于队尾元素，则把当前元素坐标入列
                que.add(i);

                // 如果队列首元素超出了窗口的范围则移除队首元素
                if (!que.isEmpty() && que.peekFirst() < i - k + 1) {
                    que.pollFirst();
                }

                // 何时开始取最大值？在窗口形成时，也就是大于最初形成窗口的坐标，i>=k-1时
                if (!que.isEmpty() && i >= k - 1) {
                    // 最大值即是队列首
                    re[i + 1 - k] = nums[que.peekFirst()];

                }
            }
            return re;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}