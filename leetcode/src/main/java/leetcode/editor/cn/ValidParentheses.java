package leetcode.editor.cn;

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串 
// 👍 2042 👎 0

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            Map<String, String> map = new HashMap<>(3);
            map.put("{", "}");
            map.put("[", "]");
            map.put("(", ")");

            Stack<String> stack = new Stack<>();
            String[] array = s.split("");
            for (String str : array) {
                // 栈顶为空，且遇见了回括号，直接返回false
                if (stack.empty() && map.containsValue(str)) {
                    return false;
                }
                // (])
                if (map.containsKey(str)) {
                    stack.push(str);
                    continue;
                }
                if (map.get(stack.peek()).equals(str)) {
                    // 移除栈顶元素
                    stack.pop();
                } else {
                    return false;
                }
            }
            return stack.empty();
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}