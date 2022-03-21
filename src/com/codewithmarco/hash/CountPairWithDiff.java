package com.codewithmarco.hash;

import java.util.HashMap;
import java.util.Map;

//Input: [1, 7, 5, 9, 2, 12, 3] K=2
public class CountPairWithDiff {
    static int MAX = 100000;

    // O(n^2)
    public static int count1(int[] arr, int k) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] - arr[j] == k || arr[j] - arr[i] == k) {
                    count++;
                }
            }
        }
        return count;
    }

    // O(n)
    public static int count2(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i] - k)) {
                res += map.get(arr[i] - k);
            }
            if (map.containsKey(arr[i] + k)) {
                res += map.get(arr[i] + k);
            }
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }


        return res;
    }

    // O(n)
    public static int countUnique(int[] arr, int k) {
        int count = 0;

        // HashMap<item, 1>
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (var item : arr) {
            map.put(item, true);
        }

        for (int item : arr) {
            if (item - k > 0 && map.get(item - k)) {
                count++;
            }

            if (map.get(item + k)) {
                count++;
            }

            map.put(item, false);
        }


        return count;
    }


}
