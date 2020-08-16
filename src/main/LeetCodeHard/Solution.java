package main.LeetCodeHard;
import java.util.*;

public class Solution {

        private int c;

        public int solution(int[] A) {
            if(A.length==0) return 0;
            if(A[0]==-1) return 1;
            c=0;
            dfs(0, A);
            return c;
        }

        private void dfs(int index, int[] A) {
            c++;
            if(A[index]==-1) {
                return;
            }
            dfs(A[index], A);
        }
}
