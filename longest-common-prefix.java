/*
 * LeetCode Problem #14: Longest Common Prefix
 * Difficulty: Easy
 * 
 * Problem Description:
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 * 
 * Example:
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * 
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * 
 * Algorithm: Vertical Scanning
 * Time Complexity: O(S) where S is the sum of all characters in all strings
 * Space Complexity: O(1) - only using constant extra space
 * 
 * Key Insight: 
 * Compare characters at each position across all strings vertically.
 * Stop when we find a mismatch or reach the end of any string.
 * 
 * Alternative approaches considered:
 * - Horizontal scanning: compare pairs sequentially
 * - Divide and conquer: split array and find LCP of each half
 * - Binary search: search for the length of common prefix
 * 
 * Step-by-step approach:
 * 1. Handle edge case: empty array
 * 2. Iterate through each character position i (0 to first string length)
 * 3. Get character at position i from first string
 * 4. Compare this character with character at position i in all other strings
 * 5. If mismatch found OR reached end of any string, return prefix up to i-1
 * 6. If no mismatch found, entire first string is the common prefix
 */

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {
                // If i is past the current word's length OR chars don't match
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0]; // If no mismatch, entire first word is prefix
    }
}
