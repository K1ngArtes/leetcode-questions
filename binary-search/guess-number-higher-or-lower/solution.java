/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        if (n == 1) {
            return 1;
        }
        
        int l = 1;
        int r = n;
        while(true) {
            int pivot = l + (r - l)/2;
            int reply = guess(pivot);
            
            if (reply == -1) {
                r = pivot - 1;
                continue;
            } else if (reply == 1) {
                l = pivot + 1;
                continue;
            }
            
            return pivot;
        }
    }
}