package linklist;
import java.util.LinkedList;
class Node
{
    int data;           //Chua du lieu
    Node next;          //Chua dia chi node tiep theo
    Node (){}           //Ham dung de Khoi tao 1 node rong
    Node(int x)         //Ham dung co tham so Khoi tao 1 node chua co gia tri x
    {
        data = x;         //Dua x vao phan data cua node
        next = null;      //Node moi tao nen khong chua dia chi cua ai ca                  
    }
}

public class LinkList {
    Node head, tail;      //2 con tro chua dia chi node dau tien va node cuoi cung 
    LinkList()            //Ham dung de khoi tao DSLK rong
    {
        head = tail = null;
    
    }                     //Khoi tao DS rong
    void AddFirst(int x)
    {
       Node P = new Node(x);
       if(head == null)
           head = tail = P;
       else
       {
           P.next = head;
           head = P;
       }
    }
    void AddLast(int x)
    {
        Node P = new Node(x);
        if(head == null)
            head = tail =P;
        else 
        {
            tail.next = P;
            tail = P;
        }
    }
    void DelFirst()
    {
        head=head.next;     //di chuyen qua node tiep theo
    }
    void DelLast()
    {
        Node P = head;
        while(P.next != tail)
            P = P.next;
        
        tail = P;
        tail.next = null;
    }
    void Traversal()
    {
        Node P = head;
        while(P != null)
        {
            System.out.print(P.data+" ");
            P = P.next;
        }
    }
    int Find(int x)
    {   
        int c = -1;
        Node P = head;
      while(P != null && P.data != x) 
      {
          c++;
          P = P.next;
      }
      if(P == null)
          return -1;
      else
          return c;
    }
    int count()
    {
        int c =0;
        Node P = head;
        while(head != null)
        {
            c++;
             P = P.next;
        }
        return c;
    }
    Node Search(int n)
    {
        int c =0;
        Node P = head;
        while(P != null && c < n)
        {
            c++;
            P= P.next;
        }
        return P;
    }
    void InsertAt(int x, int n)
    {
        Node P = new Node(x);
                if (n <= 0)
                    AddFirst(x);
                else
                    if (n > count())
                        AddLast(x);
                else
                    {
                        Node Q = Search(n-1);
                        P.next = Q.next;
                        Q.next = P;
                        if(Q==tail)
                                tail = P;
        }
    }
     void insert(int x, int n){
        int k=1;
        System.out.println("Insert "+x+" at "+n);
        if (n == 0||head==null){
            AddFirst(x);
            return;
        }
        Node p=head;
        while(p!=null&&k<n){
            p=p.next;
            ++k;
        }
        Node B= new Node(x);
        B.next=p.next;
        p.next=B;
    }
    void delAt( int n){
        System.out.println("Delete at "+n);
        if (n==0||head==null||head.next==null){
            DelFirst();
            return;
        }
        int k=1;
        Node p = head;
        while (p.next.next!=null&k<n){
            p=p.next;
            k++;
        }
        p.next=p.next.next;
    }  
    void DeleteAt(int n)
    {
        
                if (n <= 0)
                    DelFirst();
                else
                    if (n >= count())
                        DelLast();
                else
                    {
                        Node Q = Search(n-1);
                        //Node P = Search(n);
                        Q.next =Q.next.next;
                    }
    }
    public static void main(String[] args) {
    LinkList L =new LinkList();
    L.AddFirst(1);L.AddFirst(2);L.AddFirst(3);L.AddFirst(4);L.AddFirst(5);
    System.out.println("DS vua nhap:");
    L.Traversal();
    L.AddLast(4);
    System.out.println("\nDS sau khi them 4 vao cuoi:");
    L.Traversal();
    L.DelFirst();
    System.out.println("\nDS sau khi xoa:");
    L.Traversal();
    L.DelLast();
    System.out.println("\nDS sau khi xóa cuối:");
    L.Traversal();
    System.out.print("\n");
    L.insert(6, 1);
    System.out.println("DS sau khi chen 6 vào vị trí số 1:");
    L.Traversal();
    System.out.print("\n");
    L.delAt(2);
    System.out.println("DS sau khi xoa:");
    L.Traversal();
    System.out.print("\n");

    }
}
