package J1_S_P0050;

import java.util.ArrayList;
import java.util.List;

public class EquationProgram {

    int menu(){
        System.out.println("----------Equation Program----------");
        System.out.println("1 - Calculate Superlative Equation");
        System.out.println("2 - Calculate Quadratic Equation");
        System.out.println("3 - Exit");
        System.out.print("YOUR CHOICE (1/2/3) ? : ");
        int choice= Validation.checkInputRange(1, 3);
        return choice;
    }

    void terminate(){
        System.out.println("Exitting program...");
        System.exit(0);
    }

    public boolean isOdd(int x){
        if (x%2==1) return true;
        return false;
    }

    public boolean isEven(int x){
        if (x%2==0) return true;
        return false;
    }

    public boolean isPerfectSquare(double x){
        if (x==0) return false;
        int temp=(int)Math.sqrt(x);
        if (temp*temp==(int)x) return true;
        return false;
    }

    public List<Double>calculateEquation (double a, double b){
        List<Double> result=new ArrayList<>();
        if ((a==b)&&(b==0)) {
            result.add(a); 
            result.add(a); 
            result.add(a); 
            return result;
        }
        if ((a==0)&&(b!=0)) {
            return result;
        }

        result.add(-b/a);
        return result;
    }

    public List<Double> calculateQuadraticEquation(double a, double b, double c){
        List<Double> result=new ArrayList<>();
        if ((a==b)&&(b==c)&&(c==0)) {
            result.add(a); 
            result.add(a); 
            result.add(a); 
            return result;
        }

        double denta=(Math.pow(b, 2)-4*a*c);
        if (denta<0) return result;

        if (denta==0){
            result.add(-b/(2*a));
            return result;
        }

        double x1=(-b-Math.sqrt(denta))/(2*a);
        double x2=(-b+Math.sqrt(denta))/(2*a);
        result.add(x1);
        result.add(x2);

        return result;
    }

    void option2(){
        System.out.println("======== Calcute Quadratic Equation ========");
        System.out.print("Enter A: ");
        double a=Validation.checkInputDouble();
        System.out.print("Enter B: ");
        double b=Validation.checkInputDouble();
        System.out.print("Enter C: ");
        double c=Validation.checkInputDouble();

        List<Double> resulf=new ArrayList<>();
        resulf=calculateQuadraticEquation(a, b, c);
        if (resulf.isEmpty()) 
            System.out.println("NO SOLUTION !");
      
        else if (resulf.size()==1){
            System.out.printf("|DOUBLE SOLUTION| x1 = x2 = %.2f\n",resulf.get(0));
        }
        else if (resulf.size()==2){
            System.out.printf("|SOLUTION| x1 = %.2f and x2 = %.2f\n",resulf.get(0),resulf.get(1));
        }
        else {
            System.out.println("INFINITY SOLUTION ! ");
        }

        double[] arr=new double[] {a,b,c};
        int[] check=new int[3];

        for (int i=0;i<3;i++)
            if (isOdd((int)arr[i])) check[i]=0; else check[i]=1;
        System.out.print("ODD NUMBER: ");
        for (int i=0;i<3;i++) 
            if (check[i]==0) System.out.printf("%.1f ",arr[i]);
        System.out.println("");
        System.out.print("EVEN NUMBER: ");
        for (int i=0;i<3;i++) 
            if (check[i]==1) System.out.printf("%.1f ",arr[i]);
        System.out.println("");

        for (int i=0;i<3;i++)
            if (isPerfectSquare(arr[i])) check[i]=2;
        System.out.print("PERFECT SQUARE NUMBER: ");
        for (int i=0;i<3;i++) 
            if (check[i]==2) System.out.printf("%.1f ",arr[i]);
        System.out.println("");
    }
    
    void option1(){
        System.out.println("======== Calcute Equation ========");
        System.out.print("Enter A: ");
        double a=Validation.checkInputDouble();
        System.out.print("Enter B: ");
        double b=Validation.checkInputDouble();

        List<Double> resulf=new ArrayList<>();
        resulf=calculateEquation(a, b);
        if (resulf.isEmpty()) 
            System.out.println("NO SOLUTION !");
          
    
        else if (resulf.size()==1){
            System.out.printf("|SOLUTION| x =  %.2f\n",resulf.get(0));
        }
        else {
            System.out.println("INFINITY SOLUTION ! ");
        }

        double[] arr=new double[] {a,b};
        int[] check=new int[2];

        for (int i=0;i<2;i++)
            if (isOdd((int)arr[i])) check[i]=0; else check[i]=1;
        System.out.print("ODD NUMBER: ");
        for (int i=0;i<2;i++) 
            if (check[i]==0) System.out.printf("%.1f ",arr[i]);
        System.out.println("");
        System.out.print("EVEN NUMBER: ");
        for (int i=0;i<2;i++) 
            if (check[i]==1) System.out.printf("%.1f ",arr[i]);
        System.out.println("");

        for (int i=0;i<2;i++)
            if (isPerfectSquare(arr[i])) check[i]=2;
        System.out.print("PERFECT SQUARE NUMBER: ");
        for (int i=0;i<2;i++) 
            if (check[i]==2) System.out.printf("%.1f ",arr[i]);
        System.out.println("");
    }
}