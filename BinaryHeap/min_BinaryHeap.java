import java.util.Arrays;
// 二叉堆的实现代码
// 这是一个最小堆
//
//

public class min_BinaryHeap {

    /*
     * 上浮操作
     * 当二叉堆插入节点时，插入的位置是完全二叉树的最后一个位置。
     * 然后再和其父节点进行比较，如果不符合最小堆的性质，就让新插入的节点上浮，和父节点交换位置
     *
     *@param array 待调整的堆

     */
    public static void upAdjust(int[] array){
        
        // 定义子结点下标值
        int childIndex = array.length - 1;
        // 定义父节下标值
        int parentIndex = (childIndex - 1) / 2;
        // 定义临时存储上浮数字的变量
        int temp = array[childIndex];

        // 如果未达到根节点，且插入值小于父节点
        while(childIndex > 0 && temp < array[parentIndex]){

            // 将父节点下沉
            array[childIndex] = array[parentIndex];
            // 更新焦点树
            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;
        }
        // 当跳出循环时，将temp临时储存的插入值赋值
        array[childIndex] = temp;
    }

    /*
     * 下沉操作
     * 当需要删除某个节点时，被删除的节点的位置就空了出来
     * 我们用完全二叉树的最后一个节点临时补到被删除的节点的位置上，然后进行“下沉”操作
     * 让这个被替换的节点与他的左右孩子进行比较，如果左右孩子中最小的一个比节点小，那么让节点下沉
     * 
     * @param array        要进行下沉操作的二叉堆
     * @param parentIndex  要下沉的父节点下标
     * @param length       堆的有效大小
     *
     */
    public static void downAdjust(int[] array, int parentIndex, int length){

        // 定义左孩子节点
        int childIndex = 2 * parentIndex + 1; 
        // 临时储存要下沉的父节点的值
        int temp = array[parentIndex];
        // 将父节点和左右孩子进行比较，
        // 当子节点没超过索引值时
        while(childIndex < length){

            // 还要看左右孩子哪个更小
        if(childIndex + 1 < length && array[childIndex + 1] < array[childIndex]){
            // 如果右孩子更小，则直接跟右孩子进行交换
                childIndex ++;
            }

            if(temp <= array[childIndex]) // 如果他小于任何一个孩子的值（即小于最小的那个孩子的值）则不下沉，直接跳出
                break;
            //  将子孩子“上浮”
            array[parentIndex] = array[childIndex];
            // 转换“焦点树”
            parentIndex = childIndex;
            childIndex = (2 * parentIndex) + 1;
        }
        array[parentIndex] = temp;
    }


    /* 构建二叉堆
     * 构建二叉树的本质就是让一个没有顺序的数组中的每个节点依次下沉
     * 首先从最后一个 【非叶子节点】开始
     * 下沉结束后，再从上一个 【非叶子节点】 继续
     * 下沉到根节点后，就进行完了一轮下沉
     * 经过几轮下沉后，最终这个完全二叉树就被构建成了一个最小堆
     * @param array     要进行构建的数组
     */
    public static void bulidHeap(int[] array){
    
        // 从最后一个【非叶子节点】开始，依次进行下沉
        for(int i = (array.length - 2) / 2; i >= 0; i--){ // 最后一个非叶子节点就是最后一个右孩子的父节点
            
            downAdjust(array, i, array.length);
        }
    }

    public static void main(String[] args){
    
        int[] array = new int[] {1, 3, 2, 6, 5, 7, 8, 9, 10, 0};
        /*
         *                          1
         *                       /     \
         *                     3         2
         *                  /    \     /   \
         *                6       5   7      8
         *              /   \    / 
         *             9    10  0
         */
        upAdjust(array);
        // 上浮操作
        System.out.println(Arrays.toString(array));
        
        int[] array2 = new int[] {7, 1, 3, 10, 5, 2, 8, 9, 6};
        /*
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
