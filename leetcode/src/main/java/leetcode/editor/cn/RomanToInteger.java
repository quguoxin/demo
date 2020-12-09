package leetcode.editor.cn;

//罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。 
//
// 字符          数值
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000 
//
// 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做 XXVII, 即为 XX + V + I
//I 。 
//
// 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5
// 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况： 
//
// 
// I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。 
// X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
// C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。 
// 
//
// 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。 
//
// 
//
// 示例 1: 
//
// 输入: "III"
//输出: 3 
//
// 示例 2: 
//
// 输入: "IV"
//输出: 4 
//
// 示例 3: 
//
// 输入: "IX"
//输出: 9 
//
// 示例 4: 
//
// 输入: "LVIII"
//输出: 58
//解释: L = 50, V= 5, III = 3.
// 
//
// 示例 5: 
//
// 输入: "MCMXCIV"
//输出: 1994
//解释: M = 1000, CM = 900, XC = 90, IV = 4. 
//
// 
//
// 提示： 
//
// 
// 题目所给测试用例皆符合罗马数字书写规则，不会出现跨位等情况。 
// IC 和 IM 这样的例子并不符合题目要求，49 应该写作 XLIX，999 应该写作 CMXCIX 。 
// 关于罗马数字的详尽书写规则，可以参考 罗马数字 - Mathematics 。 
// 
// Related Topics 数学 字符串 
// 👍 1144 👎 0

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RomanToInteger {
    public static void main(String[] args) {
        Solution solution = new RomanToInteger().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int romanToInt(String s) {
            ///////////////////////1///////////////////////
            // 从大到小依次列出可排序的类型
            // M CM D CD C XC L XL X IX V IV I
            /*int sum = 0;
            while (!"".equals(s)) {
                if (s.startsWith("M")) {
                    sum += 1000;
                    s = s.substring(1);
                } else if (s.startsWith("CM")) {
                    sum += 900;
                    s = s.substring(2);
                } else if (s.startsWith("D")) {
                    sum += 500;
                    s = s.substring(1);
                } else if (s.startsWith("CD")) {
                    sum += 400;
                    s = s.substring(2);
                } else if (s.startsWith("C")) {
                    sum += 100;
                    s = s.substring(1);
                } else if (s.startsWith("XC")) {
                    sum += 90;
                    s = s.substring(2);
                } else if (s.startsWith("L")) {
                    sum += 50;
                    s = s.substring(1);
                } else if (s.startsWith("XL")) {
                    sum += 40;
                    s = s.substring(2);
                } else if (s.startsWith("X")) {
                    sum += 10;
                    s = s.substring(1);
                } else if (s.startsWith("IX")) {
                    sum += 9;
                    s = s.substring(2);
                } else if (s.startsWith("V")) {
                    sum += 5;
                    s = s.substring(1);
                } else if (s.startsWith("IV")) {
                    sum += 4;
                    s = s.substring(2);
                } else if (s.startsWith("I")) {
                    sum += 1;
                    s = s.substring(1);
                }
            }
            return sum;*/

            /////////////////////2/////////////////////////
            // 前面比后面大则加，前面比后面小则减（题目已明确给出了不可能出现异常排序）
            Map<Character, Integer> map = new HashMap<Character, Integer>(6) {
                {
                    put('M', 1000);
                    put('D', 500);
                    put('C', 100);
                    put('L', 50);
                    put('X', 10);
                    put('V', 5);
                    put('I', 1);
                }
            };
            int sum = 0;
            char[] arr = s.toCharArray();
            int index = 0;
            // 最后一位单独算，避免数组越界
            while (index < arr.length - 1) {
                if (map.get(arr[index]) >= map.get(arr[index + 1])) {
                    sum += map.get(arr[index]);
                }
                if (map.get(arr[index]) < map.get(arr[index + 1])) {
                    sum -= map.get(arr[index]);
                }
                index++;
            }
            return sum + map.get(arr[s.length() - 1]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}