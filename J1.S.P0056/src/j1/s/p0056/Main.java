
package j1.s.p0056;

import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static int menu(InputChecker ic){
        System.out.println("=================== Worker management ===================");
        System.out.println("1. Add Worker");
        System.out.println("2. Up Salary");
        System.out.println("3. Down Salary");
        System.out.println("4. Display");
        System.out.println("5. Exit");
        System.out.print("======>>YOUR CHOICE: ");
        int choice = ic.inputIntRange(1,5);
        return choice;
    }
    public static int searchId(ArrayList<Worker> a,String id){
        for (Worker i:a)
            if (i.getId().equals(id)) return a.indexOf(i);
        return -1;
    }

    public static void input(ArrayList<Worker> a,InputChecker ic){
        while (true){
            String id=null;
            while(true){
                System.out.print("Please type code: "); id = ic.inputString();
                if (searchId(a, id)== -1) break;
                System.out.println("Code already exit, enter again");
            }
            System.out.print("Please type name: ");String name=ic.inputString();
            System.out.print("Please type age: ");int age=ic.inputIntRange(18,50);
            System.out.print("Please type salary: ");double salary=ic.inputDouble();
            a.add(new Worker(id, name, age, salary, "NOT CHANGE", new Date()));
            System.out.print("Wanna add another worker? (0/1): ");
            int choice=ic.inputIntRange(0, 1);
            if (choice==0) break;
        }
    }     
    public static void changeSalary(ArrayList<Worker> a,InputChecker ic){
        System.out.print("Type id: ");
        String id = ic.inputString();
        int pos = searchId(a, id);
        if (pos==-1) {
            System.out.println("ID not found!");
            return;
        }
        System.out.print("Type new Salary for "+a.get(pos).getName()+" : ");
        double salary = ic.inputDouble();
        double oldSalary = a.get(pos).getSalary();
        String status="NOT CHANGE";
        if (oldSalary > salary) status = "DOWN";
            else status="UP";
        a.get(pos).setSalary((int) salary);
        a.get(pos).setStatus(status);
    }
    public static void display(ArrayList<Worker> a){
        System.out.printf("%5s %15s %-5s %-8s %15s %15s\n","ID","NAME","Age","Salary","Status","Date");
        for (Worker i:a) i.display();
    }
    public static void main(String[] args) {
        InputChecker ic=new InputChecker();
        ArrayList<Worker> workerArr=new ArrayList<>();
        while (true){
            int choice=menu(ic);
            switch (choice) {
                case 1: input(workerArr,ic);
                        break;
                case 2: changeSalary(workerArr,ic);
                        break;
                case 3: changeSalary(workerArr,ic);
                        break;
                case 4: display(workerArr);
                        break;
                case 5: System.out.println("Exitting...");
                        System.exit(0);
            }
        }
    }
}


