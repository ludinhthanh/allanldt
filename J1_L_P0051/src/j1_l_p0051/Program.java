
package j1_l_p0051;

enum BMI{
    UNDER_STANDARD,STANDATD,OVERWEIGHT,FAT,VERY_FAT;
}

public class Program {

    int menu(){
        System.out.println("----------Calculator Program----------");
        System.out.println("1 - Normal Calculator");
        System.out.println("2 - BMI Calculator");
        System.out.println("3 - Exit");
        System.out.print("YOUR CHOICE (1/2/3) ? : ");
        int choice=Validation.checkInputRange(1, 3);
        return choice;
    }

    public void terminate(){
        System.out.println("Exitting...");
        System.exit(0);
    }

    public double calculate(double a,Operator operator,double b){
        switch (operator.getOpe()){
            case '+':   return a+b;
            case '-':   return a-b;
            case '*':   return a*b;
            case '/':   return a/b;
            case '^':   return Math.pow(a,b);
        }
        return 8;
    }

    public BMI calculateBMI(double w,double h){
        h=h/100;
        double bmi=w/(h*h);
        System.out.printf("BMI = %.3f",w/(h*h));
        System.out.println();
        if (bmi<19) return BMI.UNDER_STANDARD;
        if (bmi<25) return BMI.STANDATD;
        if (bmi<30) return BMI.OVERWEIGHT;
        if (bmi<40) return BMI.FAT;
        return BMI.VERY_FAT;
    }

    public void option1(){
            System.out.print("Enter number 1: ");
            double num1=Validation.checkInputDouble();
            double result=num1;
            int time=1;
        while (true){
            Validation.sc.nextLine();
            System.out.print("Enter operator: ");
            Operator operator=Validation.checkInputOperator();

            if (operator.getOpe()=='='){
                System.out.printf("RESULT: %.3f",result);
                System.out.println();
                return;
            }

            time++;
            System.out.print("Enter number "+time+": ");
            double num2=Validation.checkInputDouble();
            result=calculate(result, operator, num2);
            
            System.out.printf("MEMORY: %.3f",result);
            System.out.println();
        }
    }

    public void option2(){
        System.out.print("Enter Weight (kg): ");
        double w=Validation.checkInputDouble();
        System.out.print("Enter Height (cm): ");
        double h=Validation.checkInputDouble();
        System.out.println(calculateBMI(w, h));
        return;
    }
}