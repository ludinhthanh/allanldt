package managestudents;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

public class View {
    private ArrayList<Student> List;
    private final static Scanner sc = new Scanner(System.in);
    public View(){
        this.List = new ArrayList<Student>();
    }
    public View(ArrayList <Student> List) {
        this.List = List;
    }
    public ArrayList<Student> getList() {
        return this.List;
    }
    public void setList(ArrayList<Student> list) {
        this.List = list;
    }
    @Override
    public String toString() {
        return "{" +
            " list='" + getList() + "'" +
            "}";
    }
    public void add(Student e){
        this.List.add(e);
    }    
    public void create() {        
        if (this.List.size() >= 3){
            System.out.print("Do you want to continue? (y/N)");
            if (sc.nextLine().trim().toUpperCase() != "Y") 
                return;
        }  
        Student st = new Student();
        System.out.print("Enter student ID: "); st.setId(sc.nextLine());
        System.out.print("Enter student name: "); st.setStudentName(sc.nextLine());
        System.out.print("Enter semester: "); st.setsemester(sc.nextLine());
        System.out.print("Enter course: "); st.setCourseName(sc.nextLine());
        if (this.List.contains(st))
            System.out.println("Student is exist.");
        else {
            this.add(st);
            System.out.println("Add student success!.");
        }
        System.out.println("\n");                
        this.create();
    }
    public ArrayList<Student> findByPartOfName(String partOfName) {
        ArrayList<Student> tempList = new ArrayList<Student>();
        for (Student e: this.List){
            if (e.getStudentName().toLowerCase().contains(partOfName.toLowerCase()))  tempList.add(e);               
        }
        tempList.sort(Comparator.comparing(Student::getStudentName));
        return tempList;
    }   
    public void findAndListStudentByName(){
        System.out.print("Enter name you want to search: ");
        String partOfName = sc.nextLine().trim();
        System.out.printf("%-20s %-15s %-15s\n", "Name", "Semester", "Course Name");
                
        ArrayList<Student> tempList = this.findByPartOfName(partOfName);
        for (Student e: tempList) 
            System.out.printf("%-20s %-15s %-15s\n", e.getStudentName(), e.getSemester(), e.getCourseName());        
    }
    public Student findStudentById(String id) {
        for (Student e: this.List)
            if (e.getId().equals(id)) return e;
        return null;
    }
    public void remove(Student e){
        Iterator<Student> it = this.List.iterator();
        while (it.hasNext()){
            if (e.equals(it.next())) it.remove();            
        }
    }
    public void updateOrDelete(){
        Student student;
        for (;;){
            System.out.print("Enter student ID you want to find: ");
            student = this.findStudentById(sc.nextLine());
            if (student != null) break;
            System.out.println("Student isn't exist. Please input again!");            
        }
        
        System.out.print("Do you want to Update (U) or Delete (D)? ");
        
        if (sc.next().trim().toUpperCase().equals("D")) {
            this.remove(student);
            System.out.println("Deleted successfully!");
            return;
        }
        sc.nextLine();
        System.out.print("Enter student name: "); student.setStudentName(sc.nextLine());
        System.out.print("Enter semester: "); student.setsemester(sc.nextLine());
        System.out.print("Enter course name: ");; student.setCourseName(sc.nextLine());
        System.out.println("Update successfully!");
    }
    public int countCourse(int countbyName){
        int res = 0;
        String id = List.get(countbyName).getId();
        String course = List.get(countbyName).getCourseName();
        for(int i = countbyName; i < List.size(); i++){
            if(List.get(i).getId().equals(id) && List.get(i).getCourseName().equals(course)) res++;
        } 
        return res;
    } 
    public void Report(){
        String id = "";
        for(int i = 0; i < List.size(); i++){
            String test = List.get(i).getId().concat(List.get(i).getCourseName());
            if(id.contains(test)) continue;
            int countbyName = i;
            id = id.concat(test);
            System.out.println(List.get(i).getId()+"\t| "+List.get(i).getStudentName()+"\t| "+List.get(i).getCourseName()+"\t| "+countCourse(countbyName));
        }
    }
    public void menu() {
        System.out.println("STUDENT MANAGER");
        System.out.println("1. Create student");
        System.out.println("2. Find student by name");
        System.out.println("3. Update or Delete student");
        System.out.println("4. Report");
        System.out.println("0. Exit");
        System.out.print(">>> ");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                this.create(); break;
            case 2:
                this.findAndListStudentByName(); break;
            case 3:
                this.updateOrDelete(); break;
            case 4:
                this.Report(); break;
            default:
                System.out.println("Goode bye!");
                break;
        }
        menu();
    }
}
