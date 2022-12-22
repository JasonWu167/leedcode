public class LC37解数独 {
    public void solveSudoku(char[][] board) {
        fill(board);
    }
    // 填充数字（回溯）
    private boolean fill (char[][] board){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    continue;
                }
                // 从1-9填入
                for(char k = '1' ; k <= '9';k++){
                    // 将数字填入，判断合法性
                    board[i][j] = k;
                    if(isValid(board)){
                        if(fill(board)){
                            return true ;
                        }else{
                            board[i][j] = '.';//回溯
                        }
                    }else{
                        board[i][j] = '.';// 不合法
                    }
                }
                return false;
            }
        }
        return true;
    }
    // 判断数独是否有效
    private boolean isValid(char[][] board){
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][] area = new int[9][9];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.'){
                    continue;
                }
                int temp = board[i][j] - '1';
                row[i][temp]++;
                col[j][temp]++;
                area[i/3 + j/3*3][temp]++;
                if(row[i][temp] > 1 || col[j][temp] > 1 || area[i/3 + j/3*3][temp] > 1 ){
                    return false;
                }
            }
        }
        return true;
    }
}
