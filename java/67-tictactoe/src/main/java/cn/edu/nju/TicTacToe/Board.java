package cn.edu.nju.TicTacToe;
public class Board {
	/**
	 * 成员变量的初始化代码请修改，请灵活选择初始化方式
	 * 必要时可添加成员变量
	 */
	protected char[][] cells;
	protected GameChess chessStrategy;
	protected GameWinStrategy winStrategy;
//	protected GameChessStrategy chessStrategy;
//	protected GameWinStrategy_HVD winStrategy;
	protected Player player = Player.X;

	public int size;

	/**
	 * 请修改构造方法，并添加合适的构造方法
	 */
//	public Board(){
//		cells = new char[3][3];
//		for(int i=0; i<3; i++){
//			for(int j=0; j<3; j++){
//				cells[i][j] = '_';
//			}
//		}
//
//		chessStrategy = new GameChessStrategy();
//		winStrategy = new GameWinStrategy_HVD();
//	}
	
	public Board(int boardSize, GameChess chessStrategy, GameWinStrategy winStrategy){
		cells = new char[boardSize][boardSize];
		size = boardSize;
		for(int i=0; i<boardSize; i++){
			for(int j=0; j<boardSize; j++){
				cells[i][j] = '_';
			}
		}
		
		this.chessStrategy = chessStrategy;
		this.winStrategy = winStrategy;
	}

	/**
	 * @param move 下棋的位置
	 * @return 落棋之后的结果
	 */
	public Result nextMove(String move) {
		if (chessStrategy.putChess(cells, nextPlay(), move) == Result.GAMING) {
			return winStrategy.check(cells, size);
		}
		return Result.ERROR;
	}
	
	/**
	 * @return 下一个落棋的玩家
	 */
	protected Player nextPlay(){
		Player res = player;
		player = player == Player.X ? Player.O : Player.X;
		return res;
	}
	
	/**
	 * 棋盘的输出方法，根据需要进行修改
	 */
	public void print(){
		StringBuilder head = new StringBuilder(" ");
		for (int i = 0; i < size; i++) {
			head.append(' ');
			head.append((char)('A' + i));
		}
		System.out.println(head.toString());
		for(int i=0 ;i<size; i++){
			System.out.print(i+1);
			for(int j=0; j<size; j++){
				System.out.print(" "+cells[i][j]);
			}
			System.out.println();
		}
	}
}