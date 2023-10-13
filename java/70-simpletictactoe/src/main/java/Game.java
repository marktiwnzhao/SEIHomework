public class Game {
    private int size = 3;
    private int[][] ChessBoard = new int[size][size];//0表示未落子；1表示X；-1表示O
    private int blank = size * size;

    //游戏主方法playGame
    //输入为对弈双方轮番落子的位置，以英文逗号为间隔，X先走
    public Result playGame(String s) {
        String[] directions = s.split(",");
        int cnt = 0;

        for (String step:directions) {
            char chess = ' ';
            if ((cnt % 2) == 0) {
                chess = 'X';
            } else {
                chess = 'O';
            }

            if (PlaceChess(step, chess)) {
                blank--;
            }

            if (Win(chess)) {
                PrintBoard();
                if (chess == 'X') {
                    return Result.X_WIN;
                } else {
                    return Result.O_WIN;
                }
            }

            if (blank == 0) {
                PrintBoard();
                return Result.DRAW;
            }
            PrintBoard();
            cnt++;
        }
        return Result.GAMING;
    }

    //test yourself
    public static void main(String[] args){
        Game game = new Game();
        Result result = game.playGame("B2,C2,C1,A3,B3,B1,A2,B2,C3,A1,A3,B3,C2,B1,B2,A2,A1,C1,C3");
        System.out.println(result);
    }
    //落子
    public boolean PlaceChess(String step, char chess) {
        int col = step.charAt(0) - 'A';
        int row = step.charAt(1) - '1';

        if (ChessBoard[row][col] == 0) {
            switch (chess) {
                case 'X':
                    ChessBoard[row][col] = 1;
                    break;
                case 'O':
                    ChessBoard[row][col] = -1;
                    break;
                default:
                    break;
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean Win(char chess) {
        int mark = 0;
        if (chess == 'X') {
            mark = 1;
        } else {
            mark = -1;
        }
        //左斜判断
        for (int i = 0; i < size; i++) {
            if (ChessBoard[i][i] != mark) {
                break;
            }
            if (i == size - 1) {
                return true;
            }
        }
        //右斜判断
        for (int i = 0; i < size; i++) {
            if (ChessBoard[i][size - 1 - i] != mark) {
                break;
            }
            if (i == size - 1) {
                return true;
            }
        }
        //列判断
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(ChessBoard[j][i] != mark){
                    break;
                }
                if(j == size - 1){
                    return true;
                }
            }
        }
        //行判断
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(ChessBoard[i][j] != mark){
                    break;
                }
                if(j == size - 1){
                    return true;
                }
            }
        }
        return false;
    }

    public void PrintBoard() {
        System.out.println("  A B C");
        for (int i = 0; i < size; i++) {
            System.out.print((i+1) + " ");
            for (int j = 0; j < size; j++) {
                switch (ChessBoard[i][j]) {
                    case 0:
                        System.out.print("_");
                        break;
                    case 1:
                        System.out.print("X");
                        break;
                    case -1:
                        System.out.print("O");
                        break;
                    default:
                        break;
                }
                if (j != size - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
