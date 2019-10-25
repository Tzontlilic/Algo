/**
 * 1 、使用辗转相除法计算得到两个数的最大公约数
 * 辗转相除法：如果有两个数a b ,且a > b 那么，a b 的最大公约数等于  a/b 的余数与b之间的最大公约数
 *
 * 2、 使用更相减损术求最大公约数
 * 更相减损术： 如果有两个数a b, 且a > b 那么，a b的最大公约数等于 a - b的值与b之间的最大公约数
 */
public class GetGreatestCommonDivisor {

    /**
     * 递归使用辗转相除法算出最大公约数
     * @param a 
     * @param b
     */
    public static int getGreatestCommonDivisor(int a, int b) {
    
        int big = a > b ? a:b;
        int small = a > b ? b:a;

        if (big%small == 0){
            return small; 
        }
        return getGreatestCommonDivisor(big%small, big); 
    }


    /**
     * 递归使用更相减损术算出最大公约数
     * @param a
     * @param b
     */
    public static int getGreatestCommonDivisorV2(int a, int b) {
    
        if (a == b) {
            return a;
        }
        int big = a > b? a:b;
        int small = a > b? b:a;

        return getGreatestCommonDivisorV2(big - small, small);
    }



    public static void main(String[] args) {
    
        System.out.println(getGreatestCommonDivisor(35,10));
        System.out.println(getGreatestCommonDivisorV2(35,10));

    }
}
