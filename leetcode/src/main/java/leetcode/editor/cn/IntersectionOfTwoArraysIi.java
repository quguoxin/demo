package leetcode.editor.cn;

//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2,2]
// 
//
// 示例 2: 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[4,9] 
//
// 
//
// 说明： 
//
// 
// 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。 
// 我们可以不考虑输出结果的顺序。 
// 
//
// 进阶： 
//
// 
// 如果给定的数组已经排好序呢？你将如何优化你的算法？ 
// 如果 nums1 的大小比 nums2 小很多，哪种方法更优？ 
// 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？ 
// 
// Related Topics 数组 哈希表 双指针 二分查找 排序 
// 👍 517 👎 0

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArraysIi {
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoArraysIi().new Solution();
        solution.intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {

            // 07-16 双指针
           /* List<Integer> re = new ArrayList<>();
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
                if (nums1[i] == nums2[j]) {
                    re.add(nums1[i]);
                    i++;
                    j++;
                }else if (nums1[i] < nums2[j]) {
                    i++;
                }else {
                    j++;
                }
            }
            int[] res = new int[re.size()];
            for (int i = 0; i < re.size(); i++) {
                res[i] = re.get(i);
            }
            return res;*/

            // 07-16 Hash
            List<Integer> re = new ArrayList<>();
            Map<Integer, Integer> map = new HashMap<>();
            for (int v : nums1) {
                map.put(v, map.getOrDefault(v, 0) + 1);
            }
            for (int v : nums2) {
                if (map.containsKey(v) && map.get(v) > 0) {
                    re.add(v);
                    map.put(v, map.get(v) - 1);
                }
            }
            int[] res = new int[re.size()];
            for (int i = 0; i < re.size(); i++) {
                res[i] = re.get(i);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}