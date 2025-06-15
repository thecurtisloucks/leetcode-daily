/*
 * LeetCode Problem #9: Palindrome Number
 * Difficulty: Easy
 * 
 * Problem Description:
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 * 
 * Example:
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads the same backward as forward.
 * 
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-.
 * Therefore it is not a palindrome.
 * 
 * Follow up: Could you solve it without converting the integer to a string?
 * 
 * Algorithm: Reverse Half Number (Math approach)
 * Time Complexity: O(log n) - we process half the digits
 * Space Complexity: O(1) - only using constant extra space
 * 
 * Key Insight: 
 * Instead of reversing the entire number (which could cause overflow), 
 * reverse only half and compare with the remaining half.
 * 
 * Edge Cases:
 * - Negative numbers: always false (because of the minus sign)
 * - Numbers ending in 0: false (except 0 itself)
 * 
 * Step-by-step approach:
 * 1. Handle edge cases (negative, ends with 0)
 * 2. Reverse digits while x > reversed (processing half the number)
 * 3. For even length numbers: x == reversed
 * 4. For odd length numbers: x == reversed/10 (ignore middle digit)
 */

class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers & numbers ending in 0 (except 0 itself) cannot be palindromes
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversed = 0;

        // Reverse half of the number
        while (x > reversed) {
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            x = x / 10;
        }

        // For even length: x == reversed
        // For odd length: ignore middle digit -> reversed/10
        return x == reversed || x == reversed / 10;
    }
}
