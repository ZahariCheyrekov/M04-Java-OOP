package M04_JavaOOP.L03_Inheritance.Lab.T05StackOfStrings;

public class Main {
    public static void main(String[] args) {
        StackOfStrings sos = new StackOfStrings();
        sos.push("one");
        sos.push("two");
        sos.push("three");

        System.out.println(sos.isEmpty());
        System.out.println(sos.peek());

        System.out.println(sos.peek());
        System.out.println(sos.peek());
        System.out.println(sos.peek());
    }
}