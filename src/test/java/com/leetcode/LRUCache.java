package com.leetcode;

import com.leetcode.string.OpString;

import java.util.HashMap;

public class LRUCache {

    class Node{
        int key;
        int value;
        Node pre;
        Node next;

        Node(){
        }
        Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }
    HashMap<Integer,Node> map = new HashMap<>();
    Node head,tail;
    int size;

    public void addFirst(Node node){
        node.next = head.next;
        node.next.pre = node;

        head.next = node;
        node.pre = head;
        map.put(node.key,node);
    }
    public void removeLast(){
        if(size > 0){
            Node removeNode = tail.pre;
            removeNode.pre.next = tail;
            tail.pre = removeNode.pre;
            map.remove(removeNode.key);
        }
    }
    public void remove(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;

        map.remove(node.key);
    }
    public void getAndAddFirst(int key, int value){
        Node node = map.get(key);

        remove(node);

        addFirst(new Node(key,value));

    }


    public LRUCache(int capacity) {
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.pre = head;
        size = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.pre.next = node.next;
            node.next.pre = node.pre;
            addFirst(node);
            return node.value;
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {

        Node node = new Node(key,value);
        if(map.containsKey(key)){
            getAndAddFirst(key,value);
        }else{
            if(size <= map.size()){
                removeLast();
            }
            addFirst(node);
            map.put(key,node);
        }
    }

    public static void main(OpString[] args) {
        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        cache.get(2);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        cache.get(1);       // 返回 -1 (未找到)
        cache.get(3);       // 返回  3
        cache.get(4);       // 返回  4

    }
}
