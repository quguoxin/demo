package leetcode.editor.cn;

//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 104 
// s 和 p 仅包含小写字母 
// 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 831 👎 0

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInAString {
    public static void main(String[] args) {
    Solution solution = new FindAllAnagramsInAString().new Solution();
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> have = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            need.put(p.charAt(i), need.getOrDefault(p.charAt(i), 0) + 1);
        }

        int l = 0;
        int r = 0;
        int count = 0;// 集合字符的种类
        List<Integer> res = new ArrayList<>();
        while (r < s.length()) {
            char t = s.charAt(r);
            r++;
            // p中包含该字符时
            if (need.containsKey(t)) {
                have.put(t, have.getOrDefault(t, 0) + 1);// 已包含+1
                if (have.get(t).equals(need.get(t))) {// 当个元素集齐后统计种类个数+1，用于后面和need SIZE比较
                    count++;
                }
            }
            // 判断左侧窗口是否要收缩
            while (r - l >= p.length()) { // 这里r-l不用+1，因为r已在前面+1
                // 在这里判断是否找到了合法的子串
                if (count == need.size()) { // 此处满足条件一定是 r-l = p.length(), 因为此处基本条件while (r - l >= p.length())
                    res.add(l);
                }
                char d = s.charAt(l);// 不满足时收缩窗口l++
                if (need.containsKey(d)) {// 目标字符则 have-1，如果have与need中该元素个数一样则count-1
                    if (have.get(d).equals(need.get(d))) {
                        count--;
                    }
                    have.put(d, have.getOrDefault(d, 0) - 1);
                }
                l++;
            }

        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}