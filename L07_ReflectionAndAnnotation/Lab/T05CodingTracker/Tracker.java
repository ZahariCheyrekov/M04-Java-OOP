package M04_JavaOOP.L07_ReflectionAndAnnotation.Lab.T05CodingTracker;

public class Tracker {
    @Author(name = "Lion")
    public void test() {

    }

    @Author(name = "Gorilla")
    private static void methodByGosho() {

    }

    @Author(name = "Eagle")
    public String tester() {
        return "Test";
    }
}