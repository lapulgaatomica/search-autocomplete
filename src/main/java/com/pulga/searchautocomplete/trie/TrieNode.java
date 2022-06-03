package com.pulga.searchautocomplete.trie;

public class TrieNode {
    private final TrieNode[] links;
    private boolean isEnd;
    private int count;

    public TrieNode(){
        links = new TrieNode[26];
    }

    public boolean containsKey(char ch){
        return links[ch - 'a'] != null;
    }

    public TrieNode get(char ch){
        return links[ch - 'a'];
    }

    public void put(char ch, TrieNode node){
        links[ch - 'a'] = node;
    }

    public void setEnd(){
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for(int index = 0; index < 26; index++){
            TrieNode next = links[index];
            if (next != null) {
                stringBuilder.append((char)(index + 'a'));
            }
        }
        return stringBuilder.toString();
    }


}
