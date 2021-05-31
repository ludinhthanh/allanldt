package tongn;
import java.util.Scanner;
public class Tongn {   
    int sumn(int n)   //tính tổng dãy số bất kì VD 1234 = 10
    {
    if ( n <= 0)
        return 0;
    else{
        int x = n %10; // tinh tung chu so 1256 % 10 =6
        System.out.printf("\n%d + sumn(%d)", x,n/10 );
        return x + sumn(n/10);
        } 
    }
    int giaithua(int n)    //tính giai thừa số n
    {
    if ( n <= 0)
        return 0;
    else{
        System.out.printf("\n%d * factorial(%d)",n,n-1);
        if( n==1 )        
            return 1;
        return n * giaithua(n-1);
        
        } 
    }
    void Convert(int n) // hàm đổi n thành mã nhị phân
    {
        if(n > 0) //Dieu kien dung - Base case
{
        int x = n%2;
        Convert(n/2);
        System.out.printf("%d ", x);   //  đây là hàm Tail nếu dòng gọi hàm ở cuối thì gọi là NONE TAIL
}
}
    void Reverse(String str)    //đảo ngược dãy chữ
    {
    String input = str;
        
    StringBuffer stringBuffer = new StringBuffer(input);

    System.out.println(stringBuffer.reverse().toString());
    }
    static int fibonacci(int n)    
    {
        if(n<=1)
            return n;
        else 
            return (fibonacci(n-1)+fibonacci(n-2));
    }
    public static void main(String[] args) {
        Tongn A = new Tongn();
        int n = 1245;
        System.out.printf("\nsumn(%d) = %d ",n,A.sumn(n));
        n = 4;
        System.out.printf("\n(%d!) = %d",n,A.giaithua(n));
        System.out.print("\n");
        n = 8;
        System.out.print("Convert n = ");
        A.Convert(n); 
        System.out.print("\n");
        System.out.print("chuỗi sau khi bị đảo ngược là: ");
        A.Reverse("ABCD");
        System.out.print("dãy fibonacci là tại: ");
        for (int i = 0; i <= 7; i++) {
            System.out.print(fibonacci(i)+" ");
        }
    }
}
