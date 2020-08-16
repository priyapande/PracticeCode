package main.LeetCodeMedium;

import org.junit.Test;

import java.util.*;

public class OpenLock {
    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        List<String> deadEnds = new ArrayList<>();
        Collections.addAll(deadEnds, deadends);
        if (deadEnds.contains(target) || deadEnds.contains("0000")) return -1;
        if(target.equalsIgnoreCase("0000")) return 0;
        queue.add("0000");
        int level = 0;
        while (true) {
            int nodeInLevel = queue.size();
            if (nodeInLevel == 0) return -1;
            while (nodeInLevel > 0) {
                String t = queue.poll();
                if (target.equalsIgnoreCase(t)) return level;
                if (!deadEnds.contains(t)) {
                    for (int i = 0; i < 4; i++) {
                        char ch = t.charAt(i);
                        String next = t.substring(0, i) + (ch == '9' ? '0' : ch - '0' + 1) + t.substring(i + 1);
                        String next2 = t.substring(0, i) + (ch == '0' ? '9' : ch - '0' - 1) + t.substring(i + 1);
                        if(!deadEnds.contains(next)) queue.add(next);
                        if(!deadEnds.contains(next2)) queue.add(next2);
                    }
                    deadEnds.add(t);
                }
                nodeInLevel--;
            }
            level++;
        }
    }

    @Test
    public void shouldGiveMinStepToOpenLock() {
        String[] deadends = {"8888"};
        String target = "0009";
        int ans = openLock(deadends, target);
    }
}
