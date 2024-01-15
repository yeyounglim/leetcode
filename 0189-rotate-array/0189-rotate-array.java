import java.util.Arrays;
import java.util.stream.IntStream;
import static java.util.Arrays.stream;
class Solution {
    public void rotate(int[] nums, int k) {
       /* 
        int arrLen = nums.length;
        int[] arr1= Arrays.copyOfRange(nums,0,arrLen-k);
        int[] arr2= Arrays.copyOfRange(nums,arrLen-k,arrLen);
     
        int[] newNums = IntStream.concat(stream(arr2), stream(arr1)).toArray();
        for (int i = 0; i < arrLen; i++) {
            nums[i] = newNums[i];
        }
        */
        
        k = k % nums.length;
        sorts(nums,0,nums.length-1);
        sorts(nums, 0, k-1);
        sorts(nums,k,nums.length-1);
    }
    private static void sorts(int[] nums, int start, int end) {
        int tmp = 0;
        while(start < end){
            tmp=nums[start];
            nums[start]=nums[end];
            nums[end]=tmp;
            start++;
            end--;
        }
    }
}