package M04_JavaOOP.L04InterfacesAndAbstraction.Lab.T03SayHello;

public class European implements Person {
    private String name;

    public European(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String sayHello() {
        return "Hello";
    }
}