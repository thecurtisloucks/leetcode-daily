/*
 * LeetCode Problem #21: Merge Two Sorted Lists
 * Difficulty: Easy
 * 
 * Problem Description:
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists in a sorted order and return the head of the merged list.
 * The list should be made by splicing together the nodes of the first two lists.
 * 
 * Example:
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * 
 * Algorithm: Two Pointers with Dummy Node
 * Time Complexity: O(n + m) where n and m are lengths of the two lists
 * Space Complexity: O(1) - only using constant extra space (no new nodes created)
 * 
 * Key Insight: 
 * Use a dummy node to simplify edge cases and avoid complex null checks.
 * Compare current nodes from both lists and link the smaller one.
 * 
 * Why dummy node?
 * - Eliminates need to handle empty result list separately
 * - Simplifies the code by avoiding special cases for the first node
 * - Makes the linking logic uniform throughout
 * 
 * Step-by-step approach:
 * 1. Create dummy node to serve as the start of merged list
 * 2. Use current pointer to track the end of merged list
 * 3. While both lists have nodes:
 *    - Compare current values
 *    - Link smaller node to merged list
 *    - Advance pointer in the list we took from
 *    - Move current pointer forward
 * 4. Append remaining nodes from non-empty list
 * 5. Return dummy.next (the actual head of merged list)
 */

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node to simplify the merge process
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // While both lists are not empty
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;  // take list1 node
                list1 = list1.next;
            } else {
                current.next = list2;  // take list2 node
                list2 = list2.next;
            }
            current = current.next;
        }

        // If either list is not empty, append it
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        return dummy.next; // The head of merged list is next of dummy
    }
}
