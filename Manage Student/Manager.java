package j1lp0021;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class Manager {

    private final static Scanner sc = new Scanner(System.in);
    private Repository repo = new Repository();

    public void menu(){
        System.out.println("\n\nWELCOME TO STUDENT MANAGER!");
        System.out.println("1. Create student");
        System.out.println("2. Find student by name");
        System.out.println("3. Update or Delete");
        System.out.println("4. Report");
        System.out.println("0. Exit");
        System.out.print(">>> ");
        int choice = sc.nextInt();
        System.out.println("\n\n");
        sc.nextLine();
        switch (choice) {
            case 1:
                create(); break;
            case 2:
                findAndListByName(); break;
            case 3:
                updateOrDelete(); break;
            case 4:
                report(); break;
            default:
                return;
        }
        menu();
    }

    public void create(){
        if (repo.size() >= 3){
            System.out.print("Do you want continue (y/N)? ");            
            if (!sc.nextLine().trim().toUpperCase().equals("Y")) return;
            System.out.println();
        }
        Student st = new Student();
        
        // System.out.print("Enter id          : "); st.setId(sc.nextLine().trim());
        st.setId(Integer.toString(repo.size()));
        System.out.print("Enter student name: "); st.setName(sc.nextLine().trim());
        System.out.print("Enter semester    : "); st.setSemester(sc.nextLine().trim());
        System.out.print("Enter course      : "); st.setCourseName(sc.nextLine().trim());
        if (repo.contains(st))
            System.out.println("This student is exist.");
        else
            repo.add(st);
        
        System.out.println();
        create();
    }

    public void findAndListByName(){
        System.out.print("Enter the name: ");
        ArrayList<Student> list = repo.getManyByName(sc.nextLine().trim());
        list.sort(Comparator.comparing(Student::getName));
        System.out.printf("%-5s %-20s %-15s %-15s\n", "ID", "Name", "Semester", "Course Name");
        for (Student e: list) 
            System.out.printf("%-5s %-20s %-15s %-15s\n", e.getId() ,e.getName(), e.getSemester(), e.getCourseName());
        System.out.println();
    }

    public void updateOrDelete(){
        Student st;
        for (;;){
            System.out.print("Enter the id: ");
            st = repo.getOneById(sc.nextLine().trim());
            if (st != null) break;
            System.out.println("\nStudent has this ID doesn't exist. ");            
        }

        System.out.print("Do you want Update (U) or Delete (D)? ");
        if (sc.nextLine().trim().toUpperCase().equals("D")){
            repo.deleteById(st.getId());
            System.out.println("\nDelete Successfully!");
        } else {            
            Student tmpStudent = new Student();
            System.out.print("Enter student name: "); tmpStudent.setName(sc.nextLine().trim());
            System.out.print("Enter semester    : "); tmpStudent.setSemester(sc.nextLine().trim());
            System.out.print("Enter course      : "); tmpStudent.setCourseName(sc.nextLine().trim());

            // Check if user don't input anything
            if (tmpStudent.getName().equals("")) tmpStudent.setName(st.getName());
            if (tmpStudent.getSemester().equals("")) tmpStudent.setSemester(st.getSemester());
            if (tmpStudent.getCourseName().equals("")) tmpStudent.setCourseName(st.getCourseName());

            repo.updateById(st.getId(), tmpStudent);
            System.out.println("\nUpdate Successfully!");
        }
    }

    public void report(){
        HashMap<Report, Integer> reports = new HashMap<>();
        for (Student e: repo.getAll()){
            Report tmp = new Report(e.getName(), e.getCourseName());
            if (reports.containsKey(tmp)){
                reports.replace(tmp, reports.get(tmp) + 1);
            } else {
                reports.put(tmp, 1);
            }
        }
        System.out.printf("%-20s %-15s %-15s\n", "Student Name", "Course Name", "Total");
        for (Report report: reports.keySet()){
            int total = reports.get(report);
            System.out.printf("%-20s %-15s %-15d\n", report.getName(), report.getCourse(), total);
        }
    }
}

class Report{
    private String name;
    private String course;

    public Report(String name, String course) {
        this.name = name;
        this.course = course;
    }

    public String getName() {
        return this.name;
    }

    public String getCourse() {
        return this.course;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Report)) {
            return false;
        }
        Report report = (Report) o;
        return Objects.equals(name, report.name) && Objects.equals(course, report.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, course);
    }   
}