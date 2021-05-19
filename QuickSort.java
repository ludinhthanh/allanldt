import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class QuickSort {
    private int[] a;

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of array: ");
        a = new int[sc.nextInt()];
        sc.close();
    }

    public void randomArray(){
        Random rd = new Random();        
        for (int i=0; i<a.length; i++) a[i] = rd.nextInt(20) ;
    }

    public void qsort(int l, int r){
        int p = (l + r)/2;
        int i = l, j = r;
        while (i < j){
            while (a[i] < a[p]) i++;
            while (a[j] > a[p]) j--;
            if (i <= j){
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
                i++; 
                j--;
            }
        }
        if (i < r) qsort(i, r);
        if (l < j) qsort(l, j);
    }

    public static void main(String[] args) {
        QuickSort obj = new QuickSort();
        obj.input();
        obj.randomArray();
        System.out.println("Unsorted array: " + Arrays.toString(obj.a));
        obj.qsort(0, obj.a.length-1);
        System.out.println("Sorted array: " + Arrays.toString(obj.a));
    }
}
