package com.exec.linkedlist;

/**
 *
 * @author： <a href="mailto:wangfei@tianyancha.com">wangfei</a>
 * @date: 2021/10/19
 * @version: 1.0.0
 */
public class Node {

    //特殊处理：这里都使用public属性 方便直接点便于理解
    //data
    public int id;
    public String name;
    //next
    public Node next;

    //构造器
    public Node(int id) {
        this.id = id;
    }

    public Node(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Node(int id, String name, Node next) {
        this.id = id;
        this.name = name;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" + "id=" + id + ", name='" + name + '\'' + "}";
    }

}

