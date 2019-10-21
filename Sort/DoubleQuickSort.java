import java.util.Arrays;
public class DoubleQuickSort{

    /**
     * 快速排序
     * @param array 要排序的数组
     * @param startIndex 开始的下标
     * @param endIndex 结束的下标
     */
    public void quickSort(int[] array, int startIndex, int endIndex){

        // 退出条件，当开始的下标大于或等于结束的下标时
        if (startIndex >= endIndex) {
            return;
        }

        // 得到元素的基准位置
        int pivotIndex = partition(array, startIndex, endIndex);

        // 根据基准位置，进行递归排序
        quickSort(array, startIndex, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, endIndex);
    }

    /**
     * 获取位置
     * @param array
     * @param startIndex
     * @param endIndex
     */
    public int partition(int[] array, int startIndex, int endIndex){

        // 选择第一个数作为基准
        int pivot = array[startIndex];
        int left = startIndex;
        int right = endIndex;
        // 当左指针不等于右指针时
        while (left != right) {
        
            // 当右指针指向的元素大于或等于基准，则右指针左移
            while (left < right && array[right] > pivot) {
                right--;
            }
            // 当左指针指向的元素小于或等于基准，则左指针右移
            while (left < right && array[left] <= pivot) {
                left++;
            } 
            // 交换左右指针所指向的元素
            if (left < right) {
            
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }

        // 基准与指针重合点进行交换
        array[startIndex] = array[left];
        array[left] = pivot;
    
        return left;
    } 


    public static void main(String[] args){
    
        DoubleQuickSort mQS = new DoubleQuickSort();
        int[] array = new int[] {1,5,6,3,42,445,32,2};

        mQS.quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
