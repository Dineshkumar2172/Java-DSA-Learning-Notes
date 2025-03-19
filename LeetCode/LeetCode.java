package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;

public class LeetCode {

    // valid parentheses - Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> mapping = new HashMap<>();
        mapping.put(')', '(');
        mapping.put(']', '[');
        mapping.put('}', '{');

        for (char c: s.toCharArray()) {
            if (mapping.containsValue(c)) {
                stack.push(c);
            } else if (mapping.containsKey(c)) {
                if (stack.isEmpty() || mapping.get(c) != stack.pop()) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    // longest substring without duplicate characters - Given a string s, find the length of the longest substring without duplicate characters.
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        HashSet<Character> set = new HashSet<>();
        for (int right = 0; right < s.length(); right++) {
            if (set.contains(s.charAt(right))) {
                while (set.contains(s.charAt(right))) {
                    set.remove(s.charAt(left));
                    left++;
                }

                set.add(s.charAt(right));
                continue;
            }

            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    // Two sum - Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};
            }
            numMap.put(nums[i], i);
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        
    }
}
