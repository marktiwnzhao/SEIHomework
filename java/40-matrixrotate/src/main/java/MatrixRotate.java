import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MatrixRotate {
    public static void main(String[] args) {
        //TODO
        String temp = null;

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            temp = br.readLine();
            String[] s = temp.split(" ");
            int m = Integer.parseInt(s[0]);
            int n = Integer.parseInt(s[1]);
            int[][] nums = new int[m][n];
            for(int i = 0; i < m; i++) {
                temp = br.readLine();
                String[] numStr = temp.split(" ");
                for (int j = 0; j < n; j++) {
                    nums[i][j] = Integer.parseInt(numStr[j]);
                }
            }

            temp = br.readLine();
            int angle = Integer.parseInt(temp);

            switch ((angle / 90) % 4) {
                case 1:
                    int[][] out_matrixA = new int[n][m];
                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < n; j++) {
                            out_matrixA[j][i] = nums[m - 1 - i][j];
                        }
                    }
                    for (int row[] : out_matrixA) {
                        for (int i : row) {
                            System.out.print(i + " ");
                        }
                        System.out.println();
                    }
                    return;
                case 2:
                    int[][] out_matrixB = new int[m][n];
                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < n; j++) {
                            out_matrixB[i][j] = nums[m - 1 - i][n - 1 - j];
                        }
                    }
                    for (int row[] : out_matrixB) {
                        for (int i : row) {
                            System.out.print(i + " ");
                        }
                        System.out.println();
                    }
                    return;
                case 3:
                    int[][] out_matrixC = new int[n][m];
                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < n; j++) {
                            out_matrixC[j][i] = nums[i][n - 1 - j];
                        }
                    }
                    for (int row[] : out_matrixC) {
                        for (int i : row) {
                            System.out.print(i + " ");
                        }
                        System.out.println();
                    }
                    return;
                case 0:
                    for (int row[] : nums) {
                        for (int i : row) {
                            System.out.print(i + " ");
                        }
                        System.out.println();
                    }
                    return;
                default:
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //your implementation should not be too slow
}
