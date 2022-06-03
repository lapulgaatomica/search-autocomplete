package com.pulga.searchautocomplete.trie;

public class TrieTest {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("dele");
        trie.insert("dele");
        trie.insert("dream");
        trie.insert("dream");
        trie.insert("dream");
        trie.insert("deal");
        trie.insert("deal");
        trie.insert("deal");
        System.out.println(trie.getWords("d"));
    }
}
