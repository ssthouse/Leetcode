package leetcode;

import java.util.*;

/* Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * For example,
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5. 
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 */
public class _WordLadder {
    public int ladderLength(String start, String end, Set<String> dict) {
        if (start.equals(end))
            return 0;
        Queue<String> words = new LinkedList<String>();
        Queue<Integer> steps = new LinkedList<Integer>();
        Set<String> unused = new HashSet<String>(dict);
        unused.remove(start);
        words.add(start);
        steps.add(0);

        while (!words.isEmpty()) {
            String word = words.remove();
            int step = steps.remove();
            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    String newly = word.substring(0, i) + ch + word.substring(i + 1);
                    if (newly.equals(end)) {
                        return step + 2;
                    }
                    if (!newly.equals(word) && unused.contains(newly)) {
                        words.add(newly);
                        steps.add(Integer.valueOf(step + 1));
                        unused.remove(newly); // NOTE: put this argument here
                        // accelerates.
                    }
                }
            }
        }
        return 0;
    }

    /**********************
     * my solution 迭代实现
     * <p>
     * 其实也就是   深度搜索的queue实现
     **********************/

    public int getResult(String start, String end, Set<String> dict) {
        Queue<String> wordQueue = new LinkedList<>();
        Queue<Integer> stepQueue = new LinkedList<>();
        Set<String> usedSet = new HashSet<>(dict);
        wordQueue.add(start);
        stepQueue.add(0);
        while (!wordQueue.isEmpty()) {
            String curStr = wordQueue.poll();
            int step = stepQueue.poll();
            //对当前单词进行char遍历  每个char进行a~z遍历
            for (int i = 0; i < curStr.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    String newStr = curStr.substring(0, i) + c + curStr.substring(i + 1);
                    if (newStr.equals(end)) {
                        return step + 2;
                    }
                    //如果set中有
                    if (usedSet.contains(newStr)) {
                        usedSet.remove(newStr);
                        stepQueue.add(step + 1);
                        wordQueue.add(newStr);
                    }
                }
            }

        }
        return 0;
    }

    public static void main(String args[]) {
        String[] strArray = {"hot", "dot", "dog", "lot", "log"};
        Set<String> dict = new HashSet<>();
        for (String str : strArray) {
            dict.add(str);
        }
        int result = new _WordLadder().getResult("hit", "cog", dict);
        System.out.println("result:\t" + result);
    }
}
























