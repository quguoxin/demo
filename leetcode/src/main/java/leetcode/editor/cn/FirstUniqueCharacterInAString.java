package leetcode.editor.cn;

//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。 
//
// 
//
// 示例： 
//
// s = "leetcode"
//返回 0
//
//s = "loveleetcode"
//返回 2
// 
//
// 
//
// 提示：你可以假定该字符串只包含小写字母。 
// Related Topics 队列 哈希表 字符串 计数 
// 👍 425 👎 0

public class FirstUniqueCharacterInAString {
    public static void main(String[] args) {
    Solution solution = new FirstUniqueCharacterInAString().new Solution();
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstUniqChar(String s) {
        // hash
            /*String[] strArray = s.split("");
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < strArray.length; i++) {
                map.put(strArray[i], map.getOrDefault(strArray[i], 0) + 1);
            }
            for (int i = 0; i < strArray.length; i++) {
                if (map.get(strArray[i]) == 1) {
                    return i;
                }
            }
            return -1;*/

        // 字符串
        int len  = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if(s.indexOf(c)==s.lastIndexOf(c)) {
                return i;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}