package com.pulga.searchautocomplete.trie;

public class TrieTest {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("dab");//1
        trie.insert("dead");
        trie.insert("dead");//2
        trie.insert("deed");
        trie.insert("deed");
        trie.insert("deed");//3
        trie.insert("die");
        trie.insert("die");
        trie.insert("die");
        trie.insert("die");//4
        trie.insert("dim");
        trie.insert("dim");
        trie.insert("dim");
        trie.insert("dim");
        trie.insert("dim");//5
        trie.insert("do");
        trie.insert("do");
        trie.insert("do");
        trie.insert("do");
        trie.insert("do");
        trie.insert("do");//6
        trie.insert("don");
        trie.insert("don");
        trie.insert("don");
        trie.insert("don");
        trie.insert("don");
        trie.insert("don");
        trie.insert("don");//7

        System.out.println(trie.getWords("d"));
    }
}
