package com.kevin.capture.arithmetic.samples.stack;

import java.util.Stack;


/**
 * 解法二: 复杂度(O(1))
 * 1. 采用两个栈：一个是输出栈、一个是输入栈
 * * 1.1 输出栈 pop、peek操作
 * * 2.2 输入栈 push操作
 *
 * @author kevin
 */
public class QueueByStack2<T> {

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