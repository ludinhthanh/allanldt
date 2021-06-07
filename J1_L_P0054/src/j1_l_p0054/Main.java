
package j1_l_p0054;
import java.util.ArrayList;
public class Main {
    public static int menu(InputChecker ic){
        System.out.println("=================== Contact program ===================");
        System.out.println("1. Add a Contact");
        System.out.println("2. Display all Contact");
        System.out.println("3. Delete a Contact");
        System.out.println("4. Exit");
        System.out.print("======>>YOUR CHOICE: ");
        int choice=ic.inputIntRange(1,4);
        return choice;
    }
    public static ArrayList<Contact> input(InputChecker ic){
        ArrayList<Contact> result=new ArrayList<>();
        while (true){
            int id=result.size()+1;
            System.out.print("Please type firstName: ");String firstName=ic.inputString();
            System.out.print("Please type lastName: ");String lastName=ic.inputString();
            System.out.print("Please type group: ");String group=ic.inputString();
            System.out.print("Please type address: ");String address=ic.inputString();
            System.out.print("Please type phone: ");String phone=ic.inputPhone();
            result.add(new Contact(id, firstName+" "+lastName, firstName, lastName, group, address, phone));
            System.out.print("Wanna add another contact? (0/1): ");
            int choice=ic.inputIntRange(0, 1);
            if (choice==0) break;
        }
        return result;
    }
    public static void updateId(ArrayList<Contact> a){
        for (Contact i:a)
            i.setId(a.indexOf(i)+1);
    }
    public static void delete(ArrayList<Contact> a,InputChecker ic){
        System.out.print("Input ID to delete: ");int id=ic.inputInt();
        for (Contact i:a)
            if (i.getId()==id) {
                System.out.println("DELETE !");
                System.out.printf("%5d %15s %10s %10s %10s %20s %15s\n",i.getId(),i.getName(),i.getFirstName(),i.getLastName(),i.getGroup(),i.getAddress(),i.getPhone());
                a.remove(id-1);
                updateId(a);
                return;
            }
        System.out.println("NOT FOUND!");
    }
    public static void display(ArrayList<Contact> contactArr){
        System.out.printf("%5s %15s %10s %10s %10s %20s %15s\n","ID","NAME","FirstName","LastName","Group","Address","Phone");
        for (Contact i:contactArr) i.display();
    }
    public static void main(String[] args) {
        InputChecker ic=new InputChecker();
        ArrayList<Contact> contactArr=new ArrayList<>();
        while (true){
            int choice=menu(ic);
            switch (choice) {
                case 1: contactArr=input(ic);
                        break;
                case 2: display(contactArr);
                        break;
                case 3: delete(contactArr,ic);
                        break;
                case 4: System.out.println("Exitting...");
                        System.exit(0);
            }
        }
    }
}