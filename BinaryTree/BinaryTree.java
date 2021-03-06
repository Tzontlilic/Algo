/*
 * 二叉树的遍历
 * Author: Tzontlilic
 */
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Queue;

public class BinaryTree{

	// 构建二叉树
	public static TreeNode createBinaryTree(LinkedList<Integer> inputList){
		
		TreeNode node = null;
		// 判断是否为空
		if(inputList == null || inputList.isEmpty()){
			return null;	
		}

		// 删除第一个数字（因为要进行递归）
		// 同时会返回删除的第一个数字
		Integer data = inputList.removeFirst();
		if(data != null){
			// 递归创建二叉树					  data
			node = new TreeNode(data); // 相当于根节点               /    \   
			node.leftChild = createBinaryTree(inputList); //  leftChild rightChild
			node.rightChild = createBinaryTree(inputList); //   一直递归上述结构
		} // 直到传入的数组中没有数据了，返回递归
		return node;
	}
	
	/*                                               深度优先遍历                               */
	// 二叉树前序遍历
	// 前序遍历：若一个结点存在左孩子，则输出左孩子，直到没有左孩子，返回上一个结点，输出右孩子
	// 如果既没有左孩子也没有右孩子，则返回
	public static void preOrderTraveral(TreeNode node){

		if(node == null){
			return;	
		}	
		System.out.println(node.data);
		System.out.println("--");
		preOrderTraveral(node.leftChild); 
		preOrderTraveral(node.rightChild);
	}
	
	
	// 二叉树中序遍历
	// 中序遍历：输出的顺序为 左子树、根结点、右子树
	public static void inOrderTraveral(TreeNode node){
			
		if(node == null){
			return;	
		}
		inOrderTraveral(node.leftChild);
		System.out.println(node.data);
		System.out.println("--");
		inOrderTraveral(node.rightChild);
	}
	
	
	// 二叉树后序遍历
	// 后序遍历：输出顺序为 左子树、右子树、根节点	
	public static void postOrderTraveral(TreeNode node){
		
		if(node == null){
			return;
		}
		postOrderTraveral(node.leftChild);
		postOrderTraveral(node.rightChild);
		System.out.println(node.data);
		System.out.println("--");
	}
	

	/*                                                广度优先遍历                             */

	// 利用队列的数据结构，实现层级遍历。
    // 这种利用队列进行层级遍历的方法非常的巧妙
    // 从根结点开始，依次将根节点的左孩子进入队列，再将右孩子进入队列
    // 当左孩子作为队头被poll时，会把左孩子的左孩子和右孩子依次加进队列
	public static void levelOrderTraversal(TreeNode root){
	
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		// 向队列插入一个元素
		queue.offer(root);
		// 判断队列是否为空，如果为空，则表示遍历完成了， 如果不为空，则继续遍历
		while(!queue.isEmpty()){
			// poll():删除队头的一个元素
			TreeNode node = queue.poll();
			// 输出队头的这个元素， 表示已经遍历过了
			System.out.println(node.data);
			//判断输出的这个元素是否有左右孩子
			if(node.leftChild != null){
				queue.offer(node.leftChild);	
			}
			if(node.rightChild != null){
				queue.offer(node.rightChild);
			}
		}
	}

	// 测试用主函数 
	public static void main(String[] args){

		//  新建一个数组用来生成二叉树
		LinkedList<Integer> inputList = new LinkedList<Integer>(Arrays.asList(new Integer[]{3, 2, 9, null, null, 10, null, null, 8, null, 4}));	

		//                          3
		//                       /     \
		//                      2       8
		//                    /   \       \
		//                  9     10       4

		// 获取一个实例对象
		BinaryTree mBt = new BinaryTree();
		// 创建一个二叉树
		TreeNode treeNode = mBt.createBinaryTree(inputList);

		System.out.println("前序遍历：");
		mBt.preOrderTraveral(treeNode);
		System.out.println("中序遍历：");
		mBt.inOrderTraveral(treeNode);
		System.out.println("后序遍历：");
		mBt.postOrderTraveral(treeNode);
		System.out.println("广度优先遍历");
		mBt.levelOrderTraversal(treeNode);
	}
}
