// https://leetcode.com/problems/course-schedule-ii/
// using khan's algorithm for topological sorting

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class CourseScheduleII {

     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] prerequisites = {{1, 0}};
        int numCourses = 2;
        int[] courseOrder = findOrder(numCourses, prerequisites);
        for(int course: courseOrder) {
            System.out.println(course + " ");
        }
        sc.close();
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        Queue<Integer> q = new LinkedList<Integer>();
        List<Integer>[] adj = new ArrayList[numCourses]; 
        List<Integer>courseOrder = new ArrayList<Integer>();

        int[] indegree = new int[numCourses];
        int a, b;
        Arrays.fill(indegree, 0);


        for(int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        

        for(int i = 0; i < prerequisites.length; i++) {
            a = prerequisites[i][0];
            b = prerequisites[i][1];
            indegree[a]++;

            adj[b].add(a);
        }

        for(int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while(q.size() > 0) {

            int course = q.poll();
            courseOrder.add(course);

            for(int c: adj[course]) {
                indegree[c]--;

                if (indegree[c] == 0) {
                    q.add(c);
                }
            }
        }

        // topological sorting is not possible
        if (courseOrder.size() < numCourses) {
            return new int[0]; // returning empty array
        }

        return courseOrder.stream().mapToInt(Integer::intValue).toArray(); // convering arrayList<Integer> to array<int>.
    }
}
