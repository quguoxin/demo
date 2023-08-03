package leetcode.editor.cn;

//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 7294 👎 0

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        solution.lengthOfLongestSubstring("abcabcbb");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s.length() <= 1) {
                return s.length();
            }
            Map<Character, Integer> have = new HashMap<>(); // Map<字符, 字符的下角标>
            int l = 0;
            int r = 0;
            int max = Integer.MIN_VALUE;
            while (r < s.length()) {
                char t = s.charAt(r);
                r++;
                if (have.containsKey(t)) { // 已存在
                    max = Math.max(max, r - l - 1); // 结算此时的长度，此时t坐标处已重复，而r已在t的下一位，所有长度为r-1-l
                    int temp = have.get(t); // 获取已在区间内的重复值，此时需要将left一直移动到这个重复值的后面去，例如abca,则left得从0移动到1，重复值temp为第一个a
                    // 重复的元素的坐标，不能直接写成while (l <= have.get(t)) 循环过程中have.get(t)是变化的，移除掉后会空指针
                    while (l <= temp) { // 12341 12343 存在时清除重复元素前面的元素，将l置为重复元素后一位
                        have.remove(s.charAt(l));
                        l++;
                    }
                    have.put(t, r - 1);
                    continue;
                }
                // 不存在则加入map
                have.put(t, r - 1);
            }
            // 未曾赋值过则为字符串长度，赋值过则需要比较max和have 长度的大小(防止前面赋值过一次，后面没有重复一直到结束，例如12324567)
            return max == Integer.MIN_VALUE ? s.length() : Math.max(max, have.size());




            /*// 滑动窗口
            int res = Integer.MIN_VALUE;
            int left = 0;
            Map<Character, Integer> map = new HashMap<>(); // 值-索引
            for (int right = 0; right < s.length(); right++) {
                Character c = s.charAt(right);
                // 不重复则直接r 继续向右移动
                if (!map.containsKey(c)) {
                    map.put(c, right);
                    continue;
                }
                // 重复
                int index = map.get(c); // 与之重复的索引
                res = Math.max(res, right - left); // 先计算此时重复前的最大长度
                while (left <= index) {
                    map.remove(s.charAt(left)); // 删除掉重复和重复以前的值例如 cbafgha 则删掉c b a 后添加 a
                    left++;
                }
                map.put(c, right); // 添加当前重复的值的后面的这个（前面的已经删了）
            }
            // 如果res 未赋值过，则没有重复字符，取map长度即可
            // 如果有则赋值过，比较大小即可
            return res == Integer.MIN_VALUE ? map.size() : Math.max(res, map.size());*/
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}