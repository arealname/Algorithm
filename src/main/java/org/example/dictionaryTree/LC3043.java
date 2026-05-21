package org.example.dictionaryTree;

public class LC3043 {

    class Trie{
        Trie[]children;
        boolean isEnd;

        public Trie(){
            children = new Trie[10];
            isEnd = false;
        }
    }

    Trie root;

    public void insert(int num){
        Trie node = root;
        String s = String.valueOf(num);
        for(char c : s.toCharArray()){
            int idx = c - '0';
            if(node.children[idx] == null){
                node.children[idx] = new Trie();
            }
            node = node.children[idx];
        }
        node.isEnd = true;
    }

    public int search(int num){
        Trie node = root;

        //返回最长公共前缀的长度

        String s = String.valueOf(num);
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            int idx = c - '0';
            if(node.children[idx] == null){
                return i;
            }
            node = node.children[idx];
        }
        return s.length();
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {

        root = new Trie();

        for(int num : arr1){
            insert(num);
        }
        int ans=0;
        for(int num : arr2){
            ans=Math.max(ans, search(num));
        }
        return ans;
    }
}
