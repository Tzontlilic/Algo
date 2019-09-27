public class insertArray {

	private int[] array;
	private int size;

	public static void main(String[] args) throws Exception{
		
		insertArray mInsert = new insertArray();
		mInsert.array = new int[1];
		mInsert.insert(5, 0);
		mInsert.insert(1,1);
		mInsert.insert(3,0);
		mInsert.output();
	}

	public void insert(int element, int index) throws Exception {

		if(size >= array.length){
			resize();	
		}
		if(index < 0 || index > size){
			
			throw new IndexOutOfBoundsException("out of index");
		}	
		
			for(int i = size - 1; i >= index; i--) {
				array[i + 1] = array[i]	;
			}	

			array[index] = element;
			size ++;
		
	}
	public void resize() {
		
		int[] newArray = new int[2 * array.length];
		System.arraycopy(array, 0, newArray, 0 , array.length);
		array = newArray;
	}

	public void output(){
		for(int i = 0; i < size; i++ ){
			System.out.println(array[i]);	
		}	
	}


}
