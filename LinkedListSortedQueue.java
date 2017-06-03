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
public class LinkedListSortedQueue<T extends Comparable> implements SortedQueue<T> {

    private Node<T> front;

    private int size;

    public LinkedListSortedQueue() {
        front = null;

        size = 0;
    }

   @Override
    public void insert(Comparable value) {
        Node<T> newNode = new Node(value);

        if(size == 0) {
            front = newNode;
        } else {
            // newNode goes before front 
            if(value.compareTo(front.getValue()) <= 0) {
                newNode.setLink(front);
                front = newNode;
           
            }else{
                Node<T> temp = front;
                if(size==1){
                    front.setLink(temp);
                }else{
                while(value.compareTo(temp.getLink().getValue())>0){  
                      temp=temp.getLink();
                }
                    if(temp.getLink()==null){
                        temp.setLink(newNode);
                        
                    }
                    newNode.setLink(temp.getLink());
                    temp.setLink(newNode);
                    
                    
                
                }
            }
        }

        size++;
    }
    @Override
    public T dequeue() throws Exception {
        Node<T> temp = new Node<>(front.getValue());
        if (size > 0) {
            front = front.getLink();
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
        front.setLink(null);

        size = 0;
    }

    public String toString() {
        if (size > 0) {
            String res = "front [ ";
            Node<T> curr = front;
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
