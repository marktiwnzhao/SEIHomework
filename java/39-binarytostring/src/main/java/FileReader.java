import java.io.*;

public class FileReader {
    public String readFile(String filePath) throws IOException{
        //TODO
        File f = new File(filePath);
        //BufferedReader br = new BufferedReader(new java.io.FileReader(f));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
        return br.readLine();

//        File file = new File(filePath);
//        InputStream in = null;
//        String s = null;
//        try {
//            in = new FileInputStream(file);
//            int len = in.available();
//            char[] str = new char[len];
//            int i = 0;
//            while (i < len) {
//                str[i] = (char)(in.read());
//                i++;
//            }
//            s = String.valueOf(str);
//            in.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        //OJ version:java 8
//        return s;
    }
}
