package java_;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

    /*
    Given an integer array nums and an integer k, return the k most frequent elements.

    You may return the answer in any order.
     */

public class Problem347 {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();

            for (int num : nums) {
                if (map.containsKey(num)) {
                    map.put(num, map.get(num) + 1);
                } else {
                    map.put(num, 1);
                }
            }
            List<Integer> sorted = map.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(k)
                    .map(Map.Entry::getKey).toList();


            int[] result = new int[sorted.size()];

            for (int i = 0; i < result.length; i++) {
                result[i] = sorted.get(i);
            }
            return result;
        }
}
