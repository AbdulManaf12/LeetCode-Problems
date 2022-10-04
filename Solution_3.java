import java.util.Arrays;

class Solution_3 {
    public int[] twoSum(int[] nums, int target) {
        if(isArrayValid(nums, target)){
            for(int i=0; i<nums.length; i++){
                for(int j=i+1; j<nums.length; j++){
                    if((nums[i]+nums[j]) == target){
                        return new int[]{i, j};
                    }
                }
            }
        }
        return null;
    }
    private boolean isArrayValid(int[] nums, int target){
        double num = Math.pow(10, 9);
        if(nums.length >= 2 && nums.length <= Math.pow(10, 4) && target >= (num*-1) && target <= num)
        {
            for(int i=0; i<nums.length; i++){
                if(!(nums[i] >= (num*-1) && nums[i] <= num)){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    public static void main(String args[]){
        Solution_3 s = new Solution_3();
        System.out.println(Arrays.toString(s.twoSum(new int[]{2,7,11,15}, 9)));
    }
}