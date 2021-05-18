package solve;
import java.util.Scanner;
public class Solve{
    
    int findMax(int a, int b ,int c){
        int max = a;
        if(b>max)
            max = b;
        if(c>max)
            max = c;
        return max;
           
    }
    void PTB1(float a, float b){
        if(a ==0)
            if(b==0)
                System.out.printf("\n%.1fx + %.1f = 0 has uncountable solution.",a,b);   //vô số nghiệm khi a b =0
            else 
                System.out.printf("\n%.1fx + %.1f = 0 zero solution.",a,b);//a hoặc b = 0 thì vô nghiệm
        else 
            System.out.printf("\n%.1fx + %.1f = 0 has a solution: x = %.4f",a,b,(-b/a)); // cả a và b khác không thì có nghiệm -b/a
    }
    void PTB2 (float a, float b, float c ){
        if (a == 0) {
            if (b == 0) {
                System.out.println("Phương trình vô nghiệm!");
            } else {
                System.out.println("Phương trình có một nghiệm: " // từ dòng 26 đến 32 có thể thay bằng PTB1(b,c) vì nó giải trường hợp PTB1 lại
                        + "x = " + (-c / b));
            }
            return;
        }
        // tính delta
        float delta = b*b - 4*a*c;
        float x1;
        float x2;
        // tính nghiệm
        if (delta > 0) {
            x1 = (float) ((-b + Math.sqrt(delta)) / (2*a));
            x2 = (float) ((-b - Math.sqrt(delta)) / (2*a));
            System.out.println("Phương trình có 2 nghiệm là: "
                    + "x1 = " + x1 + " và x2 = " + x2);
        } else if (delta == 0) {
            x1 = (-b / (2 * a));
            System.out.println("Phương trình có nghiệm kép: "
                    + "x1 = x2 = " + x1);
        } else {
            System.out.println("\nPhương trình vô nghiệm!");
        }
    }
    public static void main(String[] args) {
        Solve A = new Solve();
        int a = 2; int b = 4; int c = 9;
        int m = A.findMax(a,b,c);
        System.out.printf("\nmax(%d, %d, %d)",a,b,c, m);
        A.PTB1(3,4);
        A.PTB2(5,2,8);
    }
    
}
