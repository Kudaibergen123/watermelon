/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queue;

/**
 *
 * @author User
 * @param <T>
 */
public class LLQueueSet<T> implements Set<T> {
    LinkedListQueue<T> q = new LinkedListQueue();
    
    @Override
    public void add(T value) {
        
       boolean rep = false;
       for(int i=0; i<q.getSize(); i++){
           try{
           T x = q.dequeue();
           if(x.equals(value))rep=true;
           q.enqueue(x);
               
           }catch(Exception ex){    
           }   
       }
       if(rep==false) q.enqueue(value);
    
    
    }
    @Override
    public boolean contains(T value) {
         for(int i=0; i<q.getSize(); i++){
           try{
           T x = q.dequeue();
           q.enqueue(x);
           if(x.equals(value))return true;
           
           }catch(Exception ex){    
           }   
       }
         return false;
    }

    @Override
    public boolean remove(T value) {
        for(int i=0; i<q.getSize(); i++){
           try{
           T x = q.dequeue();
          
           if(x.equals(value)){
               
               return true;
           }
            q.enqueue(x);
           }catch(Exception ex){    
           }   
       }
         return false;
    } 

    @Override
    public T removeAny() throws Exception {
         return q.dequeue(); }

    @Override
    public int getSize() {
    return q.getSize();
    }

    @Override
    public void clear() {
      q=null;
    }
    @Override
    public String toString() {
    String result = "[";
     for(int i=0; i<q.getSize(); i++){
           try{
           T x = q.dequeue();
            q.enqueue(x);
            result = result + x + " ";
           }catch(Exception ex){    
           }   
       }
     return result + "]";
    }
    
    }

   


    
    
//    private Node<T> front;
//    private Node<T> back;
//    private int size;
//    
//    public LLQueueSet(){
//        front = null;
//        back = null;
//        size = 0;
//    }
//    @Override
//    public void add(T value) {
//        if(size == 0){
//            Node<T> newNode = new Node(value);
//            front=newNode;
//            back=newNode;
//            size++;
//        }else{
//            Node<T> temp = front;
//            boolean rep = false;
//            for(int i=0; i<size; i++){
//                if(temp.getValue() == value){
//                    rep = true;
//                }
//                temp = temp.getLink();
//            }
//            if(rep == false){
//              Node<T> newNode = new Node(value);
//              back.setLink(newNode);
//              back=newNode;
//              size++;
//            }
//        }
//        
//      }

