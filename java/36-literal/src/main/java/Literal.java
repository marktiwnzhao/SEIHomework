import java.io.*;
public class Literal {

    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine();
            if (s.equals("true") | s.equals("false")) {
                System.out.println("boolean");
            }
            else if (s.endsWith("L")) {
                System.out.println("long");
            }
            else if (s.endsWith("f")) {
                System.out.println("float");
            }
            else if (s.endsWith("'")) {
                System.out.println("char");
            }
            else if (s.indexOf('.') >= 0) {
                System.out.println("double");
            }
            else {
                System.out.println("integer");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
