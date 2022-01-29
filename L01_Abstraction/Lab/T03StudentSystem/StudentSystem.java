package M04_JavaOOP.L01_Abstraction.Lab.T03StudentSystem;


public class StudentSystem {
    private StudentData data;

    public StudentSystem() {
        this.data = new StudentData();
    }

    public void ParseCommand(String[] tokens) {
        switch (tokens[0]) {
            case "Create":
                createStudent(tokens);
                break;
            case "Show":
                showStudent(tokens[1]);
                break;
        }
    }

    private void createStudent(String[] args) {
        String name = args[1];
        int age = Integer.parseInt(args[2]);
        double grade = Double.parseDouble(args[3]);

        if (!this.data.containsStudent(name)) {
            data.addStudent(name, new Student(name, age, grade));
        }
    }

    private void showStudent(String name) {
        if (this.data.containsStudent(name)) {
            Student student = data.getStudent(name);
            System.out.println(student);
        }
    }
}