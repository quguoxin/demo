package leetcode.editor.cn;

//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, 
//ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 说明：你不能倾斜容器。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 示例 2： 
//
// 
//输入：height = [1,1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：height = [4,3,2,1,4]
//输出：16
// 
//
// 示例 4： 
//
// 
//输入：height = [1,2,1]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// n = height.length 
// 2 <= n <= 3 * 104 
// 0 <= height[i] <= 3 * 104 
// 
// Related Topics 贪心 数组 双指针 
// 👍 2605 👎 0

public class ContainerWithMostWater {
    public static void main(String[] args) {
    Solution solution = new ContainerWithMostWater().new Solution();
        solution.maxArea(new int[]{1,8,6,2,5,4,8,3,7});
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxArea(int[] height) {
        // 暴力破解法 时间复杂度O(N平方) 不可取

        // 想办法从1中过滤掉一些无用的比较，这里使用双指针实现
        // 1、左右移动时，固定较长的边，移动较短的边
        // 2、移动比较时，只比较比移动边高大的，否则不比较，如果小的话肯定面积会小一些
/////////////////////////////////////////////////////////////////////////////////////////
        int left = 0;
        int right = height.length -1 ;
        int sum = Math.min(height[left] , height[right])*(right-left);

        // 无论左移还是右移，移动的总次数是固定的为length - 2
        /*for (int i = 0; i < height.length -1; i++) {
            // 移动左边,注意考虑等号
            if (height[left] <= height[right]) {
                left++;
                sum =Math.max(sum, Math.min(height[left] , height[right])*(right-left));
                continue;
            }

            // 移动右边
            if (height[left] > height[right]) {
                right--;
                sum =Math.max(sum, Math.min(height[left] , height[right])*(right-left));
            }
        }*/

        for (; left < right; ) {
            int minHeight = height[left] < height[right] ? height[left++] :height[right--];
            // 已经移动一次，所以当前计算是需要长度+1
            sum = Math.max(sum,minHeight*(right-left+1));
        }
        return sum;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}