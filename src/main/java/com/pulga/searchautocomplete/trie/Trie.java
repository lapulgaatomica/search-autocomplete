package com.pulga.searchautocomplete.trie;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
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

    public int count(String word){
        TrieNode node = searchPrefix(word);
        if(node != null){
            return node.getCount();
        }
        return 0;
    }

    public Optional<Queue<String>> getWords(String prefix) {
        TrieNode trieNode = searchPrefix(prefix);
        if (trieNode != null) {
            Queue<String> words = new PriorityQueue<>(Comparator.comparingInt(this::count));
            addAllWords(trieNode, prefix, words);
            return Optional.of(words);
        }
        return Optional.empty();
    }

    private void addAllWords(TrieNode node, String word, Queue<String> words){
        if (node.isEnd()) {
            if(words.size() < 5){
                words.add(word);
            }else{
                if(!words.contains(word)){
                    TrieNode tempNode = searchPrefix(words.peek());
                    if( tempNode.getCount() < node.getCount()){
                        words.poll();
                        words.add(word);
                    }
                }else{
                    words.add(words.poll());
                }
            }
        }
        for(int index = 0;index < 26;index++){
            TrieNode next = node.get((char)(index + 'a'));
            if (next != null) {
                addAllWords(next, word + (char)(index + 'a'), words);
            }
        }
    }
}
