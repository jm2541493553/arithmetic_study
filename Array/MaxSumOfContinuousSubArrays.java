import java.util.Scanner;

//1 -2 3 10 -4 7 2 -5
public class MaxSumOfContinuousSubArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        int sum = MaxSumOfContinuousSubArrays2(array);
        System.out.println(sum);
    }
    //暴力破解
    private static int MaxSumOfContinuousSubArrays(int[] array){
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++){
            int tempSum = 0;
            for(int j = i; j< array.length; j++){
                tempSum = tempSum + array[j];
                if (tempSum > result) {
                    result = tempSum;
                }
            }
        }
        return result;
    }

    //动态规划
    //下标以i结尾的连续子数组的最大和，怎么求呢？
    // 要想求dp[i],那我们现在假设一下，假设下标以i-1结尾的连续子数组的最大和为dp[i-1],数组第i个元素是nums[i]，那么当前的连续子数组的最大和，
    // 要么是前面的加上当前的元素：dp[i-1]+nums[i]，要么是舍弃掉之前的dp[i-1]（这个很可能是负数），取现在的nums[i];
    // dp[i]= Max{dp[i-1]+nums[i],nums[i]}
    private static int MaxSumOfContinuousSubArrays2(int[] array){
        int res = array[0]; //记录当前所有子数组的和的最大值
        int max = array[0];   //包含array[i]的连续数组最大值
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max + array[i], array[i]);
            res = Math.max(max, res);
        }
        return res;
    }
}
