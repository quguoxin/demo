package leetcode.editor.cn;

//给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。 
//
// 
// '.' 匹配任意单个字符 
// '*' 匹配零个或多个前面的那一个元素 
// 
//
// 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。 
// 
//
// 示例 1： 
//
// 
//输入：s = "aa" p = "a"
//输出：false
//解释："a" 无法匹配 "aa" 整个字符串。
// 
//
// 示例 2: 
//
// 
//输入：s = "aa" p = "a*"
//输出：true
//解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
// 
//
// 示例 3： 
//
// 
//输入：s = "ab" p = ".*"
//输出：true
//解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
// 
//
// 示例 4： 
//
// 
//输入：s = "aab" p = "c*a*b"
//输出：true
//解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
// 
//
// 示例 5： 
//
// 
//输入：s = "mississippi" p = "mis*is*p*."
//输出：false 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 20 
// 0 <= p.length <= 30 
// s 可能为空，且只包含从 a-z 的小写字母。 
// p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。 
// 保证每次出现字符 * 时，前面都匹配到有效的字符 
// 
// Related Topics 递归 字符串 动态规划 
// 👍 2330 👎 0

import org.springframework.util.StringUtils;

public class RegularExpressionMatching {
    public static void main(String[] args) {
        Solution solution = new RegularExpressionMatching().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isMatch(String text, String pattern) {
            if (pattern.isEmpty()){
                return text.isEmpty();
            }

            boolean first_match = (!text.isEmpty() &&
                    (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));
            //只有长度大于 2 的时候，才考虑 *
            if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
                //两种情况
                //pattern 直接跳过两个字符。表示 * 前边的字符出现 0 次
                //pattern 不变，例如 text = aa ，pattern = a*，第一个 a 匹配，
                //然后 text 的第二个 a 接着和 pattern 的第一个 a 进行匹配。表示 * 用前一个字符替代。
                return (isMatch(text, pattern.substring(2)) ||
                        (first_match && isMatch(text.substring(1), pattern)));
            } else {
                return first_match && isMatch(text.substring(1), pattern.substring(1));
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}