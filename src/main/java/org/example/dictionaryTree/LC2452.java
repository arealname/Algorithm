package org.example.dictionaryTree;

import java.util.List;

public class LC2452 {
    //把dictionary中的单词构建成字典树

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord;

        TrieNode() {
            isWord = false;
        }

        public void insert(String word) {
            TrieNode node = this;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.isWord = true;
        }

        public boolean search(String word) {
            TrieNode node = this;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    return false;
                }
                node = node.children[index];
            }
            return node.isWord;
        }


    }


    public List<String> twoEditWords(String[] queries, String[] dictionary) {

        List<String> ans = new java.util.ArrayList<>();

        TrieNode root = new TrieNode();

        for (String word : dictionary) {
            root.insert(word);
        }

        for (String query : queries) {
            if (dfs(root, query.toCharArray(), 0, 0)) {
                ans.add(query);
            }
        }

        return ans;

    }

    public boolean dfs(TrieNode node, char[] word, int index, int edits) {
        if (edits > 2) return false;
        if (index == word.length) return node.isWord;

        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                if (dfs(node.children[i], word, index + 1, edits + (i != word[index] - 'a' ? 1 : 0))) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        LC2452 solution = new LC2452();
        String[] queries = {"hello", "hallo", "hella"};
        String[] dictionary = {"hello", "hallo", "hella", "helloo"};
        List<String> result = solution.twoEditWords(queries, dictionary);
        System.out.println(result); // 输出: ["hello", "hallo", "hella"]
    }

}


