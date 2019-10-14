// 二叉堆的实现代码
//
//

public class BinaryHeap {



    // 上浮操作
    /*
     *@param array 待调整的堆
     */
    public void upAdjust(int[] array){
        
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
}
