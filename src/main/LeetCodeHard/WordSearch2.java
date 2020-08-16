package main.LeetCodeHard;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class WordSearch2 {
    private List<String> ans;

    public List<String> findWords(char[][] board, String[] words) {
        ans = new ArrayList<>();
        if (board.length == 0 || board[0].length == 0 || words.length == 0)
            return ans;

        Trie root = constructTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; i++) {
                Trie p = root;
                dfs(i, j, board.length, board[0].length, board, p);
            }
        }
        return ans;
    }

    private boolean dfs(int i, int j, int m, int n, char[][] board,
                        Trie root) {
        if (!isValid(i, j, m, n)) return false;

        char c = board[i][j];
        if (c == '$' || root.arr[c - 'a'] == null) return false;
        root = root.arr[c - 'a'];
        board[i][j] = '$';
        if (root.word != null) {
            ans.add(root.word);
            root.word = null;
        }
        boolean res = dfs(i + 1, j, m, n, board, root) ||
                dfs(i, j + 1, m, n, board, root) ||
                dfs(i - 1, j, m, n, board, root) ||
                dfs(i, j - 1, m, n, board, root);
        board[i][j] = c;
        return res;
    }

    private boolean isValid(int x, int y, int m, int n) {
        return (x >= 0 && y >= 0 && x < m - 1 && y < n - 1);
    }

    private Trie constructTrie(String[] words) {
        Trie root = new Trie();
        for (String s : words) {
            Trie t = root;
            for (char c : s.toCharArray()) {
                if (t.arr[c - 'a'] == null) t.arr[c - 'a'] = new Trie();
                t = t.arr[c - 'a'];
            }
            t.word = s;
        }
        return root;
    }

    @Test
    public void shouldSearchWords() {
        char[][] board = new char[][]{{'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}};
        String[] words = new String[]{"oath","pea","eat","rain"};
        System.out.println(findWords(board, words).size());
    }
}

class Trie {
    Trie[] arr = new Trie[26];
    String word;
}