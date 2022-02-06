package M04_JavaOOP.ExamPreparation.Exam16August2020.onlineShop.io;


import M04_JavaOOP.ExamPreparation.Exam16August2020.onlineShop.io.interfaces.OutputWriter;

public class ConsoleWriter implements OutputWriter {
    @Override
    public void writeLine(String text) {
        System.out.println(text);
    }
}
