package com.kevin.capture.arithmetic.samples.linked;

import java.util.Objects;

/**
 * 链表反转
 *
 * @author kevin
 */
public class ReverseCode {


  /**
   * 单向链表
   */
  private static class Node<T> {

    T data;

    Node<T> next;

    public Node(T data, Node<T> next) {
      this.data = data;
      this.next = next;
    }
  }

  private static void println(Node head) {
    Node current = head;
    while (Objects.nonNull(current)) {
      System.out.println(current.data);
      current = current.next;
    }
  }


  /**
   * 方案一
   */
  private static <T> Node reverse(Node<T> head) {
    //新链表的头节点
    Node<T> reverse = null;
    //备份当前节点的下一个节点
    Node<T> next = null;
    while (Objects.nonNull(head)) {
      next = head.next;
      head.next = reverse;
      reverse = head;
      head = next;
    }
    return reverse;
  }

  public static void main(String[] args) {
    Node<String> tail = new Node<>("5", null);
    Node<String> node3 = new Node<>("4", tail);
    Node<String> node2 = new Node<>("3", node3);
    Node<String> node1 = new Node<>("2", node2);
    Node<String> head = new Node<>("1", node1);
    ReverseCode.println(head);
    System.out.println("===========华丽的分隔线=============");

    Node<String> reverse = ReverseCode.reverse(head);
    println(reverse);
  }

}
