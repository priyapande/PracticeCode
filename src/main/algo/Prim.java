package main.algo;
import java.io.*;
import java.util.*;

public class Prim {
    public static void main(String[] args) throws Exception {
        PrintWriter  pw = new PrintWriter(System.out);
        Reader.init(System.in);
        int n = Reader.nextInt();
        int m = Reader.nextInt();
        Map<Integer, List<int[]>> map = new HashMap<>();
        for(int i=0;i<m;i++) {
            int a = Reader.nextInt();
            int b = Reader.nextInt();
            int w = Reader.nextInt();
            if(!map.containsKey(a)) map.put(a, new ArrayList<>());
            if(!map.containsKey(b)) map.put(b, new ArrayList<>());
            map.get(a).add(new int[]{b,w});
            map.get(b).add(new int[]{a,w});
        }
        // Prims algo
        boolean[] selected = new boolean[n+1];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(n2 -> n2[1]));
        Integer key = map.keySet().stream().findFirst().get();
        selected[key] = true;
        pq.addAll(map.get(key));
        int visited = 1; int cost=0;
        while(!pq.isEmpty() && visited<n) {
            int[] temp = pq.poll();
            if(!selected[temp[0]]) {
                selected[temp[0]] = true;
                visited++;
                cost = cost+temp[1];
                if(map.containsKey(temp[0])) {
                    for(int[] arr: map.get(temp[0])) {
                        if(!selected[arr[0]]) pq.offer(arr);
                    }
                }
            }
        }
        pw.println(cost);
        pw.close();
    }
}

class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /**
     * call this method to initialize reader for InputStream
     */
    static void init(InputStream input) {
        reader = new BufferedReader(
                new InputStreamReader(input));
        tokenizer = new StringTokenizer("");
    }

    /**
     * get next word
     */
    static String next() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                    reader.readLine());
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static long nextLong() throws IOException {
        return Long.parseLong(next());
    }
}