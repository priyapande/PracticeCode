package main.algo;
import java.io.*;
import java.util.*;

public class Kruskal {
    public static void main(String[] args) throws Exception {
        PrintWriter  pw = new PrintWriter(System.out);
        Reader.init(System.in);
        int n = Reader.nextInt();
        int m = Reader.nextInt();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(n2 -> n2[0]));
        for(int i=0;i<m;i++) {
            int a = Reader.nextInt();
            int b = Reader.nextInt();
            int w = Reader.nextInt();
            pq.add(new int[]{w,a,b});
        }
        int visited=1; int cost=0;
        UnionFind uf = new UnionFind(n);
        while(!pq.isEmpty() && visited<n) {
            int[] temp = pq.poll();
            if(uf.find(temp[1])!=uf.find(temp[2])) {
                cost += temp[0];
                visited++;
                uf.union(temp[1], temp[2]);
            }
        }
        pw.println(cost);
        pw.close();
    }
}

class UnionFind {
    private int[] parent;

    UnionFind(int n) {
        parent = new int[n+1];
        for(int i=0;i<=n;i++) parent[i] = i;
    }

    int find(int root) {
        while(parent[root]!=root) {
            root=parent[root];
        }
        return parent[root];
    }

    void union(int x, int y) {
        int p = find(x);
        int q = find(y);
        parent[p] = parent[q];
    }
}