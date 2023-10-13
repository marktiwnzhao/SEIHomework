package edu.nju;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 实现矩阵的加法、乘法以及控制台输出
 * 其中加法和乘法需要有两种实现方式
 * 1.传入一个矩阵进行2个矩阵的操作
 * 2.从控制台（console）读入一个矩阵，再进行操作
 * 所有的数据均为int型
 * 输入数据均默认为正确数据，不需要对输入数据进行校验
 * @author Ray Liu & Qin Liu
 */
public class MatrixCalculation {
	
	/**
	 * 实现矩阵加法，返回一个新的矩阵
	 * @return result matrix = A + B
	 */
	public int[][] plus(int[][] A, int[][] B){
		// TODO
		int row = A.length;
		int col = A[0].length;//A = int[0][0];out of bound
		int[][] Matrix = new int[row][col];
		for (int i = 0; i < row; i++)  {
			for (int j = 0; j < col; j++) {
				Matrix[i][j] = A[i][j] + B[i][j];
			}
		}

		return Matrix;
	}
	
	/**
	 * 实现矩阵乘法，返回一个新的矩阵
	 * @return result matrix = A * B
	 */
	public int[][] times(int[][] A, int[][] B){
		// TODO
		int rowA = A.length;
		int colA = A[0].length;
		int colB = B[0].length;
		int[][] Matrix = new int[rowA][colB];
		for (int i = 0; i < rowA; i++)  {
			for (int j = 0; j < colB; j++) {
				for (int k = 0; k < colA; k++) {
					Matrix[i][j] += A[i][k] * B[k][j];
				}
			}
		}
		return Matrix;
	}
	
	/**
	 * 从控制台读入矩阵数据，进行矩阵加法，读入数据格式如下：
	 * m n
	 * m * n 的数据方阵，以空格隔开
	 * 连续读入2个矩阵数据
	 * example:
	 * 4 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 4 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 返回一个新的矩阵
	 */
	public int [][] plusFromConsole(){
		// TODO
		String temp = null;

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			temp = br.readLine();
			String[] s = temp.split(" ");
			int row = Integer.parseInt(s[0]);
			int col = Integer.parseInt(s[1]);
			int[][] A = new int[row][col];

			//no matrix to input
			if (row == 0 | col == 0) {
				return A;
			}

			for(int i = 0; i < row; i++) {
				temp = br.readLine();
				String[] numStr = temp.split(" ");
				for (int j = 0; j < col; j++) {
					A[i][j] = Integer.parseInt(numStr[j]);
				}
			}

			temp = br.readLine();
			s = temp.split(" ");
			row = Integer.parseInt(s[0]);
			col = Integer.parseInt(s[1]);
			int[][] B = new int[row][col];

			//no matrix to input
			if (row == 0 | col == 0) {
				return B;
			}
			for(int i = 0; i < row; i++) {
				temp = br.readLine();
				String[] numStr = temp.split(" ");
				for (int j = 0; j < col; j++) {
					B[i][j] = Integer.parseInt(numStr[j]);
				}
			}
			return plus(A, B);

		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/**
	 * 输入格式同上方法相同
	 * 实现矩阵的乘法
	 * 返回一个新的矩阵
	 */
	public int[][] timesFromConsole(){
		// TODO
		String temp = null;

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			temp = br.readLine();
			String[] s = temp.split(" ");
			int row = Integer.parseInt(s[0]);
			int col = Integer.parseInt(s[1]);
			int[][] A = new int[row][col];

			//no matrix to input
			if (row == 0 | col == 0) {
				return A;
			}

			for(int i = 0; i < row; i++) {
				temp = br.readLine();
				String[] numStr = temp.split(" ");
				for (int j = 0; j < col; j++) {
					A[i][j] = Integer.parseInt(numStr[j]);
				}
			}

			temp = br.readLine();
			s = temp.split(" ");
			row = Integer.parseInt(s[0]);
			col = Integer.parseInt(s[1]);
			int[][] B = new int[row][col];

			//no matrix to input
			if (row == 0 | col == 0) {
				return B;
			}

			for(int i = 0; i < row; i++) {
				temp = br.readLine();
				String[] numStr = temp.split(" ");
				for (int j = 0; j < col; j++) {
					B[i][j] = Integer.parseInt(numStr[j]);
				}
			}

			return times(A, B);

		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/**
	 * 打印出该矩阵的数据
	 * 起始一个空行，结束一个空行
	 * 矩阵中每一行数据呈一行，数据间以空格隔开
	 * example：
	 *
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 *
	 */
	public void print(int[][] A){
		// TODO
		System.out.println();
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length - 1; j++) {
				System.out.print(A[i][j] + " ");
			}
			System.out.println(A[i][A[0].length - 1]);
		}
	}
}
