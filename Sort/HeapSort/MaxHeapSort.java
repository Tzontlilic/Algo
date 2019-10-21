import java.util.Arrays;
public class MaxHeapSort {

    /**
     * 下沉操作
     * 降序排序使用最小堆
     * @param array         需要调整的数组
     * @param parentIndex   父节点的下标
     * @param length        数组的有效长度
     */
    public void downAdjust(int[] array, int parentIndex, int length) {

        // 临时储存父节点的值
        int temp = array[parentIndex];
        // 找出左孩子
        int childIndex = 2 * parentIndex + 1;

        while (childIndex < length) {
        
            // 如果存在右孩子，且右孩子比左孩子小
            if (childIndex + 1 < length && array[childIndex]  >= array[childIndex + 1]) {
                childIndex++;
            }

            // 如果左右孩子都比父节点要大则不下沉
            if (array[childIndex] >= temp) {
                break;
            }

            // 交换位置
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * parentIndex + 1;
        }
        array[parentIndex] = temp;
    }


    /**
     * 降序堆排序
     * @param array    要进行操作的数组
     */
    public void maxHeapSort(int[] array) {
    
        // 将无序数组构建成最小堆
        for (int i = array.length / 2; i >= 0; i--) {
            downAdjust(array, 0, array.length);
        }

        // 循环删除堆顶，并加到对应集合中
        for (int i = array.length - 1; i > 0; i--) {
        
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            downAdjust(array, 0, i);
        }
    }

    public static void main(String[] args) {
    
        MaxHeapSort mMHS = new MaxHeapSort();
        int[] array = new int[] {12,234,22,5234,32,24} ;
        mMHS.maxHeapSort(array);
        System.out.println(Arrays.toString(array));
    
    }
}
