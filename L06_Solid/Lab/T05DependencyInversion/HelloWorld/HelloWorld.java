package M04_JavaOOP.L06_Solid.Lab.T05DependencyInversion.HelloWorld;

import java.time.LocalDateTime;

public class HelloWorld {
    public String greeting(String name) {
        if (LocalDateTime.now().getHour()< 12) {
            return "Good morning, " + name;
        }

        if (LocalDateTime.now().getHour() < 18) {
            return "Good afternoon, " + name;
        }

        return "Good evening, " + name;
    }
}
