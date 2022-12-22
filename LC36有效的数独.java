public class LC36有效的数独 {
    public boolean isValidSudoku(char[][] board) {
        //9*9的大小
        // 行
        int[][] row = new int[9][9];
        // 列
        int[][] col = new int[9][9];
        // 小块
        int[][] eara = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int temp = board[i][j] - '1';
                row[i][temp]++;
                col[j][temp]++;
                // 从左往右分成九块
                eara[j / 3 + (i / 3) * 3][temp]++;
                if (row[i][temp] > 1 || col[j][temp] > 1 || eara[j / 3 + (i / 3) * 3][temp] > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
