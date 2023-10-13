import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 矩阵类，实现矩阵的加法，矩阵乘法，点乘以及转置方法
 * 其中加法和点乘方法需要有两种实现方式
 * 1.传入一个MyMatrix对象进行2个矩阵的操作
 * 2.从控制台（console）读入一个矩阵数据，再进行操作
 * 所有的数据均为int型
 * 输入数据均默认为正确数据，不需要对输入数据进行校验
 * @author Ray Liu & Qin Liu
 *
 */
public class MyMatrix {
	private int[][] data;
	
	/**
	 * 构造函数，参数为2维int数组
	 * a[i][j]是矩阵中的第i+1行，第j+1列数据
	 * @param a
	 */
	public MyMatrix(int[][] a){
		this.data = a;
	}

	public int[][] getData() {
		return data;
	}

	/**
	 * 实现矩阵加法，返回一个新的矩阵
	 * @param B
	 * @return
	 */
	public MyMatrix plus(MyMatrix B) {
		int row = data.length;
		int col = data[0].length;
		int[][] temp = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				temp[i][j] = data[i][j] + B.getData()[i][j];
			}
		}
		MyMatrix Matrix = new MyMatrix(temp);
		return Matrix;
	}

	
	/**
	 * 实现矩阵乘法，返回一个新的矩阵
	 * @param B
	 * @return
	 */
	public MyMatrix times(MyMatrix B) {
		int rowA = data.length;
		int colA = data[0].length;
		int colB = B.getData()[0].length;
		int[][] temp = new int[rowA][colB];
		for (int i = 0; i < rowA; i++)  {
			for (int j = 0; j < colB; j++) {
				for (int k = 0; k < colA; k++) {
					temp[i][j] += data[i][k] * B.getData()[k][j];
				}
			}
		}
		MyMatrix Matrix = new MyMatrix(temp);
		return Matrix;
	}
	
	/**
	 * 实现矩阵的点乘，返回一个新的矩阵
	 * @param b
	 * @return
	 */
	public MyMatrix times(int b) {
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				data[i][j] *= b;
			}
		}
		MyMatrix Matrix = new MyMatrix(data);
		return Matrix;
	}
	
	/**
	 * 实现矩阵的转置，返回一个新的矩阵
	 * @return
	 */
	public MyMatrix transpose() {
		int[][] temp = new int[data[0].length][data.length];
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				temp[j][i] = data[i][j];
			}
		}
		MyMatrix Matrix = new MyMatrix(temp);
		return Matrix;
	}
	
	/**
	 * 从控制台读入矩阵数据，进行矩阵加法，读入数据格式如下：
	 * m n
	 * m * n 的数据方阵，以空格隔开
	 * example:
	 * 4 3
	 * 1 2 3 
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 返回一个新的矩阵
	 * @return
	 */
	public MyMatrix plusFromConsole() {
		MyMatrix B = InputMatrix();
		return plus(B);
	}
	
	/**
	 * 输入格式同上方法相同
	 * 实现矩阵的乘法
	 * 返回一个新的矩阵
	 * @return
	 */
	public MyMatrix timesFromConsole() {
		MyMatrix B = InputMatrix();
		return times(B);
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
	public void print() {
		System.out.println();
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length - 1; j++) {
				System.out.print(data[i][j] + " ");
			}
			System.out.println(data[i][data[0].length - 1]);
		}
		System.out.println();
	}

	//Input the matrix
	public MyMatrix InputMatrix() {
		String temp = null;

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			temp = br.readLine();
			String[] s = temp.split(" ");
			int row = Integer.parseInt(s[0]);
			int col = Integer.parseInt(s[1]);
			int[][] A = new int[row][col];

			for (int i = 0; i < row; i++) {
				temp = br.readLine();
				String[] numStr = temp.split(" ");
				for (int j = 0; j < col; j++) {
					A[i][j] = Integer.parseInt(numStr[j]);
				}
			}
			return new MyMatrix(A);
		}catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
