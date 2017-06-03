/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queue;

/**
 *
 * @author СЏС‡СЃС‡СЏСЃ
 * @param <T>
 */
public class LinkedListQueue<T> implements Queue<T> {

    private Node<T> top;
    private Node<T> bottom;
    private int size;

    public LinkedListQueue() {
        top = null;
        bottom = null;
        size = 0;
    }

    @Override
    public void enqueue(T value) {
        Node<T> temp = new Node<>(value);
        if (size == 0) {
            top = temp;
            bottom = temp;
        } else {
            bottom.setLink(temp);
            bottom = temp;
        }
        size++;
    }

    @Override
    public T dequeue() throws Exception {
        Node<T> temp = new Node<>(top.getValue());
        if (size > 0) {
            top = top.getLink();
            size--;
            return temp.getValue();
        } else {
            throw new Exception("The queue is empty");
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        top.setLink(null);
        bottom.setLink(null);
        size = 0;
    }

    @Override
    public String toString() {
        if (size > 0) {
            String res = "front [ ";
            Node<T> curr = top;
            while (curr != null) {
                res += curr.getValue() + " ";
                curr = curr.getLink();
            }
            return res + " ] back";
        } else {
            return "Queue is empty";
        }
    }
}
