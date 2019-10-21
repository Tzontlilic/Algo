import java.util.Arrays;
public class SingalQuickSort {

    /**
     * 单边快排
     * @param array       要进行排序的数组
     * @param startIndex  开始的索引值
     * @param endIndex    结束的索引值
     */
    public void singalQuickSort(int[] array, int startIndex, int endIndex) {
        
        if(startIndex >= endIndex) {
            return;
        }
        
        int markIndex = partition(array, startIndex, endIndex);

        singalQuickSort(array, startIndex, markIndex - 1);
        singalQuickSort(array, markIndex + 1, endIndex);
    }

    /**
     * 分治
     * @param array       要进行排序的数组
     * @param startIndex  开始的索引值
     * @param endIndex    结束的索引值
     */
    public int partition(int[] array, int startIndex, int endIndex) {
        // 把第一个数字当作基准
        int pivot = array[startIndex];
        // 设置一个mark指针
        int mark = startIndex;

        for (int i = startIndex; i <= endIndex; i++) {

            // 当遍历值小于基准值，mark指针右移，交换遍历值和mark指向值
            if (array[i] < pivot) {
                mark++;

                // 交换位置
                int temp = array[mark];
                array[mark] = array[i];
                array[i] = temp;
            }
        }

        // 交换mark和基准的值
        array[startIndex] = array[mark];
        array[mark] = pivot;

        return mark;
    }


    public static void main(String[] args) {
        SingalQuickSort mSQS = new SingalQuickSort();
        
        int[] array = new int[] {1,21,545,3,5435,755,44};
        mSQS.singalQuickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
    
}
