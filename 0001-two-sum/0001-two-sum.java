class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();

        for(int i = 0; i<nums.length;i++ ){
            hashMap.put(nums[i],i);
        }
        for(int i1 = 0; i1<nums.length;i1++){
            Integer i2 = hashMap.get(target - nums[i1]);
            if(i2 != null && i1 != i2) {
                return new int[]{i1, i2};
            }
        }
        return null;
    }
}