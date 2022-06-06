package leetcode.editor.cn;

//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数组 回溯 
// 👍 2055 👎 0

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            boolean[] user = new boolean[nums.length];// 存储每个节点是否使用，已遍历到则为true，未遍历到则为false
            List<List<Integer>> re = new ArrayList<>();// 存储结果数据
            List<Integer> item = new ArrayList<>();// 存储其中某种 可能遍历到根节点时的一种可能即某条遍历路径
            huishu1(nums, re, item, 0, user);
            return re;


            // 1 回溯
            /*int len = nums.length;
            List<List<Integer>> res = new ArrayList<>();
            if (len == 0) {
                return res;
            }
            Deque<Integer> path = new ArrayDeque<>();
            boolean[] used = new boolean[len];
            dfs(nums, len, 0, path, used, res);
            return res;*/

            // 2 回溯
            /*List<List<Integer>> res = new ArrayList<>();
            boolean[] visited = new boolean[nums.length];
            backtrack(res, nums, new ArrayList<>(), visited);
            return res;*/
        }

        // 2022.6.7
        private void huishu1(int[] nums, List<List<Integer>> re, List<Integer> item, int index, boolean[] user) {
            if (index == nums.length) {// 遍历的深度和数组长度相等则遍历结束，此时添加结果数据  也可通过item中元素个数判断
                re.add(new ArrayList<>(item));// !!!!!此处不能直接re.add(item)添加item，item为地址引用，后续item会变，所以这里得重新生成一个
            }
            for (int i = 0; i < nums.length; i++) {// 一次遍历未在同一层级未被使用的数，该循环内每个未被使用的数都是该节点的一种可能性
                if (user[i]) { // 代表该层该节点已被使用    或某路径中该节点已被使用
                    continue;
                }
                // 未被使用
                user[i] = true; // 此刻已遍历该节点，则状态置为true代表已使用
                item.add(nums[i]);// 添加节点到该路径中去
                huishu1(nums, re, item, index + 1, user); // 以上的临时节点状态已经结果带到下一层继续遍历

                // 进行回溯，该层此刻选择了该节点，统计完成后回溯去进行其他节点的选择，所有需要把上面使用时改变的状态都回溯回来
                user[i] = false; // 回溯该数字的使用状态，以供后续该数字出现在其他路径的其他层级中
                item.remove(item.size()-1);// 回溯路径中添加的该节点数字

                // 回溯状态变回以后继续往下遍历，在该层选择其他的数字
            }
        }


        // 回溯
        private void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {
            if (depth == len) { // 深度==长度 停止递归
                res.add(new ArrayList<>(path));// 将链表加到res中
                return;
            }
            for (int i = 0; i < len; i++) {
                if (used[i]) { // 已使用
                    continue;
                }
                path.addLast(nums[i]);
                used[i] = true;
                dfs(nums, len, depth + 1, path, used, res);
                path.removeLast(); // 执行完下一层时 回溯本层
                used[i] = false; // 执行完下一层时 回溯本层
            }
        }

        // 回溯
        private void backtrack(List<List<Integer>> res, int[] nums, ArrayList<Integer> tmp, boolean[] visited) {
            if (tmp.size() == nums.length) {
                res.add(new ArrayList<>(tmp));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (visited[i]) {
                    continue;
                }
                visited[i] = true;
                tmp.add(nums[i]);
                backtrack(res, nums, tmp, visited);
                visited[i] = false;
                tmp.remove(tmp.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}