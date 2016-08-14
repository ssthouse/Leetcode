package leetcode;

import leetcode.utils.Utils;

import java.util.ArrayList;

/* Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * For example,
 * If n = 4 and k = 2, a solution is:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class _Combinations {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        combinehelper(n, 1, k, list, res);
        return res;
    }

    public void combinehelper(int n, int start, int k, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> res) {
        if (list.size() == k) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = start; i <= n; i++) {
            list.add(i);
            combinehelper(n, i + 1, k, list, res);
            list.remove(list.size() - 1);
        }
    }

    /****************
     * my solution
     *******************************/

    public ArrayList<ArrayList<Integer>> getResult(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<Integer>(), 1, n, k);
        return result;
    }

    private void dfs(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> curBean, int step, int n, int k) {
        //判断是否退出
        if (curBean.size() == k) {
            result.add(new ArrayList<>(curBean));
            return;
        }
        for (int i = step; i <= n; i++) {
            curBean.add(i);
            dfs(result, curBean, i+1, n, k);
            curBean.remove(curBean.size()-1);
        }
    }

    public static void main(String[] args) {
        Utils.printArrayArrayList(new _Combinations().getResult(4, 2));
    }
}
