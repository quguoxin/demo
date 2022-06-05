package leetcode.editor.cn;

//给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和
// targetSum 。如果存在，返回 true ；否则，返回 false 。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
//输出：true
//解释：等于目标和的根节点到叶节点路径如上图所示。
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,3], targetSum = 5
//输出：false
//解释：树中存在两条根节点到叶子节点的路径：
//(1 --> 2): 和为 3
//(1 --> 3): 和为 4
//不存在 sum = 5 的根节点到叶子节点的路径。 
//
// 示例 3： 
//
// 
//输入：root = [], targetSum = 0
//输出：false
//解释：由于树是空的，所以不存在根节点到叶子节点的路径。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [0, 5000] 内 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 903 👎 0

import java.util.Stack;

public class PathSum {
    public static void main(String[] args) {
        Solution solution = new PathSum().new Solution();

        TreeNode l9 = new TreeNode(2, null, null);
        TreeNode l8 = new TreeNode(7, null, null);

        TreeNode l7 = new TreeNode(1, null, null);
        TreeNode l6 = new TreeNode(4, null, l7);
        TreeNode l5 = new TreeNode(13, null, null);
        TreeNode l4 = new TreeNode(11, l8, l9);

        TreeNode l3 = new TreeNode(8, l5, l6);
        TreeNode l2 = new TreeNode(4, l4, null);
        TreeNode l1 = new TreeNode(5, l2, l3);
        solution.hasPathSum(l1, 22);
    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            // 2022.6.6
            return hasPathSum(root, targetSum, 0);

            // 递归
//            return recursion(root, targetSum, 0);

            // dfs
//            return dfs(root, targetSum);
        }

        private boolean hasPathSum(TreeNode root, int targetSum, int sum) {
            if (root == null) {
                return false;
            }
            if (root.left == null && root.right == null) {
                return targetSum == sum + root.val;
            }
            boolean r1 = false;
            if (root.left != null) {
                r1 = hasPathSum(root.left, targetSum, sum + root.val);
            }
            boolean r2 = false;
            if (root.right != null) {
                r2 = hasPathSum(root.right, targetSum, sum + root.val);
            }
            return r1 || r2;
        }

        /**
         * 递归
         */
        private boolean recursion(TreeNode root, int targetSum, int sum) {
            if (root == null) {
                return false;
            }
            if (root.left == null && root.right == null) {
                return root.val + sum == targetSum;
            }
            boolean rLeft = false;
            if (root.left != null) {
                rLeft = recursion(root.left, targetSum, root.val + sum);
            }
            boolean rRight = false;
            if (root.right != null) {
                rRight = recursion(root.right, targetSum, root.val + sum);
            }
            return rLeft || rRight;
        }

        /**
         * dfs
         */
        private boolean dfs(TreeNode root, int targetSum) {
            if (root == null) {
                return false;
            }
            Stack<TreeNode> stackNode = new Stack<>();
            stackNode.push(root);
            Stack<Integer> stackSum = new Stack<>();
            stackSum.push(0);
            while (!stackNode.empty()) {
                TreeNode node = stackNode.pop();
                Integer sum = stackSum.pop() + node.val;
                if (node.left == null && node.right == null) {
                    if (sum == targetSum) {
                        return true;
                    }
                }
                if (node.left != null) {
                    stackSum.push(sum);
                    stackNode.push(node.left);
                }
                if (node.right != null) {
                    stackSum.push(sum);
                    stackNode.push(node.right);
                }
            }
            return false;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}