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
public class LLQueueMap<K, V> implements Map<K, V> {

    private Queue<KeyValuePair<K, V>> pairs;

    public LLQueueMap() {
        pairs = new LinkedListQueue();
    }
    
    @Override
    public void define(K key, V value) {
        KeyValuePair<K, V> x;
        int y = 0;
        for (int i = 0; i < pairs.getSize(); i++) {
            try {
                x = pairs.dequeue();
                
                if (x.getKey() == key) {
                    x.setValue(value);
                    y++;
                }
                pairs.enqueue(x);
            } catch (Exception ex) {
                System.out.println("Error in dequeue");
            }
        }
        if (y == 0) {
            pairs.enqueue(new KeyValuePair(key,value));
        }
        
    }

    @Override
    public V getValue(K key) {
    KeyValuePair<K, V> x;
        for (int i = 0; i < pairs.getSize(); i++) {
            try {
                x = pairs.dequeue();
                pairs.enqueue(x);
                if (x.getKey() == key) {
                   return x.getValue();
                   
                }
                
            } catch (Exception ex) {
                System.out.println("Error dequeue");
            }
    }
        return null;
    }
    
    @Override
    public V remove(K key) {
         KeyValuePair<K, V> x;
        for (int i = 0; i < pairs.getSize(); i++) {
            try {
                x = pairs.dequeue();
                
                if (x.getKey() == key) {
                    
                   return x.getValue();
                   
                }
                pairs.enqueue(x);
            } catch (Exception ex) {
                System.out.println("Error dequeue");
            }
    }
        return null;
        }
    
    @Override
    public KeyValuePair<K, V> removeAny() throws Exception {
       return pairs.dequeue();
    }
    
    @Override
    public int getSize() {
      return pairs.getSize();  }
    
    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
