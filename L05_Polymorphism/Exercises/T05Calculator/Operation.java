package M04_JavaOOP.L05_Polymorphism.Exercises.T05Calculator;

public interface Operation {
    void addOperand(int operand);
    int getResult();
    boolean isCompleted();
}