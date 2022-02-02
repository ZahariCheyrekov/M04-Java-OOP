package M04_JavaOOP.L04InterfacesAndAbstraction.Lab.T04SayHelloExtend;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();

        persons.add(new Bulgarian("Петър"));
        persons.add(new European("John"));
        persons.add(new Chinese("Cheng"));

        for (Person person : persons) {
            print(person);
        }
    }

    private static void print(Person person) {
        System.out.println(person.sayHello());
    }
}