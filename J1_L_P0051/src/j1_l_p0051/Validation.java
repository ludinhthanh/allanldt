
package j1_l_p0051;

import java.util.Scanner;

public class Validation{
    public static Scanner sc=new Scanner(System.in);

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

    static char checkInputChar(){
        String temp=sc.nextLine();
        char temp1=temp.charAt(0);
        if ((temp.length()>1)||((temp1>='0')&&(temp1<='9'))){
            if (temp.length()>1) 
                System.out.println("Must input a single char!");
            if ((temp1>='0')&&(temp1<='9'))
                System.out.println("Don't input the number here!");
            System.out.print("Type Again: ");
            return checkInputChar();
        }
        return temp1;
    }
    static Operator checkInputOperator(){
        while (true){
            char temp=checkInputChar();
            if ((temp=='+')||(temp=='-')||(temp=='*')||(temp=='/')||(temp=='^')||(temp=='='))
            return new Operator(temp);
            System.out.print("Operator must be (+,-,*,/,^,=), type again: ");
        }
    }
}
