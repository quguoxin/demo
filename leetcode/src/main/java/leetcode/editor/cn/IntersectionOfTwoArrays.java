package leetcode.editor.cn;

//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4] 
//
// 
//
// 说明： 
//
// 
// 输出结果中的每个元素一定是唯一的。 
// 我们可以不考虑输出结果的顺序。 
// 
// Related Topics 排序 哈希表 双指针 二分查找 
// 👍 308 👎 0

import java.util.*;
import java.util.stream.Collectors;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
    Solution solution = new IntersectionOfTwoArrays().new Solution();
    int[] a = {1,2,2,1};
    int[] b = {2,2};
    solution.intersection(a,b);
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        /*List<Integer> numsNew1 = Arrays.stream(nums1).distinct().boxed().collect(Collectors.toList());
        List<Integer> numsNew2 = Arrays.stream(nums2).distinct().boxed().collect(Collectors.toList());
        List<Integer> list = new ArrayList<>();
        for (Integer a :numsNew1) {
            if (numsNew2.contains(a)) {
                list.add(a);
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;*/
        Set<Integer> set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        return Arrays.stream(nums2).distinct().filter(set::contains).toArray();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}