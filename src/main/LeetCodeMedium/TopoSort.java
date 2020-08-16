package main.LeetCodeMedium;

import org.junit.Test;

import java.util.*;

public class TopoSort {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int i,u,v;
        int edges = prerequisites.length;
        Graph g = new Graph(numCourses);
        for(i=0;i<edges;i++) {
            u = prerequisites[i][0];
            v = prerequisites[i][1];
            g.addEdge(u, v);
        }

        boolean[] visited = new boolean[numCourses];
        for(Map.Entry<Integer, List<Integer>> entry: g.adj.entrySet()) {
            if(!dfs(g, entry.getKey(), visited)) return false;
        }
        return true;
    }

    public boolean dfs(Graph g, int v, boolean[] visited) {
        visited[v] = true;
        for(Integer u: g.adj.get(v)) {
            if(!visited[u])
                return dfs(g,u,visited);
            else return false;
        }
        return true;
    }

    @Test
    public void shouldSort() {
        int[][] prereq = {{1,0}};
        System.out.println(canFinish(2, prereq));
    }
}

class Graph {
    public Map<Integer, List<Integer>> adj; //Adjacency List

    // Constructor
    Graph(int v) {
        // No. of vertices
        adj = new HashMap<>();
        for (int i = 0; i < v; ++i)
            adj.put(i, new ArrayList<>());
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj.get(v).add(w);
    }
}