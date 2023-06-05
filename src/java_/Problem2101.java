package java_;

    /*
        You are given a list of bombs. The range of a bomb is defined as the area where its effect can be felt.

        This area is in the shape of a circle with the center as the location of the bomb.

        The bombs are represented by a 0-indexed 2D integer array bombs where bombs[i] = [xi, yi, ri].

         xi and yi denote the X-coordinate and Y-coordinate of the location of the ith bomb,

         whereas ri denotes the radius of its range.

        You may choose to detonate a single bomb. When a bomb is detonated,

        it will detonate all bombs that lie in its range. These bombs will further detonate the bombs that lie in their ranges.

        Given the list of bombs, return the maximum number of bombs that can be detonated if you are allowed to detonate only one bomb.
     */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Problem2101 {
    public int maximumDetonation(int[][] bombs) {
        Map<Integer, List<Integer>> neighbors = buildNeighbors(bombs);

        int maxCount = 0;
        for (int startBomb = 0; startBomb < bombs.length; startBomb++) {
            int count = countDetonationFrom(startBomb, neighbors);
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }

    private int countDetonationFrom(int startIndex, Map<Integer, List<Integer>> neighbors) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startIndex);
        Set<Integer> reachable = new HashSet<>();
        reachable.add(startIndex);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size --> 0) {
                int bomb = queue.poll();

                for (int neighbor : neighbors.get(bomb)) {
                    if (!reachable.contains(neighbor)) {
                        queue.add(neighbor);
                        reachable.add(neighbor);
                    }
                }
            }
        }
        return reachable.size();
    }

    private Map<Integer, List<Integer>> buildNeighbors(int[][] bombs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < bombs.length; i++) {
            List<Integer> neighbors = new ArrayList<>();

            long x1 = bombs[i][0];
            long y1 = bombs[i][1];
            long r1 = bombs[i][2];

            for (int j = 0; j < bombs.length; j++) {
                long x2 = bombs[j][0];
                long y2 = bombs[j][1];

                if (i != j) {
                    if ((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) <= r1 * r1) {
                        neighbors.add(j);
                    }
                }
            }
            graph.put(i, neighbors);
        }
        return graph;
    }
}
