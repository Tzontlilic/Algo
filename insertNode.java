public class insertNode {

	private Node head;	// 链表头
	private Node last;	// 链表尾
	private int size = 0;

	public static void main(String[] args) throws Exception {
		
		insertNode mNode = new insertNode();
		mNode.insert(0, 0);
		mNode.insert(1, 1);
		mNode.insert(2, 2);
		mNode.insert(3, 3);
		mNode.insert(0, -1);
		mNode.insert(2, 15);
		System.out.println("size:" + mNode.size);
		//mNode.insert(0, -1);
		mNode.print();


	}

	public void print(){
		Node preNode = head;
		for(int i = 0; i < size ; i++) {
			System.out.println(preNode.Data);
			preNode = preNode.next;
		}
	}

	public Node get(int index) throws Exception{
		Node target;
		target = head;
		for(int i = 0; i <= index; i ++) {
			target = head.next;
		}		
		return target;
	}

	public void insert(int index, int data) throws Exception{
	
		if(index > size || index < 0) {
			
			throw new IndexOutOfBoundsException("索引超出范围");
		}
		
		Node insertNode = new Node(data);

		if(size == 0) { // 如果为空链表
			head = insertNode;
			last = insertNode;
		}else if(index == size){ // 如果在尾部插入
			last.next = insertNode;
			last = insertNode;
		}else if(index == 0){  // 如果在头部插入
			insertNode.next = head;
			head = insertNode;
		}else { // 在链表中部插入
			Node preNode = get(index - 1);
			Node nextNode = preNode.next;
			preNode.next = insertNode;
			insertNode.next = nextNode;
		} 
		size++;
	}


}
