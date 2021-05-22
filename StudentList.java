package studentlist;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

public class StudentList {
    private ArrayList<Student> students;

    // Constructor
    public StudentList() {
        this.students = new ArrayList<Student>();
    }

    public StudentList(ArrayList<Student> students) {
        this.students = students;
    }
    
    // Get & Set
    public ArrayList<Student> getStudents() {
        return this.students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    // Methods
    public boolean add(Student student) {
        return this.students.add(student);
    }

    public int hasYearOfBirth(int year){
        int res = 0;
        Calendar cal = Calendar.getInstance();
        for (Student student: this.students){
            cal.setTime(student.getDob());
            if (cal.get(Calendar.YEAR) == year) res++;
        }
        return res;
    }

    public boolean hasName(String name) {
        for (Student student : this.students){
            if (student.getName() == name) return true;
        }
        return false;
    }

    public void removeName(String name){
        Iterator<Student> i = this.students.iterator();
        while (i.hasNext()){
            Student student = i.next();
            if (student.getName() == name) i.remove();
        }        
    }

    public ArrayList<Student> biggestAverage(){
        ArrayList<Student> res = new ArrayList<>();
        double avg = -1;
        for (Student student: this.students){
            if (student.average() < avg) continue;
            if (student.average() > avg) res.clear();
            res.add(student);            
        }
        return res;
    }

    public ArrayList<Student> mathMarkLessThan5(){
        ArrayList<Student> res = new ArrayList<>();
        for (Student student: this.students){
            if (student.getMathMark() < 5) res.add(student);
        }
        return res;
    }

    public void writeFile(String filepath){
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("student.txt"));
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            for (Student student: this.students){
                String s = 
                    student.getName() + "\n" +
                    sdf.format(student.getDob()) + "\n" +
                    student.getMathMark() + " " +
                    student.getPhysicMark() + " " + 
                    student.getLanguageMark() + "\n\n"
                ;                
                out.write(s);                
            }
            out.close();
        } catch (IOException e) {            
            e.printStackTrace();
        }
    }

    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number students: ");
        int n = sc.nextInt();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (int i=0; i<n; i++){
            Student temp = new Student();
            sc.nextLine();
            System.out.print("Enter student name: ");
            temp.setName(sc.nextLine());
            System.out.print("Enter date of birth (dd/MM/yyyy): "); 
            try {
                temp.setDob(sdf.parse(sc.next()));
            } catch (ParseException e) {                
                e.printStackTrace();
            }
            System.out.print("Enter math mark: "); 
            temp.setMathMark(sc.nextDouble());
            System.out.print("Enter physic mark: "); 
            temp.setPhysicMark(sc.nextDouble());
            System.out.print("Enter language mark: "); 
            temp.setLanguageMark(sc.nextDouble());
            this.add(temp);
        }
        sc.close();
    }

    public static void main(String[] args) throws ParseException {        
        StudentList list = new StudentList();
        list.input();

        // Add 
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Student student = new Student(
            "Le Trung Luc",
            sdf.parse("07/06/2001"),
            9.6,
            8.5,
            4.3
        );
        list.add(student);

        // Count student have year of birth given        
        System.out.println("Have " + list.hasYearOfBirth(2001) + " student was born in 2001");

        // Check if name exist
        System.out.println("Name \"Le Trung Luc\""+ (list.hasName("Le Trung Luc") ? " " : " NOT ") + "exist");

        // Remove name
        list.removeName("Le Trung Luc");
        System.out.println(list.getStudents());

        // Biggest Average
        System.out.println(list.biggestAverage());

        // Math mark less than 5
        System.out.println(list.mathMarkLessThan5());

        list.writeFile("student.txt");
    }
}

class Student {
    private String name;
    private Date dob;
    private double mathMark;
    private double physicMark;
    private double languageMark;

    // Constructor
    public Student() {
    }

    public Student(String name, Date dob, double mathMark, double physicMark, double languageMark) {
        this.name = name;
        this.dob = dob;
        this.mathMark = mathMark;
        this.physicMark = physicMark;
        this.languageMark = languageMark;
    }

    public String getName() {
        return this.name;
    }

    // Get & Set
    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return this.dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public double getMathMark() {
        return this.mathMark;
    }

    public void setMathMark(double mathMark) {
        this.mathMark = mathMark;
    }

    public double getPhysicMark() {
        return this.physicMark;
    }

    public void setPhysicMark(double physicMark) {
        this.physicMark = physicMark;
    }

    public double getLanguageMark() {
        return this.languageMark;
    }

    public void setLanguageMark(double languageMark) {
        this.languageMark = languageMark;
    }

    public double average(){
        return (this.mathMark + this.physicMark + this.languageMark)/3;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +            
            ", mathMark='" + getMathMark() + "'" +
            ", physicMark='" + getPhysicMark() + "'" +
            ", languageMark='" + getLanguageMark() + "'" +
            "}";
    }

}
