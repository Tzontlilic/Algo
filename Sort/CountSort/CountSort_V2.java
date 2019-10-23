import java.util.Arrays;
public class CountSort_V2 {

    /**
     *  优化计数排序
     *  @param array 要进行排序的数组
     */
    public int[] countSort_V2 (int[] array) {

        // 获取最大值和最小值
        int max = array[0];
        int min = array[0];

        for (int i = 0; i < array.length; i++) {
        
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }

        // 建立计数数组
        int d = max - min;
        int[] countArray = new int[d + 1];

        // 对数组进行计数
        for (int i = 0 ; i < array.length; i++) {
           countArray[array[i] - min] ++;
        }

        // 对计数数组的元素值进行累加
        for (int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i - 1];
        }

        // 初始化最后结果数组，长度与初始数组相同
        int[] sortArray = new int[array.length];

        // 倒序遍历初始数组，进行排序索引
        for (int i = array.length - 1; i >=0; i--) {
        
            sortArray[countArray[array[i] - min] - 1] = array[i];
        }

        return sortArray;
    }

    public static void main(String[] args) {


        CountSort_V2 mCS = new CountSort_V2();
        int[] array = new int[] {1, 534, 73, 7335, 535};
        System.out.println(Arrays.toString(  mCS.countSort_V2(array)  ));
    
    }
}
