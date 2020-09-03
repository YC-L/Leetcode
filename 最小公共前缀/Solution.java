// 编写一个函数来查找字符串数组中的最长公共前缀。

// 如果不存在公共前缀，返回空字符串 ""。

// 示例 1:

// 输入: ["flower","flow","flight"]
// 输出: "fl"

// 示例 2:

// 输入: ["dog","racecar","car"]
// 输出: ""
// 解释: 输入不存在公共前缀。

// 说明:

// 所有输入只包含小写字母 a-z 。

// 来源：力扣（LeetCode）
// 链接：https://leetcode-cn.com/problems/longest-common-prefix
// 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处

//  依次比较每个元素的前缀，返回公共部分
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        String prefix = strs[0];
        for(int i = 1, count = strs.length;i < count; i++){
            prefix = GetSmallerPrefix(prefix, strs[i]);
            if(prefix.length() == 0){
                break;
            }
        }
        return prefix;
    }

    String GetSmallerPrefix(String prefix, String target){
        int length = Math.min(prefix.length(), target.length());
        int index = 0;
        while(index < length && prefix.charAt(index) == target.charAt(index)){
            index++;
        }
        return prefix.substring(0, index);
    }
}

// 纵向比较
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for(int i = 0; i < length; i++){
            char c = strs[0].charAt(i);
            for(int j = 1; j < count; j++){
                if(i == strs[j].length() || strs[j].charAt(i) != c){
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];       
    }    
}
