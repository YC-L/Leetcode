class abc{
    public static void main(String[] args){
        Solution s = new Solution();     
        for(int j = 0; j < 3; j++){
            System.out.println(sum.val);
            sum = sum.next;
        }
    }	
}
class Solution {
    public int lengthOfLongestSubstring(String s) {
    	// ascii字符，常规的7位有128个字符，扩展的位有256个字符
    	int[] ascii = new int[256];
        // 左指针，每个窗口的大小
        int left = 0, res = 0;
        char ch;
        // 滑动窗口，left指针和索引i形成一个窗口，每次遍历都判断窗口长度大小，并取最大的长度
        // 之前没有出现过的字符囊括进来
        // 之前出现过，而且在窗口中的字符，截断该字符之前的字符串
        // 之前出现过，但不在窗口中的字符不管
        for(int i = 0, len = s.length(); i < len; i++){
        	ch = s.charAt(i);
        	if(ascii[ch] == 0 || ascii[ch] < left){
        		res = Math.max(res, i + 1 - left);
        	}else{
        		left = ascii[ch];        		
        	}
        	ascii[ch] = i + 1;
        }
        return res;
    }
}