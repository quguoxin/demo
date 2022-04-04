package leetcode.editor.cn;

//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 
//输入: s = "rat", t = "car"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, t.length <= 5 * 104 
// s 和 t 仅包含小写字母 
// 
//
// 
//
// 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 哈希表 字符串 排序 
// 👍 414 👎 0

import java.util.Arrays;

public class ValidAnagram {
    public static void main(String[] args) {
        Solution solution = new ValidAnagram().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAnagram(String s, String t) {
            // 11111111111111111111111
            /*if (s.length() < 1 || s.length() > 50000) {
                return false;
            }
            if (t.length() < 1 || t.length() > 50000) {
                return false;
            }
            if (s.length() != t.length()) {
                return false;
            }
            while (s.length() > 0) {
                char a = s.charAt(0);
                s = s.replaceAll(String.valueOf(a), "");
                t = t.replaceAll(String.valueOf(a), "");
                if (s.length()!=t.length()) {
                    return false;
                }
            }
            return true;*/
           // 222222222222222222222222222
            /*if (s.length() != t.length()) {
                return false;
            }
            if (t.length() < 1 || t.length() > 50000) {
                return false;
            }
            char[] sChars = s.toCharArray();
            char[] tChars = t.toCharArray();
            Arrays.sort(sChars);
            Arrays.sort(tChars);
            return Arrays.equals(sChars, tChars);*/

            // 33333333333333333333333333
            if (s.length() != t.length()) {
                return false;
            }
            if (t.length() < 1 || t.length() > 50000) {
                return false;
            }
            return Arrays.equals((s.chars().sorted().toArray()),(t.chars().sorted().toArray()));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}