
package j1.s.p0056;

import java.text.SimpleDateFormat;
import java.util.Date;
public class Worker {
    private String id;
    private String name;
    private int age;
    private double salary;
    private String status;
    private Date date;   
    
    
    public Worker(String id, String name, int age,double salary, String status, Date date ){
        this.id=id;
        this.name=name;
        this.age=age;
        this.salary=salary;
        this.status=status;
        this.date=date;
    }    

    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age=age;
    }      
    public double getSalary(){
        return salary;
    }
    public void setSalary(int salary){
        this.salary=salary;
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status=status;
    }
    public Date getDate(){
        return date;
    }
    public void setDate(Date date){
        this.date = date;
    }
    public void display(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        System.out.printf("%5s %15s %-5d %-8.2f %15s %15s\n",id,name,age,salary,status,dateFormat.format(date));
    }

}
