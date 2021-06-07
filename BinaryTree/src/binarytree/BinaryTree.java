package binarytree;
public class BinaryTree {
    Node root;
    public void insert(int x) 
    {Node p = new Node(x);
     Node f = null, q = root;
     while(q != null) {
      if(q.x == x) {System.out.println("Key cannot be duplicated...");return;}
      if(q.x < x) {f = q; q = q.right;}
      else {f = q; q = q.left;}
     }
    if(f == null) root = p;
    else if(p.x > f.x) f.right = p;
    else f.left = p;
    }
    void PreOrder(Node root)
    {
        if(root == null) return ;
        System.out.print(root.x + " ");
        PreOrder(root.left);
        PreOrder(root.right);
    }
    void InOrder(Node root)
    {
        if(root == null) return;
        InOrder(root.left);
        System.out.print(root.x + " ");
        InOrder(root.right);
    }
    void PostOrder(Node root)
    {
        if(root == null) return;
        PostOrder(root.left);
        PostOrder(root.right);        
        System.out.print(root.x + " ");
    }
    void BFT(Node root)
    {if(root == null) return;
     Queue m = new Queue();
     m.enqueue(root);
     while(!m.isEmpty()) {
      Node q = (Node)m.dequeue();
      System.out.print(q.x + " ");
      if(q.left != null) m.enqueue(q.left);
       if(q.right != null) m.enqueue(q.right);
     }
    }
    Node search(Node root, int x)
    {
        if (root == null) return null;
        
        if(root.x == x)
        {
            return root;
        }
        if(root.x > x)
        {
            search(root.left, x);
        }
        else
        {
            search(root.right, x);
        }
        return null; 
    }    
    Node delete(Node root, int x){
        if (root == null) return root;

        if (x < root.x)
            root.left = delete(root.left, x);
        else if (x > root.x)
            root.right = delete(root.right, x);
        else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            Node tmp = root.left;
            int minValue = tmp.x;
            while (tmp.right != null){
                tmp = tmp.right;
                minValue = tmp.x;
            }
            root.x = minValue;
            root.left = delete(root.left, root.x);
        }
        return root;
    }
    void input()
    {
        insert(5);
        insert(4);
        insert(3);
        insert(2);
        insert(6);
        insert(8);
        insert(9);
        insert(7);
        
    }
    public static void main(String[] args) {
                BinaryTree bt = new BinaryTree();
		bt.input(); //Goi ham insert de chen dl
		System.out.print("\nPreOrder: ");
		bt.PreOrder(bt.root);
		System.out.print("\nInoder: ");
		bt.InOrder(bt.root);
		System.out.print("\nPostOrder: ");
		bt.PostOrder(bt.root);
		System.out.print("\nBFT: ");
		bt.BFT(bt.root);
                System.out.print("\n");
                System.out.print("Delete 8 "); 
                bt.delete(bt.root,8);
                System.out.print("\nPreOrder: ");bt.PreOrder(bt.root);
                System.out.print("\nInoder: ");bt.InOrder(bt.root);
                System.out.print("\nPostOrder: ");bt.PostOrder(bt.root);
                System.out.print("\nBFT: ");bt.BFT(bt.root); 
                bt.search(bt.root, 5);
          
                
                
    }
}
    
    