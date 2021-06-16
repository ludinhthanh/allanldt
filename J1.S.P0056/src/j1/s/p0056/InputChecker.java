
package j1.s.p0056;


import java.util.Scanner;

public class InputChecker {
    private Scanner sc;
    public InputChecker(){
        sc=new Scanner(System.in);
    }
    public int inputInt(){
        int temp=0;
        while(true){
            try{
                temp=sc.nextInt();
                sc.nextLine();
                return temp;
            }catch (Exception e){
                System.out.print("Please input integer, enter again: ");
                sc.nextLine();
            }
        }    
    }
    public double inputDouble(){
        double temp=0;
        while(true){
            try{
                temp=sc.nextDouble();
                sc.nextLine();
                return temp;
            }catch (Exception e){
                System.out.print("Please input number, enter again: ");
                sc.nextLine();
            }
        }    
    }
    public String inputString(){
        String temp=null;
        while(true){
            try{
                temp=sc.nextLine();
                if (temp.isEmpty()) throw new Exception();
                return temp;
            }catch (Exception e){
                System.out.print("Null string, enter again: ");
            }
        }
    }
    public int inputIntRange(int min,int max){
        while (true){
            int temp=inputInt();
            if ((temp>=min)&&(temp<=max)) return temp;
            System.out.print("Out of range ("+min+" - "+max+") ,please type again: ");
        }
    }
}