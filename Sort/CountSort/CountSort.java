import java.util.Arrays;
public class CountSort {

    /**
     * 对数组进行计数排序
     * @param array 要进行排序的数组
     * @return countAarray 得到的计数数组
     */
    public int[] countSort(int[] array) {
        // 找到数组的最大值
        int max = array[0];
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        
        // 新建一个用于计数的数组
        int[] countArray = new int[max + 1];

        // 遍历需要排序的数组，进行计数
        for (int i = 0; i < array.length; i++) {
            countArray[array[i]] ++;    
        }

        return countArray;
    }

    /**
     * 输出数组
     * @param array 计数数组 
     */
    public void printArray(int[] countArray) {
        // 对计数数组进行遍历，存储的数字为下标出现的次数
        // i为下标, countArray[i]为数字出现的次数
        for (int i = 0; i < countArray.length; i++) {

            for(int j = 0; j < countArray[i]; j++) {
                System.out.print(i);
                System.out.print(", ");
            }
        }
    }

    public static void main(String[] args) {
    
        CountSort mCountSort = new CountSort();
        int[] array = new int[] {1,445,22,12,123};
        mCountSort.printArray(mCountSort.countSort(array));
        //System.out.println(Arrays.toString(mCountSort.countSort(array)));
    }
}
