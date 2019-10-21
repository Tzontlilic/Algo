import java.util.Arrays;
/*
 * 最大二叉堆，父节点的值始终比子节点要大
 * 根节点是这个堆中最大的数字
 */
public  class max_BinaryHeap{


    /**
     * 上浮操作
     * @param array 待操作的数组
     */
    public static void upAdjust(int[] array){

        int childIndex = array.length - 1; // 定义最后一个叶子节点为子节点 
        int parentIndex = (childIndex - 1) / 2; // 子节点的父节点
        int temp = array[childIndex]; // 对要上浮的数字

        // 将子节点与父节点的大小进行比较，如果子节点更大，就交换位置，直到子节点达到根节点位置
        while(childIndex > 0 && temp > array[parentIndex]){

            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;
        }
        array[childIndex] = temp;
    
    } 

    /**      
     * *下沉操作
     * @param array 待操作的数组
     * @param parentIndex 待下沉的父节点的索引值
     * @param length 堆的有效大小
     */
    public static void downAdjust(int[] array, int parentIndex, int length){

        int temp = array[parentIndex]; // 临时存储要下沉的节点的数值
        int childIndex = 2 * parentIndex + 1; // 左孩子下标

        // 这里的下沉操作是将小的数下沉，因为是最大二叉堆
        while(childIndex < length) {
        
            // 当右孩子比左孩子要大时，直接将下沉节点与右孩子替换
            if(childIndex + 1 < length && array[childIndex + 1] > array[childIndex]) 
                childIndex++;

            // 如果下沉节点大于两个孩子，则直接跳出
            if(temp >= array[childIndex])
                break;

            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * parentIndex + 1;
        }
        array[parentIndex] = temp;
    }

    /** 构建二叉堆
     *
     * @param array 待构建的数组
     */
    public static void bulidHeap(int[] array){

        // 从最后一个非叶子节点开始依次进行下沉操作
        for(int i = (array.length - 2) / 2; i >= 0; i-- ){
            
            downAdjust(array, i, array.length);
        }
    
    }

    public static void main(String[] args){
    
        int[] array = new int[] {1, 3, 2, 6, 5, 7, 8, 9, 10, 0};
        /**
         *                          1
         *                       /     \
         *                     3         2
         *                  /    \     /   \
         *                6       5   7      8
         *              /   \    / 
         *             9    10  0
         */
        bulidHeap(array);
        //upAdjust(array);
        // 上浮操作
        System.out.println(Arrays.toString(array));
        
        int[] array2 = new int[] {7, 1, 3, 10, 5, 2, 8, 9, 6};
        /**
         *                           7
         *                         /   \
         *                       1       3
         *                    /    \  /     \
         *                  10     5 2        8
         *                /    \  
         *              9       6
         */
        bulidHeap(array2); // 对于一个无序的数组，可以使用下沉操作来构建出一个二叉堆
        System.out.println(Arrays.toString(array2));
        
    }

}
