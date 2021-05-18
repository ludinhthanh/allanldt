package arrayList;

import java.util.Scanner;

public class ArrayList {
    private int[] a;

    public int find(int x){
        for (int i=0; i<a.length; i++)
            if (a[i] == x) return i;
        return -1;
    }

    public void delete(int pos){
        int[] t = new int[a.length - 1];
        int i=0;        
        for (int e: a){
            if (i == pos){
                pos = -1;
                continue;
            };
            t[i] = e;
            i++;
        }
        a = t;
    }

    public void insert(int x, int pos){
        int[] t = new int[a.length + 1];
        int i=0;        
        for (int e: a){
            if (i == pos) 
                t[i] = x;
            else 
                t[i] = e;
            i++;
        }
        a = t;
    }

    public void replace(int x, int pos){
        a[pos] = x;
    }

    public boolean isEmpty(){
        return a.length==0;
    }    

    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of element: ");
        a = new int[sc.nextInt()];
        for (int i=0; i<a.length; i++){
            System.out.print("Element " + i + ": ");
            a[i] = sc.nextInt();
        }
        sc.close();
    }

    public void output(){
        System.out.print("[");
        for (int i=0; i<a.length; i++){
            if (i != a.length-1) System.out.print(a[i] + ", ");
            else System.out.print(a[i]);
        }
        System.out.println("]");
    }    

    public static void main(String[] args) {                    
        ArrayList a = new ArrayList();
        a.input();
        a.output();

        
        System.out.println("Found 5 index at " + a.find(5));        
        
        System.out.print("Delete element at index 3: ");
        a.delete(3);
        a.output();

        System.out.println("Insert element 7 at index 3: ");
        a.insert(7, 3);
        a.output();

        System.out.println("Replace element 9 at index 3: ");
        a.replace(9, 3);
        a.output();
    }
}
