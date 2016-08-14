package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/* Given a set of distinct integers, S, return all possible subsets.
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If S = [1,2,3], a solution is:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */

public class Subsets {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        if (S == null)
            return null;
        Arrays.sort(S);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < S.length; i++) {
            ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();

            //get sets that are already in result
            for (ArrayList<Integer> a : result) {
                temp.add(new ArrayList<Integer>(a));
            }

            //add S[i] to existing sets
            for (ArrayList<Integer> a : temp) {
                a.add(S[i]);
            }

            //add S[i] only as a set
            ArrayList<Integer> single = new ArrayList<Integer>();
            single.add(S[i]);
            temp.add(single);
            result.addAll(temp);
        }
        //add empty set
        result.add(new ArrayList<Integer>());

        return result;
    }

    /**************************my solution************************/


    /**
     * 因为  每一个数字  都没有重复的
     * 只用判断  每一个数  是否加入List就好了
     */

    public ArrayList<ArrayList<Integer>> getResult(int[] array) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tempBean = new ArrayList<>();
        dfs(result, tempBean, 0, array);
        return result;
    }

    private void dfs(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> tempBean, int depth, int[] array){
        //当走到最后一步  tempBean添加进  result
        if(depth >= array.length){
            result.add(tempBean);
            return;
        }
        //否则  将当前步数据填入  depth加一
        dfs(result,new ArrayList<>(tempBean), depth+1, array);
        tempBean.add(array[depth]);
        dfs(result, new ArrayList<>(tempBean) , depth+1, array);
    }

    public static void main(String[] args) {
        int[] array = {1,2,3};
        ArrayList<ArrayList<Integer>> result = new Subsets().getResult(array);
        for (ArrayList<Integer> resultBean : result) {
            System.out.println(Arrays.toString(resultBean.toArray()));
        }
    }
}












