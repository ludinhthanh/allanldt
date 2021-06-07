package binarytree;

import java.util.LinkedList;

class Node{
        int x;
        Node left,right;
        Node(){}
        Node(int x){
            this.x=x;
            left=right=null;
        }
    }
class Queue{
    LinkedList<Object> head;

    public Queue() {head = new LinkedList<>();}

    Queue(int i) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    public void enqueue(Object obj) {head.addLast(obj);}
    
    public boolean isEmpty() {return head.isEmpty();}
    
    public Object dequeue() 
     {if(isEmpty()) return null;
      else return head.removeFirst();
    }
    
    public Object front() 
    {if(isEmpty()) return null;
     else return head.getFirst();
    }
    
    public void clear() {head = null;}
}