
package thesamesorting;

import java.util.Random;
import java.util.Scanner;


public class ThesameSorting {
    int A[];
    int n;
    int i;
    ThesameSorting(int numE){
        n = numE;
        A = new int[n];
    }
    
    //hàm xuất 
    void input()
    {
        Random rd = new Random();
        for(int i = 0; i<n; i++)
            A[i] = rd.nextInt(5);
    }
    
    //hàm xuất
    void output()
    {
        for(int i = 0;i<n; i++)
            System.out.print(A[i]+" ");
    }
    
    //Sx Selection Sort
    void SelectionSort(){
        for(int i = 0; i<n-1; i++)
        {
            int m = i;
            for(int j = i+1; j<n ; j++)
            {
                if(A[j] < A[m])
                    m = j;
            }
            if(m != 1)
            {
                int tmp = A[i];
                A[i] = A[m];
                A[m] = tmp;
            }
    }
}
    
    //Sx Inser Sort
    void InsertSort(){
        for(int i = 1; i<n; i++)
        {
            int tmp = A[i];
            int j = 1;
            while(j>0 && A[j-1] > tmp)
            {
                A[j] = A[j-1];
                j--;
            }
            A[j] = tmp;
    }
}
    
    //Sx Bubble Sort
    void BubbleSort()
    {
        for (int i = 0;i<n;i++)
        {
             for(int j=n-1;j>0;j--)
                 if(A[j] < A[j-1])
                 {
                     int tmp = A[j];
                     A[j] = A[j-1];
                     A[j-1] = tmp;
                 }
        }
    }
    
    //Sx Quick Sort 
    void QuickSort(int left, int right)
    {
        if(left<right)
        {
            int up = left;
            int down = right;
            int x = A[(left + right)/2];
            do{
                while(A[up] < x)up++;
                while(A[down] > x)down--;
                if(up <= down)
                {
                    int tmp = A[up];
                    A[up] = A[down];
                    A[down] = tmp;
                    up++;
                    down--;
                }
            }while(up <= down);
            QuickSort(left, down);
            QuickSort(up, right);
        }
            
    }
    
    //Sx Merge Sort 
    void merge(int p,int q,int r)	
        {if(!(p<=q)&&(q<=r))	return;	
        int n,i,j,k,x;	n = r-p+1;	
	int[]b = new int[n];	
	i=p;j=q+1;k=0;	
        while(i<=q && j<=r)	
            {if(A[i]<A[j])	
                b[k++] = A[i++];	
            else	
            b[k++] = A[j++];}		
            while(i<=q) b[k++]	= A[i++];	
            while(j<=r)	b[k++]	= A[j++];	
                k=0;	
		for(i=p;i<=r;i++) A[i] = b[k++];	
				}	
    void MergeSort(int p,int r)
    {
        if(p>=r) return;
        int q = (p+r)/2;
        MergeSort(p,q);
        MergeSort(q+1,r);
        merge(p,q,r);
    }
    
    //Sx Head Sort
    void headsort() {
        int n = A.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(A, n, i);
        for (int i = n - 1; i > 0; i--) {
            int temp = A[0];
            A[0] = A[i];
            A[i] = temp;
            heapify(A, i, 0);
        }
    }
    void heapify(int A[], int n, int i) {
        int largest = i; 
        int l = 2 * i; 
        int r = 2 * i + 1; 
        if (l < n && A[l] > A[largest])
            largest = l;        
        if (r < n && A[r] > A[largest])
            largest = r;
        if (largest != i) {
            int swap = A[i];
            A[i] = A[largest];
            A[largest] = swap;          
            heapify(A, n, largest);
        }
    }
    
    //Sx Radix Sort
    void radixSort() {
        int i, m = A[0], exp = 1, n = A.length;
        int[] B = new int[10000];
        for (i = 1; i < n; i++) //tìm số lớn nhất trong dãy
        {
            if (A[i] > m) {
                m = A[i];
            }
        }
        while (m / exp > 0) {
            int[] bucket = new int[10];
            for (i = 0; i < n; i++)
            {
                bucket[(A[i] / exp) % 10]++;
            }
            for (i = 1; i < 10; i++) {
                bucket[i] += bucket[i - 1];
            }
            for (i = n - 1; i >= 0; i--) {
                B[--bucket[(A[i] / exp) % 10]] = A[i];
            }
            for (i = 0; i < n; i++) {
                A[i] = B[i];
            }
            exp *= 10;
        }
    }
    
    public static void main(String[] args) {
         int n = 10000;
        ThesameSorting S = new ThesameSorting(n);
        double start, finish, duration;
        S.input();
//        S.output();
//        System.out.println("\nSau khi chạy sắp xếp chọn: ");
        start = System.currentTimeMillis();
        S.SelectionSort();
        finish = System.currentTimeMillis();
        duration = finish - start;
//        S.output();
        System.out.printf("\n Sx %d PT bằng Sắp xếp chọn hết %.1fms", n, duration);

        //Sx chen---------------------------------------------------
        S.input();
//        System.out.println("\n Mảng vừa nhập: ");
//        S.output();
//        System.out.println("\n Sau khi chạy sắp xếp chèn: ");
        start = System.currentTimeMillis();
        S.InsertSort();
        finish = System.currentTimeMillis();
        duration = finish - start;
//        S.output();
        System.out.printf("\n Sx %d PT bằng Sắp xếp chèn hết %.1fms",n ,  duration);

        //Sx Noi bot
        S.input();
        start = System.currentTimeMillis();
        S.BubbleSort();
        finish = System.currentTimeMillis();
        duration = finish - start;
//        S.output();
        System.out.printf("\n Sx %d PT bằng Sắp xếp nổi bọt hết %.1fms", n, duration);

        //Sx QS----------------------------------------------------------------
        S.input();
        start = System.currentTimeMillis();
        S.QuickSort(0, n - 1);
        finish = System.currentTimeMillis();
        duration = finish - start;
//        S.output();
        System.out.printf("\n Sx %d PT bằng Quick Sort hết %.1fms", n, duration);
        
        //Sx MS
        S.input();
        start = System.currentTimeMillis();
        S.MergeSort(0, n- 1); 
        finish = System.currentTimeMillis();
        duration = finish - start;
//          S.output();
        System.out.printf("\n Sx %d PT bằng Merge Sort hết %.1fms", n, duration);
        
        //Sx HS 
        S.input();
        start = System.currentTimeMillis();
        S.headsort(); 
        finish = System.currentTimeMillis();
        duration = finish - start;
//          S.output();
        System.out.printf("\n Sx %d PT bằng Head Sort hết %.1fms", n, duration);
        
        //Sx RS
        S.input();
        start = System.currentTimeMillis();
        S.radixSort();
        finish = System.currentTimeMillis();
        duration = finish - start;
//          S.output();
        System.out.printf("\n Sx %d PT bằng Radix Sort hết %.1fms", n, duration);
        
    }
}

    
