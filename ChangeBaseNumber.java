import java.util.Scanner;

public class ChangeBaseNumber {
    public static String convert(String str, int fromBase, int toBase){
        return Integer.toString(Integer.parseInt(str, fromBase), toBase);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number: "); 
        String num = sc.next();

        System.out.print("From base: ");
        int fromBase = sc.nextInt();

        System.out.print("To base: ");
        int toBase = sc.nextInt();

        System.out.println("Result: " + convert(num, fromBase, toBase));
        sc.close();
    }
}
