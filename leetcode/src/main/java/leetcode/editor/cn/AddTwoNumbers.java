package leetcode.editor.cn;

//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学 
// 👍 5335 👎 0


public class AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode result = new ListNode(0);
            ListNode cursor = result;
            int add = 0;
            while (l1 != null || l2 != null || add != 0) {
                int add1 = l1 == null ? 0 : l1.val;
                int add2 = l2 == null ? 0 : l2.val;

                cursor.next = new ListNode((add1 + add2+ add) % 10 );

                // 将result的指针往下移一位，下次循环时保持这尾节点的next为空
                cursor = cursor.next;

                // l1 l2 指针下移，进行下一次的对位相加
                l1 = l1 != null ? l1.next : null;
                l2 = l2 != null ? l2.next : null;

                // 更新进位
                add = (add1 + add2 + add) / 10;
            }
            return result.next;
        }
    }


    //leetcode submit region end(Prohibit modification and deletion)
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}