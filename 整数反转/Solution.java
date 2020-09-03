// 整数反转
// 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
// 注意:
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
// 来源：力扣（LeetCode）
// 链接：https://leetcode-cn.com/problems/reverse-integer
// 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处
//  注意int范围，要判断溢出
//  官方题解
//  想象成卷饼的过程
// 溢出判断，从卷饼前的十位开始判断
// 个位通过二进制转十进制后，确定个位的数字上限
// 参考图像 https://leetcode-cn.com/problems/reverse-integer/solution/hua-jie-suan-fa-7-zheng-shu-fan-zhuan-by-guanpengc/
class Solution {
    public int reverse(int x) {
        int ans = 0;
        while(x != 0){
            int remainder = x % 10;
            if(ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE && remainder > 7)){
                return 0;
            }                
            if(ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE && remainder > 8)){
                return 0;                            
            }                 
            ans *= 10;
            ans += remainder;     
            x /= 10;       
        }
        return ans;
    }
}

