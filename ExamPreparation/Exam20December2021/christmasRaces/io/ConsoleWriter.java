package M04_JavaOOP.ExamPreparation.Exam20December2021.christmasRaces.io;

import M04_JavaOOP.ExamPreparation.Exam20December2021.christmasRaces.io.interfaces.OutputWriter;

public class ConsoleWriter implements OutputWriter {
    @Override
    public void writeLine(String text) {
        System.out.println(text);
    }
}
