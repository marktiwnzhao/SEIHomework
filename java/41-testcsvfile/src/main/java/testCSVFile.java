import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class testCSVFile {

    public static void main(String[] args) {
       //TODO
       try {
           File f = new File(args[0]);
           FileReader fr = new FileReader(f);

           BufferedReader reader = new BufferedReader(fr);

           String line = null;

           int num = 0;
           ArrayList<String[]> info = new ArrayList<>();


           while ((line = reader.readLine()) != null) {
               String[] temp = line.split(",");
               info.add(temp);
               num++;
           }

           reader.close();

           BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           String[] order = br.readLine().split(" ");
           if (order.length > 2) {
               if (order[2].equals("order")) {
                   int turn = toNum(order[4]);
                   for (int i = 0; i < num - 1; i++) {
                       for (int j = 0; j < num - 1 - i; j++) {
                           if (Integer.parseInt(info.get(j)[turn]) < Integer.parseInt(info.get(j + 1)[turn])) {
                               String[] te = info.get(j);
                               info.set(j, info.get(j + 1));
                               info.set(j + 1, te);
                           }
                       }
                   }
               }
           }
           if (order[order.length - 2].equals("limit")) {
               num = Integer.parseInt(order[order.length - 1]);
           }
           if (order[1].equals("*")) {
               System.out.println("Last_name    First_name    Salary    Department    Employee_id");
               for (int i = 0; i < num; i++) {
                   for (int j = 0; j < 4; j++) {
                       System.out.print(info.get(i)[j] + "    ");
                   }
                   System.out.println(info.get(i)[4]);
               }
           }
           else {
               String[] s = order[1].split(",");
               int len = s.length;
               for (int i = 0; i < len - 1; i++) {
                   System.out.print(s[i] + "    ");
               }
               System.out.println(s[len - 1]);
               for (int i = 0; i < num; i++) {
                   for (int j = 0; j < len - 1; j++) {
                       System.out.print(info.get(i)[toNum(s[j])] + "    ");
                   }
                   System.out.println(info.get(i)[toNum(s[len - 1])]);
               }
           }

       } catch (IOException ex) {
           ex.printStackTrace();
       }
    }
    public static int toNum(String field) {
        if (field.equals("Last_name")) {
            return 0;
        }
        if (field.equals("First_name")) {
            return 1;
        }
        if (field.equals("Salary")) {
            return 2;
        }
        if (field.equals("Department")) {
            return 3;
        }
        if (field.equals("Employee_id")) {
            return 4;
        }
        return -1;
    }
}
