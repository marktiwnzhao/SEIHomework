package cn.nju.test9arrivalofgeneral2;

public class ArrivalOfGeneral {

    /**
     * 处理士兵交换次数
     * @param num 士兵个数
     * @param heightArr 身高数组
     * @return 交换次数
     */
    public static int calculate(int num, int[] heightArr) {
        int count = 0;
        int IndexOfMax = 0;
        for (int i = 1; i < heightArr.length; i++) {
            if (heightArr[i] > heightArr[IndexOfMax]) {
                IndexOfMax = i;
            }
        }
        count += IndexOfMax;
        if(IndexOfMax != 0) {
            int temp = heightArr[IndexOfMax];
            for (int i = IndexOfMax - 1; i >= 0; i--) {
                heightArr[i+1] = heightArr[i];
            }
            heightArr[0] = temp;
        }
        int IndexOfMin = heightArr.length - 1;
        for (int i = heightArr.length - 2; i >= 0; i--) {
            if (heightArr[i] < heightArr[IndexOfMin]) {
                IndexOfMin = i;
            }
        }
        count = count + heightArr.length - 1 - IndexOfMin;
        return count;
    }
}
