package java_;

    /*
            A company has n employees with a unique ID for each employee from 0 to n - 1.

            The head of the company is the one with headID.

            Each employee has one direct manager given in the manager array where manager[i] is the direct manager of the i-th employee,

            manager[headID] = -1. Also, it is guaranteed that the subordination relationships have a tree structure.

            The head of the company wants to inform all the company employees of an urgent piece of news.

            He will inform his direct subordinates, and they will inform their subordinates, and so on until all employees know about the urgent news.

            The i-th employee needs informTime[i] minutes to inform all of his direct subordinates

            (i.e., After informTime[i] minutes, all his direct subordinates can start spreading the news).

            Return the number of minutes needed to inform all the employees about the urgent news.
     */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Problem1376 {
    public static void main(String[] args) {
        int n = 15;
        int headID = 0;
        int[] manager = new int[]{-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6};
        int[] informTime = new int[]{1,1,1,1,1,1,1,0,0,0,0,0,0,0,0};
        int numOfMinutes = numOfMinutes(n, headID, manager, informTime);
        System.out.println(numOfMinutes);
    }
    static int timeNeeded = 0;
    public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (manager[i] == -1) {
                continue;
            }
            ArrayList<Integer> list;
            if (!graph.containsKey(manager[i])) {
                list = new ArrayList<>();
            } else {
                list = graph.get(manager[i]);
            }
            list.add(i);
            graph.put(manager[i], list);
        }
        calculateTime(headID, graph, informTime, 0);

        return timeNeeded;
    }

    private static void calculateTime(int headID, Map<Integer, ArrayList<Integer>> graph, int[] informTime, int t) {
        // base case for recursion
        if (informTime[headID] == 0) {
            return;
        }

        t = t + informTime[headID];
        ArrayList<Integer> temp = graph.get(headID);

        for (Integer integer : temp) {
            calculateTime(integer, graph, informTime, t);
            if (t > timeNeeded) {
                timeNeeded = t;
            }
        }
    }
}
