package binarysearch;

import java.util.Random;
import java.util.Scanner;

public class BinarySearch{

    private int[] a;
    private int x;

    // Constructor
    public BinarySearch() {
        this.x = -1;
    }

    public BinarySearch(int[] a, int x) {
        this.a = a;
        this.x = x;
    }

    // Getter & Setter
    public int[] getA() {
        return this.a;
    }

    public void setA(int[] a) {
        this.a = a;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }


    // Method
    public void input(int[] a, int x){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of array: ");
        this.a = new int[sc.nextInt()];
        System.out.print("Enter search value: ");;
        this.x = sc.nextInt();
        sc.close();
    }

    public void randomArray(int[] a){
        Random rd = new Random();
        int n = a.length;
        for (int i=0; i<n; i++) a[i] = rd.nextInt(20);
    }

    public int binarySearch(int a[], int x)
    {
        int l = 0, r = a.length;
        while (l <= r){
            int k = (l + r)/2;
            if (a[k] == x) return k;
            else if (x < a[k]) r = k-1;
            else l = k+1;                
        }
        return -1;
    }

    public void sort(int[] a){
        int n = a.length;
        for (int i=0; i<n-1; i++){
            for (int j=i+1; j<n; j++){
                if (a[j] < a[i]){
                    int t = a[j];
                    a[j] = a[i];
                    a[i] = t;
                }
            }
        }
    }
    
}
