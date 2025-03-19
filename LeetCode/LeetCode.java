package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
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

    // palindromic number - Given an integer x, return true if x is a palindrome, and false otherwise.
    public boolean isPalindrome(int x) {
        // x cannot be palindrome if its negative
        if (x < 0) return false;

        int temp = x;
        int reversed = 0;
        while (temp != 0) {
            int digit = temp%10;
            reversed = reversed * 10 + digit;
            temp /= 10;
        }

        return x == reversed;
    }

    // roman to integer - Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
    public int romanToInt(String s) {
        Map<Character, Integer> romanMap = new HashMap<>(); 
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int n = s.length();
        int result = 0;
        for (int i = 0; i < n; i++) {
            if(i < n - 1 && romanMap.get(s.charAt(i)) < romanMap.get(s.charAt(i + 1))) {
                result -= romanMap.get(s.charAt(i));
            } else {
                result += romanMap.get(s.charAt(i));
            }
        }

        return result;
    }

    // remove duplicates from sorted array - Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
    public int removeDuplicates(int[] nums) {
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                nums[index] = nums[i];
                index++;
            }
        }

        return index;
    }

    // group of anagrams
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = String.valueOf(chars);

            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }

            map.get(sortedStr).add(str);
        }

        return new ArrayList<>(map.values());
    }

    // number of islands
    public void bfsSearch(
        boolean[][] visited, char[][] grid, 
        int i, int j, int rows, int cols) {

            Queue<Integer[]> queue = new LinkedList<>();
            queue.offer(new Integer[]{i, j});
            visited[i][j] = true;

            while (!queue.isEmpty()) {
                Integer[] current = queue.poll();
                int r = current[0], c = current[1];

                // checking above element
                if (r > 0 && grid[r-1][c] == '1' && !visited[r-1][c]) {
                    visited[r-1][c] = true;
                    queue.offer(new Integer[]{r-1,c});
                }

                // checking below element
                if (r < rows-1 && grid[r+1][c] == '1' && !visited[r+1][c]) {
                    visited[r+1][c] = true;
                    queue.offer(new Integer[]{r+1, c});
                }

                // checking left element
                if (c > 0 && grid[r][c-1] == '1' && !visited[r][c-1]) {
                    visited[r][c-1] = true;
                    queue.offer(new Integer[]{r, c-1});
                }

                // checking right element
                if (c < cols-1 && grid[r][c+1] == '1' && !visited[r][c+1]) {
                    visited[r][c+1] = true;
                    queue.offer(new Integer[]{r, c+1});
                }
            }
    }

    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int result = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    bfsSearch(visited, grid, i, j, rows, cols);
                    result++;
                }
            }
        }

        return result;
    }


    public static void main(String[] args) {
        
    }
}
