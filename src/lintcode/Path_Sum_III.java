package lintcode;

import leetcode.IntegerBreak;
import leetcode.utils.Utils;

import java.util.*;

/**
 * Created by ssthouse on 15/12/2016.
 */
public class Path_Sum_III {

    public static class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    public int pathSum(TreeNode root, int sum) {
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<List<Integer>> nodeListQueue = new LinkedList<>();
        int result = 0;


        nodeQueue.add(root);
        nodeListQueue.add(new ArrayList<>());
        nodeListQueue.peek().add(root.val);

        while (!nodeQueue.isEmpty()) {
            //get fist node
            TreeNode curNode = nodeQueue.poll();
            List<Integer> curList = nodeListQueue.poll();
            if (curNode.left != null) {
                nodeQueue.offer(curNode.left);
                List<Integer> newList = new ArrayList<>();
                Collections.copy(newList, curList);
                newList.add(curNode.val);
                nodeListQueue.offer(newList);
                int curSum = curNode.val;
                for (int i = curList.size() - 1; i >= 0; i--) {
//                    curSum +=
                }
            }
            if (curNode.right != null) {
                nodeQueue.offer(curNode.right);
//                nodeListQueue.offer(curResult + curNode.right.val);
//                if (curResult + curNode.right.val == sum) {
//                    result++;
//                }
            }
        }
        Utils.print(result);
        return result;
    }

    public static void main(String args[]) {
        Path_Sum_III.TreeNode rootNode = new TreeNode(10);
        rootNode.left = new TreeNode(5);
        rootNode.right = new TreeNode(-3);
        rootNode.left.left = new TreeNode(3);
        rootNode.left.right = new TreeNode(2);
        rootNode.right.right = new TreeNode(11);
        rootNode.left.left.left = new TreeNode(3);
        rootNode.left.left.right = new TreeNode(-2);
        rootNode.left.right.right = new TreeNode(1);
        new Path_Sum_III().pathSum(rootNode, 8);
    }
}
