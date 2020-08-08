package com.kuldeep.problems.tree;

import java.util.HashMap;
import java.util.Map;

public class TrieDictionary {
    private class TrieNode{
        Map<Character, TrieNode> children;
        boolean isEndofWord;

        TrieNode() {
            children = new HashMap<>();
            isEndofWord = false;
        }
    }
    TrieNode root = null;
    TrieDictionary(){
        root = new TrieNode();
    }

    public static void main(String args[]){
        TrieDictionary trieDictionary = new TrieDictionary();
        trieDictionary.insert("kuldeep");

        System.out.println(trieDictionary.serach("kul"));
        System.out.println(trieDictionary.serach("kuldeep"));
    }

    public void insert(String word){
        TrieNode current = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node==null){
                node= new TrieNode();
                current.children.put(ch, node);
            }
            current = node;
        }
        current.isEndofWord=true;
    }

    public boolean serach(String word){
        TrieNode current = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node==null){
                return false;
            }
            current = node;
        }
        return current.isEndofWord;
    }
}
