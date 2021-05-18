package linearsearch;
import java.util.*;
public class LinearSearch {
    public int[] array;
public LinearSearch(){}
public LinearSearch(int[] array){
    this.array= array;
}
   @Override
   public String toString(){
       String s ="";
       for(int a:array){
           s=+a+"";
                   }
       return s;
   }
    public int[] getArray(){
        return array;
    }
    public void setArray(int [] array){
        this.array=array;
    }
    public int keyBoard(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of array: ");
        int n=input.nextInt();
        return n;
    }
    public void randomArray(int n) {
        Random rd=new Random();
        array = new int[n];
        for(int i=0; i< array.length ; i++){
            array[i]=rd.nextInt(10);
        }
    }
    public int search(int x) {
    for (int i = 0, length = array.length; i < length; i++) 
            if (array[i] == x) return i;
    return -1;
    }
    public static void main(String[] args) {
        LinearSearch A = new LinearSearch();
        Scanner sc = new Scanner(System.in);// nhập từ bàn phím
        A.randomArray(A.keyBoard());
        System.out.print("Enter search value: ");
        int x = sc.nextInt();//khai báo để nhập từ bà phím
        System.out.println("The array: " + Arrays.toString(A.array));
        A.search(x);
        System.out.println("Found " + x + " at index: " + (A.search(x)));
    }  
}
