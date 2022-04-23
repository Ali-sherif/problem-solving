
/*

 Runtime beats 98.96 % of java submissions
 Your memory usage beats 81.18 % of java submissions

*/
class Solution {

    public int reverse(int x) {

       int result = 0, preValue;
       boolean isNegative = (x < 0);
        
        if (x % 10 == x) return x;
        

        while (x != 0) {
            
            // save previous value of result before calculte new one
            
            preValue = result;
            result *= 10;
            
            // if previous value of result > calculte new one then there is over flow
            
            if(preValue > result / 10) return 0;
            
            if (x % 10 != 0) {
                result += (x % 10);
            }
            x /= 10;
            System.out.println(result);
        }
        
        // if input > 0 his reverse must be gt zero unless there is overflow happed and vice versa 
       
        return ((isNegative && result > 0) || (!isNegative && result < 0)) ? 0 : result;

    }
}
