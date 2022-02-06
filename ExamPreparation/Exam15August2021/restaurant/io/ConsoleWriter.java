package M04_JavaOOP.ExamPreparation.Exam15August2021.restaurant.io;

import M04_JavaOOP.ExamPreparation.Exam15August2021.restaurant.io.interfaces.OutputWriter;

public class ConsoleWriter implements OutputWriter {
    public void writeLine(String text) {
        System.out.println(text);
    }
}
