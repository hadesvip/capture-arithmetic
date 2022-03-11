package com.kevin.capture.arithmetic.samples.linked;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * LRU 实现
 * <p>
 * 常见的缓存策略：
 * 1. FIFO: 先进先出；
 * 2. LFU: 访问次数最少的剔除；
 * 3. LRU: 很长时间不使用的剔除；
 * <p>
 * LRU 实现：
 * HashMap + LinkedList
 *
 * @author kevin
 */
public class LRUCode{



    static class Node {

        Integer key;

        Integer value;

        Node prev;

        Node next;

        public Node(Integer key,Integer value){
            this.key = key;
            this.value = value;
        }
    }


    Map<Integer,Node> cacheNodeMap = new HashMap<>();

    /**
     * 默认5个长度
     */
    int capacity = 5;

    /**
     * 头部
     */
    private Node head = null;

    /**
     * 尾部
     */
    private Node tail = null;



    public LRUCode(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = cacheNodeMap.get(key);
        if (node == null){
            return -1;
        }
        // 存在，删除原节点，放入头节点
        else {
            remove(node);
            addHead(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        Node node = cacheNodeMap.get(key);
        int size = cacheNodeMap.size();
        //存在，更新数据
        if(node != null){
            node.value = value;
            remove(node);
            addHead(node);
        }
        // 未超过最大容量
        else if (size < capacity) {
            Node newNode = new Node(key,value);
            //放入头节点
            addHead(newNode);
            //添加缓存
            cacheNodeMap.put(key,newNode);
        }
        // 超过最大容量,剔除尾部节点，添加新节点到头部
        else {
            Node newNode = new Node(key,value);
            // 删除尾部节点缓存
            cacheNodeMap.remove(tail.key);
            // 删除尾部节点
            remove(tail);
            // 添加新节点到头部
            addHead (newNode);
            // 新节点加入缓存
            cacheNodeMap.put(key,newNode);
        }
    }


    void addHead(Node node){
        if(head == null){
            head = node;
            tail = node;
        } else {
            node.prev = node;
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    void remove(Node node){
        if (head == tail){
            head = null;
            tail = null;
        } else if (node == head) {
            head = head.next;
            node.prev = null;
        } else if (node == tail){
            tail = tail.prev;
            node.next = null;
        }
        // 其他节点
        else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
        }
    }

    /**
     * ["LRUCache","put","put","get","put","get","put","get","get","get"]
     * [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
     *
     */
    public static void main(String[] args) {
        LRUCode lruCode = new LRUCode(2);
        lruCode.put(1, 1);
        lruCode.put(2, 2);
        lruCode.put(3, 3);
        lruCode.get(2);
        lruCode.put(4, 4);
        lruCode.get(1);
        lruCode.get(3);
        lruCode.get(4);
    }



}
