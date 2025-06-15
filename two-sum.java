import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        /*
         * LeetCode Problem #1: Two Sum
         * Difficulty: Easy
         * 
         * Problem Description:
         * Given an array of integers nums and an integer target, return indices of the 
         * two numbers such that they add up to target.
         * 
         * You may assume that each input would have exactly one solution, and you may 
         * not use the same element twice.
         * 
         * You can return the answer in any order.
         * 
         * Example:
         * Input: nums = [2,7,11,15], target = 9
         * Output: [0,1]
         * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
         * 
         * Algorithm: Hash Map (One-pass)
         * Time Complexity: O(n) - single pass through the array
         * Space Complexity: O(n) - for the hash map storage
         * 
         * Key Insight: 
         * Instead of checking every pair (O(n²)), use a hash map to store complements.
         * For each number, check if its complement (target - current) already exists.
         * 
         * Step-by-step approach:
         * 1. Create a hash map to store number -> index mapping
         * 2. For each element, calculate its complement (target - current number)
         * 3. Check if complement exists in the map
         * 4. If yes, return the indices
         * 5. If no, store current number and its index in the map
         */

        // Map to store number -> index
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // If complement is already seen, return both indices
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            // Otherwise, store the current number with its index
            map.put(nums[i], i);
        }

        // Should never happen if exactly one solution exists
        throw new IllegalArgumentException("No two sum solution");
    }
}
