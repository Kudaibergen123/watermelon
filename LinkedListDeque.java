/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queue;

/**
 *
 * @author User
 */
public class LinkedListDeque<T> implements Deque<T> {
      private DoublyLinkedNode<T> front;
    private DoublyLinkedNode<T> back;
    private int size;

    public LinkedListDeque() {
        front = null;
        back = null;
        size = 0;
    }
@Override
    public void pushToFront(T value) {
        DoublyLinkedNode<T> newNode = new DoublyLinkedNode(value);
        if(size==0){
            front=newNode;
            back=newNode;
        }
        else{
            front.setPrevious(newNode);
            newNode.setNext(front);
            newNode=front;
            
        }
        size++;
     }

    @Override
    public void pushToBack(T value) {
        DoublyLinkedNode<T> newNode = new DoublyLinkedNode(value);
         if(size==0){
            front=newNode;
            back=newNode;
        }
        else{
            back.setNext(newNode);
            newNode.setPrevious(back);
            back=newNode;
            
        }
         size++;
    }

    @Override
    public T popFromFront() throws Exception {
        if(size==0) throw new Exception("Nothing to throw");
        T result = front.getValue();
        if(size==1) {
            front=null;
            back=null;
        }
        else{
            front=front.getNext();
            front.setPrevious(null);         
        }
        
     return result;   
    }

    @Override
    public T popFromBack() throws Exception {
        if (size == 0) {
            throw new Exception("Queue underflow!");
        }
        T x = back.getValue();
        if (size == 1) {
            front = null;
            back = null;
        } else {
            back = back.getPrevious();
            back.setNext(null);
        }
        size--;
        return x;
    }
    

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
//        front.setLink(null);
//        back.setLink(null);
//        size = 0;
    }

    public String toString() {
        if (size > 0) {
            String res = "front [ ";
            DoublyLinkedNode<T> curr = front;
            while (curr != null) {
                res += curr.getValue() + " ";
                curr = curr.getNext();
            }
            return res + " ] back";
        } else {
            return "Queue is empty";
        }
    }

    
    
}
