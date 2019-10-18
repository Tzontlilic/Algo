public class BubbleSort{

    public static int[] array;

    /**
     * 构造函数
     * @param length 初始化数组的长度 
     */

    /**
     * 冒泡排序
     */ 
    public void bubbleSort(){

        for(int i = 0; i < array.length - 1 ; i++){

            for(int j = 0; j < array.length - i - 1; j++){
                
                // 临时存储变量
                int temp = 0;
                if(array[j] < array[j + 1]){

                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 另一种冒泡排序
     */
    public void bubbleSort2(){
    
        for(int i = 0; i < array.length - 1; i++){
        
            for(int j = array.length - 1 ; j > i; j--){
            
                int temp = 0;
                if(array[j] < array[j - 1]){
                
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }

    /**
     * 优化冒泡排序，增加有序检测
     */
    public void bubbleSort3(){

        boolean isSorted;
        for(int i = 0; i < array.length - 1; i++){

            isSorted = true;
            for(int j = 0; j < array.length - 1 - i; i++){

                if(array[j] < array[j + 1]){
                
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    isSorted = false;
                }
            }

            if(isSorted){
                break;
            }
        }
    }


    /**
     * 继续优化冒泡排序，增加有序边界检测
     */
    public void bubbleSort4(){
    
        int sortBorder = array.length - 1;
        for(int i = 0; i < array.length - 1; i++){
            boolean isSorted = true;
            for(int j = 0; j < sortBorder; j++){
            
                int temp = 0;
                if(array[j] < array[j + 1]){
                   temp = array[j]; 
                   array[j] = array[j + 1];
                   array[j + 1] = temp;

                   isSorted = false;
                }
            }
            if(isSorted){
                break;
            }
        }
    }


    public void printer(){
    
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + "   ");
        }

    }

    public static void main(String[] args){


        BubbleSort mBS = new BubbleSort();
        array = new int[] {1,2,3,34,346,234,2333,234};
        mBS.bubbleSort4(); 

        mBS.printer();
    
    }
}
