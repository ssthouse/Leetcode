package leetcode.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * Created by ssthouse on 16/8/13.
 */
public class Utils {

    public static void printArrayArrayList(ArrayList<ArrayList<Integer>> result) {
        for (ArrayList<Integer> bean : result) {
            System.out.println(Arrays.toString(bean.toArray()));
        }
    }
}
