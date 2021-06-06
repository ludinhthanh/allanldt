package J1_S_P0050;

import java.util.Scanner;

public class Validation{
    private static Scanner sc=new Scanner(System.in);

    static int checkInputInt(){
        try{
            int temp=sc.nextInt();
            return temp;
        }catch (Exception e){
            System.out.print("Please type the number!, Enter Again: ");
            sc.nextLine();
            return checkInputInt();
        }
    }

    static double checkInputDouble(){
        try{
            double temp=sc.nextDouble();
            return temp;
        }catch (Exception e){
            System.out.print("Please type the number!, Enter Again: ");
            sc.nextLine();
            return checkInputDouble();
        }
    }

    static int checkInputRange(int min,int max){
        int temp=checkInputInt();
        if ((temp>=min)&&(temp<=max)) return temp;
            else {
                System.out.print("Out of range [ "+min+" - "+max+" ], type again:"); 
                return checkInputRange(min,max);
            }
    }
}