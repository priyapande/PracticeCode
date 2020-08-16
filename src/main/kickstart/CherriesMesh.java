package main.kickstart;
import java.util.*;
import java.io.*;

public class CherriesMesh {
}


class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter pw = new PrintWriter(System.out);
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int m = in.nextInt();
            for(int j=0;j<m;j++) {
                int a = in.nextInt();
                int b = in.nextInt();
            }
            int cal;
            if(m>=n-1) cal = n-1;
            else cal = m + 2*(n-m-1);
            pw.println("Case #" + i + ": " + cal);
        }
        pw.close();
    }
}