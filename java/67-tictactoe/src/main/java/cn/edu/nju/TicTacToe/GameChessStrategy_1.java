package cn.edu.nju.TicTacToe;

public class GameChessStrategy_1 implements GameChess{
    //记录前五个棋子位置
    int countX = 0;
    int countO = 0;
    int[] countX_i = new int[5];
    int[] countX_j = new int[5];
    int[] countO_i = new int[5];
    int[] countO_j = new int[5];
    public Result putChess(char[][] cells, Player currentPlayer, String chessPos) {
        int i = chessPos.charAt(1) - '1';
        int j = chessPos.charAt(0) - 'A';
        if (cells[i][j] == '_') {
            cells[i][j] = currentPlayer == Player.X ? 'X' : 'O';
            if (currentPlayer == Player.X) {
                if (countX == 5) {
                    cells[countX_i[0]][countX_j[0]] = '_';
                    for (int it = 0; it < 4; it++) {
                        countX_i[it] = countX_i[it + 1];
                        countX_j[it] = countX_j[it + 1];
                }
                    countX_i[4] = i;
                    countX_j[4] = j;
            } else {
                    countX_i[countX] = i;
                    countX_j[countX] = j;
                    countX++;
                }
            }
            if (currentPlayer == Player.O) {
                if (countO == 5) {
                    cells[countO_i[0]][countO_j[0]] = '_';
                    for (int it = 0; it < 4; it++) {
                        countO_i[it] = countO_i[it + 1];
                        countO_j[it] = countO_j[it + 1];
                    }
                    countO_i[4] = i;
                    countO_j[4] = j;
                } else {
                    countO_i[countO] = i;
                    countO_j[countO] = j;
                    countO++;
                }
            }
            return Result.GAMING;
        } else {
            return Result.ERROR;
        }
    }


}
