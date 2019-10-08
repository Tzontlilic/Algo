public class myQueque {

	private int[] array; // 储存队列用的数组
	private int front;  // 队头
	private int rear; // 队尾

	public myQueque(int capacity){
		this.array = new int[capacity]; // 初始化队列容量		
	}
	
	// 入队函数
	public void enQueque(int element) throws Exception{
	
		// 判断队列是否满
		if((rear + 1) % array.length == front){
			throw new Exception("队列满了！");	
		}

		// 正常的入队
		array[rear] = element; 
		rear = (rear + 1)  % array.length;
	}


	// 出队函数
	public void deQueque() throws Exception{
		
		// 判断队列是否为空
		if(rear == front){
			throw new Exception("队列已空");	
		}

		// 正常的出队
		int deQuequeElement =  array[front]; // 获取旧的队头来方便返回
		front = (front + 1) % array.length; // 至于为什么出队不对数组储存的数字删除，原因是留在那等待重新入队是被覆盖
		System.out.println("出队：" + deQuequeElement);
	}

	// 输出队列
	public void output(){
		for(int i = front; i != rear; i = (i + 1)%array.length){
			System.out.println(array[i]);	
		}	
	}

	public static void main(String[] args) throws Exception{
		myQueque mQ = new myQueque(5);			

		mQ.enQueque(1);
		mQ.enQueque(2);
		mQ.enQueque(3);
		mQ.deQueque();
		mQ.output();
	}
}
