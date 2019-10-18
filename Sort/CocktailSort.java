import java.util.Arrays;
public class CocktailSort{

    int[] array;
    
    /**
     * 鸡尾酒排序
     * 从左至右、从右至左来回比较，加快冒泡的速度
     */
    public void cocktailSort(){
    
        for(int i = 0; i < array.length / 2; i++){

            boolean isSorted = true;
            // 奇数轮 从左至右
            for(int j = i; j < array.length - 1 - i; j++){
            
                if(array[j] > array[j + 1]){
                    
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    isSorted = false;
                }
            }
            if(isSorted) {
            
                break;
            }

            isSorted = true;
            // 偶数轮  从右到左
            for(int j = array.length - 1 - i; j > i; j-- ){

                if(array[j] < array[j - 1]){
                
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                    isSorted = false;
                }
            }
            if(isSorted){
            
                break;
            }
        }
    }

    /**
     * 显示函数
     */
    public void printer(){
    
        System.out.println(Arrays.toString(array));
    }


    /**
     *  测试函数
     */
    public static void main(String[] args){
    

        CocktailSort mCS = new CocktailSort();
        mCS.array = new int[] {12, 35, 364, 345, 1, 23, 244};
        mCS.cocktailSort();
        mCS.printer();
    }
}
