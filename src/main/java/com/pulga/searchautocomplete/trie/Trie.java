package com.pulga.searchautocomplete.trie;

import java.util.*;
import java.util.stream.Collectors;

public class Trie {
    private final TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode node = root;

        for(int i = 0; i < word.length(); i++){
            char currentChar = word.charAt(i);
            if(!node.containsKey(currentChar)){
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
        node.setCount(node.getCount() + 1);
    }

    private TrieNode searchPrefix(String word){
        TrieNode node = root;

        for(int i = 0; i < word.length(); i++){
            char curLetter = word.charAt(i);
            if(node.containsKey(curLetter)){
                node = node.get(curLetter);
            }else{
                return null;
            }
        }
        return node;
    }

    public boolean search(String word){
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    public boolean startsWith(String prefix){
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    public int count(String word){
        TrieNode node = searchPrefix(word);
        if(node != null){
            return node.getCount();
        }
        return 0;
    }

    public Queue<String> getWords(String prefix) {
        TrieNode trieNode = searchPrefix(prefix);
        if (trieNode != null) {
            Queue<String> heap = new PriorityQueue<>(Comparator.comparingInt(this::count).reversed());
            List<String> words = new ArrayList<>();
            addAllWords(trieNode, prefix, heap);
            return heap;
        }
        return null;
    }

    private void addAllWords(TrieNode node, String word, Queue<String> words){
        if (node.isEnd()) {
            words.add(word);
        }
        for(int index = 0;index < 26;index++){
            TrieNode next = node.get((char)(index + 'a'));
            if (next != null) {
                addAllWords(next, word + (char)(index + 'a'), words);
            }
        }
    }

//    public List<String> getWords(String prefix) {
//        TrieNode trieNode = searchPrefix(prefix);
//        if (trieNode != null) {
//            Queue<TrieNode> heap = new PriorityQueue<>((node1, node2) -> Integer.compare(node2.getCount(), node1.getCount()));
//            addAllWords(trieNode, prefix, heap);
//            return heap.stream().map(this::getString).collect(Collectors.toList());
//        }
//        return null;
//    }
//
//    private void addAllWords(TrieNode node, String word, Queue<TrieNode> words) {
//        if (node.isEnd()) {
//            words.add(node);
//        }
//
//        for(int index = 0; index < 26; index++){
//            TrieNode next = node.get((char)(index + 'a'));
//            if (next != null) {
//                addAllWords(next, word + (char)(index + 'a'), words);
//            }
//        }
//    }
//
//    public String getString(TrieNode node){
//        StringBuilder stringBuilder = new StringBuilder();
//        for(int index = 0; index < 26; index++){
//            TrieNode next = node.get((char) (index + 'a'));
//            if (next != null) {
//                stringBuilder.append((char)(index + 'a'));
//            }
//        }
//        return stringBuilder.toString();
//    }
}
