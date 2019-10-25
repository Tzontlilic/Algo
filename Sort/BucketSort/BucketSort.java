import java.util.Collections;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ArrayList;
public class BucketSort {

    /**
     * 桶排序
     * @param array 要进行排序的数组
     */
    public double[] bucketSort (double[] array) {

        // 找出最大值和最小值，并计算出差值
        double max = array[0];
        double min = array[0];
        
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i]; 
            }
            if (array[i] < min) {
                min = array[i]; 
            }
        }
        double d = max - min;


        int bucketNum = array.length;
        // 初始化桶
        ArrayList<LinkedList<Double>> bucketSort = new ArrayList<LinkedList<Double>>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketSort.add(new LinkedList<Double>());
        }

        // 遍历原始数组，将元素放到相应的桶中
        for (int i = 0; i < array.length; i++) {
        
            int num = (int) ((array[i] - min) * ( d / (bucketNum - 1) ));
            bucketSort.get(num).add(array[i]);
        }

        // 在桶内对元素进行排序
        for (int i = 0; i < bucketSort.size(); i++) {
            Collections.sort(bucketSort.get(i));
        }

        // 输出全部元素
        double[] sortedArray = new double[array.length];
        int index = 0;
        for (LinkedList<Double> list : bucketSort) {
        
            for (double element : list) {
               sortedArray[index] = element;
               index++;
            }
        }
        return sortedArray;
    }

    public static void main(String[] args) {
    
        BucketSort mBS = new BucketSort();
        double[] array = new double[] {1.2, 6.34, 63, 5354.4};
        System.out.println(Arrays.toString(mBS.bucketSort(array)));


    }
}
