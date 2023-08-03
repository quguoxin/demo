package leetcode.editor.cn;

//给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。 
//
// 换句话说，s1 的排列之一是 s2 的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "ab" s2 = "eidbaooo"
//输出：true
//解释：s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入：s1= "ab" s2 = "eidboaoo"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 104 
// s1 和 s2 仅包含小写字母 
// 
// Related Topics 哈希表 双指针 字符串 滑动窗口 
// 👍 627 👎 0

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PermutationInString {
    public static void main(String[] args) {
        Solution solution = new PermutationInString().new Solution();
        solution.checkInclusion("ab", "eidbaooo");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            if (s1.length() == 1) {
                return s2.contains(s1);
            }
            if (s1.length() > s2.length()) {
                return false;
            }
            Map<Character, Integer> need = new HashMap<>();
            Map<Character, Integer> have = new HashMap<>();
            for (int i = 0; i < s1.length(); i++) {
                need.put(s1.charAt(i), need.getOrDefault(s1.charAt(i), 0) + 1);
            }

            int l = 0;
            int r = 0;
            int count = 0;// 集齐字符的种类
            while (r < s2.length()) {
                char t = s2.charAt(r);
                r++;
                // s1中包含该字符时
                if (need.containsKey(t)) {
                    have.put(t, have.getOrDefault(t, 0) + 1);// 已包含+1
                    if (have.get(t).equals(need.get(t))) {// 当个元素集齐后统计种类个数+1，用于后面和need SIZE比较
                        count++;
                    }
                }
                // 判断左侧窗口是否要收缩，因为子串的大小是固定s1.length大小
                while (r - l >= s1.length()) { // 这里r-l不用+1，因为r已在前面+1
                    // 在这里判断是否找到了合法的子串
                    if (count == need.size()) {
                        return true;
                    }
                    char d = s2.charAt(l);// 不满足时收缩窗口l++
                    if (need.containsKey(d)) {// 目标字符则 have-1，如果have与need中该元素个数一样则count-1
                        if (have.get(d).equals(need.get(d))) {
                            count--;
                        }
                        have.put(d, have.getOrDefault(d, 0) - 1);
                    }
                    l++;
                }

            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}