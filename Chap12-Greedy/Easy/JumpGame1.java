public class JumpGame1 {
    static boolean canJump(int[] nums) {
        int maxReach = 0;

        for(int i = 0; i < nums.length; i++) {
            if(i > maxReach) return false;
            maxReach = Math.max(maxReach, i + nums[i]);
            if(i >= nums.length - 1) return true;
        }

        return true;
    }
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(canJump(nums));
    }
}
