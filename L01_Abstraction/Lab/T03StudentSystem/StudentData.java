package M04_JavaOOP.L01_Abstraction.Lab.T03StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentData {
    private Map<String, Student> students;

    public StudentData() {
        this.students = new HashMap<>();
    }

    public Student getStudent (String name){
        return this.students.get(name);
    }

    public void addStudent(String name ,Student student){
        this.students.putIfAbsent(name,student);
    }
    public boolean containsStudent (String name){
        return students.containsKey(name);
    }
}