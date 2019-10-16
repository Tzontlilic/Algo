/*
 * 最大优先队列
 *Author:Tzontlilic
 *
 */
import java.util.Arrays;

public class max_PriorityQueue {

    int[] array;
    int size;

    /* 构造函数
     *
     */
    public max_PriorityQueue(){
    
        this.array = new int[32];
    }

    /* 入队
     * @param key 新入队的数字
     *
     */
    private void enQueue(int key){
    
        if(size >= array.length){
            resize();
        }
        array[size++] = key;
        upAdjust();
    }

    /* 出队
     *
     */
    private int deQueue() throws Exception{

        if(size == 0){
        
            throw new Exception("队列为空");
        }

        int head = array[0];
        array[0] = array[--size];
        downAdjust();
    
        return head;
    }

    /* 上浮操作
     *
     */
    private void upAdjust(){

        // 定义最后一个节点
        int childIndex = size - 1;
        // 临时存储最后一个节点的数值
        int temp = array[childIndex];
        // 找到父节点
        int parentIndex = (childIndex - 1) / 2;

        // 当子节点大于父节点时， 交换位置
        while(childIndex > 0 && temp > array[parentIndex]){
        
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;
        }
        array[childIndex] = temp;
    }

    /* 下沉操作
     *
     */
    private void downAdjust(){

        // 定义父节点为根节点
        int parentIndex = 0;
        // 临时存储父节点的值
        int temp = array[parentIndex];
        // 找到子节点
        int childIndex = 2 * parentIndex + 1;
        
        
        while(childIndex < size){

            // 如果右孩子比左孩子大，则目标替换目标转为右孩子
            if(childIndex + 1 < size && array[childIndex] < array[childIndex + 1]){
            
                childIndex ++;
            }

            // 如果孩子比父节点小，则不继续下沉
            if (temp >= array[childIndex]){
                break;
            }
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * parentIndex + 1;
        }
        array[parentIndex] = temp;
    }

    /* 数组扩容
     *
     */
    private void resize(){

        int newsize;
        newsize = this.size * 2;
        this.array = Arrays.copyOf(this.array, newsize);
    }
   
    public static void main(String[] args) throws Exception{
    
        max_PriorityQueue mPQ = new max_PriorityQueue();
        mPQ.enQueue(9);
        mPQ.enQueue(59);
        mPQ.enQueue(35);
        mPQ.enQueue(15);
        System.out.println("出队元素为:" + mPQ.deQueue());
        System.out.println("出队元素为:" + mPQ.deQueue());
        System.out.println("出队元素为:" + mPQ.deQueue());
        System.out.println("出队元素为:" + mPQ.deQueue());
    }

}
