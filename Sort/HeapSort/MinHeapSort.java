import java.util.Arrays;
public class MinHeapSort{

    /**
     * 下沉操作
     * 升序排列用到的是最大堆
     * @param array         要进行调整的数组
     * @param parentIndex   要下沉的节点
     * @param length        数组的有效长度
     */
    public void downAdjust(int[] array, int parentIndex, int length) {
    
        // 临时保存父节点的值
        int temp = array[parentIndex];
        // 找到孩子节点
        int childIndex = 2 * parentIndex + 1;

        while(childIndex < length) {

            // 如果存在右孩子且右孩子更大
            if (childIndex + 1 < length && array[childIndex] < array[childIndex + 1])
                childIndex++;

            // 如果父节点比两个孩子都大，则不下沉
            if (temp >= array[childIndex]) {
                break;
            }

            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * parentIndex + 1;
        }
        array[parentIndex] = temp;
    }

    /**
     * 堆排序 
     * @param array 要进行排序的数组
     */
    public void minHeapSort(int[] array) {
    
        // 把无序数组构建成最小堆
        for (int i = array.length / 2; i >= 0; i--) {
        
            downAdjust(array, i, array.length - 1);
        }

        // 循环删除堆顶，移到集合尾部，调整堆产生新的堆顶
        for (int i = array.length - 1; i > 0; i--) {
            // 最后一个元素与第一个元素交换
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            // 下沉操作，调整最大堆
            downAdjust(array, 0, i);
        }
    }

    public static void main(String[] args) {
    
        MinHeapSort mMHS = new MinHeapSort();
        int[] array = new int[] {1,2,3123,45,23,23,44};
        
        mMHS.minHeapSort(array);
        System.out.println(Arrays.toString(array));
    }
}
