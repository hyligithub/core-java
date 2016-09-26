package com.core.collection.linkedlist;

import java.util.LinkedList;

/**
 * Created by lihuiyan on 2016/9/26.
 */
public class LinkedListTest {
    public static void main(String[] args) {
        testLinkedListAPI();
        testLinkedListAsStack();
        testLinkedListAsQueue();
    }

    private static void testLinkedListAPI() {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add(1, "a");
        System.out.println(list.toString());
        //将10 添加到第一个位置，失败则抛异常
        list.addFirst("10");
        System.out.println(list.toString());
        //删除第一个元素，失败则抛异常
        list.removeFirst();
        System.out.println(list.toString());
        //获取第一个元素，失败则抛异常
        String first = list.getFirst();
        System.out.println(first + "---" + list.toString());

        System.out.println("\nTest \"offerFirst(), pollFirst(), peekFirst()\"");
        //将10 添加到第一个位置，返回true
        list.offerFirst("10");
        System.out.println(list);
        //删除第一个元素，失败的话返回null
        System.out.println(list.pollFirst() + "--" + list);
        //返回第一个元素，失败的话返回null
        System.out.println(list.peekFirst() + "--" + list);

        System.out.println("\nTest \"addLast(), removeLast(), getLast()\"");
        list.addLast("20");//20加到队列最后，失败的话抛异常
        System.out.println(list);
        //删除最后一个元素，失败的话抛异常
        System.out.println(list.removeLast() + "***" + list);
        //获取最后一个元素，失败的话抛异常
        System.out.println(list.getLast() + "****" + list);

        System.out.println("\nTest \"offerLast(), pollLast(), peekLast()\"");
        list.offerLast("20");//20添加到最后一个位置，返回true
        System.out.println(list);
        //删除最后一个元素，失败的话返回null
        System.out.println(list.pollLast() + "***" + list);
        //获取最后一个元素，失败的话返回null
        System.out.println(list.peekLast() + "****" + list);
        //第三个位置设置成300，不建议这么操作，效率低
        System.out.println(list.set(2, "300") + "***" + list);
        //获取索引为3的元素，不建议这么搞，效率低
        System.out.println(list.get(3));
        //toArray(T[] a) list 转化为数组，这种方式最常用
        String[] strArray = (String[]) list.toArray(new String[0]);
        for (String s : strArray) {
            System.out.println(s);
        }

        System.out.println(list.size());
        list.clear();
        System.out.println(list.isEmpty());
    }

    //list 作为 栈  ,FILO
    private static void testLinkedListAsStack() {
        LinkedList<String> stack = new LinkedList<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        System.out.print(stack);
        //取栈顶元素，并删除之
        System.out.println(stack.pop() + "***" + stack);
        //出栈
        System.out.println(stack.peek() + "***" + stack);
    }

    //  likedlist 作为队列 FIFO
    private static void testLinkedListAsQueue() {
        LinkedList<String> queue = new LinkedList<>();
        queue.add("a");
        queue.add("b");
        queue.add("c");
        queue.add("d");
        System.out.println(queue);
        //删除队列第一个元素
        System.out.println(queue.remove() + "***" + queue);
        //读取队列第一个元素
        System.out.println(queue.element());
    }
}
