import java.util.Arrays;

public class BeautifulYear {

    /**
     * 计算出离该年份最近且大于该年份的"Beautiful Year"，"Beautiful Year"是指所有数字均不重复的年份，例如"1987"
     *
     * @param rawYear 任意年份
     * @return "Beautiful Year"
     */
    public static int getYear(int rawYear) {
        rawYear = rawYear + 1;
        int[] raw = new int[4];
        while(true) {
            raw[0] = rawYear / 1000;
            raw[1] = rawYear / 100 % 10;
            raw[2] = (rawYear / 10) % 10;
            raw[3] = rawYear % 10;
            if (raw[0] == raw[1] || raw[1] == raw[2] || raw[2] == raw[3] || raw[0] == raw[2] || raw[0] == raw[3] || raw[1] == raw[3]) {
                rawYear++;
            } else {
                break;
            }
        }
        return rawYear;
    }
}
