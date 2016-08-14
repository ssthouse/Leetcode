package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/* Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * For example,
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 */
public class _SurroundedRegions {
    public void solve(char[][] board) {
        if (board.length == 0)
            return;
        Stack<Integer> xindex = new Stack<Integer>();
        Stack<Integer> yindex = new Stack<Integer>();
        int row = board.length;
        int column = board[0].length;
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') {
                xindex.push(i);
                yindex.push(0);
            }
            if (board[i][column - 1] == 'O') {
                xindex.push(i);
                yindex.push(column - 1);
            }
        }
        for (int i = 0; i < column; i++) {
            if (board[0][i] == 'O') {
                xindex.push(0);
                yindex.push(i);
            }
            if (board[row - 1][i] == 'O') {
                xindex.push(row - 1);
                yindex.push(i);
            }
        }

        while (!xindex.empty()) {
            int x = xindex.pop();
            int y = yindex.pop();
            board[x][y] = '#';
            if (x > 0 && board[x - 1][y] == 'O') {
                xindex.push(x - 1);
                yindex.push(y);
            }
            if (x < row - 1 && board[x + 1][y] == 'O') {
                xindex.push(x + 1);
                yindex.push(y);
            }
            if (y > 0 && board[x][y - 1] == 'O') {
                xindex.push(x);
                yindex.push(y - 1);
            }
            if (y < column - 1 && board[x][y + 1] == 'O') {
                xindex.push(x);
                yindex.push(y + 1);
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                if (board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }

    /**
     * my solution:
     * 将所有  边界上的0   全部使用广度优先搜索进行遍历   在一个全局变量中   进行标注
     */


    private int colNum, rowNum;

    public void getResult(char[][] board) {
        colNum = board[0].length;
        rowNum = board.length;

        Queue<Integer> zeroQueue = new LinkedList<>();
        //找出所有边界上的0
        for (int i = 0; i < colNum; i++) {//上下两行
            if (board[0][i] == '0')
                zeroQueue.add(i);
            if (board[rowNum - 1][i] == 'X')
                zeroQueue.add((rowNum - 1) * colNum + i);
        }
        //左右列
        for (int i = 0; i < rowNum; i++) {
            if (board[i][0] == '0')
                zeroQueue.add(i * colNum);
            if (board[i][colNum - 1] == '0')
                zeroQueue.add(i * colNum + colNum - 1);
        }

        boolean[][] isZero = new boolean[rowNum][colNum];
        //广度遍历  找到所有邻接的点
        while (!zeroQueue.isEmpty()) {
            int indexSum = zeroQueue.poll();
            int colIndex = (indexSum) % colNum;
            int rowIndex = (indexSum) / colNum;
            //左
            if (colIndex - 1 > 0 && board[rowIndex][colIndex - 1] == 'O' && !isZero[rowIndex][colIndex - 1]) {
                isZero[rowIndex][colIndex - 1] = true;
                zeroQueue.add(rowIndex * colNum + colIndex);
            }
            //右
            if (colIndex + 1 < colNum-1 && board[rowIndex][colIndex + 1] == 'O' && !isZero[rowIndex][colIndex + 1]) {
                isZero[rowIndex][colIndex + 1] = true;
                zeroQueue.add(rowIndex * colNum + colIndex);
            }
            //上
            if (rowIndex - 1 > 0 && board[rowIndex - 1][colIndex] == '0' && !isZero[rowIndex-1][colIndex]) {
                isZero[rowIndex-1][colIndex] = true;
                zeroQueue.add((rowIndex - 1) * colNum + colIndex);
            }
            //下
            if (rowIndex + 1 < rowNum - 1 && board[rowIndex + 1][colIndex] == '0' && !isZero[rowIndex+1][colIndex]) {
                isZero[rowIndex+1][colIndex] = true;
                zeroQueue.add((rowIndex + 1) + colIndex);
            }
        }

        //将没有标记为zero的点赋值为X
        for (int i = 1; i < rowNum-1; i++) {
            for (int j = 1; j < colNum-1; j++) {
                if(!isZero[i][j])
                    board[i][j] = 'X';
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = { {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}};
        new _SurroundedRegions().getResult(board);


        //输出结果
        for (char[] rowChar : board) {
            System.out.println(Arrays.toString(rowChar));
        }
    }
}






















