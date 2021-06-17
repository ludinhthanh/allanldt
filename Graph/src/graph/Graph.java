package graph;
public class Graph {
    int [][] a;
    int n;
    char vertex[] = "ABCDE".toCharArray();
    
    public Graph() {
     int [][]b  = {
            {0, 1, 1, 1, 1},
            {1, 0, 1, 0, 0},
            {1, 1, 0, 1, 0},
            {1, 0, 1, 0, 1},
            {1, 0, 0, 1, 1},
     };
     a = b;
     n = a.length;
    }
    public void visit(int i) {
     System.out.print(" " +vertex[i] + "  ");
    }
    public void BFT(int u, boolean []c) {
     MyQueue mq = new MyQueue();
     mq.enqueue(u); c[u] = true;
     while(!mq.isEmpty()) {
      int j = (int)mq.dequeue();
      visit(j);
      for (int i = 0; i < n; i++) {
       if(!c[i] && a[j][i] > 0) {
        mq.enqueue(i); c[i] = true;
       }}}
    }
    public void BFT(int u) {
     boolean []c = new boolean[n];
     BFT(u,c);
     for (int i = 0; i < n; i++) {
      if(!c[i]) BFT(i,c);
     }
    } 
    public void DFT(int i, boolean []c) {
     c[i] = true; visit(i);
     for (int j = 0; j < n; j++) {
      if(!c[j] && a[i][j] > 0) DFT(j,c);
     }
    }
    public void DFT(int i) {
     boolean []c = new boolean[n];
     DFT(i,c);
     for (int j = 0; j < n; j++) {
      if(!c[j]) DFT(j,c);
     }}
    public static void main(String[] args) {
       Graph g = new Graph();
       g.BFT(4); // 0 = A; 1 = B;.....3 = C;
       System.out.println("\n");
       g.DFT(4);
       
    }
    
}
