package 数组.简单;

import java.util.HashMap;
import java.util.Map;

/**
 * 有效的数独
 * 请你判断一个 9x9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 *      数字 1-9 在每一行只能出现一次。
 *      数字 1-9 在每一列只能出现一次。
 *      数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 *      数独部分空格内已填入了数字，空白格用 '.' 表示。
 *
 * 注意：
 *      一个有效的数独（部分已被填充）不一定是可解的。
 *      只需要根据以上规则，验证已经填入的数字是否有效即可。
 *
 */
public class 有效的数独 {
    public static void main(String[] args) {

    }

    /**
     * 先判断行和列，再判断3*3
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {

        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < board.length; i++) {//行
            for (int j = 0; j < board[i].length; j++) {//列

            }
        }
        return false;
    }
}
