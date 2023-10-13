

import java.util.Arrays;

/**
 * 矩阵类，实现矩阵的加法，矩阵乘法
 * 1.传入一个int[][]进行2个矩阵的操作
 * 2.返回一个int[][]
 * 所有的数据均为int型
 * 输入数据均默认为正确数据，不需要对输入数据进行校验
 * @author Qin Liu
 *
 */
public class BadMatrix {
	private int[][] data;
	
	/**
	 * 构造函数，参数为2维int数组
	 * a[i][j]是矩阵中的第i+1行，第j+1列数据
	 * @param a
	 */
	public BadMatrix(int[][] a){
		this.data = a;
	}

	public int[][] getData() {
		return data;
	}

	
	/**
	 * 实现矩阵加法，返回一个新的矩阵
	 * @param b
	 * @return
	 */
    public int[][] plus(int[][] b) {
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length; j++) {
				b[i][j] += data[i][j];
			}
		}
		return b;
	}
        
	
	/**
	 * 实现矩阵乘法，返回一个新的矩阵
	 * @param b
	 * @return
	 */
	public int[][] times(int[][] b) {
		int[][] Matrix = new int[data.length][b[0].length];
		for (int i = 0 ; i < data.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				for (int k = 0; k < b.length; k++) {
					Matrix[i][j] += data[i][k] * b[k][j];
				}
			}
		}
		return Matrix;
	}

	//不要修改下面print方法
	/**
	 * 打印出该矩阵的数据
	 * 
	 */
	public void print(){
		System.out.print(this.toString());
	}

	/**
	 * 实现toString方法
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
	public String toString() {
		String s = System.getProperty("line.separator");
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length - 1; j++) {
				s += String.valueOf(data[i][j]);
				s += " ";
			}
			s += String.valueOf(data[i][data[i].length - 1]);
			s += System.getProperty("line.separator");
		}
		return s;
	}

	//不要修改下面equals方法
	public boolean equals(Object o){
		if(this.toString().equals(((BadMatrix)o).toString()))
			return true;
		else
			return false;
	}
}
