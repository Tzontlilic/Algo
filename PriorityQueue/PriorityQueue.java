/*
 * 优先队列
 * Author:Tzontlilic
 * 优先队列不用于一般的队列的fifo，而是出队是总是最大（最小）数字先出队
 * 这就需要使用二叉堆来对队列进行调整
 *
 * 最大优先队列：无论入队顺序如何，都是当前最大的元素优先出队
 * 最小优先队列：无论入队顺序如何，都是当前最小的元素优先出队。
 *
 */
public class PriorityQueue {

private int[] array;
private int size;


/* 入队
 * @param key 入队元素
 *
 */
 public void enQueue(int key){
	
	// 队列超出长度，扩容
	if(size >= array.length){
		resize();	
	}
	array[size++] = key;
	upAdjust();

 }

 /* 出队
  *
  */
  public void deQueue() throws Exception{
  	
	// 如果队列为空，则抛出异常
	if(size <= 0)
		throw new Exception("队列为空");
	
	// 获取堆顶元素
	int head = array[0];
	// 让最后一个元素移动到顶端
	array[0] = array[--size];
	// 做下沉操作
	downAdjust();
	// 返回出队的数字
	return head;
  }

  /* 上浮操作
   * @param array 待操作的数组
   *
   */
   public void upAdjust(int[] array){
	
	// 找到最后一个非叶子节点
	int childIndex = size - 1;
	// 找到父节点
	int parentIndex = (childIndex - 1) / 2;
	// 临时储存上浮对象的数值
	int temp = array[childIndex];

	// 将非叶子节点和父节点进行比较，如果非叶子节点比副节点小，就让他们交换位置
	while(parentIndex > 0 && array[childIndex] < array[parentIndex]){

		array[childIndex] = array[parentIndex];
		childIndex = parentIndex;
		parentIndex = (childIndex - 1) / 2; 
	}
	array[childIndex] = temp;
   }


  /* 下沉操作
   * @param array 要操作的数组对象
   * @param parentIndex 要下沉的节点的索引值
   * @param length  数组的实际大小
   *
   */
   public void downAdjust(int[] array int parentIndex, int length){
	
	// 获取到左孩子	
	int childIndex = 2 * parenIndex + 1;
	// 临时储存下沉对象的数值
	int temp = array[parentIndex];
	
	// 将父节点与左右孩子进行比较，并与最小的那个孩子交换位置
	while(childIndex < length){

		// 将左右孩子比较，选出最小的那个
		if(childIndex + 1 < length  && array[childIndex] > array[childIndex + 1]){

			childIndex ++;
		}
		
		// 如果副节点比两个孩子都要小，就直接跳出
		if(temp  <= array[childIndex]){
		 	// 因为经过上一个IF的处理，这时的childIndex指向的是最小的那个孩子 
			
			break;
		}


	}


	
   }
}
