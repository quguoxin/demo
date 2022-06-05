package leetcode.editor.cn;

//给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,3,4,4,5]
//输出：[1,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,1,1,2,3]
//输出：[2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序 排列 
// 
// Related Topics 链表 双指针 
// 👍 913 👎 0

import java.util.List;

public class RemoveDuplicatesFromSortedListIi {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedListIi().new Solution();
        ListNode l1 = new ListNode(1, null);
        ListNode l2 = new ListNode(1, l1);
        solution.deleteDuplicates(l2);
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
        public ListNode deleteDuplicates(ListNode head) {
            // 2022.6.6
            if (head == null) {
                return null;
            }
            if (head.next == null) {
                return head;
            }
            if (head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                return deleteDuplicates(head.next);
            }
            head.next = deleteDuplicates(head.next);
            return head;

            // 1、找出重复节点，利用不重复节点重新构建链表
            /*HashMap<Integer, Integer> hashMap = new HashMap<>();
            Stack<Integer> stack = new Stack<>();
            while (head != null) {
                hashMap.put(head.val, hashMap.getOrDefault(head.val, 0) + 1);
                stack.add(head.val);
                head = head.next;
            }

            ListNode re = null;
            while (!stack.empty()) {
                int item = stack.pop();
                if (hashMap.getOrDefault(item, 0) == 1) {
                    ListNode l = new ListNode(item, re);
                    re = l;
                }
            }
            return re;*/

            // 2、递归
            /*ListNode next = head.next;
            // 如果是这种情况 1 --> 1 --> 1 --> 2 --> 3
            if (head.val == next.val) {
                //1 则需要移动next直到出现与当前head.value不相等的情况（含null）
                while (next != null && head.val == next.val) {
                    next = next.next;
                }
                //2 并且此时的原head已经不能要了，因为已经是重复的节点，新的head则是递归返回的节点
                head = deleteDuplicates(next);
                return head;
            }
            //3 如果没有出现重复的情况（1 --> 2 --> 3），则递归返回的节点就作为head的子节点
            head.next = deleteDuplicates(next);
            return head;*/

            // 3、遍历
           /* // 由于链表的头节点可能会被删除，因此我们需要额外使用一个哑节点（dummy node）指向链表的头节点
            ListNode dummy = new ListNode(0, head);
            ListNode cur = dummy;
            while (cur.next != null && cur.next.next != null) { // 因为存在哑节点所以这里从next和next.next开始计算比较
                // 遇见重复节点时
                if (cur.next.val == cur.next.next.val) {
                    // 重复值
                    int x = cur.next.val;
                    // 一直往下直到遇见不重复的值
                    while (cur.next != null && cur.next.val == x) {
                        cur.next = cur.next.next;
                    }
                    continue;
                }
                // 不重复时，处理下一个节点
                cur = cur.next;
            }
            return dummy.next;*/
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}