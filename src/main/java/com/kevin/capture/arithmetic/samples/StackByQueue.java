package com.kevin.capture.arithmetic.samples;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 使用队列实现栈
 * 思路：
 * 1. 提供push、pop方法
 * 1.1 pop的时候，需要将一个队列中元素移动到另一个队列中，然后弹出最后一个元素
 * 1.2 push的时候，只放入一个队列中
 * 2. 保证两个队列始终保持一个队列有数据
 *
 * @author kevin
 */
public class StackByQueue<T> {

    private final Queue<T> first = new LinkedList<>();
    private final Queue<T> second = new LinkedList<>();

    /**
     * 压栈
     *
     * @param value 值
     */
    public void push(T value) {
        if (!first.isEmpty()) {
            first.offer(value);
        } else {
            second.offer(value);
        }
    }

    public T pop() {
        if (first.isEmpty() && second.isEmpty()) {
            throw new EmptyStackException();
        }
        if (first.isEmpty() && !second.isEmpty()) {
            while (second.size() > 1) {
                first.offer(second.poll());
            }
            return second.poll();
        }
        if (!first.isEmpty() && second.isEmpty()) {
            while (first.size() > 1) {
                second.offer(first.poll());
            }
            return first.poll();
        }
        return null;
    }


    public static void main(String[] args) {
        StackByQueue<String> strStack = new StackByQueue<>();
        strStack.push("1");
        strStack.push("2");
        strStack.push("3");
        strStack.push("4");

        System.out.println(strStack.pop());
        System.out.println(strStack.pop());
        System.out.println(strStack.pop());
        System.out.println(strStack.pop());
        System.out.println(strStack.pop());

    }
}
