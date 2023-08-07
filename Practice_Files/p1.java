package Practice_Files;

import java.util.TreeSet;

public class p1 {
    public static void main(String[] args) {
        Student s1= new Student(7);
        Student s2 = new Student(1);

        TreeSet<Student> stud = new TreeSet<>();
        stud.add(s1);
        stud.add(s2);

        for(Student s : stud){
            System.out.println(s.get());
        }
    }
}
class Student implements Comparable<Student>{
    int roll;
    Student(int roll){
        roll=this.roll;
    }
    public int get(){
        return this.roll;
    }
 
    @Override
    public int compareTo(Student o) {
        if(this.roll<o.roll)
            return this.roll;
        if(this.roll>o.roll)
            return o.roll;
        return 0;
    }
}