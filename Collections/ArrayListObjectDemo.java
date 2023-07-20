package Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
public class ArrayListObjectDemo {
    public static void main(String args[]){

                //Create objects of Student class

        Student s1 = new Student("Alex", 80);
        Student s2 = new Student("Kris", 64);

               //Create an ArrayList of objects Student

        ArrayList<Student> aListStudents = new ArrayList<Student>();

               //add Objects of Student to ArrayList

        aListStudents.add(s1);
        aListStudents.add(s2);

       //display ArrayList objects
       
        for(Student student : aListStudents){
            System.out.println("Name: " + student.getName() + ", Marks: "+student.getMarks());
        }
        
        Iterator<Student> itr=aListStudents.iterator();

        while(itr.hasNext()){
            Student s=(Student)itr.next();
            System.out.println("Name: " + s.getName() + ", Marks: "+s.getMarks());
        }       
        int sum=0;
        for(Student s: aListStudents){
            sum += s.getMarks();
        }
        double avg=sum/aListStudents.size();
        System.out.println("Average = " + avg);
        int sum1 =0;

        while(itr.hasNext()){
            Student s=(Student)itr.next();
            sum1 += s.getMarks();
        }        
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(50);
        list.add(15);
        list.add(450);
        list.add(550);
        list.add(200);
        int  minValue = Collections.min(list);
        int  maxValue = Collections.max(list);
        System.out.println("Minimum value is = " + minValue);
        System.out.println("Maximum value is = " + maxValue);
    } 
    
}
class Student{
       String name;
        int marks;
       public Student(String name, int marks){
        this.name = name;
        this.marks = marks;
    }
       public String getName(){
        return this.name;
    }
       public int getMarks(){
        return this.marks;
    }
}
