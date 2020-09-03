// 给定一个整数数组 nums 和一个目标值 target
// 请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

// 来源：力扣（LeetCode）
// 链接：https://leetcode-cn.com/problems/two-sum
// 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

// 暴力解法
// 很简单，O(n^2)的遍历
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i,j,length = nums.length;
        int[] array = new int[2];         
        for(i = 0;i < length; i++){
            for(j = 0;j < length; j++){
                if(nums[i] + nums[j] == target && i != j){                    
                    array[1] = i;
                    array[0] = j;
                    break;                    
                }
            }
        }
        return array;       
    }
}

// 使用哈希
//  哈希表本身查找和插入是O(1)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i,length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(i = 0;i < length; i++){
            int difference  = target - nums[i];
            if(map.containsKey(difference)){
                return new int[] {map.get(difference), i};
            }            
            map.put(nums[i], i);  
        }        
    }
}
