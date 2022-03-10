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
public class LRUCode<T> {


    public static class Node<T> {
        String key;

        T value;

        Node<T> prev;

        Node<T> next;

        public Node(String key, T value) {
            this.key = key;
            this.value = value;
        }
    }


    private final Map<String, Node<T>> nodeMap = new HashMap<>();

    /**
     * 默认5个容量
     */
    private int capacity = 5;

    /**
     * 头部
     */
    private Node<T> head = null;

    /**
     * 尾部
     */
    private Node<T> tail = null;

    public LRUCode(int capacity) {
        this.capacity = capacity;
    }

    public void put(String key, T value) {
        Node<T> node = nodeMap.get(key);
        if (Objects.nonNull(node)) {
            node.value = value;
            //删除这个元素
            remove(node);
            //放到链表头部
            appendHead(node);
        }
        //未超过容量
        else if (nodeMap.size() < capacity ) {
            Node<T> currentNode = new Node<>(key, value);
            appendHead(currentNode);
        }
        //超过容量
        else {
            //删除链表尾部元素
            Node<T> currentNode = new Node<>(key, value);
            nodeMap.remove(tail.key);
            remove(tail);
            appendHead(currentNode);
            nodeMap.put(currentNode.key, currentNode);
        }
    }

    private void appendHead(Node<T> node) {
        if (Objects.isNull(head)) {
            head = tail = node;
        } else {
            node.next = head;
            node.prev = null;
            head = node;
        }
    }


    public Node<T> get(String key) {
        Node<T> node = nodeMap.get(key);
        if (Objects.nonNull(node)) {
            return node;
        }
        return null;
    }

    private void remove(Node<T> node) {
        if (head == node) {
            head = head.next;
            head.prev = null;
            return;
        }
        if (tail == node) {
            tail = tail.prev;
            tail.next = null;
            return;
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
    }


    public static void main(String[] args) {

    }

}
