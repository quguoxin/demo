package leetcode.editor.cn;

//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 105 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 字符串 滑动窗口 
// 👍 1767 👎 0

public class MinimumWindowSubstring {
    public static void main(String[] args) {
    Solution solution = new MinimumWindowSubstring().new Solution();
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        if (s == null || "".equals(s) || t == null || "".equals(t) || s.length() < t.length()) {
            return "";
        }


        int[] need = new int[128]; // 已有字符串指定字符的出现次数 ASCII表总长128
        int[] have = new int[128];// 目标字符串指定字符的出现次数

        //将目标字符串指定字符的出现次数记录
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }

        int left = 0; // 左指针
        int right = 0; // 右指针
        int min = Integer.MAX_VALUE; // 最小长度(初始值为一定不可达到的长度)
        int count = 0;// 已有字符串中目标字符串指定字符的出现总频次
        int start = 0;// 最小覆盖子串在原字符串中的起始位置
        while (right < s.length()) {
            char r = s.charAt(right);
            if (need[r] == 0) { // 不在目标子串字符内，跳过，r向后移动
                right++;
                continue;
            }

            if (have[r] < need[r]) { //  已有字符串目标字符出现的次数小于目标字符串字符的出现次数时count+1；为了后续能直接判断已有字符串是否已经包含了目标字符串的所有字符
                // 此处为什么不考虑AAB这种重复场景下count为什么不加？？因为不加也没关系，因为have[r]++会加，而下面have[l] == need[l] 才会count减少，
                // 所有这里即使不加后面在出现多个have[l]时（have[l] > need[l]）时count也不会减少，直到have[l] == need[l]
                count++;
            }
            have[r]++;//已有字符串中目标字符出现的次数+1

            while (count == t.length()) { // 满足要求
                if (right - left < min) { // 窗口的长度比已有的最短值小时，更改最小值，并记录起始位置
                    min = right - left;
                    start = left;
                }

                char l = s.charAt(left);
                if (need[l] == 0) {//如果左边即将要去掉的字符不被目标字符串需要，那么不需要多余判断，直接可以移动左指针
                    left++;
                    continue;
                }
                // 如果左边即将要去掉的字符被目标字符串需要，且出现的频次正好等于指定频次，那么如果去掉了这个字符，
                // 就不满足覆盖子串的条件，此时要破坏循环条件跳出循环，即控制目标字符串指定字符的出现总频次(count）-1
                if (have[l] == need[l]) {
                    count--;
                }
                //已有字符串中目标字符出现的次数-1
                have[l]--;
                //移动左指针
                left++;
            }
            right++;//移动右指针
        }
        //如果最小长度还为初始值，说明没有符合条件的子串
        if (min == Integer.MAX_VALUE) {
            return "";
        }
        //返回的为以记录的起始位置为起点，记录的最短长度为距离的指定字符串中截取的子串
        return s.substring(start, start + min + 1);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}