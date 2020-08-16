package main.LeetcodeEasy;

import org.junit.Test;

import java.util.Arrays;

public class Anagram {
    public boolean isAnagram(String s, String t) {
        int[] arr = new int[26];
        Arrays.fill(arr, 0);
        char[] ch = s.toCharArray();
        for (char c : ch) {
            arr[c - 97]++;
        }
        ch = t.toCharArray();
        for (char c : ch) {
            arr[c - 97]--;
        }
        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0) return false;
        }
        return true;
    }

    @Test
    public void inputAnagram() {
        System.out.println(isAnagram("anagrm", "nagaram"));
    }
}

