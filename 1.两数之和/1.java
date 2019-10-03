// 破解
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
    	for(int i = 0, len = nums.length; i < len; i++){
    		for(int j = 0, j_len = nums.length; j < j_len; j++){
    			if(i != j && (nums[i] + nums[j] == target)){
    				ans[0] = i;
    				ans[1] = j;
    				break;
    			}
    		}
    	}
        return ans;
    }
}
// 两遍哈希 (dynamic programming)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
// 一遍哈希表 (dynamic programming)
class Solution {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
	}	 
}
