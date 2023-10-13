import java.io.*;

public class ZTransformation {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine();
            char ss[] = s.toCharArray();
            int n = Integer.parseInt(br.readLine());

            if (n == 1) {
                for (int i = 0; i < s.length() - 1; i++) {
                    System.out.print(ss[i] + " ");
                }
                System.out.println(ss[s.length() - 1]);
            }
            else {
                int quotient = s.length() / (2 * n - 2);
                int reminder = s.length() % (2 * n - 2);
                int col = quotient * (n - 1);
                if (reminder > 0 & reminder <= n) {
                    col++;
                }
                else if (reminder > n) {
                    col = col + 1 + reminder - n;
                }
                char[][] list = new char[n][col];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < col; j++) {
                        list[i][j] = ' ';
                    }
                }
                for (int i = 1; i <= quotient; i++) {
                    for (int j = 0; j < n; j++) {
                        list[j][(i - 1) * (n - 1)] = ss[(i - 1) * (2 * n - 2) + j];
                    }
                    for (int j = 1; j <= n - 2; j++) {
                        list[n - 1 - j][(i - 1) * (n - 1) + j] = ss[(i - 1) * (2 * n - 2) + n - 1 + j];
                    }
                }

                if (reminder > 0 & reminder <= n) {
                    for (int j = 0; j < reminder; j++) {
                        list[j][quotient * (n - 1)] = ss[quotient * (2 * n - 2) + j];
                    }
                }
                else if (reminder > n) {
                    for (int j = 0; j < n; j++) {
                        list[j][quotient * (n - 1)] = ss[quotient * (2 * n - 2) + j];
                    }
                    for (int j = 1; j <= reminder - n; j++) {
                        list[n - 1 - j][quotient * (n - 1) + j] = ss[quotient * (2 * n - 2) + n - 1 + j];
                    }
                }

                int len = n;
                if (s.length() < n) {
                    len = s.length();
                }

                for (int i = 0; i < len; i++) {
                    int k = 0;
                    for (int j = col - 1; j > 0; j--) {
                        if (list[i][j] != ' ') {
                            k = j;
                            break;
                        }
                    }
                    for (int j = 0; j < k; j++) {
                        System.out.print(list[i][j]);
                        System.out.print(' ');
                    }
                    System.out.println(list[i][k]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
