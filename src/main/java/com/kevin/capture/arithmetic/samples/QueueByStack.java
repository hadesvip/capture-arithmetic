package com.kevin.capture.arithmetic.samples;

import java.util.Stack;

/**
 * 通过栈实现队列 思路:
 * <p>
 * 方案一：复杂度(O(n))
 * 1.采用两个栈：一个是数据栈、一个是临时栈
 * 2.提供push、pop、peek、empty方法 2.1 push的时候将数据放入到数据栈中，
 * 2.2执行pop和peek的时候移动到临时栈中，执行完毕后，还需要将临时栈中的数据移动到数据栈中
 * <p>
 *
 * @author kevin
 */
public class QueueByStack<T> {

    /**
     * 数据栈
     */
    private final Stack<T> data = new Stack<>();

    /**
     * 临时栈
     */
    private final Stack<T> temp = new Stack<>();


    public void push(T value) {
        data.push(value);
    }

    public T peek() {
        while (!data.empty()) {
            temp.push(data.pop());
        }
        //临时栈栈顶数据
        T value = temp.peek();
        while (!temp.empty()) {
            data.push(temp.pop());
        }
        return value;
    }

    public T pop() {
        while (!data.empty()) {
            temp.push(data.pop());
        }
        //临时栈栈顶数据
        T value = temp.pop();
        while (!temp.empty()) {
            data.push(temp.pop());
        }
        return value;
    }


    public boolean empty() {
        return data.isEmpty();
    }


    public static void main(String[] args) {
        QueueByStack<String> queue = new QueueByStack<>();
        queue.push("1");
        queue.push("2");
        queue.push("3");
        queue.push("4");
        queue.push("5");

//        System.out.println(queue.pop());
//        System.out.println(queue.pop());
//        System.out.println(queue.pop());
//        System.out.println(queue.pop());
//        System.out.println(queue.pop());
//        System.out.println(queue.pop());

        QueueByStack<String> queue2 = new QueueByStack<>();
        queue2.push("1");
        queue2.push("2");
        queue2.push("3");
        queue2.push("4");
        queue2.push("5");

        System.out.println(queue2.pop());
        System.out.println(queue2.pop());
        System.out.println(queue2.pop());
        System.out.println(queue2.pop());
        System.out.println(queue2.pop());
        System.out.println(queue2.pop());

    }

}

/**
 * 解法二: 复杂度(O(1))
 * * 1. 采用两个栈：一个是输出栈、一个是输入栈
 * * 1.1 输出栈 pop、peek操作
 * * 2.2 输入栈 push操作
 *
 * @param <T>
 */
class QueueByStack2<T> {

    /**
     * 输入栈
     */
    private final Stack<T> input = new Stack<>();

    /**
     * 输出栈
     */
    private final Stack<T> output = new Stack<>();

    public void push(T value) {
        input.push(value);
    }

    public T peek() {
        if (output.empty()) {
            while (!input.empty()) {
                output.push(input.pop());
            }
        }
        return output.peek();
    }

    public T pop() {
        if (output.empty()) {
            while (!input.empty()) {
                output.push(input.pop());
            }
        }
        return output.pop();
    }


    public boolean empty() {
        return input.isEmpty() && output.empty();
    }

}
