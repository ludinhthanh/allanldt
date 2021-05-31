package tower;
import java.util.Scanner;
public class Tower {
    void Tower(int n, char a , char b, char c)
    {
        if(n==1){
            System.out.printf("\t%c---------%c\n",a,c);
            return;
        }
        Tower(n-1,a,c,b);
        Tower(1,a,b,c);
        Tower(n-1,b,a,c);
    }
   
    public static void main(String[] args) {
            Tower A = new Tower();
            int n = 5;// nếu có n số đĩa thì ít nhất (2^n-1) bước
            A.Tower(n,'A','B','C'); 
    }
    
}
