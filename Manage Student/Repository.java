package j1lp0021;

import java.util.ArrayList;
import java.util.Iterator;

public class Repository {
    private ArrayList<Student> students = new ArrayList<>();


    public int size(){
        return this.students.size();
    }

    public void add(Student e){
        students.add(e);
    }

    public boolean contains(Student e){
        return this.students.contains(e);
    }

    public Student getOneById(String id){
        for (Student e: students){
            if (e.getId().equals(id)) return e;
        }
        return null;
    }

    public ArrayList<Student> getManyByName(String name){
        ArrayList<Student> res = new ArrayList<>();
        for (Student e: students){
            if (e.getName().toUpperCase().contains(name.toUpperCase())) res.add(e);
        }
        return res;
    }

    public ArrayList<Student> getAll(){
        return this.students;
    }

    public void deleteById(String id){
        Iterator<Student> it = students.iterator();
        while (it.hasNext()){
            if (it.next().getId().equals(id)) it.remove();
        }
    }

    public void updateById(String id, Student e){        
        for (int i=0; i<students.size(); i++){
            if (students.get(i).getId().equals(id)) {
                students.set(i, e);     
            }
        }
    }
}
