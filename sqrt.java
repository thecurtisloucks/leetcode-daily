/*
 * LeetCode Problem #69: Sqrt(x)
 * Difficulty: Easy
 * 
 * Problem Description:
 * Given a non-negative integer x, return the square root of x rounded down to the nearest integer.
 * The returned integer should be non-negative as well.
 * 
 * You must not use any built-in exponent function or operator.
 * For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 * 
 * Example:
 * Input: x = 4
 * Output: 2
 * Explanation: The square root of 4 is 2, so we return 2.
 * 
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
 * 
 * Algorithm: Binary Search
 * Time Complexity: O(log x) - binary search reduces search space by half each iteration
 * Space Complexity: O(1) - only using constant extra space
 * 
 * Key Insight: 
 * The square root of x lies between 1 and x. Use binary search to find the largest
 * integer whose square is ≤ x.
 * 
 * Important considerations:
 * - Integer overflow: mid * mid might overflow, so use long
 * - Edge cases: x = 0 and x = 1 return themselves
 * - We want floor(sqrt(x)), so keep track of last valid answer
 * 
 * Step-by-step approach:
 * 1. Handle base cases: x = 0 or x = 1
 * 2. Set search range: left = 1, right = x
 * 3. Binary search:
 *    - Calculate mid point
 *    - Compute mid² using long to avoid overflow
 *    - If mid² == x: found exact square root
 *    - If mid² < x: mid could be answer, search right half
 *    - If mid² > x: search left half
 * 4. Return the last valid answer found
 */

class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;

        int left = 1, right = x, ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Use long to avoid mid * mid overflow
            long sq = (long) mid * mid;

            if (sq == x) {
                return mid; // perfect square
            } else if (sq < x) {
                ans = mid;  // store last valid mid
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }
}
